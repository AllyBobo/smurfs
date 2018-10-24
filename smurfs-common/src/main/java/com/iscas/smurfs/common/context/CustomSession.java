package com.iscas.smurfs.common.context;

import com.iscas.smurfs.common.entity.dto.UserJwtDto;

/**
 * description:
 *
 * @author lee
 * @date 2018/10/24
 */
public class CustomSession {
    private static final ThreadLocal<UserJwtDto> LOCAL = new ThreadLocal<UserJwtDto>();
    public static void set(UserJwtDto userJwtDto){
        LOCAL.set(userJwtDto);
    }

    public static UserJwtDto get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
