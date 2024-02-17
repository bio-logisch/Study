package com.hrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.DAO.MemberDAO;

/**
 * Servlet implementation class JoinForm
 */
@WebServlet("/JoinForm")
public class JoinForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinForm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			
		// Model작업..
		MemberDAO mdao = MemberDAO.getInstance(); //싱글톤으로 작성(의무는 아님)
		int nowcnt = mdao.nowCnt();
		
		// view 전달.
		request.setAttribute("nownumber", nowcnt); //("변수명", 값)		
	
		// view지정..
		String url ="join.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		//request.setAttribute("TeamName", "Human");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
