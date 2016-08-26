package com.practice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dao.MembersDAO;

public class MemberSignupCommand implements MembersCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mUserId = request.getParameter("mUserId");
		String mPassword = request.getParameter("mPassword");
		String mDisplayName = request.getParameter("mDisplayName");
		MembersDAO dao = new MembersDAO();
		dao.memberSignup(mUserId, mPassword, mDisplayName);

	}

}
