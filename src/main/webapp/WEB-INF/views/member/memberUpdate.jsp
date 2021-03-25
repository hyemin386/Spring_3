<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Page</h1>
	
	<form action="./memberUpdate" method="post">
		Id: <input type="text" name="id" readonly="readonly" value="${member.id}"><br>
		Pw: <input type="password" name="pw" value="${member.pw}"><br>
		Name: <input type="text" name="name" value="${member.name}"><br>
		Phone: <input type="text" name="phone" value="${member.phone}"><br>
		Email: <input type="text" name="email" value="${member.email}"><br>
		<Button>Update</Button>	 
	</form>
</body>
</html>