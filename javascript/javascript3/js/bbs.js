//全局变量
var imgs = new Array("tou01.jpg", "tou02.jpg", "tou03.jpg", "tou04.jpg");

// 显示发帖div
function showDiv() {
    document.getElementById("showSubmit").style.display = "block";
}

// 点击发布添加到内容li
function publist() {
    // 获得随机头像的图片的数组下标
    var index = Math.floor(Math.random() * 4);

    // 创建li节点
    var tvLi = document.createElement("li");

    // 创建div节点
    var tvDiv = document.createElement("div");

    // 创建图片节点
    var tvimage = document.createElement("img");

    // 设置图片节点src属性
    tvimage.setAttribute("src", "image/" + imgs[index]);

    // div添加图片为子节点
    tvDiv.appendChild(tvimage);

    // 创建h1标签节点
    var tvh1 = document.createElement("h1");

    // 取得发布div框里的标题的值填充到h1标签
    var tvTitle = document.getElementById("title").value;
    tvh1.innerText = tvTitle;
    // 创建一个p标签节点
    var tvP = document.createElement("p");

    // 创建两个span标签节点
    var tvSpanOne = document.createElement("span");
    var tvSpanTow = document.createElement("span");

    // 第一个span标签取填充div里的下拉列表框所选的值
    var tvSelect = document.getElementById("section").value;
    tvSpanOne.innerText = "板块：" + tvSelect;

    // 第二个span标签追加到p标签节点里
    var date = new Date();
    var str = date.getFullYear() + "/" + date.getMonth() + 1 + "/" + date.getDate() + "/" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    tvSpanTow.innerText = "时间是：" + str;

    // 把两个sapn标签追加到p标签节点里
    tvP.appendChild(tvSpanOne);
    tvP.appendChild(tvSpanTow);

    // 把div、h1、p标签追加到li里
    tvLi.appendChild(tvDiv);
    tvLi.appendChild(tvh1);
    tvLi.appendChild(tvP);

    // 把添加好的li再插入到ul标签节点里
    var oldUl = document.getElementById("showContent");
    // 把新添加的li节点插入到老的li节点之前
    oldUl.insertBefore(tvLi, oldUl.firstChild);
    // 清除div里填充过的内容，如标题和内容部分
    document.getElementById("title").value = "";
    document.getElementById("content").value = "";


    // 设置发布div隐藏
    document.getElementById("showSubmit").style.display = "none";
}