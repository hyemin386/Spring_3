<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
	</div>
	
	<h4>No: ${dto.num}</h4>
	<h4>Title: ${dto.title}</h4>
</body>
</html>