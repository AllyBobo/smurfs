package com.iscas.smurfs.admin2.dynamic;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author: lee
 * @date: 2018-11-12
 */
@Component
public class EnvironmentUtils  implements EnvironmentAware {
    private static Environment environment ;
    @Override
    public void setEnvironment(Environment environment) {
        EnvironmentUtils.environment=environment;
    }
    public static Environment getEnvironment(){
        return EnvironmentUtils.environment;
    }
}
