<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈쇼핑 회원 등록</title>
<style>
table {
	text-align: center;
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
				<td><input type="text" id="custno" name="custno"
					value="${nownumber}" readonly></td>
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
				<td><input type="text" name="joindate" id="joindate" value="${nowdate}"></td>
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
					<input type="button" value="조회" onclick="location.href='listView'"></td>
			</tr>
		</table>
	</form>

	<jsp:include page="footer.jsp"></jsp:include>

	<script>
		function chk(){
			alert("유효성 검사");
			var inputfrm = document.querySelector('#inputForm'); 
			var name = inputfrm.custname.value;
			var phone = inputfrm.phone.value;
			var address = inputfrm.address.value;
			var joindate = inputfrm.joindate.value;
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
			}else if(joindate==''){
				alert("가입일은 필수 입력입니다. yyyymmdd형식 준수바랍니다.");
				return;
			}else if(grade==''){
				alert("고객등급은 필수 입력입니다.");
				return;
			}else if(city==''){
				alert("도시코드는 필수 입력입니다.");
				return;
			}
			inputfrm.submit();  
			alert('회원등록이 완료 되었습니다!');
		}
	</script>
</body>
</html>
