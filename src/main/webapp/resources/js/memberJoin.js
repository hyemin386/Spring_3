/**
 * 
 */
 //pw길이
let id = document.getElementById("id");
id.addEventListener("blur", function() {
	let message = "6글자 미만입니다.";
	let c = "r1";
	if(id.value.length>5){
		message = "6글자 이상입니다.";
		c ="r2";
	}
	
	let idResult = document.getElementById("idResult");
	idResult.innerHTML = message;
	idResult.setAttribute("class", c);
});

//pw길이 
let pw = document.getElementById("pw");
let pw2 = document.getElementById("pw2");
pw.addEventListener("blur", function(){
	let message ="8글자 미만입니다.";
	if(pw.value.length>7){
		message="8글자 이상입니다";
		c ="r2";
	}
	
	let pwResult = document.getElementById("pwResult");
	pwResult.innerHTML = message;
	pwResult.setAttribute("class", c);
});

//pw와 pw2가 같은지 비교
pw2.addEventListener("blur", function() {
	if(pw.value != pw2.value) {
		pw2.value="";
	}
});