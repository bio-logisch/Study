package com.cafe.dao;

import com.cafe.vo.MemberVO;

public interface IF_memberDAO {
	public void insert(MemberVO mvo);
	public MemberVO selectOne(MemberVO mvo);
}
