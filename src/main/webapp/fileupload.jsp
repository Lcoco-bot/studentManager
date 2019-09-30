<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/9/26
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <title>上传文件</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/fileupload" method="post" enctype="multipart/form-data">
<input id="input-b5" name="file" type="file">
    <button type="submit" value="上传">上传</button>
</form>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/my.js"></script>
<script src="${pageContext.request.contextPath}/js/toastr.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fileinput.min.js"></script>
<script src="${pageContext.request.contextPath}/js/theme.js"></script>
<script src="${pageContext.request.contextPath}/js/zh.js"></script>
</body>

</html>
