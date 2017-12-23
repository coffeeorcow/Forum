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
                <div class="row">
                    <%-- itemm 信息概要--%>
                    <h4>${itemInfo.item.itemTitle}</h4>
                    <p class="text-right">
                        创建者：${itemInfo.userName}&nbsp;&nbsp;
                        所属板块：${itemInfo.boardName}&nbsp;&nbsp;
                        评论数：${itemInfo.replyCount}&nbsp;&nbsp;
                        时间：${itemInfo.item.itemCreateTime}
                    </p>
                    <hr>
                </div>
                <div class="row">
                    <%-- item 内容主体--%>
                    <p>&nbsp;&nbsp;${itemInfo.item.itemContent}</p>
                    <hr>
                </div>
                <div class="row">
                    <%-- 添加评论--%>
                    <div class="well">
                        <form role="form" action="/user/item/itemId=${itemInfo.item.itemId}" method="post">
                            <div class="form-group">
                                <lable for="content">我的评论</lable>
                                <textarea id="replyContent" name="replyContent" class="form-control" rows="4"></textarea>
                                <button type="submit" class="btn btn-success">添加</button>
                            </div>
                        </form>
                    </div>
                    <%-- 评论区--%>
                    <div class="well">
                        <h5>评论区</h5>
                        <c:choose>
                            <c:when test="${empty replyList}">
                                <p>大家很懒，什么都没留下~*~</p>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${replyList}" var="reply">
                                    <p>&nbsp;&nbsp;${reply.reply.replyContent}</p>
                                    <p class="text-right">
                                        评论人：${reply.userName}&nbsp;&nbsp;
                                        评论时间：${reply.reply.replyCreateTime}
                                        <hr>
                                    </p>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script type="text/javascript" src="/js/user/main.js"></script>
</body>
</html>