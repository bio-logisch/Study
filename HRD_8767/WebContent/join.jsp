<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈쇼핑 회원 등록</title>
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
	
	<h2>홈쇼핑 회원 등록</h2>
		<form id="inputForm" action="joinAction" method="post">
			<table border="1">
				<tr>
					<td>회원번호(자동발생)</td>
					<td><input type="text" id="custno" name="custno" value="${nownumber}" readonly></td>
				</tr>
				<tr>
					<td>회원성명</td>
					<td><input type="text" id="custname" name="custname"></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td>가입일자</td>
					<td><input type="text" name="joindate"></td>
				</tr>
				<tr>
					<td>고객등급</td>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="등록" onclick="chk()"> 
					<input type="button" value="조회"></td>
				</tr>
			</table>
		</form>

	<jsp:include page="footer.jsp"></jsp:include>
	
	<script>
		function chk(){
			// 정적인 문서 html요소를 선택하여 제어 한 후.. 컨트롤러에게 데이터를 넘길 못적으로 정의된 것.
			alert("유효성 검사");
			var inputfrm = document.querySelector('#inputForm'); 
			alert(inputfrm.custname.value);
			var name = inputfrm.custname.value;
			// 유효성 검사 코드를 작성
			
			if(name==''){
				alert("이름은 필수 입력입니다.");
				return;
			}
			
			inputfrm.submit();  //서브밋 실행(컨트롤러에게 넘기는 작업)
			alert('등록을 성공하였습니다');
		}
	
	
	</script>
</body>
</html>
