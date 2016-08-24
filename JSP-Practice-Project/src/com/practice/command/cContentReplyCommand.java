package com.practice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dao.ContentsDAO;

public class cContentReplyCommand implements ContentsCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cTitle = request.getParameter("cTitle");
		String cName = request.getParameter("cName");
		String cContent = request.getParameter("cContent");
		String cGroup = request.getParameter("cGroup");
		String cStep = request.getParameter("cStep");
		String cIndent = request.getParameter("cIndent");
		
		ContentsDAO dao = new ContentsDAO();
		dao.contentReply(cTitle, cName, cContent, cGroup, cStep, cIndent);

	}

}
