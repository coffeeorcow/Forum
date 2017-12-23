<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">

<head>
    <title>添加idea</title>
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
        <%-- 导航菜单--%>
        <div class="col-sm-3">
            <%@include file="../common/userNav.jsp"%>
        </div>

        <%-- 内容显示--%>
        <div class="col-sm-9">
            <div class="container-fluid">
                <div class="row">
                    <form class="form-horizontal" role="form" action="/userItem/updateItem" method="post">
                        <div class="form-group">
                            <label for="itemTitle" class="col-sm-2 control-label">item名称</label>
                            <div class="col-sm-10">
                                <input type="hidden" id="itemId" name="itemId" value="${itemInfo.item.itemId}">
                                <input type="text" id="itemTitle" name="itemTitle" class="form-control" value="${itemInfo.item.itemTitle}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="itemContent" class="col-sm-2 control-label">item内容</label>
                            <div class="col-sm-10">
                                <textarea type="text" id="itemContent" name="itemContent" class="form-control" rows="20" value="${itemInfo.item.itemContent}">${itemInfo.item.itemContent}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary col-sm-offset-10">修改</button>
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