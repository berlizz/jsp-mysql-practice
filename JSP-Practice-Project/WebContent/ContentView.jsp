<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�Խ��� �� �б�</h1>
	
	<table width="1500">
		<tr>
			<td>��ȣ</td>
			<td>${dto.cId}</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${dto.cTitle}</td>
		</tr>
		<tr>
			<td>��ȸ��</td>
			<td>${dto.cHit}</td>
		</tr>
		<tr>
			<td>�ۼ���</td>
			<td>${dto.cName}</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${dto.cContent}</td>
		</tr>
	</table>
	<input type="button" value="���" onclick="window.location='contentreplypage.co?cId=${dto.cId}'">&nbsp;&nbsp;
	<input type="button" value="����" onclick="window.location='contentedit.co?cId=${dto.cId}'">&nbsp;&nbsp;
	<input type="button" value="����" onclick="window.location='contentdelete.co?cId=${dto.cId}'">
	<jsp:include page="list.jsp" />

</body>
</html>