$(".explanation-btn").click(
    // 显示注释等
    function() {
        // 注释数组
        var explanations = $(this).nextAll(".explanation").children();
        // 按钮数组
        var btns = $(this).siblings(".btn");
        var index = $(this).index();
        var now = $(this).nextAll(".explanation").children().eq(index)

        btns.removeClass("btn-active")
        $(this).toggleClass("btn-active")


        if (now.hasClass("hide")) {
            explanations.addClass("hide")
            now.removeClass("hide")
        } else {
            now.addClass("hide")
        }
    }
)

$(".line-btn").click(
    function() {
        // 按钮数组
        var btns = $(this).siblings(".btn");
        btns.removeClass("btn-active")
        $(this).toggleClass("btn-active")
    }
)

$(".collapse-btn").click(
    function() {
        var collapses = $(this).parents(".container").children(".collapse");
        collapses.removeClass("show");
        collapses.eq($(this).index()).addClass("show")
    }
)