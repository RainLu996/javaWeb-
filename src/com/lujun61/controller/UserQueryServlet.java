package com.lujun61.controller;

import com.lujun61.dao.UserDAO;
import com.lujun61.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO dao = new UserDAO();

        //1、调用【DAO】将查询命令推送到数据库服务器上，得到所有的用户信息【List】
        List<Users> elements = dao.query();

        //2、将得到的用户信息添加到请求作用域对象中
        request.setAttribute("users", elements);

        //3、通过请求转发，向HTTP服务器索要user_Query.jsp文件，向响应体中写入所有试题信息
        request.getRequestDispatcher("/user_Query.jsp").forward(request, response);
    }
}
