package com.practice.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dao.ContentsDAO;
import com.practice.dto.ContentsDTO;

public class cListCommand implements ContentsCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ContentsDAO dao = new ContentsDAO();
		ArrayList<ContentsDTO> list = dao.list();
		request.setAttribute("list", list);
		
	}

}
