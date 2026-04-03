package com.lanhai.hello_server.interceptor;

import com.lanhai.hello_server.common.Result;
import com.lanhai.hello_server.common.ResultCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import java.util.Map;

public class AuthInterceptor implements HandlerInterceptor {

    private static final Map<String, String> TOKEN_STORE = Map.of(
            "test-token", "admin"
    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null || !TOKEN_STORE.containsKey(token)) {
            response.setContentType("application/json;charset=UTF-8");
            Result<?> result = Result.error(ResultCode.UNAUTHORIZED);
            new ObjectMapper().writeValue(response.getWriter(), result);
            return false;
        }
        return true;
    }
}