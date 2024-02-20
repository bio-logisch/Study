package com.cafe.service;

import com.cafe.vo.MemberVO;

public interface IF_memberService {
	
	// 서비스단
	// 요청은 순서는 클라이언트 요청(url, method, parameters)
	// apache tomcat
	// spring controller > service > dao > mybatis > Database(oracle)
	
	public void newJoin(MemberVO mvo); // 컨트롤러에게 제공하는 서비스 정의가 됨
	                                  // 서비스 구현은 별도의 클래스에서 구현 받아 
	                                 // 메서드를 재정의한다.. 
	public MemberVO selectOne(MemberVO mvo);
}
