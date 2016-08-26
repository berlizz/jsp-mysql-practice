<%@page import="com.practice.dao.MembersDAO"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
		String mUserId = request.getParameter("mUserId");
		String mPassword = request.getParameter("mPassword");
		
		MembersDAO dao = new MembersDAO();
		if(dao.memberLogin(mUserId, mPassword)) {
			session.setAttribute("login", mUserId);
			response.sendRedirect("list.co");
		} else {
	%>
		<script>
			alert('아이디 혹은 비밀번호가 일치하지 않습니다');
			history.go(-1);
		</script>
	<%
		}
	%>
    
