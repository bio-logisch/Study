package com.cafe.human;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cafe.service.IF_memberService;
import com.cafe.vo.MemberVO;

@RestController //controller + responsebody
public class LoginChk {
	@Inject
	IF_memberService memberservice;
	
	@RequestMapping(value = "idchk" , method = RequestMethod.POST)
	public int idchk(@RequestBody Map<String, Object> a) {
		System.out.println((String)a.get("userid"));
		System.out.println((String)a.get("test"));
		String uid = (String)a.get("userid");
		MemberVO mvo = new MemberVO();
		mvo.setId(uid);
		MemberVO rmvo = memberservice.selectOne(mvo);
		//mvo가 null인지 아닌지 출력하기
		if(rmvo == null) {
			return 1;
		}else {
			return 0;   // forwarding 방식
		}
	} 
}

