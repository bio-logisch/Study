<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hrd.VO.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록조회/수정</title>
</head>
<body>
	<%@ include file="top_nav.jsp"%>
	<h2>회원목록조회/수정</h2>

	<table>
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>가입일자</td>
			<td>고객등급</td>
			<td>거주지역</td>
		</tr>
		<!--순회-->
		<%
		   	ArrayList<MemberVO> mlist = (ArrayList<MemberVO>) request.getAttribute("memberList");
		   	if (mlist != null) {
		       for (int i = 0; i < mlist.size(); i++) {
		           MemberVO tempvo = mlist.get(i);
		%>
		<tr>
			<td><a href="modForm?custno=<%=tempvo.getCustno()%>"><%=tempvo.getCustno()%></a></td>
			<td><%=tempvo.getCustname()%></td>
			<td><%=tempvo.getPhone()%></td>
			<td><%=tempvo.getAddress()%></td>
			<td><%=tempvo.getJoindate().substring(0, 10)%></td>
			<td>
				<% 
                if(tempvo.getGrade().equals("A")){
                    out.print("VIP");
                }else if(tempvo.getGrade().equals("B")){
                    out.print("일반");
                }else if(tempvo.getGrade().equals("C")){
                    out.print("직원");
                }                       
                %>
			</td>
			<td><%=tempvo.getCity()%></td>
		</tr>
	<%
	        }
	    } else {
	        // memberList가 null인 경우 처리할 내용 추가
	        out.println("데이터가 없습니다.");
	    }
	%>

	</table>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
