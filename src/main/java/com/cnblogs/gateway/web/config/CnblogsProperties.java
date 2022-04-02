package com.cnblogs.gateway.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 全局配置文件
 * @author RAE
 * @date 2022/03/21
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@Component
@ConfigurationProperties(prefix = "cnblogs")
public class CnblogsProperties {

    /**
     * 是否为调试模式
     */
    private boolean debug;

    /**
     * 用于请求签名加密的HMAC密钥
     */
    private String requestHmacKey = "cnblogs.com";

    private Map<String, String> maps;

    private List<String> urls;

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getRequestHmacKey() {
        return requestHmacKey;
    }

    public void setRequestHmacKey(String requestHmacKey) {
        this.requestHmacKey = requestHmacKey;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
