<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
<%@ include file="./include/top.jsp" %>
	<article>
		<section>
			<div>
				<div>
					<div class="card text-center">
						<div class="card-body">

							<h5 class="card-title">게시판</h5>
						</div>
					</div>
				</div>
			</div>
			<div id="article_table">
				<table class="table">
					<thead class="table-dark">
						<tr style="text-align: center">
							<th scope="col" width=10% style="text-align: center">번호</th>
							<th scope="col" width=30% style="text-align: center">제목</th>
							<th scope="col" width=15% style="text-align: center">작성자</th>
							<th scope="col" width=15% style="text-align: center">작성일</th>
							<th scope="col" width=10% style="text-align: center">조회수</th>
							<th scope="col" width=20% style="text-align: center">수정 / 삭제</th>
						</tr>
					</thead>
					<tbody>
						<!--  컨트롤러에서 보낸 리스트를 반복하여 tr단위로 출력하면 된다. -->
						<c:forEach items="${blist}" var="bbsvo">
							<tr>
								<td scope="row" style="text-align: center">${bbsvo.bbs_num }</td>
								<td style="text-align: left"><a
									href="bbsdetail?vno=${bbsvo.bbs_num }">${bbsvo.bbs_title }</a>
								</td>
								<td style="text-align: center">${bbsvo.bbs_wr }</td>
								<td style="text-align: center">${bbsvo.bbs_date}</td>
								<td style="text-align: center">${bbsvo.bbs_cnt}</td>

								<td style="text-align: center"><a
									href="bbsmod?mno=${bbsvo.bbs_num }">[수정]</a> <a href="#"
									onclick='delchk(${bbsvo.bbs_num })'>[삭제]</a></td>
							</tr>
						</c:forEach>

						<script>
							function delchk(dno){
								if(confirm("정말로 삭제하시겠습니까?")==true){
									location.href="bbsdel?dno="+dno
								}else{
									alert("취소되었습니다.")
								}
							}
						</script>
						<!-- paging Info -->
						<tr>
							<td colspan=5 align=center>
							<c:if test="${pagevo.prev}">
							<a href = "bbsview?page=${pagevo.startPage-1}">[이전]</a>
							</c:if> 
							<c:forEach begin="${pagevo.startPage}" 
										end="${pagevo.endPage}"
										var="idx">
										<a href="bbsview?page=${idx}">
										<c:if test="${idx==pagevo.page}">[</c:if> 
										${idx}
										<c:if test="${idx==pagevo.page}">]</c:if> 
										</a>
								</c:forEach> 
								<c:if test="${pagevo.next}">
							<a href = "bbsview?page=${pagevo.endPage+1}">[다음]</a>
							</c:if></td>
						</tr>
					</tbody>
				</table>
				<div id="table_menu" style="">
					<a href="bbswr"> <svg xmlns="http://www.w3.org/2000/svg"
							width="20" height="20" fill="currentColor"
							class="bi bi-file-plus" viewBox="0 0 16 16">
                        <path
								d="M8.5 6a.5.5 0 0 0-1 0v1.5H6a.5.5 0 0 0 0 1h1.5V10a.5.5 0 0 0 1 0V8.5H10a.5.5 0 0 0 0-1H8.5V6z" />
                        <path
								d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2zm10-1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1z" />
                      </svg>
					</a>
				</div>

			</div>
			</div>
		</section>
	</article>
	<footer>
		<hr>
		<div>
			<p>개발자 : 이윤지</p>
		</div>
	</footer>
</body>
</html>
