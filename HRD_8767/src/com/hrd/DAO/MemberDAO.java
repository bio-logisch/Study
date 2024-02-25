package com.hrd.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.hrd.VO.MemberVO;
import com.hrd.VO.ViewMoneyVO;


public class MemberDAO {
	private Connection conn;	

	// 싱글톤
	// 외부에서는 getInstance 메서드로 접근해서 객체의 주소를 요청
	// 변수와 메서드는 클래스 외부에서 접근 가능해야 하기에 static 지정
	public static MemberDAO mdao;
	public static MemberDAO getInstance() {
		if(mdao == null) {
			mdao = new MemberDAO();
		}
		return mdao;
	}

	private MemberDAO(){
		//1. 드라이버로드(1번만)  2. 커넥션  3. 쿼리 전송   4. 리턴값 처리
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드 성공");  //디버깅 목적
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("로드 실패");
		}
	}
	public boolean connect() {
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","1111");
			return true;   

		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	//회원가입 실행
	public void insert(MemberVO mvo) {
		if(connect()) {
			String sql = "insert into MEMBER_TBL_02 values (?,?,?,?,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, mvo.getCustno());
				psmt.setString(2, mvo.getCustname());
				psmt.setString(3, mvo.getPhone());
				psmt.setString(4, mvo.getAddress());
				psmt.setString(5, mvo.getJoindate());
				psmt.setString(6, mvo.getGrade());
				psmt.setString(7, mvo.getCity());
				psmt.executeUpdate();
				System.out.println("가입성공");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("가입실패");
			}
		}
	}
	//회원 전체 조회
	public ArrayList<MemberVO> selectAll() {
		// 1. 드라이버로드 2. 커넥션 가져오기 3. 쿼리값 4. 리턴..
		ResultSet rs = null; // 쿼리의 결과를 리턴받기 위한 객체
		ArrayList<MemberVO> allList = new ArrayList<>();
		if (connect()) {
			try {
				String sql = "select * from member_tbl_02"; // 완성된쿼리
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				// 단일 객체또는 숫자를 리턴 or 리스트를 리턴 해야 하기에 while문사용
				while (rs.next()) { // rs는 튜플을 통채로 가져옴
					MemberVO m = new MemberVO(); // 튜플하나당 객체 한개
					m.setAddress(rs.getString("address"));
					m.setCity(rs.getString("city"));
					m.setCustname(rs.getString("custname"));
					m.setCustno(rs.getInt("custno"));
					m.setGrade(rs.getString("grade"));
					m.setJoindate(rs.getString("joindate").substring(0,10));
					m.setPhone(rs.getString("phone"));
					allList.add(m);
				}
			} catch (Exception e) {
				e.printStackTrace(); // ;예외의 메시지를 출력, 디버깅용도
			}
		}
		return allList;
	}	
	//회원매출조회
	public ArrayList<ViewMoneyVO> selectTotalAll() {
		// 1. 드라이버로드 2. 커넥션 가져오기 3. 쿼리값 4. 리턴..
		ResultSet rs = null; // 쿼리의 결과를 리턴받기 위한 객체
		ArrayList<ViewMoneyVO> allList = new ArrayList<>();
		if (connect()) {
			try {
				String sql = "select m1.custno, m1.custname, m1.grade, sum(m2.price) total";
				sql += " from member_tbl_02 m1, money_tbl_02 m2";
				sql += " where m1.custno = m2.custno";
				sql += " group by (m1.custno, m1.custname, m1.grade)";// 컬럼 묶어서 그룹별(여기서는 회원마다)에 대한 통계내기
				sql += " order by m1.custno asc";

				System.out.println(sql);

				Statement stmt = conn.createStatement(); 
				rs = stmt.executeQuery(sql);
				while (rs.next()) { 
					ViewMoneyVO m = new ViewMoneyVO(); 
					m.setCustgrade(rs.getString("grade"));
					m.setCustname(rs.getString("custname"));
					m.setCustno(rs.getInt("custno"));
					m.setTotalprice(rs.getInt("total"));
					allList.add(m);
				}
			} catch (Exception e) {
				e.printStackTrace(); // ;예외의 메시지를 출력, 디버깅용도
			}
		}
		return allList;
	}
	//회원 한 명 조회(회원번호로 검색)
	public MemberVO selectOne(int custno) {
		// 1. 드라이버로드 2. 커넥션 가져오기 3. 쿼리값 4. 리턴..
		ResultSet rs = null; // 쿼리의 결과를 리턴받기 위한 객체
		if (connect()) {
			try {
				String sql = "select * from member_tbl_02 where custno=?"; // 완성된쿼리
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, custno);
				rs = psmt.executeQuery();
				if (rs.next()) { 
					MemberVO m = new MemberVO(); 
					m.setAddress(rs.getString("address"));
					m.setCity(rs.getString("city"));
					m.setCustname(rs.getString("custname"));
					m.setCustno(rs.getInt("custno"));
					m.setGrade(rs.getString("grade"));
					m.setJoindate(rs.getString("joindate").substring(0,10));
					m.setPhone(rs.getString("phone"));
					return m;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return null;
	}
	public int getCustNo() {
		int custno = 0;
		ResultSet rs = null; // 쿼리의 결과를 리턴받기 위한 객체
		if (connect()) {
			try {
				String sql = "select member_seq.nextval as num from dual";
				PreparedStatement psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				if(rs.next()) {
					custno = rs.getInt("num");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}	
		return custno; 
	}
	//회원정보 수정 
	public void update(MemberVO m) {
		if (connect()) {
			try {
				String sql = "update member_tbl_02 set custname=?, phone=?, address=?, joindate=?, grade=?, city=? where custno=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, m.getCustname());
				psmt.setString(2, m.getPhone());
				psmt.setString(3, m.getAddress());
				psmt.setString(4, m.getJoindate());
				psmt.setString(5, m.getGrade());
				psmt.setString(6, m.getCity());
				psmt.setInt(7, m.getCustno());
				psmt.executeUpdate();
				System.out.println("수정 성공");
			} catch (Exception e) {
				System.out.println("수정 실패");
				e.printStackTrace();
			}
		}	
	}
	//시퀀스(회원번호) 조회
	public int nowCnt() {
		int nowNumber=-1;		
		if(connect()) {			
			try {
				String sql = "select member_seq.nextval as num from dual";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) {
					nowNumber=rs.getInt("num");
				}
			} catch (Exception e) {
				System.out.println("시퀀스번호 조회실패");
			}			
		}
		return nowNumber;
	}
	//가입 날짜 조회(현재 날짜)
	public String nowDate() {
		String nowdate = null;
		if(connect()) {
			try {
				String sql = "select sysdate from dual";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) {
					nowdate = rs.getString(1);
				}
			}catch (Exception e) {
				System.out.println("오늘날짜 조회실패");
			}
		}
		return nowdate;
	}

}
