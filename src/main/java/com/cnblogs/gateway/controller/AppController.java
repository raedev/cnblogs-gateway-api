package com.cnblogs.gateway.controller;

import com.cnblogs.gateway.domain.AppCategory;
import com.cnblogs.gateway.domain.AppVersion;
import com.cnblogs.gateway.model.AppConfig;
import com.cnblogs.gateway.service.AppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * App相关接口
 * GET /app
 * @author RAE
 * @date 2022/03/20
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@RestController
@RequestMapping("/app")
public class AppController {

    AppService mService;

    public AppController(AppService mService) {
        this.mService = mService;
    }

    @GetMapping("/config")
    public AppConfig getConfig() {
        return mService.getConfig();
    }

    @GetMapping("/version")
    public AppVersion getVersion() {
        return mService.getVersion();
    }

    @GetMapping("/category")
    public List<AppCategory> getCategory() {
        return mService.getCategory();
    }
}
