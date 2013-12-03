package com.amos.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.amos.service.IHello;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IHello hello;
    public HelloServlet() {
    	System.out.println("初始化！HelloServlet");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// hello
		// 获得hello组件需要通过容器来查找
		//方案1.每次请求都会创建一个容器，不可取！
//		ApplicationContext acx = new ClassPathXmlApplicationContext("bean.xml");
		//方案2，到一个ServletContext变量中去取容器
//		ApplicationContext acx = (ApplicationContext) this.getServletContext().getAttribute("SpringAc");
		//方案3，到一个ServletContext变量中去取容器,容器是由Spring提供的监听器
		//1)
//		ApplicationContext acx = (ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		//2)效果和1一样，但更简便
		ApplicationContext acx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		hello = acx.getBean(IHello.class);
		String result = hello.sayHi();
		System.out.println("result:" + result);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("<h1>" + result + "</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
