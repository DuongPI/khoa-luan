$(function(){
    $('#_submit').click(function() {
        let pass = $('#password').val();
        let newpass = $('#confirmPassword').val();
        let id = $('#_id').text();
        if(pass == newpass){
            $.ajax({
                type:     "post",
                data:     '',
                cache:    false,
                url:      "/tai-khoan/" + id + "?newpassword=" + pass,
                dataType: "text",
                contentType:'application/json',
                error: function (error) {
                    alert(" mật khẩu chưa đúng ! ");
                },
                success: function (data) {
                    console.log(data)

                }
            });
        }
    });
});