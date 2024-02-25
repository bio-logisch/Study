package com.hrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.DAO.MemberDAO;
import com.hrd.VO.MemberVO;

/**
 * Servlet implementation class joinAction
 */
@WebServlet("/modAction")
public class modAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 파라미터 받기
		//String custno = (String)request.getParameter("name");  *디비쿼리에서 생성하여 생략
		int custno=Integer.parseInt(request.getParameter("custno"));
		String custname = (String)request.getParameter("custname");
		String phone = (String)request.getParameter("phone");
		String address = (String)request.getParameter("address");
		String joindate = (String)request.getParameter("joindate");
		String grade = (String)request.getParameter("grade");
		String city = (String)request.getParameter("city");
		
		System.out.println(custname +"/"+phone);//확인용
		
		// dao 에게 전달한 vo
		// 번호자동 생성 이라는 기능을 구현한다면 자동생성된 번호도 추가 해야 함
		MemberVO mvo = new MemberVO();
		mvo.setCustno(custno);
		mvo.setCustname(custname);
		mvo.setCity(city);
		mvo.setAddress(address);
		mvo.setGrade(grade);
		mvo.setJoindate(joindate);
		mvo.setPhone(phone);
		
		MemberDAO mdao = MemberDAO.getInstance();
		mdao.update(mvo);
	    response.sendRedirect("listView"); //수정후 리스트로 돌아가기
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
