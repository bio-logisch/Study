<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hrd.VO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원매출조회</title>
</head>
<body>
<%@ include file="top_nav.jsp" %>
	<h2> 회원매출조회 </h2>
	
	<table>
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>고객등급</td>
			<td>매출</td>
		</tr>	
	<!--순회-->
		<% ArrayList<ViewMoneyVO> mlist = (ArrayList)request.getAttribute("totalList"); %>
		<%	
			for(int i=0; i < mlist.size(); i++){
				ViewMoneyVO tempvo = mlist.get(i);
				out.print("<tr>");
				out.print("<td>"+tempvo.getCustno()+"</td>");
				out.print("<td>"+tempvo.getCustname()+"</td>");
				out.print("<td>");
				if(tempvo.getCustgrade().equals("A")){
					out.print("VIP");
				}else if(tempvo.getCustgrade().equals("B")){
					out.print("일반");
				}else if(tempvo.getCustgrade().equals("C")){
					out.print("직원");
				}						
				out.print("</td>");
				out.print("<td>"+tempvo.getTotalprice()+"</td>");
				out.print("</tr>");					
			}		
		
		%>	
	</table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>