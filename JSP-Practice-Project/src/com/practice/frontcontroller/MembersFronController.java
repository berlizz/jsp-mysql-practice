package com.practice.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.command.MemberLoginCommand;
import com.practice.command.MemberSignupCommand;
import com.practice.command.MembersCommand;

/**
 * Servlet implementation class MembersFronController
 */
@WebServlet("*.au")
public class MembersFronController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembersFronController() {
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
		String path = request.getServletPath();
		String viewPage = null;
		MembersCommand membersCommand = null;

		
		if(path.equals("/login.au")) {
			viewPage = "MemberLoginPage.jsp";
		} else if(path.equals("/memberlogin.au")) {
			membersCommand = new MemberLoginCommand();
			membersCommand.execute(request, response);
			viewPage = "list.co";
		} else if(path.equals("/logout.au")) {
			viewPage = "Logout.jsp";
		} else if(path.equals("/signup.au")) {
			viewPage = "SignUpPage.jsp";
		} else if(path.equals("/membersignup.au")) {
			membersCommand = new MemberSignupCommand();
			membersCommand.execute(request, response);
			viewPage = "list.co";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}






