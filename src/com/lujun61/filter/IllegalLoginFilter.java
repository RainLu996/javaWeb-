package com.lujun61.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IllegalLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //ServletRequest是HttpServletRequest的父类
        //子类继承父类，同时对父类功能进行扩展
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession(false);
        if (session == null) {
            request.getRequestDispatcher("/login_error.html").forward(servletRequest, servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
