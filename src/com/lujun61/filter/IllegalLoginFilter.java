package com.lujun61.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description 为网站中所有的资源文件都设置过滤器，目的防止用户非法登录
 * @author Jun Lu
 * @date 2021-10-03 12:35:07
 */
public class IllegalLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession(false);

        /*
            1、login相当于一个身份标识（登录），只要含有这个身份标识就需要放行
            2、欢迎资源文件也必须放行
            3、session不为空，说明用户访问合法
        */
        if (requestURI.contains("login") || "/myWeb/".equals(requestURI) || session != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        request.getRequestDispatcher("/login_error.html").forward(servletRequest, servletResponse);
    }
}