package com.cernet.vipbw.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.Map;

public class LoginInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1358600090729208361L;

    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ctx = invocation.getInvocationContext();
        Map session = ctx.getSession();
        String username = (String) session.get("username");
        if (username != null ) {
            return invocation.invoke();
        }
        return Action.LOGIN;
    }
}