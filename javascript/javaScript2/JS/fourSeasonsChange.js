/**
 * 四季变化js
 * spring()春的链接js
 * 
 */
function spring() {
    window.location.href = 'spring.html';
}
/**
 * 跳转到夏天页面
 */
function summer() {
    window.location.href = 'summer.html';
}
/**
 * 跳转到秋天页面
 */
function autumn() {
    window.location.href = 'autumn.html';
}
/**
 * 跳转到冬天页面
 */
function winter() {
    window.location.href = 'winter.html';
}
/**
 * 后退按钮方法
 */
function back() {
    // 方法一
    window.history.back();
    // 方法二：
    window.history.go(-1);
}
/**
 * 前进按钮方法
 */
function forward() {
    // 方法一：
    window.history.forward();
    // 方法二：
    window.history.go(1);
}