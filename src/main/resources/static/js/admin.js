$(function () {
    $("#submit").click(function () {
        var students = $("form").serialize();

        $.post('/student',students,function (data) {

        });
    });
});