<%--
  Created by IntelliJ IDEA.
  User: wjy
  Date: 2017/11/18
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE>
<html>
<head>
    <title>后台管理</title>
    <%@include file="../common/head.jsp" %>
    <link rel="stylesheet" href="/css/admin/main.css">
</head>
<body>
<div class="container-fluid">
    <!-- 页头 -->
    <%@ include file="../common/adminHead.jsp"%>

    <!-- 页面内容 -->
    <div class="row">
        <div class="content">
            <!-- 菜单栏 -->
            <div class="col-sm-3">
                <%@ include file="../common/adminNav.jsp"%>
            </div>

            <!-- 主体内容 -->
            <div class="col-sm-9">
                <!-- 搜索框 -->
                <div class="row">
                    <div class="col-sm-3 col-sm-offset-9">
                        <form class="form-inline" role="form" action="/admin/main" method="post">
                            <div class="form-group">
                                <input name="userName" type="text" class="form-control" placeholder="此处输入用户名">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-default form-control">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>

                <!-- 用户信息显示 -->
                <div class="row">
                    <c:choose>
                        <c:when test="${empty userList}">
                            <h4>没有查找到相关用户！</h4>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${userList}" var="user">
                                <div class="col-sm-10 well">
                                    <h4>${user.userName}/${user.userEmail}</h4>
                                    <hr>
                                    <a href="/admin/lockUser/userId=${user.userId}" class="btn btn-default">封锁</a>
                                    <a href="/admin/activeUser/userId=${user.userId}" class="btn btn-default">激活</a>
                                    <a href="/admin/changeToUser/userId=${user.userId}" class="btn btn-default">设为普通用户</a>
                                    <a href="/admin/changeToAdmin/userId=${user.userId}" class="btn btn-danger">设为管理员</a>
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
</html>
