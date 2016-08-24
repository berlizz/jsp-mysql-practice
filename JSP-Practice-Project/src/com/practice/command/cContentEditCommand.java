package com.practice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dao.ContentsDAO;
import com.practice.dto.ContentsDTO;

public class cContentEditCommand implements ContentsCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cId = request.getParameter("cId");
		ContentsDAO dao = new ContentsDAO();
		ContentsDTO dto = dao.contentEdit(cId);
		request.setAttribute("dto", dto);

	}

}
