$(document).on('click', '#roomTable tbody tr', function() {
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

$(document).on('click', 'button.btn.btn-warning.pull-right', function() {
	var ID = $('tr.Selected').data("id");
	$('#modal .modal-title').text('CHỈNH SỬA KHÓA HỌC');
	$('.modal-body [property]').each((index, item) => {
		$(item).val($('tr.Selected').children()[index + 1].innerText)
	})
	mode = 2;
	/*sessionStorage.setItem('ID', ID);*/
})

$(document).on('click', 'button.btn.btn-success.pull-right', function() {
	mode = 1;
	$('#modal .modal-title').text('THÊM KHÓA HỌC');
});
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

//lưu form
$(document).on('click', '#modal .save', function() {
	let btn = $(this);
	let flag = checkDataInputModal();
	if (flag === 1) {
		if (mode === 1) {
			let course = {
				id: null,
				courseName: null,
				description: null,
				shortDescription: null,
				category: null,
				imageName: null,
				imagetobase64: null
			};
			course["courseName"] = $('#courseName').val();
			course["description"] = $('#description').val();
			course["shortDescription"] = $('#shortDescription').val();
			course["category"] = Number($('#category').val());
			course["imagetobase64"] = arraybase64["base64"];
			course["imageName"] = arraybase64["name"];
			console.log(course);

			ajaxJSON.post('/api/v1/course', course, true,
				(res) => {
					window.location.replace('/quan-tri/khoa-hoc');
				});
		}
		else if (mode === 2) {
			let course = {
				id: $('tr.Selected').data('id'),
				courseName: null,
				description: null,
				shortDescription: null,
				category: null,
				imageName: null,
				imagetobase64: null
			};
			$('[property]').each((index, item) => {
				course[$(item).attr('property')] = $(item).val();
			});
			course["category"] = Number($('#category').val());
			course["imagetobase64"] = arraybase64["base64"];
			course["imageName"] = arraybase64["name"];
			console.log(course);
			ajaxJSON.put('/api/v1/course', course, true,
				function (data) {
					window.location.replace('/quan-tri/khoa-hoc');
				})

		}
	}
	else {
		flag.forEach(function(item) {
			warningInput(item);
		});
	}
});
$("#delete-course" ).click(function() {
	let id = $('tr.Selected').data('id');
    let url1 = '/api/v1/course/'+ id;
    console.log(url1);
    ajaxJSON.delete(url1, undefined,true,
        function (data) {
            location.reload();
        })
});
