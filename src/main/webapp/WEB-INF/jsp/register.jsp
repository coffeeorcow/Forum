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
                    <h3 class="panel-title">注册</h3>
                </div>
                <div class="panel-body">
                    <form role="form" id="registerForm" action="/start/register" method="post">
                        <div class="form-group">
                            <label for="userName" class="text-info">用户名</label>
                            <input type="text" class="form-control" id="userName" name="userName" placeholder="不能超过20位"
                                   required="required">
                        </div>
                        <div class="form-grouup">
                            <label for="password" class="text-info">密码</label>
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="建议有符号及大小写组合，但不能超过20位" required="required">
                        </div>
                        <div class="form-group">
                            <label for="userEmail" class="text-info">邮箱地址</label>
                            <input type="email" class="form-control" id="userEmail" name="userEmail"
                                   placeholder="例如：1875256338@qq.com" required="required">
                        </div>
                        <button type="submit" class="btn btn-success">注册</button>
                        <button id="registerBtn" class="btn btn-danger">重置</button>
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