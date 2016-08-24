<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 글 읽기</h1>
	
	<table width="1500">
		<tr>
			<td>번호</td>
			<td>${dto.cId}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${dto.cTitle}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${dto.cHit}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${dto.cName}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${dto.cContent}</td>
		</tr>
	</table>
	<input type="button" value="답글" onclick="window.location='contentreplypage.co?cId=${dto.cId}'">&nbsp;&nbsp;
	<input type="button" value="수정" onclick="window.location='contentedit.co?cId=${dto.cId}'">&nbsp;&nbsp;
	<input type="button" value="삭제" onclick="window.location='contentdelete.co?cId=${dto.cId}'">
	<jsp:include page="list.jsp" />

</body>
</html>