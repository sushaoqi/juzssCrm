package com.juzss.crm.web.interceptor;


import com.juzss.crm.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

public class PrivilegeInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        // 判断session中是否已经有用户的对象
        User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("exist_user");
        if(existUser == null){
            // 没有登录
            ActionSupport actionSupport = (ActionSupport) invocation.getAction();
            actionSupport.addActionError("没有登录！没有权限访问！");
            return actionSupport.LOGIN;
        }else{
            // 已经登录
            return invocation.invoke();
        }
    }
}
