package com.lanhai.hello_server.controller;

import com.lanhai.hello_server.common.Result;
import com.lanhai.hello_server.model.dto.ChatRequestDTO;
import com.lanhai.hello_server.model.vo.ChatResponseVO;
import com.lanhai.hello_server.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public Result<ChatResponseVO> chat(@RequestBody ChatRequestDTO dto) {
        String answer = chatService.chat(dto.getMessage());
        ChatResponseVO vo = new ChatResponseVO(dto.getMessage(), answer);
        return Result.success(vo);
    }
}