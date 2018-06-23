package com.truechain.task.plat.form.util;

import com.truechain.task.plat.form.core.BusinessException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * Jwt工具类
 */
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    /**
     * 验证token合法性
     *
     * @param token
     * @param salt
     * @return
     */
    public static boolean verifyToken(String token, String salt) {
        Key key = generalKey(salt);
        try {
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            return true;
        } catch (Exception e) {
            logger.error("---方法verifyToken---错误信息：" + e.getMessage(), e);
            if (e.getMessage().contains("JWT expired")) {
                throw new BusinessException("JWT expired");
            }
            if (e.getMessage().contains("not match locally computed signature")) {
                throw new BusinessException("keyNotMatch");
            }
            return false;
        }
    }

    /**
     * 解析被压缩的token值并获取redisKey
     *
     * @param token
     * @param salt
     * @return
     */
    public static String getRedisKeyByToken(String token, String salt) {
        // 得到Key
        Key key = generalKey(salt);
        try {
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            return (String) claims.get("payload");
        } catch (Exception e) {
            logger.error("---方法getRedisKeyByToken---错误信息：" + e.getMessage(), e);
            if (e.getMessage().contains("JWT expired"))
                return "expired";
            if (e.getMessage().contains("not match locally computed signature"))
                return "keyNotMatch";
            return "invalid";
        }
    }

    /**
     * 根据自定义的Constant的字符串生成的Key
     *
     * @param salt 私钥盐
     * @return
     */
    private static Key generalKey(String salt) {
        if (null == salt || "".equals(salt))
            return null;
        salt = "truechain" + salt;
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
        String printBase64Binary = DatatypeConverter.printBase64Binary(salt.getBytes());
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(printBase64Binary);
        // 根据给定的字节数组构造一个密钥。
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }

    /**
     * createToken
     *
     * @param salt              私钥盐
     * @param redisKey
     * @param expireMillisecond 过期时间（毫秒）
     * @return
     */
    public static String createToken(String salt, String redisKey, long expireMillisecond) {
        String issuer = "truechain";
        // 定义算法
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        // 留出3分钟的误差时间
        Date nbf = new Date(nowMillis - 180000L);
        // 默认3天过期时间
        Date exp = new Date(nowMillis + expireMillisecond);
        Key signingKey = generalKey(salt);

        // 构造JWT三部分（header,payload,Signature），为了防止token的payload被恶意解析后知道redisKey的真实含义，此处用airoland来作为保存字段以作混淆
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT").setHeaderParam("alg", "HS256")
                .setIssuedAt(now).setIssuer(issuer).claim("payload", redisKey).signWith(SignatureAlgorithm.HS512, signingKey);
        // 添加过期时间，和token不被接受时间
        builder.setExpiration(exp).setNotBefore(nbf);
        // 生成压缩的字符串
        return builder.compact();
    }
}
