package com.iscas.smurfs.common.constant;

/**
 * description:
 *
 * @author lee
 * @date 2018/9/23
 */
public class Constant {
    public static int PW_ENCORDER_SALT = 12;

    public static String TOKEN_HEADER = "Authorization";
    public static final String JWT_KEY_USER_ID = "userId";
    public static final String JWT_KEY_NAME = "name";
    // 用户token异常
    public static final Integer EX_USER_INVALID_CODE = 40101;
    public static final int TOKEN_FORBIDDEN_CODE = 40301;

    //自定义session的key
    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_USERNAME = "currentUserName";
    public static final String CONTEXT_KEY_USER_NAME = "currentUser";
    public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";

    //客户端类型标识
    public static final String CLIENT_TAG = "clientType";
    public static final String CLIENT_TYPE_SYSTEM = "system";
}
