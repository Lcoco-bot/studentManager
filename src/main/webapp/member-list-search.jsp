<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</html>
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
        <a href="${pageContext.request.contextPath}/studentlist">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <table class="layui-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>性别</th>
            <th>学院名字</th>
            <th>分数</th>
            <th>真实名字</th>
            <th>年级</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.pageData}"  step="1" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.username}</td>
                <td>${student.sex}</td>
                <td>${student.collegname}</td>
                <td>${student.score}</td>
                <td>${student.realname}</td>
                <td>${student.studentclass}</td>
                <td>
                    <a title="编辑" onclick="x_admin_show('编辑','member-edit.jsp',600,400)" href="javascript:">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" class="del" onclick="member_del(this,'要删除的id')" href="${pageContext.request.contextPath}/deletedata">
                        <i class="layui-icon">&#xe640;</i>
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
                    <a href="${pageScope.request.contextPath}/searchstudentandcollegname?p=${page.currentPage-1}">
                        <span>&laquo</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${page.pageCount}" step="1" var="p">
                    <li>
                        <a href="${pageScope.request.contextPath}/searchstudentandcollegname?p=${p}">${p}</a>
                    </li>
                </c:forEach>
                <li>
                    <a href="${pageScope.request.contextPath}/searchstudentandcollegname?p=${page.currentPage+1}">
                        <span>&raquo</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

</div>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fileinput.min.js"></script>
<script src="${pageContext.request.contextPath}/js/theme.js"></script>
<script src="${pageContext.request.contextPath}/js/zh.js"></script>
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

    /*用户-停用*/
    // function member_stop(obj,id){
    //     layer.confirm('确认要停用吗？',function(index){
    //
    //         if($(obj).attr('title')=='启用'){
    //
    //             //发异步把用户状态进行更改
    //             $(obj).attr('title','停用')
    //             $(obj).find('i').html('&#xe62f;');
    //
    //             $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
    //             layer.msg('已停用!',{icon: 5,time:1000});
    //
    //         }else{
    //             $(obj).attr('title','启用')
    //             $(obj).find('i').html('&#xe601;');
    //
    //             $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
    //             layer.msg('已启用!',{icon: 5,time:1000});
    //         }
    //
    //     });
    // }
    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $ajax({});
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {icon: 1, time: 1000});
        });
    }

    function del(id) {
        var ids = [];
        ids[0] = id;
        my.confirm({message: '是否要删除数据?'}).on(function (e) {
            if (!e) {
                return;
            }
            // 通过ajax删除数据,然后同步刷新页面
            // jq ajax
            $.ajax({
                url: '${pageContext.request.contextPath}/deletedata',
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


    }


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
    var num = function () {
        var num = 0;
        $info.each(function () {
            if (this.checked === true) {
                ids[num] = this.value;
                alert(num)
                num++;
            }
        });
        return num;
    };

    // 监听点击
    $info.click(function () {
        if ($info.length === num()) {
            $("#checkedAll").prop("checked", true);
        } else {
            $("#checkedAll").prop("checked", false);
        }
    });

    <%--// 全选--%>
    var $info = $('.checkedInfo');
    var num = 0;
    var ids = [];
    $("#checkedAll").click(function () {
        // 获取当前是否选择
        var checked = this.checked;
        // = 赋值
        // == 等于   '1' == 1  true
        // === 等于   '1' === 1  false
        if (checked === true) {
            $info.prop('checked', true);
            num++
            ids[num]
            alert(num)
        } else {
            $info.prop('checked', false);
        }
    });
    //做批量删除修改代码(接除注释)
    $('.deleteAll').click(function () {
        alert("lengthnum" + num)
        $.ajax({
            url: '${pageContext.request.contextPath}/delAll',
            type: 'post',
            data: {'id': ids},
            success: function (result) {
                // 刷新页面
                toastr.success("数据删除成功");
                window.location.reload();
            },
            error: function () {

            }
        });
    })

    <%--// 删除数据--%>
    function del(id) {
        var ids = [];
        ids[0] = id;
        my.confirm({message: '是否要删除数据?'}).on(function (e) {
            if (!e) {
                return;
            }
            // 通过ajax删除数据,然后同步刷新页面
            // jq ajax
            $.ajax({
                url: '${pageContext.request.contextPath}/deletedata',
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


    }

</script>
<script src="${pageContext.request.contextPath}/js/fileinput.min.js"></script>
</body>

</html>