//1.使用ES6语法，导入 jquery
import $ from 'jquery'

//导入css样式 （在webpack中，一切皆模块，都可以通过ES6导入语法进行导入和使用）
//如果某个模块中，使用from 接收到的成员为undefined ，则没必要进行接收
import './css/index.css'
import './css/index.less'

//导入图片，得到图片文件
import logo from './image/logo.jpg'
//给 img 标签的src 动态赋值
$('.box').attr('src', logo)

//2.定义jQuery 的入口函数
$(function () {
    //3.实现奇偶隔行变色
    $('li:odd').css('background-color', 'skyblue');
    $('li:even').css('background-color', 'pink');
})


//定义装饰器函数
function info(target) {
    target.info = 'Person info'
}

//定义一个普通的类
@info
class Person{}

//打印Person 的静态属性 info
console.log(Person.info)

