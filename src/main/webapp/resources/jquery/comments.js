/**
 * 
 */

/* Ajax */
let num = $("#comments").attr("title");
getList();

function getList() {
	$.get("../comments/commentsList?num="+num,function(data){
		console.log(data);
		$("#comments").html(data.trim());
	});
}

$("#write").click(function(){
	let name = $("#name").val();
	let contents = $("#contents").val();

	$.post("../comments/commentsInsert", 
	{	
		num:num,
		name:name,
		contents:contents
	}, function(data){
		data = data.trim();
		if(data==1){
			alert("등록성공!");
			$("#name").val(''); //등록성공시 빈 문자열로 
			$("#contents").val('');
			getList();
		} else {
			alert("등록실패!");
		}
	});
});

//이벤트 위임
$("#comments").on("click","#remove", function() {
	const ar = []; //빈 배열
	//반복문 돌리기
	$(".del").each(function(){
		let ch = $(this).prop("checked");
		if(ch){
			ar.push($(this).val());
		}
	});
	
	$.ajax({
		type: "POST",
		url: "../comments/commentsDelete",
		traditional : true, //배열을 전송
		data: {commentNum: ar},
		success: function(data){
			alert(data);
		}
	});
});
