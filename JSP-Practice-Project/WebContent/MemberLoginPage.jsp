<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인 페이지</h1>
	<form action="memberlogin.au" method="post">
		<table >
			<tr>
				<td>아이디</td>
				<td><input type="text" name="mUserId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="mPassword"></td>
			</tr>
		</table>
		<input type="submit" value="로그인">&nbsp;&nbsp;
		<input type="button" value="취소" onclick="window.location='list.co'">
	</form>
	
</body>
</html>