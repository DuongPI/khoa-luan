$(document).on('click', '#roomTable tbody tr', function () {
    if ($(this).hasClass('Selected')) {
        $(this).removeClass('Selected')
        $('button.btn.modify').attr('disabled', true); $('button.btn.delete').attr('disabled', true)
    }
    else {
        if ($('tbody tr').hasClass('Selected')) {
            $('tbody tr').removeClass('Selected')
        }
        $(this).addClass('Selected')
        $('button.btn.modify').attr('disabled', false); $('button.btn.delete').attr('disabled', false)
    }
})

$(document).on('click', 'button.btn.btn-warning.pull-right', function () {
    var ID = $('tr.Selected').data("id");

    $('#modal .modal-title').text('CHỈNH SỬA BÀI GIẢNG');
    $
    $('.modal-body [property]').each((index, item) => {
        $(item).val($('tr.Selected').children()[index + 1].innerText)
    })
    mode = 2;
    /*sessionStorage.setItem('ID', ID);*/
})

$(document).on('click', 'button.btn.btn-success.pull-right', function () {
    mode = 1;
    $('#modal .modal-title').text('THÊM BÀI GIẢNG');
});

//lưu form
$(document).on('click', '#modal .save', function () {
    let btn = $(this);

    let flag = checkDataInputModal();
    if (flag === 1) {
        if (mode === 1) {
            let lecture = {
                lectureName : null,
                lectureVideo : null,
                chapterID: null,
            };
            $('[property]').each((index, item) => {
                lecture[$(item).attr('property')] = $(item).val();
            });
            console.log(lecture);
            ajaxJSON.post('/api/v1/lecture', lecture, true,
                (res) => {
                    window.location.replace('/quan-tri/bai-giang');
                    //console.log(res);
                });
        }
        else if (mode === 2) {
            let lecture = {
                id: $('tr.Selected').data('id'),
                lectureName: null,
                chapterID: null,
                lectureVideo : null
            };
            $('[property]').each((index, item) => {
                lecture[$(item).attr('property')] = $(item).val();
            });
            console.log(lecture);
            ajaxJSON.put('/api/v1/lecture', lecture, true,
                function (data) {
                    window.location.replace('/quan-tri/bai-giang');
                   // console.log(res);
                })
                
            // $.ajax({
            //     url: '/major/update',
            //     type: "PUT",
            //     contentType: 'text/html;charset=UTF-8',
            //     dataType: "text/html",
            //     encoding: "UTF-8",
            //     data: {
            //         major
            //     },
            //     success: function (data) {
            //         // some task
            //         window.location.replace('/major');
            //     }
            //     , fail: function () {
            //         // some task
            //     }
            // })

        }
    }
    else {
        flag.forEach(function (item) {
            warningInput(item);
        });
    }
});

$("#delete-lecture" ).click(function() {
	let id = $('tr.Selected').data('id');
    let url1 = '/api/v1/lecture/'+ id;
    console.log(url1);
    ajaxJSON.delete(url1, undefined,true,
        function (data) {
            location.reload();
        })
});