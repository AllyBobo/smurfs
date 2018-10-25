package com.iscas.smurfs.common.context;

import com.iscas.smurfs.common.constant.Constant;
import com.iscas.smurfs.common.entity.dto.UserJwtDto;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 * 还是用map吧，用UserJwtDto扩展性不好
 * @author lee
 * @date 2018/10/24
 */
public class CustomSession {
    private static final ThreadLocal<Map<String,Object>> LOCAL = new ThreadLocal<>();
//    public static void set(UserJwtDto userJwtDto){
//        LOCAL.set(userJwtDto);
//    }
//
//    public static UserJwtDto get(){
//        return LOCAL.get();
//    }

    public static void set(String key, Object value) {
        Map<String, Object> map = LOCAL.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            LOCAL.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key){
        Map<String, Object> map = LOCAL.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            LOCAL.set(map);
        }
        return map.get(key);
    }

    public static String getUserID(){
        Object value = get(Constant.CONTEXT_KEY_USER_ID);
        return returnObjectValue(value);
    }

    public static String getUsername(){
        Object value = get(Constant.CONTEXT_KEY_USERNAME);
        return returnObjectValue(value);
    }


    public static String getName(){
        Object value = get(Constant.CONTEXT_KEY_USER_NAME);
        return getObjectValue(value);
    }

    public static String getToken(){
        Object value = get(Constant.CONTEXT_KEY_USER_TOKEN);
        return getObjectValue(value);
    }
    public static void setToken(String token){set(Constant.CONTEXT_KEY_USER_TOKEN,token);}

    public static void setName(String name){set(Constant.CONTEXT_KEY_USER_NAME,name);}

    public static void setUserID(String userID){
        set(Constant.CONTEXT_KEY_USER_ID,userID);
    }

    public static void setUsername(String username){
        set(Constant.CONTEXT_KEY_USERNAME,username);
    }

    private static String returnObjectValue(Object value) {
        return value==null?null:value.toString();
    }
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
