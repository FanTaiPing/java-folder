$(document).ready(function() {
    // 设置所有html元素主题加粗  * 代表所有
    $("*").css("font-weight", "bold");

    //自营图片几十万.....字体颜色为红色
    $(".intro").css("color", "red");

    //京东价￥24.10设置24px大小，红色加粗
    $("#jdPrice>span:nth-of-type(1)").css({
        "font-size": "24px",
        "color": "red"
    })


    //定价￥35.0字体颜色为#ccc，价格中有中划线
    $("#jdPrice>p").css({
        "color": "#ccc",
        "text-decoration": "line-through"
    })

    //dl标签中的字体颜色为红色
    $("dl").css("color", "red");

    //单击"以下促销。。。"系那是隐藏的内容，此部分字体颜色为红色
    $("dt").click(function() {
        $("dd").css("color", "red");
        // 方法一
        // if ($("dd").css("display") == "none") {
        //     $("dd").show();
        // } else {
        //     $("dd").hide();
        // }


        // 方法二
        $("dd").toggle();
    })


    //加购价、满减。105-5/200-16字体颜色白色
    $("dd>span,#ticket>span").css({
        "color": "#fff",
        "background-color": "red",
        "padding": "1px 5px",
        "margin-right": "5px"
    });

    //背景颜色红色。上下内边距1px，左右内边距为5px，外边距为5px
})