package com.lujun61.controller;

import com.lujun61.dao.ExamDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ExamDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ExamDAO dao = new ExamDAO();

        int result = dao.deleteExam(request.getParameter("examID"));
        if (result == 1) {
            request.setAttribute("info", "试题删除成功");
        } else {
            request.setAttribute("info", "试题删除失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
