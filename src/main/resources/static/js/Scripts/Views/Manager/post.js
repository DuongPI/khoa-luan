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
var a;
a = CKEDITOR.replace( 'editor1' );
var arraybase64 = {};
$("#image").change(function(){
	var files = $(this)[0].files[0];
	if(files != undefined){
		var reader = new FileReader();
		reader.onload = function(e){
			arraybase64["base64"] = e.target.result;
			arraybase64["name"] =files.name;
			console.log(arraybase64);
		}
		reader.readAsDataURL(files);
	}
});

$(document).on('click', 'button.btn.btn-warning.pull-right', function () {
    var ID = $('tr.Selected').data("id");
    //console.log($('tr.Selected').data("content"));
    $('#modal .modal-title').text('CHỈNH SỬA BÀI VIẾT');
    
    $('.modal-body [property]').each((index, item) => {
        $(item).val($('tr.Selected').children()[index + 1].innerText);
    })
    CKEDITOR.instances['editor1'].setData($('tr.Selected').data("content"));
    mode = 2;
    /*sessionStorage.setItem('ID', ID);*/
})


$(document).on('click', 'button.btn.btn-success.pull-right', function () {
    mode = 1;
    $('#modal .modal-title').text('THÊM BÀI VIẾT');
});

//lưu form
$(document).on('click', '#modal .save', function () {
    let btn = $(this);

    let flag = checkDataInputModal();
    if (flag === 1) {
        if (mode === 1) {
            let post = {
                name: null,
                content: null,
                urlname: null,
                image: null,
                imagetobase64: null,
                shortDecripsion: null
            };
            $('[property]').each((index, item) => {
                post[$(item).attr('property')] = $(item).val();
            });
            post["content"] = a.getData();
            post["imagetobase64"] = arraybase64["base64"];
			post["image"] = arraybase64["name"];
            console.log(post);
            ajaxJSON.post('/api/v1/post', post, true,
                (res) => {
                    window.location.replace('/quan-tri/bai-viet');
                    console.log(res);
                });
        }
        else if (mode === 2) {
            let post = {
                id: $('tr.Selected').data('id'),
                name: null,
                content: null,
                urlname: null,
                image: null,
                imagetobase64: null,
                shortDecripsion: null
            };
            $('[property]').each((index, item) => {
                post[$(item).attr('property')] = $(item).val();
            });
            post["content"] = a.getData();
            post["imagetobase64"] = arraybase64["base64"];
			post["image"] = arraybase64["name"];
            console.log(post);
            ajaxJSON.put('/api/v1/post', post, true,
                function (data) {
                    window.location.replace('/quan-tri/bai-viet');
                    console.log(data);
                })

        }
    }
    else {
        flag.forEach(function (item) {
            warningInput(item);
        });
    }
});

$("#delete-post" ).click(function() {
	let id = $('tr.Selected').data('id');
    let url1 = '/api/v1/post/'+ id;
    console.log(url1);
    ajaxJSON.delete(url1, undefined,true,
        function (data) {
            location.reload();
        })
});