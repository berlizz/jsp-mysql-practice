<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>��� ����</h1>
	
	<form action="contentreply.co" method="post">
		<table widh="1500">
			<input type="hidden" name="cGroup" value="${dto.cGroup}">
			<input type="hidden" name="cStep" value="${dto.cStep}">
			<input type="hidden" name="cIndent" value="${dto.cIndent}">
			<tr>
				<td>����</td>
				<td><input type="text" name="cTitle"></td>
			</tr>
			<tr>
				<td>�ۼ���</td>
				<td><input type="text" name="cName"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><textarea name="cContent"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="���">
	</form>
</body>
</html>