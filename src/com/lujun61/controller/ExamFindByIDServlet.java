package com.lujun61.controller;

import com.lujun61.dao.ExamDAO;
import com.lujun61.entity.Exam;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ExamFindByIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String examID = request.getParameter("examID");
        //2、调用DAO对象将Insert命令推送至数据库，并得到处理结果
        ExamDAO dao = new ExamDAO();
        Exam exam = dao.findByID(examID);

        request.setAttribute("singleExam", exam);
        request.getRequestDispatcher("/exam_Update.jsp").forward(request, response);
    }
}
