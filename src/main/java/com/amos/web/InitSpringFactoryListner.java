package com.amos.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class InitSpringFactoryListner
 *
 */
public class InitSpringFactoryListner implements ServletContextListener {
    /**
     * Default constructor. 
     */
    public InitSpringFactoryListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	ApplicationContext acx = new ClassPathXmlApplicationContext("bean.xml");
    	arg0.getServletContext().setAttribute("SpringAc", acx);
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
