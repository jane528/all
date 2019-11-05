<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" type="text/css">
    <title>登录界面</title>
    <script>

    </script>
</head>
<body>
    <div class="container">

        <form class="form-horizontal" action=" https://www.easy-mock.com/mock/5d6f868ccf6511682c3a755d/example/upload" method="post">
            <div class="form-group">
                <label class="control-label col-sm-2" for="username">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="请输入用户名" id="username" name="username">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="password">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" placeholder="请输入用户名" id="password" name="password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                    <input type="submit"  value="登录" id="login">
                </div>
            </div>
        </form>
    </div>
</body>
</html>
