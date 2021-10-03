<%@ page import="com.lujun61.entity.Exam" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: 陆俊
  Date: 2021/9/22
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <table border="2">
        <tr align="center">
            <td>试题编号</td>
            <td>试题标题</td>
            <td>A选项</td>
            <td>B选项</td>
            <td>C选项</td>
            <td>D选项</td>
            <td>试题答案</td>
            <td>操作</td>
        </tr>

        <%
            List exams = (List)request.getAttribute("exam_Info");
            for (int i = 0; i < exams.size(); i++) {
                Exam exam = (Exam)exams.get(i);
        %>

        <tr align="center">
            <td><%=exam.getExamID()%></td>
            <td><%=exam.getTitle()%></td>
            <td><%=exam.getOptionA()%></td>
            <td><%=exam.getOptionB()%></td>
            <td><%=exam.getOptionC()%></td>
            <td><%=exam.getOptionD()%></td>
            <td><%=exam.getAnswer()%></td>
            <td>
                <a href="/myWeb/exam/del?examID=<%=exam.getExamID()%>">删除试题</a>
                <a href="/myWeb/exam/findByID?examID=<%=exam.getExamID()%>">更新试题</a>
            </td>
        </tr>

        <%
            }
        %>
    </table>
</center>
</body>
</html>
