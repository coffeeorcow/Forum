<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE>
<html>
<head>
    <title>模块管理</title>
    <%@include file="../common/head.jsp" %>
    <link rel="stylesheet" href="/css/admin/main.css">
</head>
<body>
<div class="container-fluid">
    <!-- 页头 -->
    <%@ include file="../common/adminHead.jsp"%>

    <%-- 页面内容--%>
    <div class="row">
        <div class="content">
            <!-- 菜单栏 -->
            <div class="col-sm-3">
                <%@ include file="../common/adminNav.jsp"%>
            </div>

            <%-- 主体内容--%>
            <div class="col-sm-9">
                <!-- 搜索框 -->
                <div class="row">
                    <div class="col-sm-3 col-sm-offset-9">
                        <form class="form-inline" role="form" action="/admin/board" method="post">
                            <div class="form-group">
                                <input name="boardName" type="text" class="form-control" placeholder="此处输入模块名">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-default form-control">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>

                <%-- 模块信息显示--%>
                <div class="row">
                    <c:choose>
                        <c:when test="${empty boardList}">
                            <h4>没有搜索到相关信息-_-||</h4>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${boardList}" var="board">
                                <div class="col-sm-10 well">
                                    <form class="form-horizontal" role="form" action="/admin/updateBoard" method="post">
                                        <div class="form-group">
                                            <label for="boardName" class="col-sm-2 control-label">模块名称</label>
                                            <div class="col-sm-10">
                                                <input type="hidden" name="boardId" value="${board.board.boardName}">
                                                <input type="text" id="boardName" name="boardName" class="form-control" value="${board.board.boardName}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="boardDescription" class="col-sm-2 control-label">模块描述</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control" id="boardDescription" name="boardDescription" rows="8">${board.board.boardDescription}</textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-10 col-sm-offset-2">
                                                <div class="col-sm-2">
                                                    <button type="submit" class="form-control btn btn-default">修改</button>
                                                </div>
                                                <div class="col-sm-2">
                                                    <a class="form-control btn btn-default" href="/admin/deleteBoard/boardId=${board.board.boardId}">删除</a>
                                                </div>

                                            </div>
                                        </div>
                                    </form>
                                    <div class="col-sm-10 col-sm-offset-2">
                                        <hr>
                                        <p class="text-right">数量统计：${board.count}条</p>
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

</body>
</html>