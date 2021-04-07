/**
 * 
 */
let count = 0;

$("#add").click(function(){
	if(count<5){ //최대 5개까지만 추가
	let contents = $("#sample").html(); //html요소를 불러와서 contents에 저장
	$("#files").append(contents);
	count++; //count=count+1	
	} else {
		alert("최대 5개만 가능합니다")
	}
});

$("#del").click(function(){
	$("#files").remove();
});

//부모의 이벤트를 자식에게 위임
$("#files").on("click",".delete", function(){
	$(this).parent().remove();
	count--;
});