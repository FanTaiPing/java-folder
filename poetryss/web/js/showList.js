window.onload = function () {
    //给删除选中按钮添加单击事件
    document.getElementById("delSelected").onclick = function () {
        if (confirm("您确定要删除选中条目吗？")) {
            var flag = false;
            //判断是否有选中条目
            var cbs = document.getElementsByName("uid");
            for (var i = 0; i < cbs.length; i++) {
                if (cbs[i].checked) {
                    //有一个条目选中了
                    flag = true;
                    break;
                }
            }
            if (flag) {//有条目被选中
                //表单提交
                document.getElementById("form").submit();
            }
        }
    }
    //1.获取第一个cb
    document.getElementById("firstCb").onclick = function () {
        //2.获取下边列表中所有的cb
        var cbs = document.getElementsByName("uid");
        //3.遍历
        for (var i = 0; i < cbs.length; i++) {
            //4.设置这些cbs[i]的checked 的状态 = firstCb.checked
            cbs[i].checked = this.checked;
        }
    }
}

