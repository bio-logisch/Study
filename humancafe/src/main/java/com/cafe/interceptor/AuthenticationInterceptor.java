package com.cafe.interceptor;
//클라이언트 요청 시 인터셉터 지나갈 때 - 인터셉터에서 잡은 URL 주소에 대한 처리 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//preHandle이라는 의미는 미리 인터셉터에서 url패턴을 분석하여 잡는다는 의미(통과여부 결정한다).
		//현재 기준으로는 상품문의 클릭하면 인터셉터가 잡았다고 표시하지만 일단 문의글리스트 화면으로 넘어간다.
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("userid"); //쿠키값을 가지고 있어서 해당되는 세션에서 자기 정보값 비교
		if(obj == null) { //로그인이 안된 사람이면
			response.sendRedirect(request.getContextPath()+"/");
			return false; //게시판으로 넘어가지 않는다. home에 계속 남아있음. 인터셉터가 잡고 있기 때문.
			//게시판 보이게는 하고 리스트상태에서 수정삭제 불가하도록 하려면 servlet-context.xml에 예외로 bbsview를 둔다.
			//로그인 안한 상태에서 게시판 목록보기 들어간 뒤 수정/삭제 버튼 누르면 home으로 돌아온다.
		}
		return super.preHandle(request, response, handler); //통과 의미(원래 URL로 가라는 의미)
	}

}
