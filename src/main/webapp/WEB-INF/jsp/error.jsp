<%--
  Created by IntelliJ IDEA.
  User: wjy
  Date: 2017/11/22
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <title>Forum的出错页</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        出错原因：
                    </h3>
                </div>
                <div class="panel-body">
                    <p>${message}</p>
                    <a class="btn btn-success" href="/login">重新登录</a>
                    <a class="btn btn-danger" href="/register">重新注册</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
