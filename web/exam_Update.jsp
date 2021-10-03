<%@ page import="com.lujun61.entity.Exam" %><%--
  Created by IntelliJ IDEA.
  User: 陆俊
  Date: 2021/10/3
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <%
            Exam singleExam = (Exam) request.getAttribute("singleExam");
        %>
<center>
    <form action="/myWeb/exam/update">
        <table border="2">
            <tr align="center">
                <td>试题编号：</td>
                <td><input type="text" name="examID" value="<%=singleExam.getExamID()%>" readonly></td>
            </tr>
            <tr align="center">
                <td>题目：</td>
                <td><input type="text" name="title" value="<%=singleExam.getTitle()%>"></td>
            </tr>
            <tr align="center">
                <td>A选项：</td>
                <td><input type="text" name="optionA" value="<%=singleExam.getOptionA()%>"></td>
            </tr>
            <tr align="center">
                <td>B选项：</td>
                <td><input type="text" name="optionB" value="<%=singleExam.getOptionB()%>"></td>
            </tr>
            <tr align="center">
                <td>C选项：</td>
                <td><input type="text" name="optionC" value="<%=singleExam.getOptionC()%>"></td>
            </tr>
            <tr align="center">
                <td>D选项：</td>
                <td><input type="text" name="optionD" value="<%=singleExam.getOptionD()%>"></td>
            </tr>
            <tr align="center">
                <td>正确答案：</td>
                <td>
                    <input type="radio" name="answer" value="A" <%="A".equals(singleExam.getAnswer()) ? "checked" : ""%>>A
                    <input type="radio" name="answer" value="B" <%="B".equals(singleExam.getAnswer()) ? "checked" : ""%>>B
                    <input type="radio" name="answer" value="C" <%="C".equals(singleExam.getAnswer()) ? "checked" : ""%>>C
                    <input type="radio" name="answer" value="D" <%="D".equals(singleExam.getAnswer()) ? "checked" : ""%>>D
                </td>
            </tr>
            <tr align="center">
                <td><input type="submit" value="更新试题"></td>
                <td><input type="reset" value="                重置                "></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
