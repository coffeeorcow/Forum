<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4><span class="glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;${sessionScope.userName}</h4>
<div class="list-group">
    <a href="/admin/main" class="list-group-item">用户管理</a>
    <a href="/admin/board" class="list-group-item">模块管理</a>
    <a href="/admin/newBoard" class="list-group-item">添加模块</a>
    <a href="/admin/item" class="list-group-item">item管理</a>
    <a href="/admin/setting" class="list-group-item"><span class="glyphicon glyphicon-asterisk"></span>设置</a>
</div>