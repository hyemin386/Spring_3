<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootStrap.jsp"></c:import>
<meta charset="UTF-8">
<title>Notice Select</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h3>Notice Select Page</h3>


		<table class="table">
			<thead class="thead-dark">
				<tr>
					<td>TITLE</td>
					<td>NAME</td>
					<td>DATE</td>
					<td>HIT</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${dto.title}</td>
					<td>${dto.name}</td>
					<td>${dto.regdate}</td>
					<td>${dto.hit}</td>
				</tr>
			</tbody>
		</table>

		<div class="container">
			<h1>Contents: ${dto.contents}</h1>
		</div>
		
		<c:catch>
			<c:if test="${member.id eq 'admin'}">
				<a href="./noticeUpdate?num=${dto.num}">수정</a>
				<a href="./noticeDelete?num=${dto.num}">삭제</a>
			</c:if>
		</c:catch>
	</div>
</body>
</html>