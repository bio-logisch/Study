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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// 1. 한글설정 2. 파라미터 받기 3. 모델작업 4. 뷰지정(전달할 데이터가 있는지? )

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");//코드 39,40은 한글깨질 때 작성
		
		//2. 파라미터 받을 필요없다. 그러나 페이지기능이 있다면 몇번 페이지를 요청했는지 받아야 한다.
		//3. 모델    쿼리 > 리턴받을 값 (DTO단일 객체이거나 여러개일 경우는 List많이 사용)
		//   쿼리 : select * from MEMBER_TBL_02;
		//        이 쿼리는 여러개의 튜플을 반환하다. 그래서 단일 객체보다는 List가 적당하다.
		MemberDAO mdao = MemberDAO.getInstance(); //싱글톤(객체는 한개만 만들고 공유)
		ArrayList<MemberVO> listMember = new ArrayList<>();
		listMember = mdao.selectAll();
		
		// 디버깅
		System.out.println(listMember.size()+" 건 가져옴 [디버깅]");
		
		// 4. 뷰지정
		// view지정..
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
