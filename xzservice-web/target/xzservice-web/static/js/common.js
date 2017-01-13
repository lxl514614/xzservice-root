/**
 * Created by Administrator on 2017/1/9.
 */
$(function(){
    /*
    * 菜单
    */
    //变换上下箭头
    $(".panel-collapse").on('show.bs.collapse', function () {
        $(this).parents(".panel").find(".first-menu-icon").removeClass("glyphicon-chevron-up").addClass("glyphicon-chevron-down");
    });
    $(".panel-collapse").on('hide.bs.collapse', function () {
        $(this).parents(".panel").find(".first-menu-icon").removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-up");
    });
    //变换加减号
    //$(".panel-collapse").find(".second-menu-list").on('show.bs.collapse', function () {
    //    $(this).parents(".panel-body").find(".second-menu-icon").text("-");
    //});
    //$(".panel-collapse").find(".second-menu-list").on('hide.bs.collapse', function () {
    //    $(this).parents(".panel-body").find(".second-menu-icon").text("+");
    //});

    //点击下发
    $(".releaseBtn").on("click",function(){
        //var newsUrl = $("input[name=newsLink]").val();
        //var newsTitle = $("input[name=newsTitle]").val();
        //var newsContent = $("input[name=newsContent]").val();

    });
    $(".panel-body").on("click","p",function(){
        $(this).addClass("focusCurrent").siblings().removeClass("focusCurrent");
    });

});