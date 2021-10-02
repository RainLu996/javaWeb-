package com.lujun61.controller;

import com.lujun61.dao.UserDAO;
import com.lujun61.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        UserDAO dao = new UserDAO();

        //1、调用【DAO】将查询命令推送到数据库服务器上，得到所有的用户信息【List】
        List<Users> elements = dao.query();

        //2、调用【响应对象】将用户信息结合<table>标签命令，以二进制的形式写入到响应体中
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>用户编号<td/>");
        out.print("<td>用户姓名<td/>");
        out.print("<td>用户密码<td/>");
        out.print("<td>用户性别<td/>");
        out.print("<td>用户邮箱<td/>");
        out.print("<td>操作<td/>");
        out.print("<tr/>");

        for (Users user :
             elements) {
            out.print("<tr align='center'>");
            out.print("<td>" + user.getUserId() + "<td/>");
            out.print("<td>" + user.getUserName() + "<td/>");
            out.print("<td>" + user.getPassword() + "<td/>");
            out.print("<td>" + user.getSex() + "<td/>");
            out.print("<td>" + user.getEmail() + "<td/>");

            /* 以用户ID为区分点，删除用户信息 */
            out.print("<td><a href='/myWeb/user/del?userID=" + user.getUserId() + "'>删除用户<a/><td/>");

            out.print("<tr/>");
        }
        out.print("<table/>");
    }
}
