<%--
  Created by IntelliJ IDEA.
  User: 35557
  Date: 2024/6/12
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('img/bg2.jpg') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        #registerbox {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 40px;
            width: 400px;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
            color: #333;
        }

        table {
            width: 100%;
            margin-top: 20px;
        }

        table th {
            font-size: 24px;
            text-align: center;
            padding-bottom: 20px;
        }

        table td {
            padding: 10px 0;
            text-align: left;
        }

        input[type="text"], input[type="password"], input[type="number"], input[type="submit"] {
            padding: 10px;
            width: calc(100% - 22px);
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #1c6483;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #004361;
        }

        .role-option {
            text-align: left;
            margin-bottom: 15px;
        }

        .role-option input {
            margin-right: 10px;
        }

        .register-link {
            margin-top: 20px;
            display: block;
            color: #1c6483;
            text-decoration: none;
            transition: color 0.3s;
        }

        .register-link:hover {
            color: #004361;
        }
    </style>
</head>
<body>
<div id="registerbox">
    <h2>注册</h2>
    <form action="register" method="post">
        <table>
            <tr>
                <td>请输入账号：</td>
                <td><input name="username" type="text" required></td>
            </tr>
            <tr>
                <td>请输入密码：</td>
                <td><input name="password" type="password" required></td>
            </tr>
            <tr>
                <td>请输入姓名：</td>
                <td><input name="sname" type="text" required></td>
            </tr>
            <tr>
                <td>请输入班级：</td>
                <td><input name="sclass" type="number" required> 班</td>
            </tr>
            <tr>
                <td>请输入性别：</td>
                <td>
                    <label><input name="sex" type="radio" value="男" required checked> 男</label>
                    <label><input name="sex" type="radio" value="女" required> 女</label>
                </td>
            </tr>
            <tr>
                <td>请选择身份：</td>
                <td colspan="2" class="role-option">
                    <label><input type="radio" name="role" value="学生" checked> 学生</label>
                    <label><input type="radio" name="role" value="老师"> 老师</label>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;"><input type="submit" value="确定"></td>
            </tr>
        </table>
        <a href="Login.jsp" class="register-link">登录</a>
    </form>
</div>
</body>
</html>
