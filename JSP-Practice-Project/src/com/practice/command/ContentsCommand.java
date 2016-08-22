package com.practice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ContentsCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response);
	
}
