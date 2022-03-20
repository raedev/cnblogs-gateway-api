package com.cnblogs.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * App相关接口
 * GET /app
 *
 * @author RAE
 * @date 2022/03/20
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@RestController
@RequestMapping("/app")
public class AppController {

    @GetMapping("/config")
    public Map<String, Object> getConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put("versionCode", 1);
        config.put("versionName", "1.0.0");
        config.put("downloadUrl", "https://cnblogs.com/download/");
        return config;
    }
}
