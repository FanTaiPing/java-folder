/**
 * 关不按钮事件
 */
function closeWindow() {
    window.close();
}
/**
 * 移入收藏事件
 */
function moveCollection() {
    alert("收藏成功！");
}
/**
 * 删除事件
 */
function del() {
    var flag = confirm("确定要删除吗？");
    if (flag) {
        alert("删除成功！");
    } else {
        alert("您点了取消按钮！");
    }
}
/**
 * 结算事件
 */
function settlement() {
    alert("您点了结算按钮！");
}