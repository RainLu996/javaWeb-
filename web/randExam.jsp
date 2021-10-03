<%@ page import="java.util.List" %>
<%@ page import="com.lujun61.entity.Exam" %><%--
  Created by IntelliJ IDEA.
  User: 陆俊
  Date: 2021/10/3
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="/myWeb/exam/score">
        <table border="2">
            <tr align="center">
                <td>试题编号</td>
                <td>试题标题</td>
                <td>A选项</td>
                <td>B选项</td>
                <td>C选项</td>
                <td>D选项</td>
                <td>你的作答</td>
            </tr>

            <%
                /* EL表达式并不支持遍历循环：所以得利用标记！！！ */
                List exams = (List)session.getAttribute("exam");
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
                <td>
                    <input type="radio" name="answer_<%=exam.getExamID()%>" value="A">A
                    <input type="radio" name="answer_<%=exam.getExamID()%>" value="B">B
                    <input type="radio" name="answer_<%=exam.getExamID()%>" value="C">C
                    <input type="radio" name="answer_<%=exam.getExamID()%>" value="D">D
                </td>
            </tr>

            <%
                }
            %>

            <tr>
                <td colspan="3" align="center"><input type="submit" value="确认提交"></td>
                <td colspan="3" align="center"><input type="reset" value="重做"></td>
                <td align="center"><a href="/myWeb/exam/rand">刷新试题</a> </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
