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