package com.iscas.smurfs.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWTInfo {
    private String username;
    private Integer userId;
    private String name;
}
