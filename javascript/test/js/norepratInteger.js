function norepeat() {
    var integers = prompt("请输入一组整数：", "");
    if (isNaN(integers)) {
        alert("请输入一组整数！！！");
    } else {
        var integerArray = integers.split("").reverse(); //reverse():将数组逆序反转
        var newArray = new Array();
        for (var i = 0; i <= integerArray.length - 1; i++) {
            if (newArray.indexOf(integerArray[i]) == -1) {
                newArray.push(integerArray[i]);
            }
        }
        document.write(`输入<br>${integers}<br>输出<br>`);
        for (var j = 0; j < newArray.length; j++) {
            document.write(`${newArray[j]}`);
        }
    }
}