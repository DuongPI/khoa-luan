$(function(){
    $('#th_gia').click(function() {
        localStorage.setItem('id', $(this).attr('name'));
    });
    $('#button_check').click(function() {
        let mk = $('#mk_test').val();
        let id = localStorage.getItem('id');
        $.ajax({
            type:     "post",
            data:     '',
            cache:    false,
            url:      "/api/v1/test/" + id,
            dataType: "text",
            contentType:'application/json',
            error: function (error) {
                alert(" mật khẩu chưa đúng ! ");
            },
            success: function (data) {
                console.log(data)
                if(mk == data){

                    window.location.replace('/kiem-tra/'+id);
                    alert("thành công  ");
                }

                else
                    alert("mk chưa đúng  ");
            }
        });

    });

});
