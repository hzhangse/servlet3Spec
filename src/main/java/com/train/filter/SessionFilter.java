package com.train.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

//@WebFilter(urlPatterns = { "/*" }, initParams = {
//		@WebInitParam(name = "logonStrings", value = "login.jsp"),
//		@WebInitParam(name = "includeStrings", value = ".jsp;.html;.htm"),
//		@WebInitParam(name = "redirectPath", value = "./login.jsp"),
//		@WebInitParam(name = "disabletestfilter", value = "n") })
public class SessionFilter implements Filter {
	String logonStrings, includeStrings, redirectPath, disabletestfilter;
	String[] logonList, includeList;

	private boolean isContains(String containers, String[] regx) {
		boolean result = false;
		for (int i = 0; i < regx.length; i++) {
			if (containers.indexOf(regx[i]) != -1)
				return true;
		}
		return result;
	}

	public FilterConfig config;

	private void setFilterConfig(FilterConfig config) {
		this.config = config;
	}

	private FilterConfig getFilterConfig() {
		return config;
	}

	// 必须重写
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		logonStrings = config.getInitParameter("logonStrings");
		includeStrings = config.getInitParameter("includeStrings");
		redirectPath = config.getInitParameter("redirectPath");
		disabletestfilter = config.getInitParameter("disabletestfilter");
		logonList = logonStrings.split(";");// 分割为数组
		includeList = includeStrings.split(";");// 分割为数组
	}

	// 必须重写
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {
		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpServletResponse httpres = (HttpServletResponse) response;
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(
				(HttpServletResponse) response);
		if (disabletestfilter.toUpperCase().equals("Y")) {
			chain.doFilter(request, response);// 如果不过滤
			return;
		}
		Object user = httpreq.getSession().getAttribute("userinfo");
		if (user == null) {// 该用户没有登录
			if (!isContains(httpreq.getRequestURI(), includeList)) {
				chain.doFilter(request, response);
				return;// 访问的是不受保护的页面，可以
			}
			if (isContains(httpreq.getRequestURI(), logonList)) {
				chain.doFilter(request, response);
				return; // 访问的是登录页面，可以
			}
			wrapper.sendRedirect(redirectPath); // 转向登页面
		} else {// 该用户已经登录
			chain.doFilter(request, response);
		}
	}

	// 必须重写
	public void destroy() {
		config = null;
	}
}
