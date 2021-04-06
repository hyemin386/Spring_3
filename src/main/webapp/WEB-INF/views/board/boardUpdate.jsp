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
	<h2>${board} Update form</h2>
		<form id="frm" action="./${board}Update" method="post">
		<input type="hidden" name="num" value="${dto.num}"> <!-- value="${param.nu}" 으로도 사용가능 -->
			<div class="form-group">
				<label for="name">NAME</label> 
				<input type="text" readonly="readonly" value="${dto.name}" class="form-control" id="name" name="name" >
			</div>
			<div class="form-group">
				<label for="title">TITLE</label> 
				<input type="text" class="form-control" id="title" name="title" value="${dto.title}">
			</div>
			<div class="form-group">
				<label for="contents">CONTENTS</label> 
				 <textarea class="form-control" rows="5" id="contents" name="contents">${dto.contents}</textarea>
			</div>
		
			<!-- <button type="submit" class="btn btn-primary" onclick="insertCheck()">Insert</button> -->
			
			<input type="submit" id="btn" value="UPDATE" class="btn btn-primary" >
		</form>
	</div>
<!-- <script type="text/javascript" src="../resources/js/noticeInsert.js"></script>	 -->
</body>
</html>