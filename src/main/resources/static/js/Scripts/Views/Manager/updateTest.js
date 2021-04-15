var number = 10;
function getInfo(){
    let test = {
        name: null,
        password: null,
        quizzs: []
    };

    test["name"] = $('#TestName').val();
    test["password"] = $('#TestPassword').val();
    for(var j = 0 ;j< number; j++){
        test["quizzs"][j] = {
            id:null,
            question:null,
            answers:[]
        }
        test["quizzs"][j]["id"] = $('#question_'+(j+1)+'_id').val();
        test["quizzs"][j]["question"] = $('#question_'+(j+1)).val();
        for(var k = 0 ; k<4 ; k++){
            test["quizzs"][j]["answers"][k]={
                id:null,
                content : null,
                istrue: false
            }
            test["quizzs"][j]["answers"][k]["id"] = $('#answer_'+(j+1)+'_'+(k+1)+'_id').val();
            test["quizzs"][j]["answers"][k]["content"] = $('#answer_'+(j+1)+'_'+(k+1)).val();
            test["quizzs"][j]["answers"][k]["istrue"] =
                $('input[name="answer_'+(j+1)+'_'+(k+1)+'_istrue'+'"]:checked').val();

        }
    }
    return test;
}
$(function(){
    $( "#submit" ).click(function() {
        let id = localStorage.getItem('id');
        //console.log(getInfo());
        ajaxJSON.put('/api/v1/test/'+ id, getInfo(), true,
            (res) => {
                window.location.replace('/quan-tri/kiem-tra');
            });

    });
});