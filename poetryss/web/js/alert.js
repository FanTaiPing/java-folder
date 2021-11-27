// 在之前的CSS代码中，加入id="mask"的遮罩层和id="loginBox"的窗体的样式
Base.prototype.center = function(width,height){
    //将loginBox 设置为绝对定位
    //将浏览器窗口的高度-窗体自身的高度后除以2后的值设置为top
    //将浏览器窗口的宽度-窗体自身的宽度后除以2后的值设置为left
    var top=(window.InnerHeight - height)/2 + "px";
    var left=(window.InnerWidth - width)/2 + "px";
    for (var i=0;i<this.elements.length;i++){
        var element = this.elements[i];
        element.style.top = top;
        element.style.left = left;
    }
    return this;
}



//触发浏览器窗口事件   设置窗体水平垂直居中
Base.prototype.resize = function(fn){
    window.onresize = fn;
    return this;
}



//浏览器窗口改变大小时触发居中
window.onload = function () {
    //登录弹框
    var mask = $().getId("mask");//获取遮罩层
    var loginBox=$().getId("loginBox");//获取窗体
    loginBox.center(350,250);//设置船体居中
    //浏览器窗口改变时依然居中
    $().resize(function(){
        loginBox.center(350,250);

    });
    //默认弹窗隐藏，点击登录按钮时显示弹窗
    $().getClass("login").click(function() {
        /* Act on the event */
        loginBox.show();
        mask.show();
    });
    //点击关闭按钮时隐藏弹窗
    $().getClass("close").click(function() {//点击窗体关闭按钮，
        /* Act on the event */
        loginBox.hide();
        mask.hide();
    });

};