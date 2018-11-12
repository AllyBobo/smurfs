package com.iscas.smurfs.admin2.dynamic;

import lombok.Data;

/**
 * @author: lee
 * @date: 2018-11-12
 */
@Data
public class EnvironmentConfig {
    private String code;
    private String name;
    private String driverClassName;
    private String username;
    private String password;
    private String url;
}
