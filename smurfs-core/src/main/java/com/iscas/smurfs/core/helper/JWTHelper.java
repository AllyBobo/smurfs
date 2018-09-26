package com.iscas.smurfs.core.helper;

import com.iscas.smurfs.common.utils.StringUtils;
import com.iscas.smurfs.core.constant.Constant;
import com.iscas.smurfs.core.entity.JWTInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/7
 */
public class JWTHelper {
    private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();
    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, byte[] pubKey) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKey)).parseClaimsJws(token);
        return claimsJws;
    }
    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKey
     * @return
     * @throws Exception
     */
    public static JWTInfo getInfoFromToken(String token, byte[] pubKey) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKey);
        Claims body = claimsJws.getBody();
        return new JWTInfo(body.getSubject(), Integer.parseInt(StringUtils.getObjectValue(body.get(Constant.JWT_KEY_USER_ID))), StringUtils.getObjectValue(body.get(Constant.JWT_KEY_NAME)));
    }
}
