package com.lujun61.controller;

import com.lujun61.dao.ExamDAO;
import com.lujun61.entity.Exam;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ExamAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1、调用请求对象读取请求头，得到参数信息
        String title = request.getParameter("title");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String optionD = request.getParameter("optionD");
        String answer = request.getParameter("answer");

        //2、调用DAO对象将Insert命令推送至数据库，并得到处理结果
        ExamDAO dao = new ExamDAO();
        int result = dao.add(new Exam(null, title, optionA, optionB, optionC, optionD, answer));

        //3、通过请求转发，向HTTP服务器索要info.jsp文件，将处理结果写入到响应体
        if (result == 1) {
            request.setAttribute("info", "试题添加成功");
        } else {
            request.setAttribute("info", "试题添加失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
