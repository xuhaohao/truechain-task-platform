package com.truechain.task.plat.form.security;

import com.truechain.task.plat.form.security.filter.ShiroFilterChainManager;
import com.truechain.task.plat.form.security.filter.WebSubjectFactory;
import com.truechain.task.plat.form.security.realm.RealmManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager, ShiroFilterChainManager filterChainManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setFilters(filterChainManager.getFilters());
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainManager.getFilterChain());
        return shiroFilterFactoryBean;
    }

    @Bean
    public WebSecurityManager securityManager(RealmManager realmManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setAuthenticator(new ModularRealmAuthenticator());
        DefaultSubjectDAO subjectDAO = (DefaultSubjectDAO) securityManager.getSubjectDAO();
        DefaultSessionStorageEvaluator evaluator = (DefaultSessionStorageEvaluator) subjectDAO.getSessionStorageEvaluator();
        WebSubjectFactory subjectFactory = new WebSubjectFactory(evaluator);
        securityManager.setSubjectFactory(subjectFactory);
        securityManager.setRealms(realmManager.initRealm());
        SecurityUtils.setSecurityManager(securityManager);
        return securityManager;
    }
}
