/**
 * 
 */
let frm = document.getElementById("frm");
let name = document.getElementById("name");
let title = document.getElementById("title");
let btn = document.getElementById("btn");

btn.addEventListener("click", function(){
	let check1 = name.value == 'admin';
	let check2 = title.value != "";
	
	if(check1 && check2){
		frm.submit();
	}else {
		alert("입력 항목을 확인 하세요");
	}
});


