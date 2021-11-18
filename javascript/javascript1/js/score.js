// 方法一：
function scores() {
    var sum = 0;
    var count = parseInt(prompt("请输入考试科目的数量：", ""));
    if (isNaN(count) != true) {
        if (count != 0 || count > 0) {
            for (var i = 1; i <= count; i++) {
                var num = parseFloat(prompt(`请输入第${i}门课程的成绩：`, ""));
                sum += num;
            }
            alert(`${count}门科目的总成绩是：${sum}`);
        } else {
            alert("输入的数值必须是非零、非数字！");
        }
    } else {
        alert("输入的是非数字！");
    }
}
// 方法二:
/**
 * 统计考试科目成绩
 */
function count() {
    var num = parseInt(prompt('请输入考试科目数量：', ""));
    if (!notZeroNotNegative(num)) {
        return;
    }
    let count = 0;
    for (let i = 1; i <= num; i++) {
        let score = parseFloat(prompt("请输入第" + i + "门课程的成绩：", ""));
        if (!notNegative(score)) {
            return;
        }
        count += score;
    }
    alert(`${num}门科目的总成绩是：${count}`);
    //ES6语法 var一般申明是全局变量， let一般申明是局部变量，const一般申明是常量
}
/**
 * 判断接收是否是非零，非负数
 * @param {*} num 
 */
function notZeroNotNegative(num) {
    if (isNaN(num)) {
        alert("输入的必须是数字！");
        return false;
    }
    return true;
}

function notNegative(num) {
    if (num < 0) {
        alert('输入的必须是非零，非负数！');
        return false;
    }
    return true;
}