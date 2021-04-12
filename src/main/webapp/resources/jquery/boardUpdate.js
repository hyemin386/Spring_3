/**
 * 
 */
$(".fileDelete").click(function(){
	let check = confirm("삭제?"); //확인, 취소나오는 창
	
	if(check){
		let fileNum = $(this).attr("title");
		let obj = $(this);
		$.ajax({
			url:"./FileDelete",
			type:"GET",
			data:{fileNum:fileNum},
			success:function(result){
				result=result.trim(); //앞뒤공백 제거
				if(result>0){
					alert("삭제성공");
					$(obj).parent().remove();
					count--;
				} else {
					alert("삭제실패");
				}
			}
		});
	}
});