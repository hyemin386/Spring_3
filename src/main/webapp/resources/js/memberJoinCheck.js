/**
 * 
 */
	let check = document.getElementsByClassName("check");
	let all = document.getElementById("all");
	//const -> 상수로 사용
	//const all = document.getElementById("all");
	
	all.addEventListener("click", function(){
		for(let ch of check){ //전체동의 체크하면 전체 체크
			ch.checked = all.checked;
		}
	});
	
	for(let ch of check){ //check 하나 빠져있으면 전체동의도 빠짐
		ch.addEventListener("click", function(){
			let result = true;
			for(let c of check){ 
				if(!c.checked){ //true이면 false로 변경, false이면 true로 변경
					result=false;
					break;
				}
			}
			all.checked = result;
		});
	}

//btn눌렀을 때 모두 동의되어있으면 location 사용해 이동
const btn = document.getElementById("btn"); 
btn.addEventListener("clcik",function() {
	if(all.checked){
		location.href="./memberJoin"; //get방식
	} else {
		alert("약관동의는 필수입니다.")
	}
});

/*function check() {
	//반복문 
	let check = document.getElementsByClassName("check");
	let result = true;
	
	for(ch of check){
		if(!ch.checked){ //true이면 false로 변경, false이면 true로 변경
			result = false;
			break;
		} 
	}
	
	all.checked = result;	
}	
	all.addEventListener("mouseenter",function(){
	ch.checked;
	});*/

