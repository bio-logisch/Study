package com.hrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.DAO.MemberDAO;
import com.hrd.VO.MemberVO;

/**
 * Servlet implementation class JoinForm
 */
@WebServlet("/modForm")
public class modForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modForm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		// Model작업..
		MemberDAO mdao = MemberDAO.getInstance(); //싱글톤으로 작성(의무는 아님)
		int custno = Integer.valueOf(request.getParameter("custno"));
		MemberVO mvo = mdao.selectOne(custno);
		System.out.println("조회 회원번호1 : "+custno);
		request.setAttribute("mvo", mvo);
		System.out.println("조회 회원이름 : "+mvo.getCustname());
		String url ="modify.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
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
