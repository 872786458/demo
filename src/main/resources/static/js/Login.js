
$(function () {
    $("#sub").click(function () {
        var user = $("form").serialize();
        $.post('/login', user, function (result) {
            if (result.success == true) {
                window.location.href = "/student/toHome"
            }else {
                $("#sp").html(result.msg);
            }
        })
    });


});