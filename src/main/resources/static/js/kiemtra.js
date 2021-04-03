var form = [-1,-1,-1,-1];
$(function(){
    $('input').change(function() {
        console.log($(this).val());
        let vt = $(this).attr('name');
        form[vt] = $(this).val();
        console.log(vt);
        console.log(form);
    });
    $('#_submit').click(function() {
        ajaxJSON.post("/api/v1/user", form,true,
            function (data) {
                console.log(data);
                localStorage.setItem('result',data);
                window.location.replace('/ket-qua-thi');
            })
    });
    $('#thoat').click(function() {
        window.location.replace('/');
    });
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
            ajaxJSON.post("/api/v1/user", form,true,
                function (data) {
                    localStorage.setItem('result',data);
                    window.location.replace('/ket-qua-thi');
                })
        }

    }, 1000);
}

window.onload = function () {
    //var fiveMinutes = 60 * 5,
    var fiveMinutes = 1 * 2,
        display = document.querySelector('#time');
    startTimer(fiveMinutes, display);
};
