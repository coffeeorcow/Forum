<%--
  Created by IntelliJ IDEA.
  User: wjy
  Date: 2017/11/18
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">

<head>
    <title>Forum 主页</title>
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
        <div class="col-sm-3 ">
            <!-- 菜单导航 -->
            <%@include file="../common/userNav.jsp" %>
        </div>

        <!-- 内容显示 -->
        <div class="col-sm-9">
            <div class="container-fluid">
                <!-- 模块显示 -->
                <div class="row">
                    <div class="col-sm-10">
                        <h4>快选择一个你感兴趣的模块~</h4>
                        <hr>
                    </div>

                    <c:choose>
                        <c:when test="empty boardList">
                            <div class="col-sm-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4>暂无板块内容</h4>
                                    </div>
                                    <div class="panel-body">
                                        <p>&nbsp;&nbsp;管理员很懒还没有添加模块。。</p>
                                    </div>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${boardList}" var="board">
                                <div class="col-sm-6">
                                    <a href="/user/board/boardId=${board.board.boardId}">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <h5>${board.board.boardName}</h5>
                                            </div>
                                            <div class="panel-body">
                                                <p>&nbsp;&nbsp;${board.board.boardDescription}</p>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>

                    <!-- 搜索模块 -->
                    <div class="row">
                        <div class="col-sm-7">
                            <p class="text-danger">
                                <big>没有发现？&nbsp;&nbsp;&nbsp;</big>没关系~~&nbsp;&nbsp;试着搜索一下吧&nbsp;^_^||</p>
                        </div>
                        <div class="col-sm-3 col-sm-offset-2">
                            <form class="form-inline" role="form" action="/user/board" method="post">
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
                        </div>
                    </div>

                    <!-- item显示的提示 -->
                    <div class="row">
                        <div class="col-sm-12">
                            <hr>
                            <h4>@悄悄告诉你~~&nbsp;精彩内容在下面@&nbsp;&nbsp;
                                <span class="glyphicon glyphicon-arrow-down"></span>
                            </h4>
                        </div>

                        <!-- 显示item内容 -->
                        <c:choose>
                            <c:when test="empty itemList">
                                <div class="col-sm-12">
                                    <div class="well">
                                        <p>哎..大家很懒，什么都没留下。。</p>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${itemInfos}" var="item">
                                    <div class="col-sm-12">
                                        <div class="well">
                                            <h4>${item.item.itemTitle}</h4>
                                            <hr>
                                            <label for="board">所属板块：</label>
                                            <a id="board" class="btn btn-primary" href="/user/board/boardId=${item.item.boardId}">${item.boardName}</a>
                                            <label for="author">作者</label>
                                            <a id="author" class="btn btn-default disable">${item.userName}</a>
                                            <label for="reply">回复数</label>
                                            <a id="reply" class="btn btn-default disable">${item.replyCount}</a>
                                            <label for="time">创建时间</label>
                                            <a id="time" class="btn btn-default disable"><fmt:formatDate value="${item.item.itemCreateTime}"/></a>
                                            <a class="btn btn-success" href="/user/item/itemId=${item.item.itemId}">查看更多</a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- footer -->
<footer class="container-fluid">
    <h5 class="text-center">内容全属原创</h5>
    <div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
        <a class="btn btn-large" data-edit="bold">
            <i class="icon-bold"></i>
        </a>
    </div>
    <p class="text-center">Created by wjy on 我也不知道这里该写啥</p>
</footer>

<%-- js文件--%>
<script type="text/javascript" src="/js/user/main.js"></script>
</body>

</html>
