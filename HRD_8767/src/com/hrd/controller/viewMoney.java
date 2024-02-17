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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//2. 파라미터 받을 필요없다. 그러나 페이지기능이 있다면 몇번 페이지를 요청했는지 받아야 한다.
		//3. 모델    쿼리 > 리턴받을 값 (DTO단일 객체이거나 여러개일 경우는 List많이 사용)
		
		MemberDAO mdao = MemberDAO.getInstance(); // 문제가 있냐면 계속 객체를 만들어요..>싱글톤(객체는 한개만 만들고 공유)
		ArrayList<ViewMoneyVO> listMember = new ArrayList<>();
		listMember = mdao.selectTotalAll();
		
		// 디버깅하시오
		System.out.println(listMember.size()+" 건 가져옴-매출내용 [디버깅]");
		
		// 4. 뷰지정
		// view지정..
		String url = "viewMoney.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		request.setAttribute("totalList", listMember);  // 타입.. 리스트 타입.. 
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
