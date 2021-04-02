<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootStrap.jsp"></c:import>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.r1{
		color: red;  /* 6글자 이상이면 빨간색 */
	}
	
	.r2 {
		color:blue;  /* 6글자 미만이면 파랑색 */
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<div class="container">
	<h2>Member Join Page</h2>
		<form id="frm" action="./memberJoin" method="post">
			<div class="form-group">
				<label for="id">ID</label> 
				<input type="text" class="form-control" id="id" name="id" aria-describedby="idHelp"> 
				<h4 id="idResult"></h4>
			</div>
			<div class="form-group">
				<label for="pw">Password</label> 
				<input type="password" class="form-control" id="pw" name="pw">
				<h4 id="pwResult"></h4>
			</div>
			<div class="form-group">
				<label for="pw">Password</label> 
				<input type="password" class="form-control" id="pw2" name="pw">
			</div>
			<div class="form-group">
				<label for="name">Name</label> 
				<input type="text" class="form-control etc" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="phone">Phone</label> 
				<input type="text" class="form-control etc" id="phone" name="phone">
			</div>
			<div class="form-group">
				<label for="email">Email</label> 
				<input type="text" class="form-control etc" id="email" name="email">
			</div>
		<input type="submit" id ="btn" value="JOIN" class="btn btn-primary">
		</form>
	</div>
<!--  <script type="text/javascript" src="../resources/js/memberJoin.js"></script>	-->
</body>
</html>