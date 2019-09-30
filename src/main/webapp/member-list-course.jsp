<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/toastr.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/fileinput.min.css" rel="stylesheet">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>

<body class="layui-anim layui-anim-up">
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="${pageContext.request.contextPath}/courselist">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form  x-so search-form" action="${pageContext.request.contextPath}/searchstudentandcollegname" method="post">
            <input class="layui-input" placeholder="课程名字" name="collegname" >
            <input class="layui-input" placeholder="课程" name="studentclass" >
            <input type="text" name="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="deleteAll layui-btn">批量删除</button>
        <%--        <input type="checkbox" id="" class="layui-btn layui-btn-danger deleteAll"/><i class="layui-icon"></i>批量删除--%>
        <button class="layui-btn" onclick="x_admin_show('添加用户','order-add.jsp',600,400)"><i class="layui-icon"></i>添加
        </button>
        <button class="layui-btn" onclick="x_admin_show('上传文件','fileupload.jsp',600,400)">上传</button>
        <span class="x-right" style="line-height:40px">${pageCount}</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th><input type="checkbox" id="checkedAll">全选</th>
            <th>ID</th>
            <th>课程名字</th>
            <th>课程分数</th>
            <th>课程老师</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.pageData}"  step="1" var="course">
            <tr>
                <td><label>
                    <input type="checkbox" class="checkedInfo" value="${course.id}">
                </label></td>
                <td>${course.id}</td>
                <td>${course.coursename}</td>
                <td>${course.coursescore}</td>
                <td>${course.coursetearch}</td>
                <td>
                    <a title="edit" onclick="x_admin_show('编辑','member-edit.jsp',600,400)" href="javascript:">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="delete" class="del"  href="${pageContext.request.contextPath}/deletedataone?del=${course.id}">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                    <a title="download" class="download"  href="${pageContext.request.contextPath}/createxcel?username=${course.coursename}">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <c:if test="${page.currentPage > 1}">
                    <a href="${pageScope.request.contextPath}/courselist?p=${page.currentPage-1}">
                        <span>&laquo</span>
                    </a>
                    </c:if>
                </li>
                <c:forEach begin="1" end="${page.pageCount}" step="1" var="p">
                    <li>
                        <a href="${pageScope.request.contextPath}/courselist?p=${p}">${p}</a>
                    </li>
                </c:forEach>
                <li>
                    <c:if test="${page.currentPage < page.pageCount}">
                    <a href="${pageScope.request.contextPath}/courselist?p=${page.currentPage+1}">
                        <span>&raquo</span>
                    </a>
                    </c:if>
                </li>
            </ul>
        </nav>
    </div>

</div>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fileinput.min.js"></script>
<script src="${pageContext.request.contextPath}/js/theme.js"></script>
<script src="${pageContext.request.contextPath}/js/zh.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/my.js"></script>
<script src="${pageContext.request.contextPath}/js/toastr.min.js"></script>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });
    $(function () {
        $("#input-b5").fileinput({
            language: 'zh', //设置语言
            uploadUrl: "/fileupload", //上传的地址
            allowedFileExtensions: ['xls', 'xlsx'],//接收的文件后缀
            uploadAsync: true, //默认异步上传
            showUpload: true, //是否显示上传按钮
            showRemove: true, //显示移除按钮
            showPreview: false, //是否显示预览
            showCancel: true,   //是否显示文件上传取消按钮。默认为true。只有在AJAX上传过程中，才会启用和显示
            showCaption: false,//是否显示文件标题，默认为true
            browseClass: "btn btn-primary", //文件选择器/浏览按钮的CSS类。默认为btn btn-primary
            dropZoneEnabled: false,//是否显示拖拽区域
            msgFilesTooMany: 1
        }).on('filebatchselected', function (event, data, previewId, index) {
            $(this).fileinput('upload');
        });

    });
        var $info = $('.checkedInfo');
        var ids = [];
        // 获取选择的个数
        var num = function(){
            var num = 0;
            $info.each(function(){
                if (this.checked === true){
                    ids[num] = this.value;
                    num ++;
                }
            });
            return num;
        };
        $("#checkedAll").click(function (){
            // 获取当前是否选择
            var checked = this.checked;
            // = 赋值
            // == 等于   '1' == 1  true
            // === 等于   '1' === 1  false
            if (checked === true) {
                $info.prop('checked', true)
                alert(num())
            }else{$info.prop('checked',false);

            }
        });

    // 获取选择的个数
    <%--监听点击--%>
    $info.click(function () {
        if ($info.length === num()) {
            $("#checkedAll").prop("checked", true);
        } else {
            $("#checkedAll").prop("checked", false);
        }
    });

    $('.deleteAll').click(function () {
        // 使用ajax
        if (ids.length === 0) {
            my.alert("请选择需要删除的数据");
             return;
       }
        my.confirm({message: '是否要删除数据?'}).on(function (e) {
            if (!e) {
                return;
            }
            // 通过ajax删除数据,然后同步刷新页面
            // jq ajax
            $.ajax({
                url: '${pageContext.request.contextPath}/delAll',
                type: 'post',
                data: {'id': ids},
                success: function (result) {
                    // 刷新页面
                    // toastr.success("数据删除成功");
                    window.location.reload();
                },
                error: function () {

                }
            });
        })

    })


</script>
    <script src="${pageContext.request.contextPath}/js/fileinput.min.js"></script>
</body>

</html>