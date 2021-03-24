<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Update Page</h1>
	
	<form action="./bankBookUpdate" method="POST">
	    <!-- input type = "hidden" 으로도 숨기기 가능-->
		<!-- Number <input type="text" readonly="readonly" name="bookNumber" value="${dto.bookNumber}"><br>  -->
		<input type="hidden"  name="bookNumber" value="${dto.bookNumber}"><br>
		Name <input type="text" name="bookName" value="${dto.bookName}"><br>
		Rate <input type="text" name="bookRate" value="${dto.bookRate}"><br>
		Sale <input type="text" name="bookSale" value="${dto.bookSale}"><br>
		<button>Update</button>
	</form>
</body>
</html>