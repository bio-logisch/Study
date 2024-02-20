package com.cafe.human;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cafe.service.IF_memberService;
import com.cafe.vo.MemberVO;
@Controller
public class MemberController {	
	@Inject
	IF_memberService memberservice;
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(Model model, @ModelAttribute MemberVO mvo) {	
		mvo.prt();
		memberservice.newJoin(mvo);
		return "redirect:/";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute MemberVO mvo, HttpSession session) {	
		//mvo.toString(); //자동으로 변수의 내용을 다 출력해준다.
		System.out.println(mvo.toString()); //자동으로 변수의 내용을 다 출력해준다.
		//DB조회
		//select * from member where id=? and pass=? 해킹의 대상이 된다.
		//위 쿼리는 sql injection공격에 취약해서 사용하지 않음. 아래 조건대로면 모든 튜플 출력됨
		//예) select * from member where id='11' and pass='11' or 1=1; 1=1은 늘 true임
		//다른 방법을 고민해보면, select * from member where id=? 로 해서 DB에서 vo만 가져오고
		//컨트롤러가 pass 일치여부를 판단한다.
		MemberVO returnmvo = memberservice.selectOne(mvo);
		if(returnmvo != null) {
			if(returnmvo.getPass().equals(mvo.getPass())) {
				//세션설정
				if(session.getAttribute("userid") != null) {
					session.removeAttribute("userid"); //초기화시킨다.
				}
				//home.jsp 맨 위로 가서 <%@ page session="true" %>로 변경(false로 되어있었음)
				session.setAttribute("userid", mvo.getId()); //세션처리로 처리하면 뷰에 전달하지 않아도 된다.
															//세션영역은 어플리케이션 전체이다.
				session.setAttribute("grade", 2);
			}else {
				System.out.println("패스워드 틀림");
			}
		}else {
			System.out.println("가입한 회원이 아님 - 아이디없음");
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {	
		session.invalidate(); //세션 날리기
		return "redirect:/";
	}
}
