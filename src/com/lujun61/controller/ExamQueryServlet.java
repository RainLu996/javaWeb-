package com.lujun61.controller;

import com.lujun61.dao.ExamDAO;
import com.lujun61.entity.Exam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExamQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、调用DAO推送查询命令得到所有的试题
        ExamDAO dao = new ExamDAO();
        List<Exam> list = dao.query();

        //2、将得到的试题添加到请求作用域对象中
        request.setAttribute("exam_Info", list);

        //3、通过请求转发，向HTTP服务器索要exam_Query.jsp文件，向响应体中写入所有试题信息
        request.getRequestDispatcher("/exam_Query.jsp").forward(request, response);
    }
}
