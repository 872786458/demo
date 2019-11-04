<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>学生信息管理</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css"/>
    <script type="text/javascript" src="js/jquery.js">

    </script>
    <script type="text/javascript" src="layui/layui.js">

    </script>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">


   <#include "top.ftl">
    <#include "left.ftl"> 导入其他页面元素

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
        </div>
    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>


<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg("提交成功");
            return false;
        });
    });
</script>
</body>
</html>
