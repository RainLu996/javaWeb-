<%@ page import="java.util.List" %>
<%@ page import="com.lujun61.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: 陆俊
  Date: 2021/10/3
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <table border='2'>
        <tr align='center'>
            <td>用户编号</td>
            <td>用户姓名</td>
            <td>用户密码</td>
            <td>用户性别</td>
            <td>用户邮箱</td>
            <td>操作</td>
        </tr>

        <%
            List list = (List)request.getAttribute("users");
            for(int i = 0; i < list.size(); i++) {
                Users user = (Users) list.get(i);
        %>

        <tr align='center'>
        <td><%=user.getUserId()%></td>
        <td><%=user.getUserName()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getSex()%></td>
        <td><%=user.getEmail()%></td>
        <td><a href="/myWeb/user/del?userID=<%=user.getUserId()%>">删除用户</a></td>
        </tr>

        <%
            }
        %>
    </table>
</center>
</body>
</html>
