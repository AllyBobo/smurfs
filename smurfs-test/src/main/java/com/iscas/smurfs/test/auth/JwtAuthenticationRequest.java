package com.iscas.smurfs.test.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class JwtAuthenticationRequest implements Serializable {
    private String username;
    private String password;
}
