package com.cnblogs.gateway.web.interceptor;

import com.cnblogs.gateway.util.RequestUtils;
import com.cnblogs.gateway.util.TextUtils;
import com.cnblogs.gateway.web.config.CnblogsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求拦截器
 * @author RAE
 * @date 2022/03/21
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    private final CnblogsProperties mProperties;

    public RequestInterceptor(CnblogsProperties properties) {
        this.mProperties = properties;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!mProperties.isDebug()) {
            // 启用请求签名
            return handleRequestSign(request, response, mProperties.getRequestHmacKey());
        }
        return true;
    }


    /**
     * 处理请求签名
     */
    private boolean handleRequestSign(HttpServletRequest request, HttpServletResponse response, String hmacKey) throws IOException {
        String sign = request.getHeader("Sign");
        String nonce = request.getHeader("Nonce");
        String timestamp = request.getHeader("Timestamp");
        if (TextUtils.isEmpty(sign) || TextUtils.isEmpty(nonce) || TextUtils.isEmpty(timestamp)) {
            response.sendError(403, "非法请求");
            return false;
        }
        // 签名校验
        String serverSign = RequestUtils.generateSign(request, hmacKey, nonce, timestamp);
        if (!TextUtils.equals(sign, serverSign)) {
            response.sendError(403, "签名校验失败");
            log.error("签名校验失败！" + request.getRequestURL() + "客户端签名：" + sign + " > 服务器签名：" + serverSign);
            return false;
        }
        long timespan = System.currentTimeMillis() - TextUtils.parseLong(timestamp);
        if (timespan > 60000) {
            // 1分钟超时
            response.sendError(403, "请求已过期");
            return false;
        }
        return true;
    }
}
