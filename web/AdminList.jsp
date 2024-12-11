<%@ page import="java.util.List" %>
<%@ page import="com.model.Excuse" %>
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
            background-color: #e53935;
            color: #fff;
        }

        button.update-btn {
            background-color: #3c6f93;
            color: #fff;
        }

        button.delete-btn:hover {
            background-color: #d32f2f;
        }

        button.update-btn:hover {
            background-color: #164349;
        }
    </style>
</head>
<body>
<jsp:include page="page/top.jsp"></jsp:include>
<jsp:include page="page/admin-menu_excuse.jsp"></jsp:include>
<div id="main-container">
    <%
        List<Excuse> excuseList = (List<Excuse>) request.getAttribute("excuses");
    %>
    <div id="list">
        <table>
            <thead>
            <tr>
                <th>用户名</th>
                <th>编号</th>
                <th>姓名</th>
                <th>班级</th>
                <th>开始时间</th>
                <th>结束时间</th>
                <th>类型</th>
                <th>原因</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <% if (excuseList != null) {
                for (Excuse excuse : excuseList) { %>
            <tr>
                <td><%= excuse.getUsername() %></td>
                <td><%= excuse.getId() %></td>
                <td><%= excuse.getSname() %></td>
                <td><%= excuse.getSclass() %></td>
                <td><%= excuse.getStart() %></td>
                <td><%= excuse.getEnd() %></td>
                <td><%= excuse.getType() %></td>
                <td><%= excuse.getWhy() %></td>
                <td><%= excuse.getAgree() %></td>
                <td>
                    <input type="radio" name="agree_<%= excuse.getId() %>" value="批准" checked>批准
                    <input type="radio" name="agree_<%= excuse.getId() %>" value="不批准">不批准
                    <button type="button" onclick="checkExcuse('<%= excuse.getId()%>')" class="update-btn">确定</button>
                    <button class="delete-btn" type="button" onclick="deleteExcuse('<%= excuse.getId() %>')">删除</button>
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
    function deleteExcuse(id) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'delete', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                location.reload();
            }
        };
        xhr.send('id=' + encodeURIComponent(id));
    }

    function updateExcuse(id) {
        location = "Update.jsp?id=" + encodeURIComponent(id);
    }
    function checkExcuse(id) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'check', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

        var agree = document.querySelector('input[name="agree_' + id + '"]:checked').value;
        var params = 'id=' + encodeURIComponent(id) + '&agree=' + encodeURIComponent(agree);

        xhr.onload = function() {
            location.reload();
        };
        xhr.send(params);
    }
</script>

</body>
</html>
