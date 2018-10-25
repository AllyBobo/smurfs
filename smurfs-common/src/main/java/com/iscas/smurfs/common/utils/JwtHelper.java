package com.iscas.smurfs.common.utils;

import com.iscas.smurfs.common.utils.RsaUtils;
import com.iscas.smurfs.common.utils.StringUtils;
import com.iscas.smurfs.common.constant.Constant;
import com.iscas.smurfs.common.entity.dto.UserJwtDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/7
 */
public class JwtHelper {
    private static RsaUtils rsaKeyHelper = new RsaUtils();
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
    public static UserJwtDto getInfoFromToken(String token, byte[] pubKey) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKey);
        Claims body = claimsJws.getBody();
        return new UserJwtDto(body.getSubject(), Integer.parseInt(StringUtils.getObjectValue(body.get(Constant.JWT_KEY_USER_ID))), StringUtils.getObjectValue(body.get(Constant.JWT_KEY_NAME)));
    }

    /**
     * 密钥加密token
     *
     * @param
     * @param priKey
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(String uid,String name, byte priKey[], int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(name)//TODO:改成unicname
                .claim(Constant.JWT_KEY_USER_ID, uid)
                .claim(Constant.JWT_KEY_NAME, name)
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKey))
                .compact();
        return compactJws;
    }
}
