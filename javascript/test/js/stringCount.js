function strCount() {
    var str = prompt("请输入字符串：", "");
    var strArray = str.split(" ");
    for (var i = 0; i < strArray.length; i++) {
        if (i == strArray.length - 1) {
            var lastStr = strArray[strArray.length - 1];
        }
    }
    var count = lastStr.length;
    document.write(`输入<br>${str}<br>输出<br>${count}`);
}