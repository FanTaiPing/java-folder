
function checkUser() {
	let username = document.getElementById("username").value;
	let flag = document.getElementById("flag").value;
	let url = document.getElementById("url").value;
	let msg = document.getElementById("msg");

	axios.get(url + "CheckUserServlet", {
		params: {
			username,
			flag
		}
	})
		.then(function(response) {
			if (response.data.flag) {
				msg.style.color = "green";
				msg.innerText = response.data.msg;

			}else{
			msg.style.color = "red";
			msg.innerText = response.data.msg;
			}

		})


}