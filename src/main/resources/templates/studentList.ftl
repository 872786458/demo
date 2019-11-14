<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>学生信息管理</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css"/>
    <script type="text/javascript" src="layui/layui.js"></script>
</head>

<body class="layui-layout-body">

<#--//修改删除弹出层-->
<div style="display: none" id="updateOrDelete">
    <form class="layui-form" lay-filter="dataForm" id="dataFor" >
        <div style="display: none" class="layui-form-item" >
            <label class="layui-form-label">ID</label>
            <div class="layui-input-block">
                <input id="studentId" type="text" name="studentId" required lay-verify="required" placeholder="请输入id" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input  id="name" type="text" name="name" required lay-verify="required" placeholder="请输入姓名" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">成绩</label>
            <div class="layui-input-inline">
                <input id="score" type="text" name="score" required lay-verify="required" placeholder="请输成绩" autocomplete="off"
                       class="layui-input">
            </div>

        </div>
        <div class="layui-form-item" style="width: 50%">
            <label class="layui-form-label">年级</label>
            <div class="layui-input-block">
                <select name="gradeId" lay-verify="required" id="grade">
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
             <#--   <button class="layui-btn"  lay-filter="formDemo" id="but">立即提交</button>-->
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
    <button class="layui-btn"  lay-filter="formDemo" id="but" style="position: relative;left: 20%">立即提交</button>
</div>
<div class="layui-layout layui-layout-admin">

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <#--查询条件-->
            <div class="demoTable">
                <div class="layui-inline">
            <form class="layui-form  layui-form-pane" id="formStudent" method="post">
                <div class="layui-form-item" pane style="display: inline-block">
                    <label class="layui-form-label">学生姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name"  placeholder="学生姓名" autocomplete="off" class="layui-input" id="nameStudent">
                    </div>
                </div>
                <div class="layui-form-item" pane style="display: inline-block">
                    <label class="layui-form-label">学生班级</label>
                    <div class="layui-input-block">
                        <select  name="gradeId" id="gradeId" >
                            <option value=""></option>
                            <option value="1">一年级</option>
                            <option value="2">二年级</option>
                            <option value="3">三年级</option>
                            <option value="4">四年级</option>
                            <option value="5">五年级</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item" style="display: inline-block">
                    <div class="layui-input-block">
                        <button class="layui-btn" data-type="reload">搜索</button>
                    </div>
                </div>
            </form>
                </div>
            </div>


           <#--数据表格-->
            <table class="layui-hide" id="test" lay-filter="test"></table>

            <#--头部工具栏-->
            <script type="text/html" id="toolbarDemo">
                <div class="layui-btn-container">
                    <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
                    <button class="layui-btn layui-btn-sm" lay-event="isAll">导出Excel</button>
                </div>
            </script>
            <#--//行工具栏-->
            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
            <#--监听事件 渲染数据表格-->
            <script>
                layui.use(['table', 'layer', 'jquery', 'form', 'element','laypage',], function () {
                    var table = layui.table;
                    var layer = layui.layer;
                    var $ = layui.jquery;
                    var form = layui.form;
                    var element = layui.element;
                    var laypage = layui.laypage;
//渲染数据表格
                    var limit;
                    var page;
                    var curre_page;
                    var tableIns = table.render({
                        elem: '#test'//渲染目标
                        , url: '/listStudents'//数据接口
                       ,id: 'testReload'
                        ,page: true
                        ,even:true


                        , done: function (rest, curr, count) {
                            console.log(rest);//后台返回的json字符串
                            console.log(curr);//当前页
                            console.log(count);//数据总条数
                        }
                        , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
                        , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                            title: '提示'
                            , layEvent: 'LAYTABLE_TIPS'
                            , icon: 'layui-icon-tips'
                        }]
                        , title: '用户数据表'//excel导出
                        , cols: [[
                            {type: 'checkbox', fixed: 'left'}
                            , {field: 'studentId', title: 'ID', width: 80, fixed: 'left', unresize: true, sort: true}
                            , {field: 'name', title: '学生姓名', width: 120, edit: 'text'}
                            , {field: 'score', title: '成绩', width: 100}
                            , {field: 'grade', title: '班级'}
                            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
                        ]]

                    });
/*条件查询*/
                    var $ = layui.$, active = {
                        reload: function () {
                            var name = $("#nameStudent");
                          /*  console.log($("#nameStudent").val()+"----------");
                            console.log($("#gradeId").val()+"++++++++++++")*/
                            var gradeId = $("#gradeId");
                            //执行重载
                            table.reload('testReload', {
                                page: {
                                    curr: 1 //重新从第 1 页开始
                                }
                                , where: {
                                    'name': name.val(),
                                    'gradeId': gradeId.val()
                                }
                            }, 'data');
                        }
                    }
                    $('.demoTable .layui-btn').on('click', function () {
                        var type = $(this).data('type');
                        active[type] ? active[type].call(this) : '';
                        return false;
                    });

                    $('.demoTable .layui-btn').on('click', function(){
                        var type = $(this).data('type');
                        active[type] ? active[type].call(this) : '';
                    });

                    //头工具栏事件
                    table.on('toolbar(test)', function (obj) {
                        var checkStatus = table.checkStatus(obj.config.id);
                        switch (obj.event) {
                            case 'getCheckData':
                                var data = checkStatus.data;
                                layer.alert(JSON.stringify(data));
                                break;
                            case 'getCheckLength':
                                var data = checkStatus.data;
                                layer.msg('选中了：' + data.length + ' 个');
                                break;
                            case 'isAll':
                               /* alert("导出excel")*/
                                $.post("/doExcel",function (result) {
                                    window.location.href="/student/doExcel";
                            });
                                break;
                            case 'add':
                                addStudents()
                                break;
                            //自定义头工具栏右侧图标 - 提示
                            case 'LAYTABLE_TIPS':
                                layer.alert('这是工具栏右侧自定义的一个图标按钮');
                                break;
                        }
                    });
                    //请求路径
                    var url;
                    //标记弹出层
                    var mainIndex;
                    //添加弹窗
                    function addStudents() {
                        mainIndex = layer.open({
                            type: 1,
                            title: "添加用户",
                            skin: 'layui-layer-rim', //加上边框
                            area: ['500px', '500px'], //设置宽高
                            content: $("#updateOrDelete"),
                            success: function (index) {
                                //清空
                                $("#dataFor")[0].reset();
                                url="";

                            }
                        });
                    }
                    //修改弹窗
                    function modify(data) {
                        mainIndex = layer.open({
                            type: 1,
                            title: "修改用户",
                            skin: 'layui-layer-rim', //加上边框
                            area: ['500px', '500px'], //设置宽高
                            content: $("#updateOrDelete"),
                            success: function (index) {
                                form.val("dataForm", data);
                                url ="/modifyStudents"

                            }
                        });
                    }

//修改
                    $("#but").click(function () {
                       // var serialize = $("#dataFor").serialize();
                        var id = $("#studentId").val();
                        var name = $("#name").val();
                        var score = $("#score").val();
                        var gradeId = $("#grade").val();
                        alert(gradeId+""+score);
                        $.post(url, { id:id,name:name,score:score,gradeId:gradeId}, function (result) {
                            layer.msg("成功");
                            //关闭弹出层
                            layer.close(mainIndex);
                            //刷新数据表格
                            tableIns.reload();
                        });
                    });


                    //监听行工具事件
                    table.on('tool(test)', function (obj) {
                        var data = obj.data;//获得当前行数据
                        //console.log(obj)  obj.event获取lay-event 对应的值
                        if (obj.event === 'del') {
                            layer.confirm('真的删除行么', function (index) {
                                obj.del();
                                layer.close(index);//向服务端发送删除指令
                                 alert(data.studentId);
                                //删除事件
                                $.post("/delStudent", {id: data.studentId, score: data.score}, function () {
                                });

                            });
                        } else if (obj.event === 'edit') {//编辑
                            modify(data);
                        }
                    });

                   /* $("#subStudent").click(function () {
                       var serialize = $("#formStudent").serialize();
                        $.post("/listStudents",serialize,function () {
                        })
                    });*/
                });

            </script>
        </div>
</div>
</div>
 </body>
</html>
