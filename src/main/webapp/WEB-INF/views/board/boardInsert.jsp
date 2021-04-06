<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h2>${board} Insert</h2>
		<form id="frm" action="./${board}Insert" method="post">
			<div class="form-group">
				<label for="name">NAME</label> 
				<input type="text" readonly="readonly" value="${member.id}" class="form-control myCheck" id="name" name="name" >
			</div>
			<div class="form-group">
				<label for="title">TITLE</label> 
				<input type="text" class="form-control myCheck" id="title" name="title">
			</div>
			<div class="form-group">
				<label for="contents">CONTENTS</label> 
				 <textarea class="form-control myCheck" rows="5" id="contents" name="contents"></textarea>
	
			</div>
		
<!-- <button type="submit" class="btn btn-primary" onclick="insertCheck()">Insert</button> -->
			
			<input type="button" id="btn" value="WRITE" class="btn btn-primary" >
		</form>
	</div>
<script type="text/javascript" src="../resources/jquery/boardInsert.js"></script>
</body>
</html>