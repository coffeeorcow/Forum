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

<!-- 页面主体 -->
<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-3">
            <%@include file="../common/userNav.jsp" %>
        </div>

        <%-- 内容展示--%>
        <div class="col-sm-9">
            <div class="container-fluid">
                <div class="row">
                    <%-- 搜索模块--%>
                    <form class="form-inline" role="form" action="/user/newItem" method="post">
                        <div class="form-group">
                            <label class="sr-only" for="boardName">模块名称</label>
                            <input type="text" class="form-control" id="boardName" name="boardName"
                                   placeholder="请输入模块名称">
                        </div>
                        <div class="form-group">
                            <button id="serachBorad" type="submit">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </div>
                    </form>
                    <hr>
                </div>

                <div class="row">
                    <%-- 添加item--%>
                    <c:choose>
                        <c:when test="${empty boardList}">
                            <h4>您搜索的模块未查找到，因此不能添加到该模块</h4>
                            <p>如果你想要添加该模块可以向管理员反馈，我们会尽快审核并处理的~</p>
                        </c:when>
                        <c:otherwise>
                            <form class="form" role="form" action="/userItem/newItem" method="post">
                                    <%-- 选择模块--%>
                                <div class="form-group">
                                    <label>请选择模块</label>
                                    <c:forEach items="${boardList}" var="board">
                                        <div class="radio-inline">
                                            <label>
                                                <input type="radio" name="boardId" checked
                                                       value="${board.board.boardId}">${board.board.boardName}
                                            </label>
                                        </div>
                                    </c:forEach>
                                </div>
                                    <%-- 添加item信息--%>
                                <div class="form-group">
                                    <label for="title">标题</label>
                                    <input type="text" id="title" name="itemTitle" class="form-control" placeholder="不能为空的！">
                                </div>
                                <div class="form-group">
                                    <label for="itemContent">内容</label>
                                    <textarea class="form-control"  name="itemContent" id="itemContent" rows="20"></textarea>
                                </div>
                                <div class="form-group">
                                    <button class="btn btn-primary" class="form-control" type="submit">提交</button>
                                </div>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/js/user/main.js"></script>
</body>
</html>