$(function(){
    $('#select_category').change(function(){
        if($('#select_category').val() == -1)
            window.location.replace('/khoa-hoc');
        else window.location.replace('/khoa-hoc/the-loai/'+$('#select_category').val());
    });
});