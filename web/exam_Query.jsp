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
temp
<table style="border: 35px;">
    <tr align="center">
        <td>试题编号</td>
        <td>试题标题</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
        <td>试题答案</td>
    </tr>

    <%
        List list = (List) request.getAttribute("exam_Info");
    %>

    <tr align="center">
        <td></td>
        <td>试题标题</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
        <td>试题答案</td>
    </tr>

</table>




</body>
</html>
