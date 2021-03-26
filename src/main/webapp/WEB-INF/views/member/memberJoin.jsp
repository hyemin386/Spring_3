<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootStrap.jsp"></c:import>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	
	
	<div class="container">
	<h2>Member Join Page</h2>
		<form action="./memberJoin" method="post">
			<div class="form-group">
				<label for="id">ID</label> 
				<input type="text" class="form-control" id="id" name="id" aria-describedby="idHelp"> 
			</div>
			<div class="form-group">
				<label for="pw">Password</label> 
				<input type="password" class="form-control" id="pw" name="pw">
			</div>
			<div class="form-group">
				<label for="name">Name</label> 
				<input type="text" class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="phone">Phone</label> 
				<input type="text" class="form-control" id="phone" name="phone">
			</div>
			<div class="form-group">
				<label for="email">Email</label> 
				<input type="text" class="form-control" id="email" name="email">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>