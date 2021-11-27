/*
/!*用户注册时验证是否存在此用户*!/
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


/!*表单提交前验证用户名和密码必须填写才能提交*!/
function checkForm() {
	//取用户名，密码

	//判断验证用户名
	if (!this.falg) {
	alert("用户已存在，请重新输入！！");
		return false;
	}
	return true;
}
*/



//校验用户名
// function checkUsername(){
// 	//获取用户名的值
// 	var username = $("#username").val();
// 	//定义正则表达式
// 	var reg_username = /^[0-9A-Za-z]{8,20}$/;
// 	//判断给出提示信息
// 	var flag = reg_username.test(username);
// 	if(flag){
// 		//用户输入合法
// 		$("#username").css("border","");
// 	}else{
// 		//用户输入不合法
// 		$("#username").css("border","2px solid red");
// 	}
// 	return flag;
// }

//校验密码
function checkPassword(){
	//获取用户名的值
	var password = $("#password").val();
	//定义正则表达式
	var reg_password = /^[0-9A-Za-z]{8,20}$/;
	//判断给出提示信息
	var flag = reg_password.test(password);
	if(flag){
		//用户输入合法
		$("#password").css("border","");
	}else{
		//用户输入不合法
		$("#password").css("border","2px solid red");
	}
	return flag;
}
$(function (){
	//当表单提交时，调用所有的校验方法
	$("#registerForm").submit(function (){
		// 发送数据到服务器
		if(checkPassword()){
			//校验通过，发送ajax请求，提交表单数据
			$("registerUserServlet",$(this).serialize(),function (data){
				//处理服务器响应的数据 data

			})
		}else{
			//跳转页面
			 if(checkPassword() == false){
				return false;
			}
		}
	})
	$("#password").blur(checkPassword);
})
