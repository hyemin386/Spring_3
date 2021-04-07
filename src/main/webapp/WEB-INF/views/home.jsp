<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<c:import url="./template/bootStrap.jsp"></c:import>
<link rel="styleshhet" href="./resources/css/test.css">

<title>Home!</title>
<style type="text/css">
	#d1{
		width: 200px;
		height: 200px;
		background-color: red;
		overflow: hidden;
	}
	
	#d2{
		width: 50px;
		height: 50px;
		background-color: yellow;
		margin: 75px auto;
	}
</style>
</head>
<body>
	<!-- 내부주소 작성 -->
	<c:import url="./template/header.jsp"></c:import>

	<button class="b">BUTTON</button>
	<button id="btn" class="b">CLICK</button>
	<button id="btn2" class="b">CLICK2</button>
	<h1 id="t">version 3</h1>
	<div id="result"></div>
	
	<select id="mon">
		
	</select>
	
	<div id="d1">
		<div id="d2"></div>
	</div>
	
	<script type="text/javascript">
		/* let btn2 = document.getElementById("btn2");
	
		btn2.addEventListener("click", function(){
			alert("btn2");
		});
		
		//jquery
		$("#btn").click(function(){
			alert("jquery");
		});	 
		
		$(".b").click(function(){
			alert(this);
		});*/
		$("#btn2").click(function(){
			$("#result").append('<a href="#">Go</a>');
		});
		
		$("#btn").click(function(){
			for(let i=1;i<13;i++){
				$("#mon").append("<option>"+i+"</option>");
			}
		});
		
		$("#d1").click(function(){
			console.log("parent");
		});
		
		$("#d2").click(function(){
			console.log("child");
		});
	</script>
</body>
</html>
