package com.lanhai.hello_server.controller;

import com.lanhai.hello_server.model.dto.ChatRequestDTO;
import com.lanhai.hello_server.model.vo.ChatResponseVO;
import com.lanhai.hello_server.service.ChatService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Resource
    private ChatService chatService;

    /**
     * 带会话记忆的聊天接口
     */
    @PostMapping("/memory")
    public ChatResponseVO chatWithMemory(@RequestBody ChatRequestDTO request) {
        return chatService.chatWithMemory(request);
    }
}