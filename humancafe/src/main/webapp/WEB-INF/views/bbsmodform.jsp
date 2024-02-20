<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  jstl 문법을 사용하겠다.. jsp교재에 있음.. c로 시작하겠다. -->
<!DOCTYPE html>
<html lang="kor">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    body {
      width: 1024px;
      height: 3000px;
    }

    header {
      /*  display: inline-block;*/
      float: left;
      width: 1024px;
      height: 80px;
      color: white;

    }

    nav {
      /*display: inline-block;*/
      float: left;
      width: 100%;
      /*부모의 크기의 퍼센트 */
      height: 40px;
      /*  border: solid 1px black;     */

    }

    nav div {
      height: 40px;
      float: center;
      text-align: center;
      /*  border: dotted 1px black;  */
      /*  border-bottom-style:dotted;
            border-bottom-color:lightslategray;
            border-bottom-width: 1px;*/
      line-height: 40px;
    }

    nav div button {
      margin-right: 20px;
    }

    header #header_input {
      text-align: center;
    }

    header input[type=text] {
      width: 500px;
      height: 32px;
      font-size: 15px;
      border: solid 1px gray;
      border-radius: 15px;
      outline: none;
      margin-bottom: 10px;
      background-color: rgb(233, 233, 233);
    }

    ul {
      margin: 0px;
    }

    ul li {
      display: inline-block;
      width: 80px;
      text-align: center;
      /*inline level만 가운데 정렬*/
      margin-right: 10px;

    }

    ul li a {
      text-decoration: none;
    }

    section ul li {
      width: 100%;
    }

    ul li:hover {
      /* 마우스 커서가 위로 올라 왔을때 액션 */
      background-color: rgb(100, 237, 212);

    }

    article {
      float: left;
      width: 100%;
      /*border: dotted 1px red;*/
    }

    section {
      display: inline-block;
      width: 90%;
      /*  border: dotted 1px red;*/
      margin: 0px auto;
      margin-left: 50px;
    }

    footer {
      float: left;
      width: 100%;
      height: 50px;
      /* border: solid 1px gray;*/
    }

    #login {
      float: right;
      width: 50%;
      margin-top: 0px;
    }

    #login table {
      float: right;
      margin-top: 0px;
      padding: 0px;
      margin-bottom: 5px;
    }

    footer div {
      text-align: center;
    }

    #userinfo {
      display: inline-block;
      width: 200px;
      height: 80px;
      /*  background-color: aqua;*/
      top: 65px;
      left: 850px;
      position: absolute;
    }

    table {
      margin-top: 8px;
    }

    .table_td {
      padding-top: 10px;
    }

    header h1 {
      font-size: 16px;
      text-align: center;
      height: 40px;
      background-color: gray;
      padding-top: 10px;
    }

    header #header_div {
      text-align: center;
      width: 100%;
      display: block;
      /*  background-color: aqua;*/
    }

    header #header_div #header_div_input {
      float: left;
      width: 75%;
      text-align: right;
    }

    header #header_div #header_div_img {
      float: left;
      margin-top: 3px;
    }
  </style>
  <style>
    /*java.html */
    #section_list_control {
      width: 100%;
      text-align: center;
    }
  </style>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
    crossorigin="anonymous"></script>
</head>

<body>
  <header>
    <h1><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-cup-hot"
        viewBox="0 0 16 16">
        <path fill-rule="evenodd"
          d="M.5 6a.5.5 0 0 0-.488.608l1.652 7.434A2.5 2.5 0 0 0 4.104 16h5.792a2.5 2.5 0 0 0 2.44-1.958l.131-.59a3 3 0 0 0 1.3-5.854l.221-.99A.5.5 0 0 0 13.5 6H.5ZM13 12.5a2.01 2.01 0 0 1-.316-.025l.867-3.898A2.001 2.001 0 0 1 13 12.5ZM2.64 13.825 1.123 7h11.754l-1.517 6.825A1.5 1.5 0 0 1 9.896 15H4.104a1.5 1.5 0 0 1-1.464-1.175Z" />
        <path
          d="m4.4.8-.003.004-.014.019a4.167 4.167 0 0 0-.204.31 2.327 2.327 0 0 0-.141.267c-.026.06-.034.092-.037.103v.004a.593.593 0 0 0 .091.248c.075.133.178.272.308.445l.01.012c.118.158.26.347.37.543.112.2.22.455.22.745 0 .188-.065.368-.119.494a3.31 3.31 0 0 1-.202.388 5.444 5.444 0 0 1-.253.382l-.018.025-.005.008-.002.002A.5.5 0 0 1 3.6 4.2l.003-.004.014-.019a4.149 4.149 0 0 0 .204-.31 2.06 2.06 0 0 0 .141-.267c.026-.06.034-.092.037-.103a.593.593 0 0 0-.09-.252A4.334 4.334 0 0 0 3.6 2.8l-.01-.012a5.099 5.099 0 0 1-.37-.543A1.53 1.53 0 0 1 3 1.5c0-.188.065-.368.119-.494.059-.138.134-.274.202-.388a5.446 5.446 0 0 1 .253-.382l.025-.035A.5.5 0 0 1 4.4.8Zm3 0-.003.004-.014.019a4.167 4.167 0 0 0-.204.31 2.327 2.327 0 0 0-.141.267c-.026.06-.034.092-.037.103v.004a.593.593 0 0 0 .091.248c.075.133.178.272.308.445l.01.012c.118.158.26.347.37.543.112.2.22.455.22.745 0 .188-.065.368-.119.494a3.31 3.31 0 0 1-.202.388 5.444 5.444 0 0 1-.253.382l-.018.025-.005.008-.002.002A.5.5 0 0 1 6.6 4.2l.003-.004.014-.019a4.149 4.149 0 0 0 .204-.31 2.06 2.06 0 0 0 .141-.267c.026-.06.034-.092.037-.103a.593.593 0 0 0-.09-.252A4.334 4.334 0 0 0 6.6 2.8l-.01-.012a5.099 5.099 0 0 1-.37-.543A1.53 1.53 0 0 1 6 1.5c0-.188.065-.368.119-.494.059-.138.134-.274.202-.388a5.446 5.446 0 0 1 .253-.382l.025-.035A.5.5 0 0 1 7.4.8Zm3 0-.003.004-.014.019a4.077 4.077 0 0 0-.204.31 2.337 2.337 0 0 0-.141.267c-.026.06-.034.092-.037.103v.004a.593.593 0 0 0 .091.248c.075.133.178.272.308.445l.01.012c.118.158.26.347.37.543.112.2.22.455.22.745 0 .188-.065.368-.119.494a3.198 3.198 0 0 1-.202.388 5.385 5.385 0 0 1-.252.382l-.019.025-.005.008-.002.002A.5.5 0 0 1 9.6 4.2l.003-.004.014-.019a4.149 4.149 0 0 0 .204-.31 2.06 2.06 0 0 0 .141-.267c.026-.06.034-.092.037-.103a.593.593 0 0 0-.09-.252A4.334 4.334 0 0 0 9.6 2.8l-.01-.012a5.099 5.099 0 0 1-.37-.543A1.53 1.53 0 0 1 9 1.5c0-.188.065-.368.119-.494.059-.138.134-.274.202-.388a5.446 5.446 0 0 1 .253-.382l.025-.035A.5.5 0 0 1 10.4.8Z" />
      </svg> BONOBONO COFFEE</h1>
    <div id="header_div">
      <div id="header_div_input">
        <input type=text>
      </div>
      <div id="header_div_img">
            <img src="<%=request.getContextPath()%>/resources/img/search.PNG"  class="img-fluid" alt="...">
      </div>
    </div>
  </header>
  <div id="userinfo">
    <div>
      <p><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bug"
          viewBox="0 0 16 16">
          <path
            d="M4.355.522a.5.5 0 0 1 .623.333l.291.956A4.979 4.979 0 0 1 8 1c1.007 0 1.946.298 2.731.811l.29-.956a.5.5 0 1 1 .957.29l-.41 1.352A4.985 4.985 0 0 1 13 6h.5a.5.5 0 0 0 .5-.5V5a.5.5 0 0 1 1 0v.5A1.5 1.5 0 0 1 13.5 7H13v1h1.5a.5.5 0 0 1 0 1H13v1h.5a1.5 1.5 0 0 1 1.5 1.5v.5a.5.5 0 1 1-1 0v-.5a.5.5 0 0 0-.5-.5H13a5 5 0 0 1-10 0h-.5a.5.5 0 0 0-.5.5v.5a.5.5 0 1 1-1 0v-.5A1.5 1.5 0 0 1 2.5 10H3V9H1.5a.5.5 0 0 1 0-1H3V7h-.5A1.5 1.5 0 0 1 1 5.5V5a.5.5 0 0 1 1 0v.5a.5.5 0 0 0 .5.5H3c0-1.364.547-2.601 1.432-3.503l-.41-1.352a.5.5 0 0 1 .333-.623zM4 7v4a4 4 0 0 0 3.5 3.97V7H4zm4.5 0v7.97A4 4 0 0 0 12 11V7H8.5zM12 6a3.989 3.989 0 0 0-1.334-2.982A3.983 3.983 0 0 0 8 2a3.983 3.983 0 0 0-2.667 1.018A3.989 3.989 0 0 0 4 6h8z" />
        </svg> 현재사용자 : Guest</p>
    </div>
  </div>

  <nav>
    <div>
      <ul>
        <li><a href="./index.html"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
              class="bi bi-caret-right" viewBox="0 0 16 16">
              <path
                d="M6 12.796V3.204L11.481 8 6 12.796zm.659.753 5.48-4.796a1 1 0 0 0 0-1.506L6.66 2.451C6.011 1.885 5 2.345 5 3.204v9.592a1 1 0 0 0 1.659.753z" />
            </svg>Home</a>
        </li>
        <li><a href="./java.html"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
              class="bi bi-caret-right" viewBox="0 0 16 16">
              <path
                d="M6 12.796V3.204L11.481 8 6 12.796zm.659.753 5.48-4.796a1 1 0 0 0 0-1.506L6.66 2.451C6.011 1.885 5 2.345 5 3.204v9.592a1 1 0 0 0 1.659.753z" />
            </svg>커피</a>
        </li>
        <li><a href="./db.html"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
              class="bi bi-caret-right" viewBox="0 0 16 16">
              <path
                d="M6 12.796V3.204L11.481 8 6 12.796zm.659.753 5.48-4.796a1 1 0 0 0 0-1.506L6.66 2.451C6.011 1.885 5 2.345 5 3.204v9.592a1 1 0 0 0 1.659.753z" />
            </svg>도구</a>
        </li>
        <li><a href="./bbs.html"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
              class="bi bi-caret-right" viewBox="0 0 16 16">
              <path
                d="M6 12.796V3.204L11.481 8 6 12.796zm.659.753 5.48-4.796a1 1 0 0 0 0-1.506L6.66 2.451C6.011 1.885 5 2.345 5 3.204v9.592a1 1 0 0 0 1.659.753z" />
            </svg>상품문의</a>
        </li>

      </ul>
      <!--
            <a href="./index.html"><button type="button" class="btn btn-ligh">Home</button></a>
            <button type="button" class="btn btn-ligh">Java</button>
            <button type="button" class="btn btn-ligh">C</button>
            <a href="./bbs.html"> 
                <button type="button" class="btn btn-ligh">게시판</button>
             </a>       
-->
    </div>
  </nav>
  <!--
    <nav>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
              <a class="navbar-brand" href="#"></a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">BBS</a>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Study
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="#">Action</a></li>
                      <li><a class="dropdown-item" href="#">Another action</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                  </li>
                </ul>
                
              </div>
            </div>
          </nav>
    </nav>-->

  <div id="login">
    <table>
      <tr>
        <td width="150" class="table_td">
          <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="ID">
        </td>
        <td width="150" class="table_td">
          <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="pass">
        </td>
        <td class="table_td">
          <button type="button" class="btn btn-success">Login</button>
          <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
            Join
          </button>
        </td>
      </tr>
    </table>
  </div>
  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="exampleModalLabel">회원가입</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">ID</span>
            <input type="text" class="form-control" placeholder="Username" aria-label="Username"
              aria-describedby="basic-addon1">
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">PASS</span>
            <input type="text" class="form-control" placeholder="Pass" aria-label="Username"
              aria-describedby="basic-addon1">
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">TEL</span>
            <input type="text" class="form-control" placeholder="tel" aria-label="Username"
              aria-describedby="basic-addon1">
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">EMAIL</span>
            <input type="text" class="form-control" placeholder="E-mail" aria-label="Username"
              aria-describedby="basic-addon1">
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Save</button>
          <button type="button" class="btn btn-primary">Cancel</button>
        </div>
      </div>
    </div>
  </div>
  <article>
    <section>
      <div>
        <div class="card text-center">
          <div class="card-body">

            <h5 class="card-title">문의글 수정하기</h5>
          </div>
        </div>
      </div>
      <br>
      <form class="row g-3" action="bbsmodpro" method="post">
        <div class="col-md-4">
          <label for="inputState" class="form-label">문의분류</label>
          <select id="inputState" class="form-select" name="bbs_flag">
            	<option selected>${mbvo.bbs_flag}</option>
            	<option>상품문의</option>
            	<option>배송문의</option>
            	<option>기타문의</option>
          </select>
        </div>
        <div class="col-md-3">
          <label for="inputCity" class="form-label">작성자</label>
          <input type="text" name="bbs_wr" class="form-control" id="inputCity" value="${mbvo.bbs_wr }" readonly>
        </div>
        <div class="col-md-3">
          <label for="inputPassword4" class="form-label">비밀번호</label>
          <input type="password" name="bbs_pass" class="form-control" id="inputPassword4" value="${mbvo.bbs_pass }">
        </div>
        <div class="col-12">
          <label for="inputAddress" class="form-label">제목</label>
          <input type="text" name="bbs_title" class="form-control" id="inputAddress" value="${mbvo.bbs_title }">
        </div><div class="form-floating">
          <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2"
            style="height: 200px" name="bbs_comment">${mbvo.bbs_comment }</textarea>
          <label for="floatingTextarea2">내용</label>
        </div>
         <input type="hidden" name="bbs_num" value="${mbvo.bbs_num }"> 
        <div class="mb-3">
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
          <button type="submit" class="btn btn-primary">수정하기</button>
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