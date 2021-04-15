var number = 10;
function renderProductItem(){
    let item = "";
    for (let i = 0; i < number; i++) {
        item = item.concat("<div class=\"form-group\" style=\"overflow: hidden;\">");
        item = item.concat("<label>Câu hỏi: "+(i+1)+"</label>");
        item = item.concat("<input type=\"text\" class=\"form-control\" id=\"question_"+(i+1)+"\" name=\"question_"+(i+1)+"\">");

        for(let j = 0 ; j<4 ; j++){
            item = item.concat("<div class=\"Answer\" style=\"float: left; width: 20%;margin-right: 10px;\">");
            item = item.concat("<label>Đáp án: "+(j+1)+"</label>");
            item = item.concat("<input type=\"text\" class=\"form-control\" id=\"answer_"+(i+1)+"_"+(j+1)+"\">");
            item = item.concat("<label class=\"form-check-label\" style='margin-right: 15px;'>");
            item = item.concat("<input type=\"radio\" class=\"form-check-input\" value = true name=\"answer_"+(i+1)+"_"+(j+1)+"_istrue\">True");
            item = item.concat("</label>");
            item = item.concat("<label class=\"form-check-label\">");
            item = item.concat("<input type=\"radio\" class=\"form-check-input\" value = false name=\"answer_"+(i+1)+"_"+(j+1)+"_istrue\">False");
            item = item.concat("</label>");
            item = item.concat("</div>");
        }
        item = item.concat("</div>");
        item = item.concat("</br>");
    }
    return item;
}
$('#questionoftest').html(renderProductItem());
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
            question:null,
            answers:[]
        }
        test["quizzs"][j]["question"] = $('#question_'+(j+1)).val();
        for(var k = 0 ; k<4 ; k++){
            test["quizzs"][j]["answers"][k]={
                content : null,
                istrue: false
            }
            test["quizzs"][j]["answers"][k]["content"] = $('#answer_'+(j+1)+'_'+(k+1)).val();
            test["quizzs"][j]["answers"][k]["istrue"] =
                $('input[name="answer_'+(j+1)+'_'+(k+1)+'_istrue'+'"]:checked').val();

        }
    }
    return test;
}
$(function(){
    $( "#submit" ).click(function() {
        //getInfo();
        ajaxJSON.post('/api/v1/test', getInfo(), true,
            (res) => {

                window.location.replace('/quan-tri/kiem-tra');
            });
    });
});