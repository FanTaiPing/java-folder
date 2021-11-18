$(document).ready(function() {
    //去除所欲li前面的项目圆点
    $("li").css("list-style", "none");
    //设置所有标题标签背景颜色和字体颜色
    $(".container :header").css({
        "background-color": "#2a65ba",
        "color": "#ffffff",
        "width": "400px",
        "margin-top": "0",
    })


    //.container li 底部边框虚线
    $(".container ul li").css("border-bottom", "1px dashed gray");

    $(".container").css({
        "border": "1px solid blue",
        "width": "400px",
    })


    //设置第一个li字体大小16px，颜色红色
    $(".container li:first").css({
        "font-size": "16px",
        "color": "#e90202",
    })

    //设置最后一个li底部边框无
    $(".container li:last").css("border-bottom", "none");

    //设置li偶数（even）行的背景颜色
    $(".container li:even").css("background", "aqua");

    //设置li奇数（odd）行的背景颜色
    $(".container li:odd").css("background", "pink");

    //设置li这个位置索引小于2的li行设置背景颜色
    $(".container li:lt(2)").css('color', "#708b02");


    //设置li这个位置索引大于3的li行设置字体颜色
    $(".container li:gt(3)").css("color", "#b66302");

    //设置li这个位置索引为0的li行设置背景颜色
    $(".container li:eq(0)").css("background-color", "black");

    //设置li位置索引不等于4的li行设置背景颜色
    $(".container li:not(li:eq(4))").css('background-color', "#000");
})