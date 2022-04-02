package com.cnblogs.gateway.util;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

/**
 * 请求工具类
 * @author RAE
 * @date 2022/03/21
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@Slf4j
public final class RequestUtils {


    /**
     * 通过请求生成请求签名
     * @param request 请求
     * @return 签名
     */
    public static String generateSign(HttpServletRequest request, String hmacKey, String nonce, String timestamp) {
        Enumeration<String> names = request.getParameterNames();
        // 按照红黑树（Red-Black tree）的 NavigableMap 字母大小排序实现
        Map<String, String> map = new TreeMap<>(String::compareTo);
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = request.getParameter(name);
            map.put(name, value);
            log.debug("请求参数：" + name + "=" + value);
        }
        // 1、将Map转为标准的QueryString
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (i > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            i++;
        }
        // 2、添加随机数和时间戳
        sb.append("nonce").append("=").append(nonce);
        sb.append("timestamp").append("=").append(timestamp);
        // 3、将组合好的字符串进行HMAC加密
        return encryptHmac(hmacKey, sb.toString());
    }


    /**
     * HAMC 加密
     * @param key  秘钥
     * @param text 加密的文本
     * @return 加密后的文本
     */
    private static String encryptHmac(String key, String text) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKey secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), mac.getAlgorithm());
            mac.init(secretKey);
            byte[] data = mac.doFinal(text.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}
