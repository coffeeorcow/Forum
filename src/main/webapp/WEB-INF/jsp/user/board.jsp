<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">

<head>
    <title>模块页</title>
    <%@ include file="../common/head.jsp" %>
    <link rel="stylesheet" href="/css/user/board.css">
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
            <%@include file="../common/userNav.jsp" %>
        </div>

        <%-- 内容显示--%>
        <div class="col-sm-9">
            <div class="container-fluid">
                <%-- 搜索模块--%>
                <div class="row">
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
                    <hr>
                </div>

                <%-- 显示搜索出来的board--%>
                <c:if test="${empty boardList}">
                    <div class="row">
                        <div class="col-sm-12">
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
                        </div>
                    </div>
                </c:if>

                <div class="row">
                    <div class="col-sm-12">
                        <h4>@悄悄告诉你~~&nbsp;精彩内容在下面@&nbsp;&nbsp;
                            <span class="glyphicon glyphicon-arrow-down"></span>
                        </h4>
                        <hr>
                    </div>

                    <%-- 显示item内容--%>
                    <c:choose>
                        <c:when test="empty itemInfos">
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
                                        <a id="board" class="btn btn-primary"
                                           href="/user/board/boardId=${item.item.boardId}">${item.boardName}</a>
                                        <label for="author">作者</label>
                                        <a id="author" class="btn btn-default disable">${item.userName}</a>
                                        <label for="reply">回复数</label>
                                        <a id="reply" class="btn btn-default disable">${item.replyCount}</a>
                                        <label for="time">创建时间</label>
                                        <a id="time" class="btn btn-default disable"><fmt:formatDate
                                                value="${item.item.itemCreateTime}"/></a>
                                        <a class="btn btn-success"
                                           href="/user/item/itemId=${item.item.itemId}">查看更多</a>
                                        <p>${item.item.itemId}</p>
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


<script type="text/javascript" src="/js/user/main.js"></script>
</body>
</html>