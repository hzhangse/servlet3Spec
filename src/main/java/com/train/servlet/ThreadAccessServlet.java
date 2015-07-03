package com.train.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.RandomUtils;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

@WebServlet("/access")
public class ThreadAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    Map sycCount =  java.util.Collections.synchronizedMap(new HashMap());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThreadAccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private static String generateId(String threadName){
    	try {
			Thread.sleep(RandomUtils.nextInt(2000));
		} catch (InterruptedException e) {
			
		}
    	return threadName;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String t = Thread.currentThread().getName();
		 String result  = "";
		 String clientNo = request.getParameter("clientNo");
		
		
		 result =  generateId(clientNo);
		 sycCount.put(result, result);
		 response.getWriter().print(sycCount.size() + ":"+result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
