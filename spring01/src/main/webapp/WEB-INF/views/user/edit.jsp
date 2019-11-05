<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/22
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" type="text/css">
    <title>编辑页面</title>
</head>
<body>
    <div class="container">
        <form class="form-horizontal" action="/save?id=${user.id}" method="post" >
            <div class="form-group">
                <label class="control-labeln col-sm-2">用户名</label>
                <div class="col-sm-5">
                    <input type="text" value="${user.username}" class="form-control" name="username">
                </div>
            </div>
            <div class="form-group">
                <label class="control-labeln col-sm-2">密码</label>
                <div class="col-sm-5">
                    <input type="password" value="${user.password}" class="form-control" name="password">
                </div>
            </div>
            <div class="form-group">
                <input class="btn btn-info" type="submit" value="确定">
            </div>
        </form>
    </div>
</body>
</html>
