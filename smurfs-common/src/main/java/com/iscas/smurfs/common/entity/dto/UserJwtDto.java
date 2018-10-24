package com.iscas.smurfs.common.entity.dto;

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
public class UserJwtDto {
    private String username;
    private Integer userId;
    private String name;
}
