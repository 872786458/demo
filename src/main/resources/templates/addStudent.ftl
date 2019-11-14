
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css"/>
    <script type="text/javascript" src="layui/layui.js">
    </script>
    <script src="js/jquery.js"></script>
    <script src="js/student.js"></script>
</head>
<body>
<form class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="name" required lay-verify="required" placeholder="请输入姓名" autocomplete="off"
                   class="layui-input">

            <input type="text" name="student.name">
            <input type="test" name="grade.name">

        </div>
    </div>
    <div class="layui-form-item" style="display: inline-block">
        <label class="layui-form-label">成绩</label>
        <div class="layui-input-inline">
            <input type="text" name="scoreName" required lay-verify="required" placeholder="请输成绩" autocomplete="off"
                   class="layui-input">
        </div>
        </div>
    <div class="layui-form-item" >
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
    </div>
        </div>
</form>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
    });
    layui.use('form', function () {
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function (data) {
           // layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</body>
</html>