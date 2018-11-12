package com.iscas.smurfs.admin2.dynamic;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @author: lee
 * @date: 2018-11-12
 */
public class DynamicDataSourceRegister implements EnvironmentAware {
    @Override
    public void setEnvironment(Environment environment) {
        DynamicDataSourceRegisterUtil.initAndRegisterDataSource(environment);
    }
}
