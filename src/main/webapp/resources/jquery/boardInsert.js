/**
 * 
 */

	
$("#btn").click(function(){
	alert("click");
	/*let name = $("#name").val() != "";
	let title = $("#title").val().length != 0;
	let contents = $("#contents").val().length != 0;
	
	alert(name);
	alert(title);
	alert(contents);*/
	
	//클래스명으로 사용하는것 
	$(".myCheck").each(function(s1,s2){ //s는 매개변수명
		console.log(s1);
		console.log($(s2).val());
		console.log($(this).val());
		if($(this).val()==""){
			result = false;
		}
	});
		
	//if(name && title && contents){
	if(result){
		$("#frm").submit();
	} else {
		alert("필수요소를 입력하세요");
	}
});
