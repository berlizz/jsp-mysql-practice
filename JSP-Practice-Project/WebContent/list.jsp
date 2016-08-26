<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<h1>게시판 리스트</h1>
			<%
				if(session.getAttribute("login") == null) {
			%>
					<h2>welcome</h2>
			<%
				} else {
			%>
					<h2>hello <%=session.getAttribute("login") %></h2>
			<%
				}
			%>
			<table width="1500" class="table table-hover">
				<tr class="info">
					<th class="text-center">번호</th>
					<th class="text-center">작성자</th>
					<th class="text-center">제목</th>
					<th class="text-center">조회수</th>
					<th class="text-center">작성일</th>
				</tr>
				<c:forEach items="${list}" var="content">
					<tr>
						<td class="text-center">${content.cId}</td>
						<td class="text-center">${content.cName}</td>
						<td><a href="contentview.co?cId=${content.cId}">
							<c:forEach begin="1" end="${content.cIndent}">-</c:forEach>
							${content.cTitle}</a></td>
						<td class="text-center">${content.cHit}</td>
						<td class="text-center">${content.cDate}</td>
					</tr>
				</c:forEach>
			</table>
			<input type="button" class="btn btn-primary" value="글쓰기" onclick="window.location='write.co'">&nbsp;&nbsp;
			<%
				if(session.getAttribute("login") == null) {
			%>
					<input type="button" class="btn btn-primary" value="로그인" onclick="window.location='login.au'">&nbsp;&nbsp;
					<input type="button" class="btn btn-primary" value="회원가입" onclick="window.location='signup.au'">
			<%
				} else {
			%>
					<input type="button" class="btn btn-primary" value="로그아웃" onclick="window.location='logout.au'">
			<%
				}
			%>
			<a href="list.co">list.co</a>
		</div>
		<div class="col-md-2"></div>
	</div>

</body>
</html>