<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>게시판 글쓰기</h1>
	<form action="contentwrite.co" method="post">
		<table width="1500">
			<tr>
				<td>제목</td>
				<td><input type="text" id="title"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" id="name"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea id="content"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="완료">
	</form>

</body>
</html>