<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hrd.VO.MemberVO" %>    
<% 
	request.setCharacterEncoding("UTF-8"); 
	MemberVO mvo = (MemberVO)request.getAttribute("mvo");//컨트롤러가 보낸 객체 받기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈쇼핑 회원 정보수정</title>
<style>
	table{
		text-align:center;
		margin: auto;
		width: 50%;
	}
</style>
</head>
<body>
	<%@ include file="top_nav.jsp"%>
	
	<h2>홈쇼핑 회원 정보수정</h2>
		<form id="modForm" action="modAction" method="post">
			<table border="1">
				<tr>
					<td>회원번호(자동발생)</td>
					<td><input type="text" id="custno" name="custno" value="${mvo.custno}" readonly></td>
				</tr>
				<tr>
					<td>회원성명</td>
					<td><input type="text" id="custname" name="custname" value="${mvo.custname}"></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" name="phone" value="${mvo.phone}"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" name="address" value="${mvo.address}"></td>
				</tr>
				<tr>
					<td>가입일자</td>
					<td><input type="text" name="joindate" value="${mvo.joindate}" readonly></td>
				</tr>
				<tr>
					<td>고객등급</td>
					<td><input type="text" name="grade" value="${mvo.grade}"></td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input type="text" name="city" value="${mvo.city}"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="수정" onclick="chk()"> 
					<input type="button" value="조회" onclick="location.href='listView'">
				</tr>
			</table>
		</form>

	<jsp:include page="footer.jsp"></jsp:include>
	
	<script>
		function chk(){
			// 정적인 문서 html요소를 선택하여 제어 한 후.. 컨트롤러에게 데이터를 넘길 못적으로 정의된 것.
			alert("유효성 검사");
			var inputfrm = document.querySelector('#modForm'); 
			var name = inputfrm.custname.value;
	        var phone = inputfrm.phone.value; 
	        var address = inputfrm.address.value; 
	        var grade = inputfrm.grade.value; 
	        var city = inputfrm.city.value; 
			// 유효성 검사
			if(name==''){
				alert("이름은 필수 입력입니다.");
				return;
			}else if(phone==''){
				alert("전화번호는 필수 입력입니다.");
				return;
			}else if(address==''){
				alert("주소는 필수 입력입니다.");
				return;
			}else if(grade==''){
				alert("고객등급은 필수 입력입니다.");
				return;
			}else if(city==''){
				alert("도시코드는 필수 입력입니다.");
				return;
			}
			inputfrm.submit();  //서브밋 실행(컨트롤러에게 넘기는 작업)
			alert('회원정보수정이 완료되었습니다.');
			//document.modForm.submit();
		}
	
	
	</script>
</body>
</html>