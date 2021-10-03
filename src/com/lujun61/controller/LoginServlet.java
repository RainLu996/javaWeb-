package com.lujun61.controller;

import com.lujun61.dao.UserDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1、调用请求对象对请求体使用utf-8字符集进行重新编辑
        request.setCharacterEncoding("utf-8");

        //2、调用请求对象读取请求参数信息
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        //3、调用DAO将查询验证信息推送到数据库服务器上
        UserDAO dao = new UserDAO();
        boolean result = dao.login(userName, password);

        //4、调用响应对象，根据验证结果将不同资源文件地址写入到响应头，交给浏览器
        if (result) {
            //登录成功，就给当前用户创建一个session对象
            request.getSession();

            response.sendRedirect("/myWeb/index.html");
        } else {
            response.sendRedirect("/myWeb/login_error.html");
        }
    }
}
