<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h1>${board} Select Page</h1>
	<h3>Title: ${dto.title}</h3>
	<h3>Name: ${dto.name}</h3>
	<h3>Contents: ${dto.contents}</h3>
	
	<div>
	<c:forEach items="${dto.boardFiles}" var="file">
		<a href="../resources/upload/${board}/${file.fileName}">${file.origineName}</a>
	</c:forEach>
	</div>
	
	<!-- 댓글 리스트 -->
	<div id="comments" title="${dto.num}">
		
	</div>
	
	<div class="form-group">
  		<label for="usr">Name:</label>
  		<input type="text" class="form-control" id="name">
	</div>

	<div class="form-group">
  		<label for="comment">Comment:</label>
  		<textarea class="form-control" rows="5" id="comments"></textarea>
	</div>
	
	<button type="button" class="btn btn-success" id="write">Write</button>
	
	<a href="./${board}Update?num=${dto.num}" class="btn btn-danger">Update</a>
	<a href="#" id="del" class="btn btn-info">Delete</a>
	

	<c:if test="${board ne 'notice'}">
	<a href="./${board}Reply?num=${dto.num}" class="btn btn-primary">Reply</a>
	</c:if>
	
	<form action="./${board}Delete" id="frm" method="get">
		<input type="hidden" name="num" value="${dto.num}">
	</form>
</div>

<script type="text/javascript" src="../resources/jquery/comments.js"></script> 
<script type="text/javascript">
	/* delete의 버튼을 입력했을 때 이벤트가 실행 */
	const del = document.getElementById("del");
	const frm = document.getElementById("frm");
	
	del.addEventListener("click", function() {
	let result = confirm("Delete?");
		
		if(result){ //true라면 location 실행
			//get method 속성 변경
			frm.method="post"
			//form태그 강제실행(이벤트 강제실행)
			frm.submit();
			//location.href="./${board}Delete?num=${dto.num}"; //delete 클릭시 경로 이동(확인클릭시)
		}
	});
	
</script>
</body>
</html>