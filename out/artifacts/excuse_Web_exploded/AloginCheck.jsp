<%@ page import="java.util.List" %>
<%@ page import="com.model.Excuse" %>
<%@ page import="com.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: 35557
  Date: 2024/6/12
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        setTimeout(function() {
            window.location.replace("adminList");
        }, 1000);
    </script>
    <title>Title</title>
</head>
<body>
<%
    String username = (String) session.getAttribute("username");
%>
<p>登录成功</p>
<p>欢迎您，<%= username %></p>


</body>
</html>
