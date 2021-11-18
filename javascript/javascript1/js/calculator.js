function calculate() {
    var numOne = prompt("请输入第一个数：", "");
    var numTow = prompt("请输入第二个数：", "");
    var char = prompt("请选择你要进行的运算（'+','-','*','/'）：", "");
    var result;
    switch (char) {
        case '+':
            result = parseFloat(numOne) + parseFloat(numTow);
            break;
        case '-':
            result = parseFloat(numOne) - parseFloat(numTow);
            break;
        case '*':
            result = parseFloat(numOne) * parseFloat(numTow);
            break;
        case '/':
            result = parseFloat(numOne) / parseFloat(numTow);

            break;

    }
    // alert("计算结果为：" + result);
    alert(`计算结果为:${numOne} ${char} ${numTow} = ${result}`);

}