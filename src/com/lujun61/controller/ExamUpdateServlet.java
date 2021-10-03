package com.lujun61.controller;

import com.lujun61.dao.ExamDAO;
import com.lujun61.entity.Exam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ExamUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String title = request.getParameter("title");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String optionD = request.getParameter("optionD");
        String answer = request.getParameter("answer");
        String ID = request.getParameter("examID");

        Exam exam = new Exam(Integer.parseInt(ID), title, optionA, optionB, optionC, optionD, answer);
        ExamDAO dao = new ExamDAO();
        int result = dao.updateExam(exam);
        if (result == 1) {
            request.setAttribute("info", "试题修改成功");
        } else {
            request.setAttribute("info", "试题修改失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
