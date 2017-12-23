<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">

<head>
    <title>用户设置</title>
    <%@ include file="../common/head.jsp" %>
    <link rel="stylesheet" href="/css/user/main.css">
</head>

<body>
<!-- 页首导航 -->
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid black-color">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Forum</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a id="mytime" href="#">
                    <span class="glyphicon glyphicon-time"></span>
                </a>
            </li>
            <li>
                <a href="/login">
                    <span class="glyphicon glyphicon-log-in"></span> 注销</a>
            </li>
        </ul>
    </div>
</nav>

<%-- 页面主体--%>
<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-3">
            <%@include file="../common/userNav.jsp" %>
        </div>

        <%-- 用户信息设置--%>
        <div class="col-sm-9">
            <div class="container-fluid">
                <div class="row">
                    <form class="form-horizontal" role="form" action="/user/updateInfo">
                        <div class="form-group">
                            <label for="userName" class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-10">
                                <input type="text" id="userName" name="userName" class="form-control" value="${user.userName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="text" id="password" name="password" class="form-control" value="${user.password}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="userEmail" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-10">
                                <input type="email" id="userEmail" name="userEmail" class="form-control" value="${user.userEmail}">
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="col-sm-offset-11 btn btn-success">提交修改</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>

</div>

<script type="text/javascript" src="/js/user/main.js"></script>
</body>
</html>