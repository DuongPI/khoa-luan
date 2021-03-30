$(function(){
    $('#select_category').change(function(){
        if($('#select_category').val() == -1)
            window.location.replace('/khoa-hoc');
        else window.location.replace('/khoa-hoc/the-loai/'+$('#select_category').val());
    });
    $('#testapi').click(function(){
        ajaxJSON.post('/api/v1/user', {}, true,
            function (data) {
                console.log("here")
                console.log(data);
            })
    });


});
$('#_hoanthanh').click(function(){
    let learn = {
        lectureID : null,
        courseID: null,
        userID: null
    };
    learn["lectureID"] = $('#lectureID').val();
    learn["courseID"] = $('#courseID').val();
    learn["username"] = $('#username').html();
    ajaxJSON.post('/api/v1/lecture/finish', learn, true,
        function (data) {
            console.log("here")
            console.log(data);
            location.reload();
        })
});

