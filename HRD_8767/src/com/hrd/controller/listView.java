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
import com.hrd.VO.MemberVO;

/**
 * Servlet implementation class listView
 */
@WebServlet("/listView")
public class listView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listView() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 한글설정 2. 파라미터 받기 3. 모델작업 4. 뷰지정(전달할 데이터가 있는지? )
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");//코드 39,40은 한글깨질 때 작성
		MemberDAO mdao = MemberDAO.getInstance(); //싱글톤(객체는 한개만 만들고 공유)
		ArrayList<MemberVO> listMember = new ArrayList<>();
		listMember = mdao.selectAll();
		
		System.out.println(listMember.size()+" 건 가져옴 [디버깅]");
		
		//뷰지정
		String url = "list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		request.setAttribute("memberList", listMember);  // 타입.. 리스트 타입.. 
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
