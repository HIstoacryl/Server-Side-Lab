package com.lanhai.hello_server.model.dto;

import lombok.Data;

@Data
public class ChatReq {
    private String sessionId;
    private String message;
}