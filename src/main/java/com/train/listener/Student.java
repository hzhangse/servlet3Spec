package com.train.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class Student implements HttpSessionBindingListener {
	private int age = 30;

	
	public void valueBound(HttpSessionBindingEvent arg0) {
		age += 10;

	}

	
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		age -= 5;

	}

	public int getAge() {
		return age;
	}
}
