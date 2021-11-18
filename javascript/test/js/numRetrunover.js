function returnover() {
    var integers = prompt("请输入一组整数：", "");
    if (isNaN(integers)) {
        alert("输入的必须是数字！！！");
    } else {
        var integerArray = integers.split("");
        document.write(`输入<br>${integers}<br>输出<br>`);
        for (var i = integerArray.length - 1; i >= 0; i--) {
            document.write(`${integerArray[i]}`);
        }
    }
}