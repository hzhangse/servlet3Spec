package com.train.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "date", value = "20XX-XX-XX") })
public class CopyrightFilter implements Filter{
    private String date;
    public FilterConfig config;
    //必须重写
    public void init(FilterConfig filterConfig) throws ServletException{
        this.config=filterConfig;
        date=config.getInitParameter("date");
    }
    //必须重写
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain 
                                        chain) throws ServletException, IOException {
        chain.doFilter(request,response);
        PrintWriter out=response.getWriter();
        out.print("<br><center><font size='3' color='red'>版权所有：北京工业大学 </center></font>");
        if (date!=null) 
            out.print("<br><center><font color='blue'>"+date+"</center></font>");
        out.flush();
    }
    //必须重写
    public void destroy() {
        config=null;
    }
}
