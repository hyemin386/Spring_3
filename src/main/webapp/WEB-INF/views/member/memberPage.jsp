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
	<h3>MyPage</h3>
	
	<h3> ${member.id}님 환영합니다!</h3>
	<h3> Name: ${member.name}</h3>
	<h3> Email: ${member.email}</h3>
	<h3> Phone: ${member.phone}</h3>
	
	<a href="./memberUpdate">수정</a>
	<a href="./memberDelete">탈퇴</a>
	<a href="./">계좌관리</a>
</body>
</html>