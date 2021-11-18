$(document).ready(function() {
    //标题单击事件
    $("#book h1").click(function() {
        //设置标题字体大小为24px,颜色蓝色
        $('#book h1').css({
            "font-size": "24px",
            "color": "#00f"
        });
        //设置p标签里字体颜色
        $("#book>p").css("color", "green")
    })

    //查看全部超链接
    $(".whole").click(function() {
        $(".intro").show();
        $(".intro p").css("color", "#000")
    })
})