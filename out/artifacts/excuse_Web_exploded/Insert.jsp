<%--
    Created by IntelliJ IDEA.
    User: 35557
    Date: 2024/6/13
    Time: 0:43
    To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请假管理系统</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }

        form {
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 600px;
            margin: 0 auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table tr td {
            padding: 10px 0;
        }

        input[type="text"], input[type="date"], input[type="submit"], input[type="reset"] {
            padding: 8px;
            width: calc(100% - 20px);
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 3px;
        }

        input[type="submit"], input[type="reset"] {
            background-color: rgb(28, 100, 131);
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s;
            width: 100px; /* 确保按钮宽度相同 */
            margin: 0 5px; /* 添加按钮之间的间距 */
        }

        input[type="submit"]:hover, input[type="reset"]:hover {
            background-color: rgb(0, 67, 97);
        }

        .button-row {
            text-align: center;
        }
    </style>
    <script>
        window.onload = function() {
            var today = new Date();
            var yyyy = today.getFullYear();
            var mm = String(today.getMonth() + 1).padStart(2, '0'); // Months are zero-based
            var dd = String(today.getDate()).padStart(2, '0');
            var todayStr = yyyy + '-' + mm + '-' + dd;

            var startDateInput = document.querySelector('input[name="start"]');
            var endDateInput = document.querySelector('input[name="end"]');
            startDateInput.value = todayStr;
            startDateInput.min = todayStr;
            endDateInput.value = todayStr;
            endDateInput.min = todayStr;
        };
    </script>
</head>
<body>
<jsp:include page="page/top.jsp"></jsp:include>
<jsp:include page="page/insert&modify-menu.jsp"></jsp:include>
<%
    String username = (String) session.getAttribute("username");
    String name = (String) session.getAttribute("name");
    String sclass = (String) session.getAttribute("sclass");
%>
<form method="post" action="insert">
    <table border="0" align="center">
        <tr><td>姓名:</td><td><span><%= name %></span></td></tr>
        <tr><td>班级：</td><td><span><%= sclass %> 班</span></td></tr>
        <tr><td></td><td><input type="hidden" name="sname" value="<%= name %>" readonly></td></tr>
        <tr><td></td><td><input type="hidden" name="sclass" value="<%= sclass %>" readonly></td></tr>
        <tr><td>起始日期：</td><td><input type="date" name="start" required></td></tr>
        <tr><td>结束日期：</td><td><input type="date" name="end" required></td></tr>
        <tr><td>请假类型：</td><td><input type="radio" name="type" value="病假" checked>病假 <input type="radio" name="type" value="事假">事假</td></tr>
        <tr><td>请假原因：</td><td><input type="text" name="why" required></td></tr>
        <tr><td><input type="hidden" name="username" value="<%= username %>"></td></tr>

        <tr><td colspan="2" class="button-row">
            <input type="submit" value="提交">
            <input type="reset" value="取消" onclick="location.href='list'">
        </td></tr>
    </table>
</form>
</body>
</html>
