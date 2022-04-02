package com.cnblogs.gateway.model;

import lombok.Data;

/**
 * 配置项
 * @author RAE
 * @date 2022/03/21
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@Data
public class Options {
    private Integer id;
    private String name;
    private String key;
    private String value;
    private String groupName;
}
