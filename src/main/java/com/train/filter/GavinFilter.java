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
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "oldword", value = "%") ,
		@WebInitParam(name = "newword", value = "百分号") })
public class GavinFilter implements Filter {
	private String oldword = "%", newword = "百分号";

	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse oldresponse = (HttpServletResponse) response;
		WrapperResponse wrapperResponse = new WrapperResponse(oldresponse);
		chain.doFilter(request, wrapperResponse);
		String html = wrapperResponse.getResponseData(); // 取出响应内容            
		oldresponse.getWriter().print(html.replaceAll(oldword, newword)); // 替换页面中的文字，然后发送给客户
	}

	
	public void init(FilterConfig config) throws ServletException {
		oldword = config.getInitParameter("oldword");
		newword = config.getInitParameter("newword");

	}

}
