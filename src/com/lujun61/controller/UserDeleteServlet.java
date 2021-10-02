package com.lujun61.controller;

import com.lujun61.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String userID = request.getParameter("userID");

        UserDAO dao = new UserDAO();
        int result = dao.delete(userID);

        if (result == 1) {
            out.println("<center><font style=\"color:red;font-size:35px\">用户信息删除成功<font/><center/>");
        } else {
            out.println("<center><font style=\"color:red;font-size:35px\">用户信息删除失败<font/><center/>");
        }
    }
}
