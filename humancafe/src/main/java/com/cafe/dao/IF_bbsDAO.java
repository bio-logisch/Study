package com.cafe.dao;

import java.util.List;

import com.cafe.vo.BBSVO;
import com.cafe.vo.PageVO;

public interface IF_bbsDAO {
	//작업을 정의
	public void insert(BBSVO bbsvo);   //추상클래스
	public List<BBSVO> selectAll(PageVO pagevo);
	public void delno(String dno);
	public BBSVO selectOne(String mno);
	public void update(BBSVO bvo);
	public void updateCnt(String vno);
	public int getTotalcnt();
	public int savefilenames(String fname);
	public List<String> getFileNames(String vno);
}
