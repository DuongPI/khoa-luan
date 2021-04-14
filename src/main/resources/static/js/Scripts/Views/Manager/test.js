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

    $('#modal .modal-title').text('CHỈNH SỬA BÀI KIỂM TRA');
    $
    $('.modal-body [property]').each((index, item) => {
        $(item).val($('tr.Selected').children()[index + 1].innerText)
    })
    mode = 2;
    /*sessionStorage.setItem('ID', ID);*/
})

$(document).on('click', 'button.btn.btn-success.pull-right', function () {
    mode = 1;
    $('#modal .modal-title').text('THÊM BÀI KIỂM TRA');
});

//lưu form
$(document).on('click', '#modal .save', function () {
    let btn = $(this);

    let flag = checkDataInputModal();
    if (flag === 1) {
        if (mode === 1) {
            let category = {
                name: null,
                description: null,
            };
            $('[property]').each((index, item) => {
                category[$(item).attr('property')] = $(item).val();
            });
            ajaxJSON.post('/api/v1/category', category, true,
                (res) => {
                    window.location.replace('/quan-tri/the-loai');
                });
        }
        else if (mode === 2) {
            let category = {
                id: $('tr.Selected').data('id'),
                name: null,
                description: null,
            };
            $('[property]').each((index, item) => {
                category[$(item).attr('property')] = $(item).val();
            });
            console.log(category);
            ajaxJSON.put('/api/v1/category', category, true,
                function (data) {
                    window.location.replace('/quan-tri/the-loai');
                })

        }
    }
    else {
        flag.forEach(function (item) {
            warningInput(item);
        });
    }
});

$("#delete-category" ).click(function() {
    let id = $('tr.Selected').data('id');
    let url1 = '/api/v1/category/'+ id;
    console.log(url1);
    ajaxJSON.delete(url1, undefined,true,
        function (data) {
            location.reload();
        })
});