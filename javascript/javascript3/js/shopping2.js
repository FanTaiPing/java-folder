// /**
//  * 方法一
//  */
// // 第一个商品数量计算减法
// function minus_s() {
//     // 先获得name为amount的标签集合
//     let amount = document.getElementsByName("amount");
//     var count = 1;
//     // amount[0].value获得集合里面的第一个值
//     count = parseInt(amount[0].value) - 1;
//     // 数量不能是负数
//     if (count <= 0) {
//         document.getElementsByName("amount")[0].value = 1;
//         price();
//         alert("商品数量不能小于等于0！！！！");
//     } else {
//         document.getElementsByName("amount")[0].value = count;
//         price();
//     }
// }
// // 第一个商品数量计算加法
// function plus_s() {
//     var amount = document.getElementsByName("amount");
//     var count = 1;
//     count = parseInt(amount[0].value) + 1;
//     document.getElementsByName("amount")[0].value = count;
//     price();
// }
// // 第一个商品的总价计算
// function price() {
//     // unitPrice:商品单价
//     var unitPrice = 21.90;
//     var count = document.getElementsByName("amount")[0].value;
//     // .tofixed(n):保留小数点后n位 price:商品总价
//     var price = (unitPrice * count).toFixed(2);
//     document.getElementById("price0").innerText = "￥" + price;
//     return price;
// }


// // 第二个商品数量减法计算
// function minus_ss() {
//     let amount = document.getElementsByName("amount");
//     var count = 1;
//     // amount[1].value获得集合里面的第二个值
//     count = parseInt(amount[1].value) - 1;
//     if (count <= 0) {
//         document.getElementsByName("amount")[1].value = 1;
//         price1();
//         alert("商品数量不能小于等于0！！！！");
//     } else {
//         document.getElementsByName("amount")[1].value = count;
//         price1();
//     }
// }
// // 第二个商品数量计算加法
// function plus_ss() {
//     var amount = document.getElementsByName("amount");
//     var count = 1;
//     count = parseInt(amount[1].value) + 1;
//     document.getElementsByName("amount")[1].value = count;
//     price1();
// }
// // 第二个商品总价计算
// function price1() {
//     // unitPrice:商品单价
//     var unitPrice = 24.00;
//     var count = document.getElementsByName("amount")[1].value;
//     // price:商品总价
//     var price = (unitPrice * count).toFixed(2);
//     document.getElementById("price1").innerText = "￥" + price;
//     return price;
// }

// // 两个商品总价计算
// function totalPrice() {
//     var totalPrice = (parseFloat(price()) + parseFloat(price1())).toFixed(2);
//     document.getElementById("totalPrice").innerText = "￥" + totalPrice;
// }


/**
 * 防止修改商品数量为负数和0
 * 
 * 方法一和方法二都可用（公用部分）
 */
function update(index) {
    let amount = document.getElementsByName("amount");
    var count = parseInt(amount[index].value);
    if (count <= 0) {
        alert("商品数量不能小于等于0！！");
        document.getElementsByName("amount")[index].value = 1;
        price();
    } else {
        document.getElementsByName("amount")[index].value = count;
    }

}



/**
 * 方法二
 */
// 全局变量
// 加法
var plus = document.getElementsByName("plus");

// 减法
var minus = document.getElementsByName("minus");

// 单价
var price = document.getElementsByName("price");

// 数量
var amount = document.getElementsByName("amount");

// 单个商品的总价
var priceZero = document.getElementById("price0");
var priceOne = document.getElementById("price1");

// 总价
var totolPrice = document.getElementById("totalPrice");

// 获得显示的div元素
var info = document.getElementById("info");



/**
 * 通用加法
 * @param {*} index 
 */

function addition(index) {
    // 1.取出原来的数量
    var oldNum = parseInt(amount[index].value);

    // 2.+1
    oldNum += 1;

    // 3.赋值
    amount[index].value = oldNum;

    // 4.计算单价*数量填充到对应的额购物车单价元素
    var money = parseFloat(price[index].value) * oldNum;
    switch (index) {
        case 0:
            // tofixed(2)四舍五入保留两位小数
            priceZero.innerText = "￥" + money.toFixed(2);
            // document.getElementById("price0").innerText = "￥" + money.toFixed(2);
            break;
        case 1:
            // tofixed(2)四舍五入保留两位小数
            priceOne.innerText = "￥" + money.toFixed(2);
            // document.getElementById("price1").innerText = "￥" + money.toFixed(2);
            break;
    }
}

/**
 * 通用减法
 * @param {*} index 
 */
function subtraction(index) {
    // 1.取出原来的数量
    var oldNum = parseInt(amount[index].value);

    // 2.-1后判断不能小于0
    oldNum -= 1;

    // 购物车商品数量不能小于等于0
    if (oldNum <= 0) {
        alert("商品数量不能小于等于0！！");
        return;
    }
    // 3.赋值
    amount[index].value = oldNum;

    // 4.计算单价*数量填充到对应的额购物车单价元素
    var money = parseFloat(price[index].value) * oldNum;
    switch (index) {
        case 0:
            // tofixed(2)四舍五入保留两位小数
            document.getElementById("price0").innerText = "￥" + money.toFixed(2);
            break;
        case 1:
            // tofixed(2)四舍五入保留两位小数
            document.getElementById("price1").innerText = "￥" + money.toFixed(2);
            break;
    }
}


/**
 * 获取节点信息并拼接字符串显示
 */
function infomation() {

    var cartList = document.getElementById("cartList")
    var priceOne = cartList.firstElementChild.firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.nodeValue || cartList.firstElementChild.firstElementChild.nextElementSibling.nextElementSibling.firstChild.nodeValue;
    var priceTow = cartList.firstElementChild.nextSibling.nextSibling.firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.nodeValue || cartList.firstElementChild.nextElementSibling.firstElementChild.nextElementSibling.nextElementSibling.firstChild.nodeValue;
    var totalPrice = cartList.firstElementChild.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.firstChild.nodeValue || cartList.firstElementChild.nextElementSibling.nextElementSibling.firstElementChild.firstChild.nodeValue;

    var str = "";
    str += "您本次购买的商品信息如下：<br/>";
    str += "白颜松 白色：" + priceOne + "<br>";
    str += "岛上书店 ：" + priceTow + "<br>";
    str += "商品共计：" + totalPrice;

    info.innerHTML = str;
    // 设置div显示
    info.style.display = "block";
    info.style.fontWeight = "700";
}

/**
 * 结算
 */
function count() {
    // 循环购物车商品数量
    var num = amount.length;
    // 累加总价格
    let count = 0;
    for (let i = 0; i < num; i++) {
        // 商品数量
        var oldNum = parseInt(amount[i].value);
        // 商品价格
        var money = parseFloat(price[i].value);
        count += oldNum * money;

    }
    // 赋值给总价的元素
    totalPrice.innerText = "￥" + count.toFixed(2);
    infomation();
}