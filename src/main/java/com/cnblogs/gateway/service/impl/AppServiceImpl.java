package com.cnblogs.gateway.service.impl;

import com.cnblogs.gateway.domain.AppCategory;
import com.cnblogs.gateway.domain.AppVersion;
import com.cnblogs.gateway.mapper.AppVersionMapper;
import com.cnblogs.gateway.mapper.ConfigMapper;
import com.cnblogs.gateway.model.AppConfig;
import com.cnblogs.gateway.model.Options;
import com.cnblogs.gateway.service.AppService;
import com.cnblogs.gateway.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * App接口实现
 * @author RAE
 * @date 2022/03/21
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@Service
@Slf4j
public class AppServiceImpl extends BaseService implements AppService {

    final ConfigMapper mConfigMapper;
    final AppVersionMapper mAppVersionMapper;
    final ResourceLoader mResourceLoader;

    public AppServiceImpl(ConfigMapper mConfigMapper, AppVersionMapper mAppVersionMapper, ResourceLoader resourceLoader) {
        this.mConfigMapper = mConfigMapper;
        this.mAppVersionMapper = mAppVersionMapper;
        mResourceLoader = resourceLoader;
    }

    @Override
    public AppConfig getConfig() {
        List<Options> options = mConfigMapper.findByGroup("app");
        Map<String, Object> map = new HashMap<>(options.size());
        for (Options option : options) {
            String key = option.getKey();
            String value = option.getValue();
            map.put(key, value);
        }
        return JsonUtils.mapToObject(map, AppConfig.class);
    }

    @Override
    public AppVersion getVersion() {
        AppVersion version = mAppVersionMapper.getLastVersion();
        return Objects.requireNonNull(version, "暂无版本信息");
    }

    @Override
    public List<AppCategory> getCategory() {
        try {
            // 读取文件
            String key = "app_category";
            Options options = mConfigMapper.getByKey(key);
            String json;
            if (options == null) {
                // 为了
                Resource resource = mResourceLoader.getResource("classpath:templates/category.json");
                json = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
                options = new Options();
                options.setKey(key);
                options.setName("分类列表");
                options.setValue(json);
                mConfigMapper.insert(options);
            } else {
                json = options.getValue();
            }
            return JsonUtils.parseList(json, AppCategory.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
