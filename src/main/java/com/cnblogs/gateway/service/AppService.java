package com.cnblogs.gateway.service;

import com.cnblogs.gateway.domain.AppCategory;
import com.cnblogs.gateway.domain.AppVersion;
import com.cnblogs.gateway.model.AppConfig;

import java.util.List;

/**
 * App接口
 * @author RAE
 * @date 2022/03/21
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
public interface AppService {

    /**
     * app配置信息
     */
    AppConfig getConfig();


    /**
     * 获取最新版本号
     */
    AppVersion getVersion();


    /**
     * 获取分类列表
     */
    List<AppCategory> getCategory();
}
