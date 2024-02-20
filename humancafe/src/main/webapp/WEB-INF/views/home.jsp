<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
   
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<%@ include file="./include/top.jsp" %>
    <article>
        <section>
            <div>
              <div class="card text-center">
                <img src="<%=request.getContextPath()%>/resources/img/main.PNG" class="img-fluid" alt="...">
                <div class="card-body">

                  <h5 class="card-title">보노보노 커피 쇼핑몰입니다!</h5>
                 
                    <ul>
                      <li> 즐거운 커피 시간 </li>
                      <li> 많은 관심 부탁드립니다 </li>
                    </ul>  
                  
                 <a href="#" class="btn btn-primary">제품 구경하기</a>
                </div>
              </div>
            </div>
        </section>
    </article>
    <footer>
        <div>
            <hr>
            <p>개발자 : 이윤지</p>
        </div>
    </footer>
</body>
</html>