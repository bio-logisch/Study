package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.dao.IF_bbsDAO;
import com.cafe.vo.BBSVO;
import com.cafe.vo.PageVO;
@Service
public class BBSServiceImpl implements IF_bbsService{
	@Inject  //객체 주입.. 가장 중요한 코드가 .. 이것..
	IF_bbsDAO bbsdao;
	
	@Override
	public void insertline(BBSVO bvo) {
		bbsdao.insert(bvo);	//bbs테이블에 저장하는 dao를 호출 //먼저 보내야 저장할 수 있으니까 보내기부터 한다.	
		String[] filenames = bvo.getFiles();
		if(bvo.getFiles().length > 0) { //첨부파일이 있다면
	//첨부파일을 저장한다.
	//query >> insert into bbs_files values ((select max(bbs_num) from bbs),filenames);
			for(int i=0; i<filenames.length; i++) {
				//이미지 2개올리면 오류 안나는데 1개나 아예 안올리면 오류나는 것을 방지
				if(filenames[i]!=null) { //현재 파일명이 null이 아닐때만 실행하도록 null이면 저장안하도록 세팅
					bbsdao.savefilenames(filenames[i]);
				}
			}
		}
		
	}
	@Override
	public List<BBSVO> selectAll(PageVO pagevo) {
		return bbsdao.selectAll(pagevo);
	}
	@Override
	public void deleteNum(String delno) {
		bbsdao.delno(delno);
	}
	@Override
	public BBSVO selectOne(String mno) {
		BBSVO a = bbsdao.selectOne(mno);
		return a;
	}
	@Override
	public void update(BBSVO bvo) {
		bbsdao.update(bvo);
	}
	@Override
	public BBSVO detailview(String vno) {
		bbsdao.updateCnt(vno);
		return bbsdao.selectOne(vno);
	}
	@Override
	public int getTotalcnt() {
	
		return bbsdao.getTotalcnt();
	}
	@Override
	public List<String> getFileNames(String vno) {
		return bbsdao.getFileNames(vno);
	}
}
