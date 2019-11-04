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
    <script src="js/student.js"></script>

</head>
<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">
 <#include "top.ftl">

    <#include "left.ftl"> 导入其他页面元素

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">

            <form class="layui-form" >
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">成绩</label>
                    <div class="layui-input-inline">
                        <input type="text" name="score" required lay-verify="required" placeholder="请输成绩" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">辅助文字</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">年级</label>
                    <div class="layui-input-block">
                        <select name="gradeId" lay-verify="required">
                            <option value=""></option>
                            <option value="1">一年级</option>
                            <option value="2">二年级</option>
                            <option value="3">三年级</option>
                            <option value="4">四年级</option>
                            <option value="5">五年级</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo" id="but">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>


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
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</body>
</html>
