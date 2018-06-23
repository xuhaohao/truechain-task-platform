package com.truechain.task.plat.form.security.filter;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * 对于无状态的TOKEN不创建session
 */
public class WebSubjectFactory extends DefaultWebSubjectFactory {

    private final DefaultSessionStorageEvaluator sessionStorageEvaluator;

    public WebSubjectFactory(DefaultSessionStorageEvaluator sessionStorageEvaluator) {
        this.sessionStorageEvaluator = sessionStorageEvaluator;
    }

    @Override
    public Subject createSubject(SubjectContext context) {
        context.setSessionCreationEnabled(Boolean.FALSE);
        this.sessionStorageEvaluator.setSessionStorageEnabled(Boolean.FALSE);
        return super.createSubject(context);
    }
}
