<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4><span class="glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;${sessionScope.userName}</h4>
<div class="list-group">
    <a href="/user/main" class="list-group-item">首页</a>
    <a href="/user/oldItem" class="list-group-item">我的idea</a>
    <a href="/user/newItem" class="list-group-item">新的idea</a>
    <a href="/user/reply" class="list-group-item">我的评论</a>
    <a href="/user/setting" class="list-group-item"><span class="glyphicon glyphicon-cog"></span>设置</a>
</div>
