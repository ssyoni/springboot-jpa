var pagination = {

    info : {
        currentPage : $('input[class=currentPage]').val(),
        totalPagesNum : $('input[class=totalPagesNum]').val(),
        totalCnt : $('input[class=totalCnt]').val()
    },

    init : function(){
       var _this = this;

        /*페이지 넘버 생성 */
        _this.createPageNumber();
        /*페이지 버튼 disabled 속성 컨트롤*/
        _this.checkNextOrPreviousPage();

    },

    createPageNumber : function(){

        for(var i=pagination.info.totalPagesNum;i > 0;i--){
            var pageNav = '<li class="page-item"><a class="page-link" href="?page='+(i-1)+'">'+i+'</a></li>'
            $('ul.pagination li#page-previous').after(pageNav);
        }
    },

    checkNextOrPreviousPage : function(){
        if(this.info.currentPage == this.info.totalPagesNum){
            $('li[id=page-next]').addClass('disabled');
        }
        if(this.info.currentPage <= 0){
            $('li[id=page-previous]').addClass('disabled');
        }
    }

}

pagination.init();