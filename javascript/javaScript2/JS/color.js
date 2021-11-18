function changeColor() {
    // 1.创建颜色数组对象
    var colorArray = new Array("红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色");
    var colorValue = new Array("red", "orange", "yellow", "green", "cyan", "blue", "purple");
    // 2.获得随机数用来做数组下标
    var num = Math.ceil(Math.random() * 7) - 1;

    // 3.替换span标签里的内容，同时设置css样式
    document.getElementById("color").innerText = colorArray[num];
    // js动态改变html元素css样式
    document.getElementById("color").style.color = colorValue[num];
    document.getElementById("color").style.fontWeight = "bold";

}