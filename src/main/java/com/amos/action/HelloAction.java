package com.amos.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.amos.service.IHello;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class HelloAction {
	private IHello hello;
	public void setHello(IHello hello) {
		this.hello = hello;
	}
	public String execute(){
		ApplicationContext acx = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		hello = acx.getBean(IHello.class);
		//调用业务层组件
		String msg = hello.sayHi();
		System.out.println("msg:"+msg);
		ActionContext.getContext().put("msg", msg);
		return Action.SUCCESS;
	}
}
