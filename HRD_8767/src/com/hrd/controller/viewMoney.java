package com.hrd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.DAO.MemberDAO;
import com.hrd.VO.ViewMoneyVO;

/**
 * Servlet implementation class viewMoney
 */
@WebServlet("/viewMoney")
public class viewMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewMoney() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");	
		MemberDAO mdao = MemberDAO.getInstance(); // 싱글톤
		ArrayList<ViewMoneyVO> listMember = new ArrayList<>();
		listMember = mdao.selectTotalAll();
		System.out.println(listMember.size()+" 건 가져옴-매출내용 [디버깅]");
		// 뷰지정
		String url = "viewMoney.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		request.setAttribute("totalList", listMember); 
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
