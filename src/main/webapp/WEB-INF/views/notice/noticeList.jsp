<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Notice List</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h1>Notice List</h1>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<td>NO</td>
				<td>TITLE</td>
				<td>NAME</td>
				<td>CONTENT</td>
				<td>DATE</td>
				<td>HIT</td>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><a href="./noticeSelect?num=${dto.num}">${dto.num}</a></td>
					<td>${dto.title}</td>
					<td>${dto.name}</td>
					<td>${dto.contents}</td>
					<td>${dto.regdate}</td>
					<td>${dto.hit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
</body>
</html>