package com.cnblogs.gateway.domain;

import lombok.Data;

/**
 * 分类
 * @author RAE
 * @date 2022/03/24
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@Data
public class AppCategory {
    private String categoryId;
    private String name;
    private Integer orderNo;
    private String parentId;
    private String type;
}
