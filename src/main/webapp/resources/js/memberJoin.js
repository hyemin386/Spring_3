/**
 * 
 */
function memberJoin() {
	let id = document.getElementById("id");
	if(id.value==""){
		alert("필수입력입니다.");
	}

	let pw = document.getElementById("pw");
	if(pw.value=""){
		alert("필수입력입니다.");
	}
	
	let name = document.getElementById("name");
	if(name.value=""){
		alert("필수입력입니다.");
	}
	
	let phone = document.getElementById("phone");
	if(phone.value=""){
		alert("필수입력입니다.");
	}
	
	let email = document.getElementById("email");
	if(email.value=""){
		alert("필수입력입니다.");
	}
}	