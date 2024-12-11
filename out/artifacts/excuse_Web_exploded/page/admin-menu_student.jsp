<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = (String) session.getAttribute("username");
%>
<html>
<head>
    <title>请假管理系统</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: rgb(28, 100, 131);
            overflow: hidden;
            padding: 10px 0;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .navbar a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            font-size: 17px;
        }

        .navbar a:hover {
            background-color: rgb(0, 67, 97);
            color: white;
        }

        .navbar .left, .navbar .right {
            display: flex;
            align-items: center;
        }

        .navbar .right {
            margin-left: auto;
        }

        .navbar .search-form {
            display: flex;
            align-items: center;
            margin: 0 auto;
        }

        .navbar .search-form input[type="text"] {
            padding: 8px;
            border: none;
            border-radius: 3px 0 0 3px;
            margin-right: -1px; /* Prevents double border */
        }

        .navbar .search-form input[type="submit"] {
            padding: 8px 16px;
            border: none;
            border-radius: 0 3px 3px 0;
            background-color: rgb(0, 67, 97);
            color: white;
            cursor: pointer;
        }

        .navbar .search-form input[type="submit"]:hover {
            background-color: rgb(0, 50, 72);
        }
    </style>
</head>
<body>

<div class="navbar">
    <div class="left">
        <a href="adminList">首页</a>
        <a href="adminList">查看假条</a>
        <a href="student_list">学生管理</a>
        <a href="teacher_list">教师管理</a>

    </div>
    <form action="select_student" method="post" class="search-form">
        <input name="condition" type="text" placeholder="请输入条件" required>
        <input type="submit" value="提交">
    </form>
    <div class="right">
        <a href="personal_list"><%= username %></a>
        <a href="Login.jsp">退出登录</a>
    </div>
</div>
</body>
</html>
