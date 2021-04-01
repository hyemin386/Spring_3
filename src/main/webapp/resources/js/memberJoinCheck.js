/**
 * 
 */

function check() {
	alert("check");
	
	let check = document.getElementsByClassName("check");
	//const -> 상수로 사용
	const all = document.getElementById("all");
	
	let result = true;
	
	//반복문 
	for(ch of check){
		if(!ch.checked){ //true이면 false로 변경, false이면 true로 변경
			result = false;
			break;
		} 
	}
	
	all.checked = result;	

}