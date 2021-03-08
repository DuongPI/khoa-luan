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

    $('#modal .modal-title').text('CHỈNH SỬA CHƯƠNG HỌC');
    $
    $('.modal-body [property]').each((index, item) => {
        $(item).val($('tr.Selected').children()[index + 1].innerText)
    })
    mode = 2;
    /*sessionStorage.setItem('ID', ID);*/
})

$(document).on('click', 'button.btn.btn-success.pull-right', function () {
    mode = 1;
    $('#modal .modal-title').text('THÊM CHƯƠNG HỌC');
});

//lưu form
$(document).on('click', '#modal .save', function () {
    let btn = $(this);

    let flag = checkDataInputModal();
    if (flag === 1) {
        if (mode === 1) {
            let chapter = {
                chapterName: null,
                course: null,
            };
            $('[property]').each((index, item) => {
                chapter[$(item).attr('property')] = $(item).val();
            });
            console.log(chapter);
            ajaxJSON.post('/api/v1/chapter', chapter, true,
                (res) => {
                    window.location.replace('/quan-tri/cac-chuong');
                    console.log(res);
                });
        }
        else if (mode === 2) {
            let chapter = {
                id: $('tr.Selected').data('id'),
                chapterName: null,
                course: null,
            };
            $('[property]').each((index, item) => {
                chapter[$(item).attr('property')] = $(item).val();
            });
            console.log(chapter);
            ajaxJSON.put('/api/v1/chapter', chapter, true,
                function (data) {
                    window.location.replace('/quan-tri/cac-chuong');
                    console.log(res);
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

$("#delete-chapter" ).click(function() {
	let id = $('tr.Selected').data('id');
    let url1 = '/api/v1/chapter/'+ id;
    console.log(url1);
    ajaxJSON.delete(url1, undefined,true,
        function (data) {
            location.reload();
        })
});