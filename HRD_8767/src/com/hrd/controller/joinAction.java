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
@WebServlet("/joinAction")
public class joinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("컨트롤러 작동");//확인용
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 파라미터 받기
		int custno=Integer.parseInt(request.getParameter("custno"));
		String custname = (String)request.getParameter("custname");
		String phone = (String)request.getParameter("phone");
		String address = (String)request.getParameter("address");
		String joindate = (String)request.getParameter("joindate");
		String grade = (String)request.getParameter("grade");
		String city = (String)request.getParameter("city");
	    
		System.out.println(custno +"/"+custname);//확인용
		
		 // dao 에게 전달한 vo
	  	  MemberVO mvo = new MemberVO();
	  	  mvo.setCustno(custno);
	   	 mvo.setCustname(custname);
	   	 mvo.setCity(city);
	   	 mvo.setAddress(address);
	   	 mvo.setGrade(grade);
	   	 mvo.setJoindate(joindate);
	   	 mvo.setPhone(phone);
	   	 MemberDAO mdao = MemberDAO.getInstance();
		//System.out.println("db로 insert 시도");//확인용
	   	 mdao.insert(mvo);
		//System.out.println("db로 insert 완료");//확인용
	    	// 등록 후에는 목록 페이지로 이동
	   	 response.sendRedirect("listView"); //가입후 리스트로 돌아가기
	}
}
