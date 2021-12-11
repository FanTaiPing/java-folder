//1.使用ES6语法，导入 jquery
import $ from 'jquery'



//2.定义jQuery 的入口函数
$(function(){
    //3.实现奇偶隔行变色
    $('li:odd').css('background-color','red');
    $('li:even').css('background-color','pink');
})
    
