// 点击按钮更换图书名
function alterBook() {
    // innerText 纯文本（ 字符串） 的内容， innerHTML 纯文本（ 文本里可以解析html标签）
    // document.getElementById("book").innerHTML = "书名.红楼梦";
    // 根据id属性名称获取单个html标签元素（对象）
    document.getElementById("book").innerText = "书名.红楼梦";


}
// 点击所有input标签
function all_input() {
    // 根据html标签名获取html数组对象
    let input = document.getElementsByTagName("input");
    let str = "";
    for (var i = 0; i < input.length; i++) {
        str += input[i].value + "&nbsp;&nbsp;"
    }
    document.getElementById("replace").innerHTML = str;
}
// 点击四季名称按钮
function s_input() {
    // 根据name属性名称获取html数组对象
    let season = document.getElementsByName("season");
    var str = "";
    for (let i = 0; i < season.length; i++) {
        str += season[i].value + "&nbsp;&nbsp;"
    }
    document.getElementById("replace").innerHTML = str;
}

function clearAll() {
    document.write("");
}