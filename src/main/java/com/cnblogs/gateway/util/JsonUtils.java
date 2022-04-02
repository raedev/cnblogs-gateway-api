package com.cnblogs.gateway.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

/**
 * @author RAE
 * @date 2022/03/24
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
public final class JsonUtils {

    private static final ObjectMapper sMapper = new ObjectMapper();

    public static String toJson(Object obj) {
        try {
            return sMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T parse(String json, Class<T> cls) {
        try {
            return sMapper.readValue(json, cls);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> parseList(String json, Class<T> cls) {
        try {
            return sMapper.readValue(json, new TypeReference<List<T>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T mapToObject(Map<String, Object> map, Class<T> cls) {
        return parse(toJson(map), cls);
    }
}
