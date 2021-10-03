package com.lujun61.controller;

import com.lujun61.dao.ExamDAO;
import com.lujun61.entity.Exam;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ExamRandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExamDAO dao = new ExamDAO();
        List<Exam> exam = dao.randExam();
        HttpSession session = request.getSession(false);

        session.setAttribute("exam", exam);
        request.getRequestDispatcher("/randExam.jsp").forward(request, response);
    }
}
