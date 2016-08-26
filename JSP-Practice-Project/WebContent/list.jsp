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
			<h1>�Խ��� ����Ʈ</h1>
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
					<th class="text-center">��ȣ</th>
					<th class="text-center">�ۼ���</th>
					<th class="text-center">����</th>
					<th class="text-center">��ȸ��</th>
					<th class="text-center">�ۼ���</th>
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
			<input type="button" class="btn btn-primary" value="�۾���" onclick="window.location='write.co'">&nbsp;&nbsp;
			<%
				if(session.getAttribute("login") == null) {
			%>
					<input type="button" class="btn btn-primary" value="�α���" onclick="window.location='login.au'">&nbsp;&nbsp;
					<input type="button" class="btn btn-primary" value="ȸ������" onclick="window.location='signup.au'">
			<%
				} else {
			%>
					<input type="button" class="btn btn-primary" value="�α׾ƿ�" onclick="window.location='logout.au'">
			<%
				}
			%>
			<a href="list.co">list.co</a>
		</div>
		<div class="col-md-2"></div>
	</div>

</body>
</html>