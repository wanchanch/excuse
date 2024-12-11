<%--
  Created by IntelliJ IDEA.
  User: 35557
  Date: 2024/6/20
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #top {
            width: 1650px;
            height: 100px;
            background-color: #ffffff;
            margin: 0 auto; /* 将0px改为auto，实现水平居中 */
        }

        #text {
            font-family: "华文行楷";
            font-size: 30px;
            text-align: left;
            display: flex;
            align-items: center;
        }

        img {
            width: auto;
            height: 100px;
        }

    </style>
</head>
<body>
<%
    String username = (String) session.getAttribute("username");
%>
<div id="top">
    <div id="text">
        <img src="${pageContext.request.contextPath}/img/top.png" alt="Top Image"> <!-- 确保路径正确 -->
        高校请假系统
    </div>

</div>
</div>
</body>
</html>
