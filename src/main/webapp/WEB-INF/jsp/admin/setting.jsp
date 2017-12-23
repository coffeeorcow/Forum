<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE>
<html>
<head>
    <title>管理员设置</title>
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
            <!-- 菜单栏 -->
            <div class="col-sm-3">
                <%@ include file="../common/adminNav.jsp" %>
            </div>

            <%-- 主体内容--%>
            <div class="col-sm-9">
                <form class="form-horizontal" role="form" action="/admin/updateAdmin" method="post">
                    <div class="form-group">
                        <label for="userName" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" id="userName" name="userName" class="form-control"
                                   value="${admin.userName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text" id="password" name="password" class="form-control"
                                   value="${admin.password}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="userEmail" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-10">
                            <input type="email" id="userEmail" name="userEmail" class="form-control"
                                   value="${admin.userEmail}">
                        </div>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="col-sm-offset-11 btn btn-success">提交修改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>