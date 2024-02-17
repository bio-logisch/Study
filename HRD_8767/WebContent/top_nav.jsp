<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 회원관리 ver 1.0</title>
<style>
	h1 {
		text-align: center;
		padding: 20px;
		background-color: lightskyblue;
	}
	
	h2 {
		text-align: center;
		padding: 10px;
	}
	
	#navdiv {
		background-color: darkkhaki;
		height: 50px;
		vertical-align: middle;
	}
	
	nav {
		float: left;
		display: inline-block;
		padding-top: 10px;
	}
	
	nav>span {
		margin-left: 50px;
		font-size: 20px;
	}
	
	table {
		text-align: center;
		margin: auto;
		width: 50%;
		border: solid 2px black;
	}
	
	tr, th, td {
		border: solid 2px black;
	}
</style>

</head>
<body>
	<header>
		<h1>쇼핑몰 회원관리 ver1.0</h1>
	</header>
	<div id="navdiv">
		<nav>
			<span><a href="JoinForm">[회원등록]</a></span>  
			<span><a href="listView">[회원목록 조회/수정]</a></span> 
			<span><a href="viewMoney">[회원매출조회]</a></span> 
			<span><a href="index">[홈으로]</a></span>
		</nav>
	</div>
</body>
</html>