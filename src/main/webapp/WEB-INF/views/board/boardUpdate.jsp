<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
	#sample {
		display: none;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h2>${board} Update form</h2>
		<form id="frm" action="./${board}Update" method="post" enctype="multipart/form-data">
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
		
		<c:forEach items="${dto.boardFiles}" var="file">
			<div>
				<span>${file.origineName}</span><span class="fileDelete" title="${file.fileNum}">X</span>
			</div>
		</c:forEach>
		
		<input type="button" id="add" value="ADD" class="btn btn-danger">
		<div id="files" title="${dto.boardFiles.size()}"></div>
			
	    <input type="submit" id="btn" value="UPDATE" class="btn btn-primary" >
					
		<div id="sample">
		<div class="input-group">
			<div class="custom-file">
				<input type="file"  id="inputGroupFile04"
					class="form-control-file border" name="files">
			</div>
			<div class="input-group-append delete">
				<input class="btn btn-outline-secondary" type="button"
					id="inputGroupFileAddon04" value="Delete">
			</div>
		</div>
	</div>
	
<!-- <button type="submit" class="btn btn-primary" onclick="insertCheck()">Insert</button> -->			
		</form>
	</div>
<script type="text/javascript" src="../resources/jquery/boardUpdate.js"></script>
<script type="text/javascript" src="../resources/jquery/fileAdd.js"></script>
</body>
</html>