<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>�� ����</h1>
	
	<form action="contentmodify.co" method="post">
		<table width="1500">
			<input type="hidden" name="cId" value="${dto.cId}">
			<tr>
				<td>����</td>
				<td><input type="text" name="cTitle" value="${dto.cTitle}"></td>
			</tr>
			<tr>
				<td>�ۼ���</td>
				<td>${dto.cName}</td>
			</tr>
			<tr>
				<td>����</td>
				<td><textarea name="cContent">${dto.cContent}</textarea></td>
			</tr>
		</table>
		<input type="submit" value="�Ϸ�">
	</form>
	

</body>
</html>