<%@ page import="com.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 20px;
        }
        .container {
            width: 50%;
            margin: 0 auto; /* 实现水平居中 */
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        h2, th, td{
            font-family: "新宋体", serif;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        input[type="button"] {
            padding: 10px 20px;
            background-color: rgb(28, 100, 131);
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="button"]:hover {
            background-color: rgb(0, 67, 97);
        }
    </style>
</head>
<body>
<div class="container">
    <h2>个人信息</h2>
    <%
        String role = (String) session.getAttribute("role");
        String redirectUrl =null;
        if ("老师".equals(role)) {
            redirectUrl = "tlist";
        }else if ("学生".equals(role)){
            redirectUrl = "list";
        }
        else if ("管理员".equals(role)){
            redirectUrl = "adminList";
        }
    %>
    <%
        User user = (User) request.getAttribute("user");
        if (user != null) {
    %>
    <table>
        <tr>
            <td>用户名：</td>
            <td><span><%= user.getUsername() %></span></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><span><%= user.getSname() %></span></td>
        </tr>
        <tr>
            <td>班级：</td>
            <td><span><%= user.getSclass() %></span></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td><span><%= user.getSex() %></span></td>
        </tr>
        <tr>
            <td>身份：</td>
            <td><span><%= user.getIdentity() %></span></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center;"><input type="button" value="返回首页" onclick="location.href='<%= redirectUrl %>'"></td>
        </tr>
    </table>
    <%
    } else {
    %>
    <p>未找到用户信息。</p>
    <%
        }
    %>
</div>

</body>
</html>
