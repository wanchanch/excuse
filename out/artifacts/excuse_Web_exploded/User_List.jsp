<%@ page import="java.util.List" %>
<%@ page import="com.model.Excuse" %>
<%@ page import="com.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Excuse Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        #main-container {
            display: flex;
        }

        #method {
            padding: 20px;
            background-color: #ffffff;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .menu {
            list-style-type: none;
            padding: 0;
            margin: 0;
            background-color: #ffffff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .menu li {
            display: inline-block;
        }

        .menu li a {
            display: block;
            padding: 10px 20px;
            text-decoration: none;
            color: #333;
            transition: background-color 0.3s;
        }

        .menu li a:hover {
            background-color: #f2f2f2;
        }

        #list {
            flex-grow: 1;
            padding: 20px;
            background-color: #ffffff;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
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

        button {
            padding: 5px 10px;
            margin-right: 5px;
            font-size: 14px;
            cursor: pointer;
            border: none;
            border-radius: 3px;
        }

        button.delete-btn {
            background-color: #3c6f93;
            color: #fff;
        }

        button.delete-btn:hover {
            background-color: #163a49;
        }


    </style>
</head>
<body>

<jsp:include page="page/top.jsp"></jsp:include>
<jsp:include page="page/admin-menu_student.jsp"></jsp:include>
<div id="main-container">

    <%
        List<User> userList = (List<User>) request.getAttribute("user_list");
    %>
    <div id="list">
        <table>
            <thead>
            <tr>
                <th>用户名</th>
                <th>密码</th>
                <th>姓名</th>
                <th>班级</th>
                <th>性别</th>
                <th>身份</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <% if (userList != null) {
                for (User user : userList) { %>
            <tr>
                <td><%= user.getUsername() %></td>
                <td><%= user.getPassword() %></td>
                <td><%= user.getSname() %></td>
                <td><%= user.getSclass() %></td>
                <td><%= user.getSex() %></td>
                <td><%= user.getIdentity() %></td>
                <td>
                    <button class="delete-btn" type="button" onclick="deleteUser('<%= user.getUsername() %>')">删除</button>
                </td>
            </tr>

            <%  }
            } else { %>
            <tr>
                <td colspan="9">无数据</td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>

<script>
    function deleteUser(username) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'delete_student', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                location.reload();
            }
        };
        xhr.send('username=' + encodeURIComponent(username));
    }

</script>

</body>
</html>
