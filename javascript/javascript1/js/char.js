// 输出到body
document.writeln("在以下字符中：");
// 申明一个国家字符串的英文数组//Ge希腊、Br大不列颠、Eg埃及
var country = new Array("America", "Greece", "Britain", "Canada", "China", "Egypt");

for (var i = 0; i < country.length; i++) {
    document.writeln(country[i] + "<br>");
}


// 申明一个变量用来计数
var count = 0;
for (var i = 0; i < country.length; i++) {
    // 一次判断当前数组里字符串元素是否包含小写的a 或者大写A
    if (country[i].indexOf("a") != -1 || country[i].indexOf("A") != -1) {
        count++;
    }
}
document.writeln(`共有${count}个字符串中包含a或A<br>`); //ES6语法
document.writeln("共有" + count + "个字符串中包含a或A<br>");