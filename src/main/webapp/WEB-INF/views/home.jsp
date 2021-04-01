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

</head>
<body>
	<!-- 내부주소 작성 -->
	<c:import url="./template/header.jsp"></c:import>

	<button onclick="go()">BUTTON</button>
	<button id="btn">CLICK</button>
	<button id="btn">CLICK2</button>
	
	<script type="text/javascript">
	let btn = document.getElementById("btn");
	let btn2 = document.getElementById("btn2");
	
	btn2.addEventListener("click", function()){
		alert("btn2");
		go();
	}
	
	btn.onclick = go;
		
	function go() {
		alert("hello");
		go();
	}
	
	/*btn.onclick = function() {
		go();
	}*/
	
	</script>
</body>
</html>
