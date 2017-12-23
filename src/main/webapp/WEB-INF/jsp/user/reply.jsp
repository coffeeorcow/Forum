<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">

<head>
    <title>我的回复</title>
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

        <%-- 显示我的评论--%>
        <div class="col-sm-9">
            <div class="container-fluid">
                <c:choose>
                    <c:when test="${empty replyInfoList}">
                        <div class="row">
                            <h4>你还没有留下任何评论-_-||</h4>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="row">
                            <c:forEach items="${replyInfoList}" var="reply">
                                <div class="col-sm-12">
                                    <div class="well">
                                        <h4>${reply.itemTitle}</h4>
                                        <p class="text-right">回复时间：<fmt:formatDate value="${reply.reply.replyCreateTime}"></fmt:formatDate></p>
                                        <hr>
                                        <p>&nbsp;&nbsp;${reply.reply.replyContent}</p>
                                        <a class="btn btn-default" href="/user/deleteReply/replyId=${reply.reply.replyId}">撤销评论</a>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

</div>

<script type="text/javascript" src="/js/user/main.js"></script>
</body>
</html>
