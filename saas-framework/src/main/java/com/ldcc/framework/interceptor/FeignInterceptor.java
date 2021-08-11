package com.ldcc.framework.interceptor;

import com.ldcc.common.constant.Constants;
import com.ldcc.common.utils.ServletUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author wwg
 * @version jdk1.8
 * @description feign配置类
 * @create 2021-08-11 11:02
 **/
@Component
public class FeignInterceptor implements RequestInterceptor {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 获取Header、或参数等
        String token = ServletUtils.getHeaderParameter("Authorization");
        // 注入Feign请求体
        requestTemplate.header(Constants.AUTHORIZATION, token);
    }
}
