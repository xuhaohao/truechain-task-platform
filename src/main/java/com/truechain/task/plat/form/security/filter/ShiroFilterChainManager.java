package com.truechain.task.plat.form.security.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 拦截器调用链管理
 */
@Component
public class ShiroFilterChainManager {

    private static final Logger logger = LoggerFactory.getLogger(ShiroFilterChainManager.class);

    /**
     * 获取调用链
     *
     * @return
     */
    public Map<String, Filter> getFilters() {
        Map<String, Filter> filters = new LinkedHashMap<>();
        PasswordFilter passwordFilter = new PasswordFilter();
        filters.put("auth", passwordFilter);
        JwtFilter jwtFilter = new JwtFilter();
        filters.put("jwt", jwtFilter);
        return filters;
    }

    /**
     * 获取调用链规则
     *
     * @return
     */
    public Map<String, String> getFilterChain() {
        Map<String, String> filterChain = new LinkedHashMap<>();
        //忽略的URL
        List<String> defaultAno = Arrays.asList("/css/**", "/js/**");
        defaultAno.forEach(ignore -> filterChain.put(ignore, "anon"));
        //需要认证过滤器的URL
        List<String> defalutAuth = Arrays.asList("/account/**");
        defalutAuth.forEach(auth -> filterChain.put(auth, "auth"));
        return filterChain;
    }

}
