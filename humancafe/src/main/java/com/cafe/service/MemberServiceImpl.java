package com.cafe.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.dao.IF_memberDAO;
import com.cafe.vo.MemberVO;

@Service
public class MemberServiceImpl implements IF_memberService {
	@Inject
	IF_memberDAO memberdao;

	@Override
	public void newJoin(MemberVO mvo) {
		// 컨트롤러가 요청하면 실행하는 서비스이다.
		if (mvo.getId().length() > 4) { // 예를 들자면 이렇게 조건을 달 수도 있다.
			memberdao.insert(mvo);
		}
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		return memberdao.selectOne(mvo);
	}
}
