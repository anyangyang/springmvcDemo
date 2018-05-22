<%--
  Created by IntelliJ IDEA.
  User: zhujiating
  Date: 2017/6/27
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Title</title>
    <!--引入bootstrap核心css文件-->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!--在引入bootstrap核心javascript文件之前，引入jquery-->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <!--引入bootstrap核心js文件-->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="#" class="navbar-brand">专家系统</a>
            </div>

            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">ios</a></li>
                    <li ><a href="#">svn</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            java
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">jmeter</a></li>
                            <li><a href="#">EBJ</a></li>
                            <li class="divider"></li>
                            <li><a href="#">分离的链接</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


    <h1>springmvc Demo</h1>
    出现该页，说明springmvc配置成功！<br>

    <table class="table table-striped">
        <caption>条纹表格布局</caption>
        <thread>
            <tr>
                <th>id</th>
                <th>username</th>
                <th>password</th>
                <th>firstName</th>
                <th>lastName</th>
                <th>sex</th>
                <th>age</th>
            </tr>
        </thread>

        <tbody>
            <tr>
                <td> ${user.id}</td>
                <td> ${user.nickName} </td>
                <td> ${user.password} </td>
                <td> ${user.firstName} </td>
                <td> ${user.lastName} </td>
                <td> ${user.sex} </td>
                <td> ${user.age} </td>
            </tr>

        </tbody>


    </table>




用户名：${user.nickName}<br>
密码：${user.password}<br>

</body>
</html>
