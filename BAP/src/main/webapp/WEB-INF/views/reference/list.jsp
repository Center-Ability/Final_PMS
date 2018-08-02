<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<body class="hold-transition sidebar-mini">

	<div class="content-wrapper" style="margin-left: 20px;">
		<h2>사원수정</h2>
		<!-- 검색 -->
		<div>
			<select name="searchType">
				<option value="n"
					<c:out value="${cri.searchType == null?'selected':''}"/>>
					---</option>
				<option value="t"
					<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
					제목</option>
				<option value="c"
					<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
					내용</option>
				<option value="w"
					<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>
					작성자</option>
				<option value="tc"
					<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
					제목 or 내용</option>
				<option value="cw"
					<c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>
					내용 OR 작성자</option>
			</select>
			<input type="text" name="keyword" id="keywordInput" value="${cri.keyword}">
			<button id='searchBtn'>검색</button>
			<sec:authorize access="hasAuthority('auth_pm')">
			<button  class="btn btn-default" id='newBtn'>글쓰기</button> 
			</sec:authorize>
		</div>
		
		<!-- ///////////////////////////////////// -->
		<table class="table table-boardered">
			<tr>
				<th >글 번호</th>
				<th >프로젝트 번호</th>
				<th >프로젝트 이름</th>
				<th >제목</th>
				<th >작성자</th>
				<th >작성일</th>
			</tr>
			
			<c:forEach items="${docDTO}" var="dto">
				<tr>
					<td style="width:30px">${dto.doc_no}</td>
					<td style="width:30px">${dto.pro_num}</td>
					<td style="width:100px">${dto.pro_name}</td>
					<td style="width:300px"><a href='/ref/detail${pageMaker.makeSearch(pageMaker.cri.page)}
					&doc_no=${dto.doc_no}'>${dto.doc_title}</a></td>
					<td style="width:100px">${dto.mem_name}</td>
					<td style="width:100px"><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.doc_date}"/></td>
			</c:forEach>
		</table>
		<div>
		
		
		<!-- ////////////페이지//////////// -->
		<div class="row">
				<!-- left column -->
				<div class="col-md-12">
					<div class="box">
						<div class="box-footer">
							<div class="text-center">
								<ul class="pagination link">

									<c:if test="${pageMaker.prev}">
										<li><a
											href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}">&laquo;</a>
										</li>
									</c:if>

									<c:forEach begin="${pageMaker.startPage }"
										end="${pageMaker.endPage}" var="idx">
										<li
											<c:out value="${pageMaker.cri.page == idx?'class=active':''}"/>>
											<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
										</li>
									</c:forEach>

									<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
										<li><a
											href="list${pageMaker.makeSearch(pageMaker.endPage + 1)}">&raquo;</a></li>
									</c:if>

								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<form id="jodForm">
			<input type='hidden' name="page" value="${pageMaker.cri.perPageNum}">
			<input type='hidden' name="pagePageNum"
				value="${pageMaker.cri.perPageNum}">
			
		</form>

	</div>
	!-- jQuery -->
	<script	src="<%=request.getContextPath()%>/resources/plugins/jquery/jquery.min.js"></script>
	 <!-- Bootstrap 3.3.2 JS -->
    <script src="<%=request.getContextPath()%>/resources/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='<%=request.getContextPath()%>/resources/plugins/fastclick/fastclick.min.js'></script>
    <!-- AdminLTE App -->
    <script src="<%=request.getContextPath()%>/resources/dist/js/app.min.js" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="<%=request.getContextPath()%>/resources/dist/js/demo.js" type="text/javascript"></script>
	
	<script>
	$(document).ready(function() {
		$('#searchBtn').on("click", function(event) {
			self.location = "list"
						+ '${pageMaker.makeQuery(1)}'
						+ "&searchType="
						+ $("select option:selected").val()
						+ "&keyword="
						+ encodeURIComponent($('#keywordInput').val());
		});
	
		$('#newBtn').on("click", function(evt) {
			self.location = "/ref/create";
		});
	});
	</script>

</body>
</html>