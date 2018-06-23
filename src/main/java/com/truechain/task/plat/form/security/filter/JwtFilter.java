package com.truechain.task.plat.form.security.filter;

import com.truechain.task.plat.form.security.token.JwtToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基于JWT标准的无状态认证过滤器
 */
public class JwtFilter extends PasswordFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    private static final String DEFAULT_JWT_PARAM = "jwt";

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
        if (isJwtSubmission(request)) {
            AuthenticationToken token = createJwtToken(request, response);
            try {
                Subject subject = getSubject(request, response);
                subject.login(token);
                return true;
            } catch (AuthenticationException e) {
                logger.error(e.getMessage(), e);
                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            }
        }
        return false;
    }

    /**
     * 创建JWTToken
     *
     * @param request
     * @param response
     * @return
     */
    private AuthenticationToken createJwtToken(ServletRequest request, ServletResponse response) {
        String jwt = request.getParameter(DEFAULT_JWT_PARAM);
        String host = request.getRemoteHost();
        String userName = "";
        String deviceInfo = "";
        logger.info("authenticate jwt token:" + jwt);
        return new JwtToken(userName, host, deviceInfo, jwt);
    }

    /**
     * 是否JWT请求
     *
     * @param request
     * @return
     */
    private boolean isJwtSubmission(ServletRequest request) {
        String jwt = request.getParameter(DEFAULT_JWT_PARAM);
        return (request instanceof HttpServletRequest) && !StringUtils.isEmpty(jwt);
    }
}
