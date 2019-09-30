<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/9/24
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>后台登录-X-admin2.0</title>
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />

  <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
  <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>

</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
  <div class="message">x-admin2.0-管理登录</div>
  <div id="darkbannerwrap"></div>

  <form method="post" class="layui-form" action="${pageContext.request.contextPath}/login" >
    <input name="username" placeholder="用户名"  type="text"  value="ldd" class="layui-input" >
    <hr class="hr15">
    <input name="password"  placeholder="密码"  type="password" value="123" class="layui-input">
    <hr class="hr15">
    <input name="remember" type="checkbox">记住我
    <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
    <hr class="hr20" >
    <a href="email.jsp">邮箱验证</a>
  </form>
</div>
</body>
</html>