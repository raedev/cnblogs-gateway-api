package com.cnblogs.gateway.model;

import lombok.Data;

/**
 * App配置项
 * @author RAE
 * @date 2022/03/21
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@Data
public class AppConfig {

    /**
     * 华为应用市场审核状态
     */
    private boolean huaweiAudit;

    /**
     * 小米应用市场审核状态
     */
    private boolean xiaomiAudit;

    /**
     * 接口签名密钥
     */
    private String appKey;
}
