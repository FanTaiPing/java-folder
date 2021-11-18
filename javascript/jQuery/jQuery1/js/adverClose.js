/**
 * Created by zongjuan.wang on 2016/7/14.
 */


function adv_close() {
    document.getElementById("close").style.display = "none";
    document.getElementById("float").style.display = "none";
}

var closeTop;
var closeLeft;
var floatTop;
var floatLeft;
var closeObject;
var floatObject;

function place() {
    closeObject = document.getElementById("close");
    floatObject = document.getElementById("float");
    if (closeObject.currentStyle) { //IE浏览器
        closeTop = parseInt(closeObject.currentStyle.top);
        closeLeft = parseInt(closeObject.currentStyle.left);
        floatTop = parseInt(floatObject.currentStyle.top);
        floatLeft = parseInt(floatObject.currentStyle.left);
    } else { //fireFox浏览器
        closeTop = parseInt(document.defaultView.getComputedStyle(closeObject, null).top);
        closeLeft = parseInt(document.defaultView.getComputedStyle(closeObject, null).left);
        floatTop = parseInt(document.defaultView.getComputedStyle(floatObject, null).top);
        floatLeft = parseInt(document.defaultView.getComputedStyle(floatObject, null).left);
    }
}

function roll() {
    var closeScrollTop = parseInt(document.documentElement.scrollTop || document.body.scrollTop);
    var closeScrolllLeft = parseInt(document.documentElement.scrollLeft || document.body.scrollLeft);
    var floatScrollTop = parseInt(document.documentElement.scrollTop || document.body.scrollTop);
    var floatScrolllLeft = parseInt(document.documentElement.scrollLeft || document.body.scrollLeft);
    closeObject.style.top = closeTop + closeScrollTop + "px";
    closeObject.style.left = closeLeft + closeScrolllLeft + "px";
    floatObject.style.top = floatTop + floatScrollTop + "px";
    floatObject.style.left = floatLeft + floatScrolllLeft + "px";
}
window.onload = place;
window.onscroll = roll;