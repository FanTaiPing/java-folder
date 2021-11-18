$(document).ready(function() {
    //图片名称数组
    var imgs = new Array("adver01.jpg", "adver02.jpg", "adver03.jpg", "adver04.jpg", "adver05.jpg", "adver06.jpg");
    //设置一个表示用来控制数组下标
    var index = 0;

    $(".adver").mouseover(function() {
            $(".arrowLeft").show();
            $(".arrowRight").show();
        })
        //鼠标移出
    $(".adver").mouseout(function() {
        $(".arrowLeft").hide();
        $(".arrowRight").hide();
    })

    //左箭头单击事件
    $(".arrowLeft").click(function() {
        //判断是否是第一张图片
        if (index <= 1) {
            alert("当前已经是第一张图片了");
            index = 0;
        } else {
            index--;
            $(".adver").css("background", "url(image/" + imgs[index - 1] + ")");
            $(".adver>ul>li:nth-of-type(" + index + ")").css("background-color", "orange");
            // siblings() 是取得一个包含匹配的元素集合中每一个元素的所有唯一同辈元素的元素集合，用于筛选同辈元素的表达式<除了选择器选择的元素的同级元素>
            $(".adver>ul>li:nth-of-type(" + index + ")").siblings().css("background", "#333"); //#333:灰色
        }


    });

    //右箭头单击事件
    $(".arrowRight").click(function() {
        //判断是否是最后一张图片
        if (index >= imgs.length - 1) {
            alert("已经是最后一张图片了");
            index = imgs.length;
        } else {
            index++;
            $(".adver").css("background", "url(image/" + imgs[index] + ")");
            $(".adver>ul>li:nth-of-type(" + (index + 1) + ")").css("background-color", "orange");
            // siblings() 是取得一个包含匹配的元素集合中每一个元素的所有唯一同辈元素的元素集合，用于筛选同辈元素的表达式<除了选择器选择的元素的同级元素>
            $(".adver>ul>li:nth-of-type(" + (index + 1) + ")").siblings().css("background", "black");

        }
    })
})