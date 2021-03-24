<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rate</th>
				<th>Sale</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.bookName}</td>
				<td>${dto.bookRate}</td>
				<td>${dto.bookSale}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
</body>
</html>