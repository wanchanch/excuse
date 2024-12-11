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
            background-color: #960603;
            color: #fff;
        }

        button.update-btn {
            background-color: #3c6f93;
            color: #fff;
        }

        button.delete-btn:hover {
            background-color: #590404;
        }

        button.update-btn:hover {
            background-color: #164349;
        }
    </style>
</head>
<body>
<jsp:include page="page/top.jsp"></jsp:include>
<jsp:include page="page/student-menu.jsp"></jsp:include>

<div id="main-container">
    <%
        List<Excuse> excuseList = (List<Excuse>) request.getAttribute("excuses");
    %>
    <div id="list">
        <table>
            <thead>
            <tr>
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
                <td><%= excuse.getId() %></td>
                <td><%= excuse.getSname() %></td>
                <td><%= excuse.getSclass() %></td>
                <td><%= excuse.getStart() %></td>
                <td><%= excuse.getEnd() %></td>
                <td><%= excuse.getType() %></td>
                <td><%= excuse.getWhy() %></td>
                <td><%= excuse.getAgree() %></td>
                <td>
                    <button class="update-btn" type="button" onclick="updateExcuse('<%= excuse.getId() %>', '<%= excuse.getSname() %>', '<%= excuse.getSclass() %>')">修改</button>
                    <button class="delete-btn" type="button" onclick="deleteExcuse('<%= excuse.getId() %>')">撤回</button>
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

    function updateExcuse(id, sname, sclass) {
        location = "Update.jsp?id=" + encodeURIComponent(id) + "&sname=" + encodeURIComponent(sname) + "&sclass=" + encodeURIComponent(sclass);
    }

</script>

</body>
</html>
