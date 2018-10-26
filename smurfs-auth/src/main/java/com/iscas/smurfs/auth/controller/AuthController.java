package com.iscas.smurfs.auth.controller;

import com.iscas.smurfs.common.config.KeyConfiguration;
import com.iscas.smurfs.auth.service.IAuthService;
import com.iscas.smurfs.auth.entity.dto.UserLoginDto;
import com.iscas.smurfs.common.context.CustomSession;
import com.iscas.smurfs.common.entity.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthController {

    @Autowired
    private IAuthService authService;
    @Autowired
    private KeyConfiguration keyConfiguration;
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResponseData login(
            @RequestBody UserLoginDto userLoginDto) throws Exception {
        final String token = authService.login(userLoginDto);
        //redis缓存token
        redisTemplate.opsForValue().set(token,userLoginDto.getUsername());
        return ResponseData.ok(token);
    }

    //TODO:续签问题暂时解决办法
    @RequestMapping(value = "/refresh",method = RequestMethod.GET)
    public ResponseData refresh() throws Exception{
        String token = CustomSession.getToken();
        UserLoginDto userLoginDto = (UserLoginDto) redisTemplate.opsForValue().get(token);
        final String refreshToken = authService.login(userLoginDto);
        return ResponseData.ok(refreshToken);
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ResponseData logout(){
        String token = CustomSession.getToken();
        if(redisTemplate.hasKey(token)){
            redisTemplate.delete(token);
        }
        return ResponseData.ok("logout succ");
    }
    @RequestMapping(value = "/userPubKey",method = RequestMethod.GET)
    public ResponseData<byte[]> getUserPublicKey(){
        return ResponseData.ok(keyConfiguration.getUserPubKey());
    }

}
