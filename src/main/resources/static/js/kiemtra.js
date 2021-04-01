var form = [-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1];
$(function(){
    $('input').change(function() {
        console.log($(this).val());
        let vt = $(this).attr('name');
        form[vt] = $(this).val();
        console.log(vt);
        console.log(form);
    });
});