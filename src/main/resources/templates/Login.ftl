<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="layui/layui.js">
    </script>
    <script type="text/javascript" src="js/Login.js"></script>

</head>
<body style="background-image:url('/img/bd.jpeg');background-size: 100%">

<div style="background: rgb(231,234,227);width: 460px;height:200px;margin: 20% auto;padding: 1%">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">账户框</label>
            <div class="layui-input-block">
                <input type="text" name="username" required  lay-verify="required" placeholder="请输入账户" autocomplete="off" class="layui-input" style="width: 192px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码框</label>
            <div class="layui-input-inline">
                <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>

            <div class="layui-form-item" style="position: relative;top: 10px">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-sm" lay-submit   lay-filter="formDemo" id="sub">登录</button>
                    <a href="/register" class="layui-btn layui-btn-sm">注册</a>
                </div>
            </div>
        </div>
        <div> <span id="sp" style="color: red;font-size: 20px"></span> </div>
    </form>
    <script>
        //Demo
        layui.use('form', function(){
            var form = layui.form;

            //监听提交
            form.on('submit(formDemo)', function(data){
                layer.msg("登录成功");
                return false;
            });
        });
    </script>
</div>



</body>
</html>