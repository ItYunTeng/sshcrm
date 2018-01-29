package com.ithc.interceptor;

import org.apache.struts2.ServletActionContext;

import com.ithc.bean.Sys_User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInteceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		//判断用户是否登入
		Sys_User user = (Sys_User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(user == null){
			return "login"; 
		}
		
		return invocation.invoke();
	}

}
