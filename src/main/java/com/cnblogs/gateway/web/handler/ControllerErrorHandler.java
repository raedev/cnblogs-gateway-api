package com.cnblogs.gateway.web.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 控制器错误处理
 * @author RAE
 * @date 2022/03/20
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@ControllerAdvice
public class ControllerErrorHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> handlerNullPointerException(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("message", "服务器发生错误了:" + ex.getMessage());
        ex.printStackTrace();
        return map;
    }

    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public Map<String, Object> handlerNullPointerException(NullPointerException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 501);
        map.put("message", ex.getMessage());
        ex.printStackTrace();
        return map;
    }
}
