package com.hk03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontCon
 */
@WebServlet("*.do")
public class FrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException  , IOException{
		System.out.println("action.Do");
		String viewPage = null;
		Service serv = null;
		
		String uri = request.getRequestURI();
		System.out.println("uri"+ uri);
		String conPath = request.getContextPath();
		System.out.println("conpath"+ conPath);
		String com = uri.substring(conPath.length());
		System.out.println("com"+com);
		if(com.equals("/loginok.do")) {
			viewPage = "loginOk.jsp";
		}else if(com.equals("/joinok.do")){
			viewPage = "joinOk.jsp";
		}else if(com.equals("/logout.do")) {
			viewPage = "logout.jsp";
		}else if(com.equals("/modifyok.do")) {
			viewPage = "modifyOk.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		dis.forward(request, response);
		
	}
}
