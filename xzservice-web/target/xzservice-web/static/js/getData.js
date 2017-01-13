/**
 * Created by Administrator on 2017/1/9.
 */
$(function(){
    /*
    * 新闻辅助巡查
    */
    //获取菜单项
    var webId = [];
    var n=0;
    GetData.changeParam("getSourceList",{"loginid":"7362","format":"json"});
    GetData.AjaxGetJsonData("getSourceList",function(){
        var data = arguments[0];
        if(data.status == "ok"){
            var myData = data.data;
            var menu_html = '';
            //$("#collapseOne").empty();
            for(var i=0;i<myData.length;i++){
                menu_html +='<div class="panel-body second-menu"> ' +
                                '<h3  class="panel-title "> ' +
                                    '<a href="javascript:;" data-toggle="collapse" data-target="#more-website'+i+'"><span class="second-menu-icon">+</span>'+myData[i].typename+'</a> ' +
                                '</h3> '+
                                '<div id="more-website'+i+'" class="collapse second-menu-list"> ' ;
                for(var j=0;j<myData[i].sources.length;j++){
                    menu_html +='<p id="'+myData[i].sources[j].sid+'" url="'+myData[i].sources[j].url+'">'+myData[i].sources[j].site+'</p> ';
                    webId.push(myData[i].sources[j].sid);
                }
                menu_html +='</div> ' +
                '</div>';
            }
            $("#collapseOne").append(menu_html);
            $(".news-class-child").val(webId);
        }
        //初始显示前三个信源
        n=0;
        var webIdArr = webId;
        var webIdLen = webIdArr.length;
        getNewsQueryData(n,webIdArr,webIdLen);
    });
    //全类型新闻网站的轮播
    //$(".news-query").on("click",function(){
    //    $(".focus-change").show();
    //    $(".iFrame-box").empty();
    //    n=0;
    //    var webIdStr = $(".news-class-child").val();
    //    var webIdArr = webIdStr.split(",");
    //    var webIdLen = webIdArr.length;
    //    getNewsQueryData(n,webIdArr,webIdLen);
    //});
    //向右滑动
    $(".carousel-control.right").on("click",function(){
        var webIdStr = $(".news-class-child").val();
        var webIdArr = webIdStr.split(",");
        var webIdLen = webIdArr.length;
        if(n < parseInt(webIdLen/3)-1){
            n++;
            getNewsQueryData(n,webIdArr,webIdLen);
        }
    });
    //向左滑动
    $(".carousel-control.left").on("click",function(){
        var webIdStr = $(".news-class-child").val();
        var webIdArr = webIdStr.split(",");
        var webIdLen = webIdArr.length;
        if(n > 0){
            n--;
            getNewsQueryData(n,webIdArr,webIdLen);

        }
    });
    //所有信源列表
    function getNewsQueryData(n,webIdArr,webIdLen){
        var team_webId = [];
        for(var i=0;i<webIdLen;i+=3){
            team_webId.push(webIdArr.slice(i,i+3))
        }
        var sIds = team_webId[n].join(",");
        GetData.changeParam("getElems",{"loginid":"7362","format":"json","sids":sIds});
        GetData.AjaxGetJsonData("getElems",function(){
            var data = arguments[0];
            if(data.status == "ok"){
                var myData = data.data;
                $(".carousel-inner").empty();
                var item_html = '';
                item_html +='<div class="item active clearfix">';
                for(var i=0;i<myData.length;i++){
                    item_html += '<div class="col-md-4 news-list"> ' +
                    '<h4 class="text-center" sid="'+myData[i].sid+'">'+myData[i].site+'</h4> ' +
                    '<p class="news-list-con">';

                    for(var j=0;j<myData[i].elems.length;j++){
                        item_html +='<a href="'+myData[i].elems[j].url+'" target="_black">'+myData[i].elems[j].caption+'<span class="create-time">'+myData[i].elems[j].tmcreate+'</span></a>';
                    }
                    item_html +='</p></div>';
                }
                item_html +='</div>';
                $(".carousel-inner").append(item_html);
            }
        });
    }

    /*
    * 获取单个信源网站的原页
    */
    $(".panel-collapse").on("click",".second-menu-list p",function(){
        $(".second-menu-list p").removeClass("focusCurrent");
        $(this).addClass("focusCurrent");
        var urls = $(this).attr("url");
        $(".focus-change").hide();
        $(".iFrame-box").empty();
        var iFrame_html = '<iframe width="100%" height="100%" scrolling="yes" src="'+urls+'"></iframe>';
        $(".iFrame-box").append(iFrame_html);
    });
});
