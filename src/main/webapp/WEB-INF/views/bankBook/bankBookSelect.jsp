<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Select Page</h1>
	
	<h3>Name: ${dto.bookName}</h3>
	<h3>Number: ${dto.bookNumber}</h3>
	
	<c:if test="${not empty member}">
	<c:if test="${member.id eq 'admin'}">
	<a href="./bankBookDelete?bookNumber=${dto.bookNumber}">Delete</a>
	<a href="./bankBookUpdate?bookNumber=${dto.bookNumber}">Update</a>
	</c:if>
	</c:if>
	
	<!--  
	<c:if test="${member.id eq 'admin'}">
	<a href="./bankBookDelete?bookNumber=${dto.bookNumber}">Delete</a>
	<a href="./bankBookUpdate?bookNumber=${dto.bookNumber}">Update</a>
	-->
</body>
</html>