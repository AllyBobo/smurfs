package com.iscas.smurfs.common.config;

import com.iscas.smurfs.common.constant.Constant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lee
 * @date: 2018-10-25
 */
@Configuration
public class FeignConfiguration implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(Constant.CLIENT_TAG,Constant.CLIENT_TYPE_SYSTEM);
    }
}
