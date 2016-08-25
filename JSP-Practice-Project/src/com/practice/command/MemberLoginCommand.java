package com.practice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dao.MembersDAO;

public class MemberLoginCommand implements MembersCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mUserId = request.getParameter("mUserId");
		String mPassword = request.getParameter("mPassword");
		MembersDAO dao = new MembersDAO();
		dao.memberLogin(mUserId, mPassword);
		
	}
}
