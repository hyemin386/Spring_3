<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1>${board} List</h1>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<td>NO</td>
					<td>TITLE</td>
					<td>NAME</td>
					<td>DATE</td>
					<td>HIT</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td><a href="./${board}Select?num=${dto.num}">
						
						<c:if test="${board eq 'qna'}">
						<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
						</c:if>
						${dto.title}
						</a></td>
						<td>${dto.name}</td>
						<td>${dto.regDate}</td>
						<td>${dto.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="container">
		<ul class="pagination">
			 <c:if test="${pager.pre}">	
    <li class="page-item"><a class="page-link p" href="#" title="${pager.startNum-1}">Previous</a></li>
   </c:if>
   
   <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
   
    <li class="page-item"><a class="page-link p" href="#" title="${i}">${i}</a></li>
   </c:forEach>
   
    <c:if test="${pager.next}">
    <li class="page-item"><a class="page-link p" href="#" title="${pager.lastNum+1}">Next</a></li>
    </c:if>
  </ul>

		<div class="input-group mt-3 mb-3">
			<form id="frm" action="${board}List" class="form-inline">
			<input type="hidden" name="curPage" value="1" id="curPage">
				<div class="input-group-prepend">
					<select class="form-control" name ="kind" id="kind"> <!-- select에는 value 속성이없음 -->
						<option class="sel">Title</option>
						<option class="sel">Contents</option>
						<option class="sel">Name</option>
					</select>
				</div>
				<input type="text" class="form-control" name="search" placeholder="Search" id="search" value="${pager.search}">
				<div class="input-group-append">
					<button class="btn btn-success" type="submit">Search</button>
				</div>
			</form>
		</div> 
				<c:catch>
			<c:if test="${member.id eq 'admin'}">
			</c:if>
		</c:catch>
		<a href="./${board}Insert" class="btn btn-primary" role="button">Write</a>
	</div> 
		
	<script type="text/javascript">
		//form으로 사용
		let kind = '${pager.kind}';
		$(".sel").each(function(){
		let t = $(this).text();
			if(t==kind){
				$(this).prop("selected", true);
			}
		});
			
		$(".p").click(function(){
			let curPage = $(this).attr("title");
			$("#curPage").val(curPage);
			let search = '${pager.search}';		
			$("#frm").submit();
			
		/* 	$("#curPage").val(curPage);
			$("#kind").val(kind);
			$("#search").val(search);
			$("#frm").submit(); */
			//location.href="./${board}List?curPage="+curPage+"&kind=${pager.kind}&search=${pager.search}"
		});
	</script>
</body>
</html>