package com.iscas.smurfs.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;


public class PreRequestFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestFilter.class);

    @Value("${zuul.prefix}")
    private String zuulPrefix;

    @Value("${gate.ignore.startWith}")
    private String startWith;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        PreRequestFilter.LOGGER.info(String.format(" send %s request to %s", request.getMethod(), request.getRequestURL().toString()));

        final String requestUri = request.getRequestURI().substring(zuulPrefix.length());;
        //白名单
        if (isStartWith(requestUri)) {
            return null;
        }

        return null;
    }

    private boolean isStartWith(String requestUri) {
        boolean flag = false;
        for (String s : startWith.split(",")) {
            if (requestUri.startsWith(s)) {
                return true;
            }
        }
        return flag;
    }
}
