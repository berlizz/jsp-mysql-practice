package com.practice.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.command.ContentsCommand;
import com.practice.command.cContentViewCommand;
import com.practice.command.cContentWriteCommand;
import com.practice.command.cListCommand;

/**
 * Servlet implementation class ContentsFrontController
 */
@WebServlet("*.co")
public class ContentsFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentsFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		ContentsCommand contentsCommand = null;
		String viewPage = null;
		
		String path = request.getServletPath();
		
		if(path.equals("/list.co")) {
			contentsCommand = new cListCommand();
			contentsCommand.execute(request, response);
			viewPage = "list.jsp";
		} else if(path.equals("/contentview.co")) {
			contentsCommand = new cContentViewCommand();
			contentsCommand.execute(request, response);
			viewPage = "ContentView.jsp";
		} else if(path.equals("/write.co")) {
			viewPage = "ContentWrite.jsp";
		} else if(path.equals("/contentwrite.co")) {
			contentsCommand = new cContentWriteCommand();
			contentsCommand.execute(request, response);
			viewPage = "list.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}






