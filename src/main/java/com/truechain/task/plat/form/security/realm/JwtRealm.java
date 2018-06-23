package com.truechain.task.plat.form.security.realm;

import com.google.common.collect.Sets;
import com.truechain.task.plat.form.security.token.JwtToken;
import com.truechain.task.plat.form.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * JwtRealm
 */
public class JwtRealm extends AuthorizingRealm {

    @Override
    public Class getAuthenticationTokenClass() {
        return JwtToken.class;
    }

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        JwtPayloadDTO jwtPayloadDTO = (JwtPayloadDTO) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = Sets.newHashSet(StringUtils.split(jwtPayloadDTO.getRoles(), ","));
        info.setRoles(roles);
        Set<String> permissions = Sets.newHashSet(StringUtils.split(jwtPayloadDTO.getPerms(), ","));
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;
        String jwt = (String) jwtToken.getPrincipal();
        Claims claims = JwtUtil.verifyToken(jwt);
        JwtPayloadDTO jwtPayloadDTO = new JwtPayloadDTO();
        jwtPayloadDTO.setTokenId(claims.getId());// 令牌ID
        jwtPayloadDTO.setUserId(claims.getSubject());// 客户标识
        jwtPayloadDTO.setIssuer(claims.getIssuer());// 签发者
        jwtPayloadDTO.setIssuedAt(claims.getIssuedAt());// 签发时间
        jwtPayloadDTO.setAudience(claims.getAudience());// 接收方
        jwtPayloadDTO.setRoles(claims.get("roles", String.class));// 访问主张-角色
        jwtPayloadDTO.setPerms(claims.get("perms", String.class));// 访问主张-权限
        return new SimpleAuthenticationInfo(jwtPayloadDTO, Boolean.TRUE, getName());
    }
}
