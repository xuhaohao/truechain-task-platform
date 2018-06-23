package com.truechain.task.plat.form.security.filter;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 基于用户名密码的认证过滤器
 */
public class PasswordFilter extends AccessControlFilter {

    private static final Logger logger = LoggerFactory.getLogger(PasswordFilter.class);


    /**
     * 允许放行
     *
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object o) throws Exception {
        Subject subject = getSubject(request, response);
        if (null != subject && subject.isAuthenticated()) {
            return true;
        }
        return false;
    }

    /**
     * 拒绝
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isPasswordSubmission(request)) {
            AuthenticationToken token = createPasswordToken(request);
            try {
                Subject subject = getSubject(request, response);
                subject.login(token);
                return true;
            } catch (AuthenticationException e) {//认证失败，发送401状态并附带异常信息
                logger.error(e.getMessage(), e);
                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            }
        }
        return false;
    }

    /**
     * 是否密码登录
     *
     * @param request
     * @return
     */
    private boolean isPasswordSubmission(ServletRequest request) {
        return false;
    }

    /**
     * 创建token
     *
     * @param request
     * @return
     */
    private AuthenticationToken createPasswordToken(ServletRequest request) {
        return null;
    }
}
