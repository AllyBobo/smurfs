package com.iscas.smurfs.auth.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto implements Serializable {
    private String username;//对应UserJwtDto中的username
    private String password;
}
