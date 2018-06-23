package com.truechain.task.plat.form.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.compression.DefaultCompressionCodecResolver;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.util.StringUtils;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.UUID;

/**
 * Jwt工具类
 */
public class JwtUtil {

    public static final String SECRET_KEY = "?::4343fdf4fdf6cvf):";

    private static CompressionCodecResolver codecResolver = new DefaultCompressionCodecResolver();

    /**
     * 签发
     *
     * @param subject
     * @param roles
     * @param permissions
     * @param expireMillisecond 过期时间（毫秒）
     * @return
     */
    public static String createToken(String subject, String roles, String permissions, long expireMillisecond) {
        String issuer = "truechain";
        // 定义算法
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        // 留出3分钟的误差时间
        Date nbf = new Date(nowMillis - 180000L);
        // 默认3天过期时间
        Date exp = new Date(nowMillis + expireMillisecond);
        byte[] secreKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);

        // 构造JWT三部分（header,payload,Signature），为了防止token的payload被恶意解析后知道redisKey的真实含义，此处用airoland来作为保存字段以作混淆
        JwtBuilder builder = Jwts.builder().setId(UUID.randomUUID().toString()).setHeaderParam("typ", "JWT").setHeaderParam("alg", "HS256")
                .setIssuedAt(now).setIssuer(issuer).signWith(SignatureAlgorithm.HS512, secreKeyBytes);
        if (!StringUtils.isEmpty(roles)) {
            builder.claim("roles", roles);
        }
        if (!StringUtils.isEmpty(permissions)) {
            builder.claim("perms", permissions);
        }
        // 添加过期时间，和token不被接受时间
        builder.setExpiration(exp).setNotBefore(nbf);
        // 生成压缩的字符串
        return builder.compact();
    }

    /**
     * getClaims
     *
     * @param jwt
     * @return
     */
    public static Claims verifyToken(String jwt) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new AuthenticationException("JWT 令牌过期:" + e.getMessage());
        } catch (UnsupportedJwtException e) {
            throw new AuthenticationException("JWT 令牌无效:" + e.getMessage());
        } catch (MalformedJwtException e) {
            throw new AuthenticationException("JWT 令牌格式错误:" + e.getMessage());
        } catch (SignatureException e) {
            throw new AuthenticationException("JWT 令牌签名无效:" + e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new AuthenticationException("JWT 令牌参数异常:" + e.getMessage());
        } catch (Exception e) {
            throw new AuthenticationException("JWT 令牌错误:" + e.getMessage());
        }
        return claims;
    }

}
