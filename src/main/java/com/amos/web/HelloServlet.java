package com.amos.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		ApplicationContext acx = new ClassPathXmlApplicationContext("bean.xml");
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
