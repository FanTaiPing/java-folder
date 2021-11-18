let flag = false;

function check() {
	let username = document.getElementById("username").value;
	let url = document.getElementById("url").value;
	let nameMsg = document.getElementById("msg");
	let flag = document.getElementById("flag").value;
	
	//当前的JS对象存到_this对象里
	let _this = this;
	axios.get(url + "CheckUsernameServlet", {
		params: {
			username,
			flag
		}
	})
		.then(function(response) {
		//根据标识判断(有没有用户)
			 _this.flag = response.data.flag;
			if (response.data.flag) {
				nameMsg.style.color = "green";
				nameMsg.innerText = response.data.msg;
			} else {
				nameMsg.style.color = "red";
				nameMsg.innerHTML = response.data.msg;
			}
		})
		.catch(function(error) {
			alert(error);
		});
}


function checkLogin() {
	if (!this.flag) {
		alert("登录失败，请重新登录！！！");
		return false;
	}
return true;
}