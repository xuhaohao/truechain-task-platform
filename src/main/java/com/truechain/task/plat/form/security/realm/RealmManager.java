package com.truechain.task.plat.form.security.realm;

import com.truechain.task.plat.form.security.token.JwtToken;
import com.truechain.task.plat.form.security.token.PasswordToken;
import org.apache.shiro.realm.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * realm管理器
 */
@Component
public class RealmManager {

    @Autowired
    private AccountService accountService;

    public List<Realm> initRealm() {
        List<Realm> realmList = new LinkedList<>();
        //password
        PasswordRealm passwordRealm = new PasswordRealm();
        passwordRealm.setAccountService(accountService);
        passwordRealm.setAuthenticationTokenClass(PasswordToken.class);
        realmList.add(passwordRealm);
        //jwt
        JwtRealm jwtRealm = new JwtRealm();
        jwtRealm.setAuthenticationTokenClass(JwtToken.class);
        realmList.add(jwtRealm);
        return realmList;
    }
}
