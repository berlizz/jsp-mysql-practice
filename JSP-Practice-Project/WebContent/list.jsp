<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 리스트</h1>
	<table width="1500">
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>조회수</td>
			<td>작성일</td>
		</tr>
		<c:forEach items="${list}" var="content">
			<tr>
				<td>${content.cId}</td>
				<td>${content.cName}</td>
				<td><a href="contentview.co?cId=${content.cId}">
					<c:forEach begin="1" end="${content.cIndent}">-</c:forEach>
					${content.cTitle}</a></td>
				<td>${content.cHit}</td>
				<td>${content.cDate}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" value="글쓰기" onclick="window.location='write.co'">
	<a href="list.co">list.co</a>

</body>
</html>