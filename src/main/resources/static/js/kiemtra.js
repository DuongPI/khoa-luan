
$(function(){
    var form = [-1,-1,-1,-1];
    $('input').change(function() {
        console.log($(this).val());
        let vt = $(this).attr('name');
        form[vt] = $(this).val();
        console.log(vt);
        console.log(form);
    });

    $('#submit').click(function() {
        ajaxJSON.post("/api/v1/user", form,true,
            function (data) {
                console.log(data);
            })
    });
    $('#thoat').click(function() {
        window.location.replace('/');
    });
    setTimeout(function (){
        ajaxJSON.post("/api/v1/user", form,true,
            function (data) {
                console.log(data);
                //location.reload();
            })
    },6000)
});
function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            timer = duration;
        }
    }, 1000);
}

window.onload = function () {
    //var fiveMinutes = 60 * 5,
    var fiveMinutes = 1 * 5,
        display = document.querySelector('#time');
    startTimer(fiveMinutes, display);
};
