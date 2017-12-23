<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE>
<html>
<head>
    <title>添加新模块</title>
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
                <%-- 添加baord--%>
                <form class="form-horizontal" role="form" id="form1">
                    <div class="form-group">
                        <label for="boardName" class="col-sm-2 control-label">模块名称</label>
                        <div class="col-sm-10">
                            <input type="text" id="boardName" name="boardName" class="form-control" placeholder="此处不能为空！">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="boardDescription" class="col-sm-2 control-label">模块描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="boardDescription" name="boardDescription" rows="8"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-2">
                            <button class="btn btn-default" onclick="reset()">重置</button>
                            <button class="btn btn-default" type="submit">添加</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
    function reset() {
        $('#form1')[0].reset();
    }
</script>
</body>
</html>