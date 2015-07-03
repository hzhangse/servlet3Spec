package com.train.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnLineCountListener implements HttpSessionListener,
		ServletContextAttributeListener, ServletContextListener {
	private int count;
	private ServletContext context = null;

	private void log(String message) {
		System.out.println("ContextListener:" + message);
	}

	private void setContext(HttpSessionEvent se) {

		se.getSession().getServletContext()
				.setAttribute("onLine", new Integer(count));
	}

	
	public void sessionCreated(HttpSessionEvent se) {
		count++;// 人数加1        
		setContext(se);

	}

	
	public void sessionDestroyed(HttpSessionEvent se) {
		count--;// 人数加1        
		setContext(se);

	}

	
	public void contextDestroyed(ServletContextEvent event) {
		log("contextDestroyed()");
		context = null;

	}

	
	public void contextInitialized(ServletContextEvent event) {
		this.context = event.getServletContext();
		log("contextInitialized()");

	}

	
	public void attributeAdded(ServletContextAttributeEvent event) {
		log("attributeAdded(" + event.getName() + "," + event.getValue() + ")");

	}

	
	public void attributeRemoved(ServletContextAttributeEvent event) {
		log("attributeRemove(" + event.getName() + "," + event.getValue() + ")");

	}


	public void attributeReplaced(ServletContextAttributeEvent event) {
		log("attributeReplaced(" + event.getName() + "," + event.getValue()
				+ ")");

	}

}
