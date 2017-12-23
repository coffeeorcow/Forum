<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">

<head>
    <title>我的idea</title>
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
            <%@include file="../common/userNav.jsp" %>
        </div>

        <%-- 内容显示--%>
        <div class="col-sm-9">
            <div class="container-fluid">
                <div class="row">
                    <c:choose>
                        <c:when test="${empty itemInfoList}">
                            <div class="col-sm-12">
                                <h3>你什么都没有留下-_-||</h3>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${itemInfoList}" var="item">
                                <div class="col-sm-10">
                                    <div class="well">
                                        <h4>${item.item.itemTitle}</h4>
                                        <hr>
                                        <p class="text-right">
                                            所属板块名称：${item.boardName}&nbsp;
                                            回复数：${item.replyCount}&nbsp;
                                            创建时间：<fmt:formatDate value="${item.item.itemCreateTime}"/>
                                        </p>
                                        <p>&nbsp;&nbsp;${item.item.itemContent}</p>
                                        <a class="btn btn-default" href="/user/item/itemId=${item.item.itemId}">查看详情</a>
                                        <a class="btn btn-default" href="/user/updateItem/itemId=${item.item.itemId}">修改</a>
                                        <a class="btn btn-default" href="/userItem/deleteItem/itemId=${item.item.itemId}">删除</a>
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