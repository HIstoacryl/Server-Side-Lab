package com.lanhai.hello_server.service.impl;

import com.lanhai.hello_server.model.dto.ChatRequestDTO;
import com.lanhai.hello_server.model.vo.ChatResponseVO;
import com.lanhai.hello_server.service.ChatService;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ChatServiceImpl implements ChatService {

    // Redis会话存储Key前缀
    private static final String CHAT_SESSION_PREFIX = "chat:session:";
    // 会话过期时间（1小时）
    private static final long SESSION_EXPIRE_HOURS = 1;
    // 最大保留历史轮数（避免Token溢出）
    private static final int MAX_HISTORY_ROUNDS = 3;

    @Resource
    private ChatClient chatClient;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public ChatResponseVO chatWithMemory(ChatRequestDTO request) {
        String sessionId = request.getSessionId();
        String userMessage = request.getMessage();
        String redisKey = CHAT_SESSION_PREFIX + sessionId;

        // 1. 从Redis读取该会话的历史对话
        List<Message> historyMessages = (List<Message>) redisTemplate.opsForValue().get(redisKey);
        if (historyMessages == null) {
            historyMessages = new ArrayList<>();
        }

        // 2. 拼接当前用户消息，构建完整Prompt
        historyMessages.add(new UserMessage(userMessage));
        Prompt prompt = new Prompt(historyMessages);

        // 3. 调用通义千问大模型
        String aiAnswer = chatClient.call(prompt).getResult().getOutput().getContent();

        // 4. 将AI回答存入历史，裁剪历史轮数（只保留最近3轮）
        historyMessages.add(new AssistantMessage(aiAnswer));
        if (historyMessages.size() > MAX_HISTORY_ROUNDS * 2) {
            historyMessages = historyMessages.subList(historyMessages.size() - MAX_HISTORY_ROUNDS * 2, historyMessages.size());
        }

        // 5. 更新Redis会话缓存，设置过期时间
        redisTemplate.opsForValue().set(redisKey, historyMessages, SESSION_EXPIRE_HOURS, TimeUnit.HOURS);

        // 6. 返回结果
        return new ChatResponseVO(sessionId, userMessage, aiAnswer);
    }
}