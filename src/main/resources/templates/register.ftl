<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="layui/layui.js">
    </script>
    <script  type="text/javascript" src="js/account.js"></script>

</head>
<body style="background-image:url('/img/bd.jpeg');background-size: 100%">

<div style="background: rgb(231,234,227);width: 460px;height:200px;margin: 20% auto;padding: 1%">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">注册账户</label>
            <div class="layui-input-block">
                <input type="text" name="username" required  lay-verify="required" placeholder="请输入账户" autocomplete="off" class="layui-input" style="width: 192px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">注册密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>


            <div class="layui-form-item" style="position: relative;top: 10px">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-sm" lay-submit  lay-filter="formDemo" id="submit">确认注册</button>
                    <a href="/login" class="layui-btn layui-btn-sm">返回登录页面</a>
                </div>
            </div>
        </div>
    </form>
    <script>
        //Demo
        layui.use('form', function(){
            var form = layui.form;

            //监听提交
            form.on('submit(formDemo)', function(data){
                layer.msg("成功");
                return false;
            });
        });
    </script>
</div>



</body>
</html>