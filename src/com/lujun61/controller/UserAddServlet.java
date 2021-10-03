package com.lujun61.controller;

import com.lujun61.dao.UserDAO;
import com.lujun61.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName, password, email, sex;
        UserDAO dao = new UserDAO();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //1、使用【请求对象】读取【请求头（GET方式）】中的参数信息，从而得到用户信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        email = request.getParameter("email");
        sex = request.getParameter("sex");
        Users user = new Users(null, userName, password, email, sex);

        //2、使用【UserDao】将用户信息填充到insert命令，并借助JDBC规范将数据信息发送到数据库服务器
        int result = dao.add(user);

        //3、使用【响应对象】将【处理结果】以二进制形式写入到响应体中
        /*
        if (result == 1) {
            out.println("<center><font style=\"color: red;font-size: 30px\"></font><center/>");
        } else {
            out.println("<center><font style=\"color: red;font-size: 30px\"></font><center/>");
        }

         */
        if (result == 1) {
            request.setAttribute("info", "用户信息注册成功");
        } else {
            request.setAttribute("info", "用户信息注册失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);

                        /* 由HTTP服务器自动完成的 */
        //销毁【请求对象】和【响应对象】
        //将HTTP响应协议包推送回发起请求的浏览器

                        /* 由浏览器自动完成的 */
        //浏览器根据响应头中的content-type属性指定编译器对响应体中的二进制数据进行编译
        //浏览器将编译后的结果展示在窗口上       宣告【结束】
    }
}
