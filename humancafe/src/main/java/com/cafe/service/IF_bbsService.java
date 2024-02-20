package com.cafe.service;

import java.util.List;

import com.cafe.vo.BBSVO;
import com.cafe.vo.PageVO;

public interface IF_bbsService {
	
	public void insertline(BBSVO bvo);
	public List<BBSVO> selectAll(PageVO pagevo);  
	public void deleteNum(String delno);
	//컨트롤러가 호출할 매서드를 정의합니다.. 그럼 컨트롤러가 왜 호출할까? 의도가 뭘까?
	// 컨트롤러가 매개변수를 주나? 컨트롤러는 리턴값을 필요로 하나?
	public BBSVO selectOne(String mno);
	public void update(BBSVO bvo);
	public BBSVO detailview(String vno);
	public int getTotalcnt();
	public List<String> getFileNames(String vno);
}
