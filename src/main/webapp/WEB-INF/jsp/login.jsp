<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">

<head>
    <title>Forum 首页</title>
    <%@include file="common/head.jsp"%>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">登录</h3>
                </div>
                <div class="panel-body">
                    <form role="form" action="/start/login" method="post">
                        <div class="form-group">
                            <label for="userName" class="text-info">用户名</label>
                            <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入用户名"
                                   required="required">
                        </div>
                        <div class="form-grouup">
                            <label for="password" class="text-info">密码</label>
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="请输入密码" required="required">
                        </div>
                        <button type="submit" class="btn btn-success">登录</button>
                        <a class="btn btn-info" href="">注册</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>

</html>