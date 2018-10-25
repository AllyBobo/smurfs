package com.iscas.smurfs.cert.service;

import com.iscas.smurfs.common.config.UserConfiguration;
import com.iscas.smurfs.common.entity.dto.UserJwtDto;
import com.iscas.smurfs.common.exception.UserTokenException;
import com.iscas.smurfs.common.utils.JwtHelper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/17
 */

public class UserJwtService {
    @Autowired
    private UserConfiguration userConfiguration;
    public UserJwtDto getInfoFromToken(String token) throws Exception {
        try {
            return JwtHelper.getInfoFromToken(token, userConfiguration.getPubKeyByte());
        }catch (ExpiredJwtException ex){
            throw new UserTokenException("User token expired!");
        }catch (SignatureException ex){
            throw new UserTokenException("User token signature error!");
        }catch (IllegalArgumentException ex){
            throw new UserTokenException("User token is null or empty!");
        }
    }
}

