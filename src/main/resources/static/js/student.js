$(function () {
    $("#but").click(function () {
        var students = $("form").serialize();
        alert(students)
        $.post('/student',students,function () {

        });

    });
    //查询学生信息
    $("#subStudent").click(function () {
        var serialize = $("form").serialize();


    });

});