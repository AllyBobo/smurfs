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
}
