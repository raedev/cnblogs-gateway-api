package com.cnblogs.gateway.util;

import org.springframework.util.StringUtils;

/**
 * 文本相关
 * @author RAE
 * @date 2022/03/21
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
public final class TextUtils {

    public static boolean isEmpty(String text) {
        return !StringUtils.hasLength(text);
    }

    public static boolean equals(String a, String b) {
        return (a == null && b == null) || (a != null && a.equals(b));
    }

    public static Long parseLong(String timestamp) {
        try {
            return Long.parseLong(timestamp);
        } catch (Exception ignored) {
        }
        return 0L;
    }
}
