<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<script src="SignUpCheck.js"></script>

<title>Insert title here</title>
</head>
<body>

	<h1>ȸ������ ������</h1>
	<form action="membersignup.au" method="post" name="signupForm">
		<table>
			<tr>
				<td>���̵�</td>
				<td><input type="text" name="mUserId"></td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type="password" name="mPassword"></td>
			</tr>
			<tr>
				<td>��й�ȣ Ȯ��</td>
				<td><input type="password" name="mPasswordCheck"></td>
			</tr>
			<tr>
				<td>�г���</td>
				<td><input type="password" name="mDisplayName"></td>
			</tr>
		</table>
		<input type="button" value="�Ϸ�" onclick="passwordCheck()">
		<input type="button" value="���" onclick="window.location='list.co'">
	</form>

</body>
</html>