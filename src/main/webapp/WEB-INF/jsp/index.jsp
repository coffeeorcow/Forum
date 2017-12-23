<%--
  Created by IntelliJ IDEA.
  User: wjy
  Date: 2017/11/18
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">

<head>
    <title>Forum 首页</title>
    <%@include file="common/head.jsp"%>
    <link rel="stylesheet" href="/css/index.css">
</head>

<body>
<!-- Navbar -->
<nav class="navbar navbar-default bg4">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Forum</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/login">
                        <span class="glyphicon glyphicon-user"></span>登录</a>
                </li>
                <li>
                    <a href="/register">
                        <span class="glyphicon glyphicon-plus"></span>注册</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- First Container -->
<div class="container-fluid bg-1 text-center">
    <h3 class="margin">Forum</h3>
    <img src="/images/forum.png" class="img-responsive img-circle margin" style="display:inline" alt="Forum" width="189" height="174">
    <p>什么是Forum？</p>
    <p>&nbsp;&nbsp;&nbsp;--Forum是由wjy设计专门用于分享新知和见解的论坛</p>
</div>

<!-- Second Container -->
<div class="container-fluid bg-2 text-center">
    <img src="/images/oracle.png" class="img-reponsive img-circle margin" style="display:inline" alt="Oracle" width="200" height="200">
    <h3 class="margin">Oracle数据库</h3>
    <p>Oracle Database，又名Oracle RDBMS，或简称Oracle。是甲骨文公司的一款关系数据库管理系统。它是在数据库领域一直处于领先地位的产品。可以说Oracle数据库系统是目前世界上流行的关系数据库管理系统，系统可移植性好、使用方便、功能强，适用于各类大、中、小、微机环境。它是一种高效率、可靠性好的
        适应高吞吐量的数据库解决方案。</p>
</div>

<!-- Third Container (Grid) -->
<div class="container-fluid bg-3 text-center">
    <h3 class="margin">还有很多。。。</h3>
    <br>
    <div class="row">
        <div class="col-sm-4">
            <p>Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征。Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程</p>
            <img src="/images/java.png" class="img-responsive margin" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-4">
            <p>深度学习的概念源于人工神经网络的研究。含多隐层的多层感知器就是一种深度学习结构。深度学习通过组合低层特征形成更加抽象的高层表示属性类别或特征，以发现数据的分布式特征表示。</p>
            <img src="/images/bigdata.png" class="img-responsive margin" style="width:100%" alt="Image">
            <a href="/login" class="btn btn-default btn-lg">
                <span class="glyphicon glyphicon-search"></span> 发现更多精彩。。。
            </a>
        </div>
        <div class="col-sm-4">
            <p>Python具有丰富和强大的库。它常被昵称为胶水语言，能够把用其他语言制作的各种模块（尤其是C/C++）很轻松地联结在一起。</p>
            <img src="/images/python.png" class="img-responsive margin" style="width:100%" alt="Image">
        </div>
    </div>
</div>

<!-- Footer -->
<footer id="my-footer" class="container-fluid bg-4 text-center">
    <h4>Made by wjy</h4>
    <p>1875256338@qq.com</p>
</footer>

<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
