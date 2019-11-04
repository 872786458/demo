
$(function () {
    $("#sub").click(function () {
        var user = $("form").serialize();

        $.post('/log', user, function (result) {

            if (result.success == true) {
                window.location.href = "/admin"
            }else if (result.success==false){

                $("#sp").html(result.m)
            }
        })
    });


});