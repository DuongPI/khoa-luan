$(function(){
    var authorize = $('#authorize').text();
    var isAdmin = authorize.indexOf('ADMIN');
    $('.th_gia').click(function() {
        localStorage.setItem('id', $(this).attr('name'));
    });
    $('#button_check').click(function() {
        let mk = $('.mk_test').val();
        let id = localStorage.getItem('id');
        $.ajax({
            type:     "GET",
            data:     '',
            cache:    false,
            url:      "/api/v1/test/" + id,
            dataType: "text",
            contentType:'application/json',
            error: function (error) {
                console.log(error);
                alert(" mật khẩu chưa đúng ! ");
            },
            success: function (data) {
                console.log(data);
                if(mk == data){
                    if(isAdmin !==-1)
                        window.location.replace('/quan-tri/kiem-tra/'+id);
                    else window.location.replace('/kiem-tra/'+id);
                }
                else
                    alert("mk chưa đúng  ");
            }
        });

    });

});
