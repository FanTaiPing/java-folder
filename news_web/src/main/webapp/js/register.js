/*用户注册时验证是否存在此用户*/
let flag = false;
function checkUser() {
	let username = document.getElementById("username").value;
	let url = document.getElementById("url").value;
	let nameMsg = document.getElementById("nameMsg");
	let flag = document.getElementById("flag").value;

	//当前的JS对象存到_this对象里
	let _this = this;
	//ajax
	axios.get(url + "CheckUsernameServlet", {
		params: {
			username,
			flag
		}
	})
		.then(function(response) {

			//根据标识判断（没有用户名）
			_this.falg = response.data.flag;
			//根据标识判断(没有用户名)
			if (response.data.flag) {
				nameMsg.style.color = "green";
				nameMsg.innerText = response.data.msg;
			} else {
				nameMsg.style.color = "red";
				nameMsg.innerText = response.data.msg;
			}
		})
		.catch(function(error) {
			alert(error);
		});   
}


/*表单提交前验证用户名和密码必须填写才能提交*/
function checkForm() {
	//取用户名，密码

	//判断验证用户名
	if (!this.falg) {
	alert("用户已存在，请重新输入！！");
		return false;
	}
	return true;
}
