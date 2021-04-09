/**
 * 
 */

/* Ajax */
let num = $("#comments").attr("title");
$.get("../comments/commentsList?num="+num,function(data){
	console.log(data);
	$("#comments").html(data.trim());
});

$("#write").click*(function(){
	let name = $("#name").val();
	let contents = $("#contents").val();
	
	alert(name);
	alert(contents);
	
	$.post("../comments/commentsInsert", 
	{	name:name,
		contents:contents
	}, function(data){
		alert(data);
	});
});