<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE>
<html>
<head>
    <title>item管理</title>
    <%@include file="../common/head.jsp" %>
    <link rel="stylesheet" href="/css/admin/main.css">
</head>

<body>
<div class="container-fluid">
    <%-- 页头--%>
    <%@ include file="../common/adminHead.jsp" %>

    <%-- 页面内容--%>
    <div class="row">
        <div class="content">
            <%-- 菜单栏--%>
            <div class="col-sm-3">
                <%@ include file="../common/adminNav.jsp"%>
            </div>

            <%-- 主体内容--%>
            <div class="col-sm-9">
                <!-- 搜索框 -->
                <div class="row">
                    <div class="col-sm-3 col-sm-offset-9">
                        <form class="form-inline" role="form" action="/admin/item" method="post">
                            <div class="form-group">
                                <input name="itemTitle" type="text" class="form-control" placeholder="此处输入idea标题">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-default form-control">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>

                <%-- item信息显示--%>
                <div class="row">
                    <c:choose>
                        <c:when test="${empty itemList}">
                            <h4>没有查找到相关item</h4>
                        </c:when>
                        <c:otherwise>
                            <c:forEach  items="${itemList}" var="item">
                                <div class="col-sm-10 well">
                                    <h4>${item.item.itemTitle}</h4>
                                    <p class="text-right">
                                        创建者：${item.userName}
                                        所属板块：${item.boardName}
                                        回复数：${item.replyCount}
                                        创建时间：<fmt:formatDate value="${item.item.itemCreateTime}"></fmt:formatDate>
                                    </p>
                                    <hr>
                                    <p>&nbsp;&nbsp;${item.item.itemContent}</p>
                                    <a class="btn btn-default" href="/admin/deleteItem/itemId=${item.item.itemId}">删除</a>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>

            </div>
        </div>
    </div>
</div>
</body>