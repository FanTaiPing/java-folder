function returnover() {
    var integers = prompt("请输入一行字符串：", "");
    var integerArray = integers.split("");
    document.write(`输入<br>${integers}<br>输出<br>`);
    for (var i = integerArray.length - 1; i >= 0; i--) {
        document.write(`${integerArray[i]}`);
    }
}