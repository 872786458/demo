$(function () {
    $("#submit").click(function () {
        var fo = $("form").serialize();
        alert(fo);
        $.post('/toRegister',fo,function (result) {
            if (result.success==true){
               window.location.href="/toLogin"
            }else{
                alert("账户密码已存在")
            }



        })
    });


});