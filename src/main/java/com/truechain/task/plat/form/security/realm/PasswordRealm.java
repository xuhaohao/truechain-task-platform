package com.truechain.task.plat.form.security.realm;

import com.truechain.task.plat.form.model.dto.AccountDTO;
import com.truechain.task.plat.form.security.token.PasswordToken;
import com.truechain.task.plat.form.util.MD5Util;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 登录认证realm
 */
public class PasswordRealm extends AuthorizingRealm {

    private AccountService accountService;

    @Override
    public Class getAuthenticationTokenClass() {
        return PasswordRealm.class;
    }

    /**
     * 此处仅处理登录，登录成功之后派发到jwt授权处理
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (!(authenticationToken instanceof PasswordToken)) {
            return null;
        }
        if (null == authenticationToken.getPrincipal() || null == authenticationToken.getCredentials()) {
            throw new UnknownAccountException();
        }
        String userName = (String) authenticationToken.getPrincipal();
        AccountDTO accountDTO = accountService.loadAccount(userName);
        if (accountDTO != null) {
            // 用盐对密码进行MD5加密
            ((PasswordToken) authenticationToken).setPassword(MD5Util.md5(((PasswordToken) authenticationToken).getPassword() + accountDTO.getSalt()));
            return new SimpleAuthenticationInfo(userName, accountDTO.getPassword(), getName());
        } else {
            return new SimpleAuthenticationInfo(userName, "", getName());
        }
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
