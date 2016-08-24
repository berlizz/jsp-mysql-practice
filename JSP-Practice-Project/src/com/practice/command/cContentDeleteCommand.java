package com.practice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dao.ContentsDAO;

public class cContentDeleteCommand implements ContentsCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cId = request.getParameter("cId");
		ContentsDAO dao = new ContentsDAO();
		dao.contentDelete(cId);

	}

}
