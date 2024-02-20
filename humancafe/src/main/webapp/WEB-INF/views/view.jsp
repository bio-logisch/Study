<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  jstl 문법을 사용하겠다.. jsp교재에 있음.. c로 시작하겠다. -->
<!DOCTYPE html>
<html lang="kor">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
 </head>
<body>
<%@ include file="./include/top.jsp" %>
  <article>
    <section>
      <div>
        <div class="card text-center">
          <div class="card-body">

            <h5 class="card-title">상품문의글 상세보기</h5>
          </div>
        </div>
      </div>
      </div>
      <br>
      <form class="row g-3" action="bbswrpro" method="post">
        <div class="col-md-4">
          <label for="inputlabel" class="form-label">문의분류 : </label>
          <span>${nowvo.bbs_flag}</span>  
        </div>
        <div class="col-12">
          <label for="inputlabel"  class="form-label">글번호 : </label>
          <span>${nowvo.bbs_num}</span>          
        </div>  
        <div class="col-12">
          <label for="inputlabel"  class="form-label">작성일 : </label>
          <span>${nowvo.bbs_date}</span>          
        </div> 
        <div class="col-md-3">
          <label for="inputlabel"  class="form-label">작성자 : </label>
          <span>${nowvo.bbs_wr }</span>
        </div>
        <div class="col-12">
          <label for="inputlabel"  class="form-label">제목 :</label>
          <span>${nowvo.bbs_title}</span>          
        </div>
        <div >
          <label for="inputlabel"  class="form-label">내용 :</label>
          <span>${nowvo.bbs_comment }</span>
        </div>
    	<div>
    		<span class="form-label"> 첨부파일 </span>
    		<br> <br>
    		<c:forEach items="${files}" var="fname">
    		<label for="inputName" class="form-label">*파일명 :</label>
    			<a href="download?filename=${fname}">${fname}</a>
    			<br> <br>
    			<img src="download?filename=${fname}">
    			<br>
    			<br>
    		</c:forEach> 
    	</div>
        <div class="col-12">
          <button type="button" onclick="location.href='bbsmod?mno=${bbsvo.bbs_num }';" 
          class="btn btn-primary">수정하기</button>
          &nbsp &nbsp
          <button type="button" onclick='delchk(${bbsvo.bbs_num })' 
          class="btn btn-primary">삭제하기</button>
          &nbsp &nbsp
          <button type="button" onclick="location.href='bbsview';" 
          class="btn btn-primary">목록으로 돌아가기</button>
        </div>
      </form>
    </section>
	<script>
		function delchk(dno){
			if(confirm("정말로 삭제하시겠습니까?")==true){
					location.href="bbsdel?dno="+dno
			}else{
					alert("취소되었습니다.")
			}
		}
	</script>

  </article>

  <footer>
    <div>
      <hr>
      <p>개발자 : 이윤지</p>
    </div>
  </footer>


</body>

</html>