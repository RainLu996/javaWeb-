package com.lujun61.controller;

import com.lujun61.entity.Exam;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(false);
        List<Exam> exams = (List<Exam>)session.getAttribute("exam");
        int score = 0;

        for (Exam exam:
             exams) {
            Integer examID = exam.getExamID();
            String answer = exam.getAnswer();
            String parameter = request.getParameter("answer_" + examID);
            if (answer.equals(parameter)) {
                score += 25;
            }
        }
        request.setAttribute("score", "你的得分是：" + score);
        request.getRequestDispatcher("/score.jsp").forward(request, response);
    }
}
