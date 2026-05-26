package com.lanhai.hello_server.service;

import com.lanhai.hello_server.model.dto.ChatRequestDTO;
import com.lanhai.hello_server.model.vo.ChatResponseVO;

public interface ChatService {
    /**
     * 带Redis会话记忆的聊天接口
     * @param request 用户请求（含sessionId和消息）
     * @return AI回答结果
     */
    ChatResponseVO chatWithMemory(ChatRequestDTO request);
}