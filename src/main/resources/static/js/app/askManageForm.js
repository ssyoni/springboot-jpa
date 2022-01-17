$(document).ready(function(){

    var cnt=0;
    $('#addRadioBtn').on('click',function(){
        cnt = $('#radioField > #radioDiv').length;
        var div = '<div class="form-check" id="radioDiv">';
        div += '<label class="form-check-label">';
        div += '<input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios'+cnt+'" value="option'+cnt+'" checked="">';
        div += '<input type="text" class="form-control" id="answerRadio" aria-describedby="emailHelp" placeholder="답변 항목을 입력해주세요" style="width:500px;">';
        div += '</label>';
        div += '<button type="button" class="btn btn-outline-dark delRadioBtn" id="delRadioBtn'+cnt+'" onclick="delRadio('+cnt+');">delete</button></div>';

        var $node = $(div);
        $("fieldset[id=radioField]").append($node);
    })

    $('#addChkBtn').on('click',function(){
        cnt = $('#chkField > #chkDiv').length;
        var div = '<div class="form-check" id="chkDiv">';
        div += '<input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">';
        div += '<label class="form-check-label" for="flexCheckDefault">';
        div += '<input type="text" class="form-control" id="answerChk" aria-describedby="emailHelp" placeholder="답변 항목을 입력해주세요" style="width:500px;">';
        div += '</label>';
        div += '<button type="button" class="btn btn-outline-dark" id="delChkBtn'+cnt+'" onclick="delChk('+cnt+');">delete</button></div>';

         var $node = $(div);
         $("fieldset[id=chkField]").append($node);
    })

    $('#selectAswForm').on('change',function(){
        var filedName = $('#selectAswForm option:selected').val();
        console.log(filedName);

        if(filedName == 'radioField'){
            $('#radioField').css('display','');
        }else{
            $('#radioField').css('display','none');
        }

        if(filedName == 'chkField'){
            $('#chkField').css('display','');
        }else{
            $('#chkField').css('display','none');
        }

    })


})

function delRadio(cnt){
    $('#delRadioBtn'+cnt).parent().remove();
}

function delChk(cnt){
    $('#delChkBtn'+cnt).parent().remove();
}



