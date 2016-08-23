package com.practice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dao.ContentsDAO;

public class cContentWriteCommand implements ContentsCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cTitle = request.getParameter("title");
		String cName = request.getParameter("name");
		String cContent = request.getParameter("content");
		ContentsDAO dao = new ContentsDAO();
		dao.contentWrite(cTitle, cName, cContent);
		
		// cTitle, cName, cContent 에 null 값이 들어옴 수정해야함

	}

}
