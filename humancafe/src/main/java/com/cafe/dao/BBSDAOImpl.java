package com.cafe.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.vo.BBSVO;
import com.cafe.vo.PageVO;

@Repository
public class BBSDAOImpl implements IF_bbsDAO{
	//Factory mapping 정보
	private static String mapperQuery="com.cafe.dao.IF_bbsDAO";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insert(BBSVO bbsvo) {
		sqlSession.insert(mapperQuery+".insertOne", bbsvo);
	}

	@Override
	public List<BBSVO> selectAll(PageVO pagevo) {
		return sqlSession.selectList(mapperQuery+".selectAll",pagevo);
	}

	@Override
	public void delno(String dno) {
		sqlSession.delete(mapperQuery+".delone",dno );
		
	}

	@Override
	public BBSVO selectOne(String mno) {
		return sqlSession.selectOne(mapperQuery+".selectOne", mno);
	}

	@Override
	public void update(BBSVO bvo) {
		sqlSession.update(mapperQuery+".updateOne", bvo);
		
	}

	@Override
	public void updateCnt(String vno) {
		sqlSession.update(mapperQuery+".updatecnt", vno);
		
	}

	@Override
	public int getTotalcnt() {
		return sqlSession.selectOne(mapperQuery+".totalcnt");//매퍼수정필요

	}

	@Override
	public int savefilenames(String fname) {
		return sqlSession.insert(mapperQuery+".saveFile", fname);//매퍼수정필요;
	}

	@Override
	public List<String> getFileNames(String vno) {
		return sqlSession.selectList(mapperQuery+".selectFiles", vno);
	}

}
