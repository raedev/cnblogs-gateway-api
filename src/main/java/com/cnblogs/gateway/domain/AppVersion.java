package com.cnblogs.gateway.domain;

import lombok.Data;

/**
 * 版本信息
 * @author RAE
 * @date 2022/03/24
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@Data
public class AppVersion {

    /**
     * 版本号
     */
    private String versionName;
    /**
     * 内部版本号
     */
    private Integer versionCode;
    /**
     * 包名
     */
    private String packageName;
    /**
     * 包下载地址
     */
    private String downloadUrl;
    /**
     * 更新说明
     */
    private String updateNote;
}
