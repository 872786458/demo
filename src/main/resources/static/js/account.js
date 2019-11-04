$(function () {
    $("#submit").click(function () {

        var fo = $("form").serialize();

        $.post('/doRegister',fo,function (result) {
            if (result.success==true){
                window.location.href="/login"
            }



        })
    });


});