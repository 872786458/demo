$(function () {
    //录入学生信息
    $("#but").click(function () {
        var students = $("form").serialize();
        $.post('/addStudent',students,function (result) {
            if (result.success==true){
                alert("录入成功");
            }else{
                alert(result.msg)
                console.log(result)
            }
        });
    });
    //查询学生信息
    $("#subStudent").click(function () {
        var serialize = $("form").serialize();
        alert("hello")

    });

});