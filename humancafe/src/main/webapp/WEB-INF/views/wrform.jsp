<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  jstl 문법을 사용하겠다.. jsp교재에 있음.. c로 시작하겠다. -->
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
          <div class="card-body">

            <h5 class="card-title">상품문의 남기기</h5>
          </div>
        </div>
      </div>
      </div>
      <br>
      <form class="row g-3" action="bbswrpro" method="post" encType="multipart/form-data">
      <!-- encType="multipart/form-data"를 적어줘야 그림파일이 바이너리 형식으로 서버에 올라간다 -->
        <div class="col-md-4">
          <label for="inputState" class="form-label">문의분류</label>
          <select id="inputState" class="form-select" name="bbs_flag">
            <option selected>상품문의</option>
            <option>배송문의</option>
            <option>기타문의</option>
            
          </select>
        </div>
        <div class="col-md-3">
          <label for="inputCity" class="form-label">작성자</label>
          <input type="text" name="bbs_wr" class="form-control" id="inputCity">
        </div>
        <div class="col-md-3">
          <label for="inputPassword4" class="form-label">비밀번호</label>
          <input type="password" name="bbs_pass" class="form-control" id="inputPassword4">
        </div>
        <div class="col-12">
          <label for="inputAddress" class="form-label">제목</label>
          <input type="text" name="bbs_title" class="form-control" id="inputAddress" placeholder="제목을 입력하세요">
        </div><div class="form-floating">
          <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2"
            style="height: 200px" name="bbs_comment"></textarea>
          <label for="floatingTextarea2">내용</label>
        </div>
        
        <div class="mb-3"> <!-- name이 같고 value가 다른 두 개의 값은 배열형식으로 보내진다 -->
          <input class="form-control" type="file" id="formFile" name="file">
          <input class="form-control" type="file" id="formFile" name="file">
        </div>

        <div class="col-12">
          <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck">
            <label class="form-check-label" for="gridCheck">
              회원만 보기
            </label>
          </div>
        </div>
        <div class="col-12">
          <button type="submit" class="btn btn-primary">저장하기</button>
        </div>
      </form>
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