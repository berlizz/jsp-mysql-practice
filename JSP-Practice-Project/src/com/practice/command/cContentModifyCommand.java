package com.practice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dao.ContentsDAO;

public class cContentModifyCommand implements ContentsCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cId = request.getParameter("cId");
		String cTitle = request.getParameter("cTitle");
		String cContent = request.getParameter("cContent");
		ContentsDAO dao = new ContentsDAO();
		dao.contentModify(cId, cTitle, cContent);

	}

}
