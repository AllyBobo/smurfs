package com.iscas.smurfs.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 用guava的ratelimiter做限流
 * @author: lee
 * @date: 2018-10-30
 */
public class RateLimiterFilter extends ZuulFilter {
    //每秒产生1000个令牌
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(1000);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return -4;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        if (!RATE_LIMITER.tryAcquire()) {
            requestContext.setSendZuulResponse(false);
            //HttpStatus.TOO_MANY_REQUESTS.value()里面有静态代码常量
            requestContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
        }
        return null;
    }
}
