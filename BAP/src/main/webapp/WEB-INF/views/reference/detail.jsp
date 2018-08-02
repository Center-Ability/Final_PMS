<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body class="hold-transition sidebar-mini">

	<form role="form" method="post">
		<input type='hidden' name="doc_no" value="${doclistDTO.doc_no}">
		<input type='hidden' name="doc_no" value="${docAttachVO.doc_no}">
	</form>
	
	  <div id="wrap" class="card card-warning" style="margin:10px auto; width: 960px; height: 755px;">
      <div class="card-header" style="background: #ffc107;">
         <h3 class="card-title">상세보기</h3>
      </div>
      <div class="card-body" style="overflow-y: scroll; height: 654px;">
      	<table>
      		<tr>
      			<th scope="row">제목</th>
      			<td>${docVO.doc_title}</td>
      		</tr>
      		<tr>
      			<th scope="row">작성일</th>
      			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${docVO.doc_date}"/></td>
      		</tr>
      		<tr>
      			<th scope="row">작성자</th>
      			<td>${mem_name}</td>
      		</tr>
      		<tr>
      			<th scope="row">내용</th>
      			<td>${docVO.doc_content}</td>
      		</tr>
      		<tr>
      			<th scope="row">파일첨부</th>
      			
      			<td>
                    <c:forEach items="${fileInfo}" var="row" >
                      <span><a href="#">${row.doc_attach_title}</a></span><br/> 
                    </c:forEach>      
                </td>                    
            </tr>
      		
      	</table>
         
      <div class="card-footer">
         
         <button id="CancelButton" type="submit" class="btn btn-default float-right">취소</button>
      </div>
   </div>
   </div>
   

<script src="<%=request.getContextPath()%>/resources/plugins/jquery/jquery.min.js"></script>
   
   <script>
   
   
   $(document).ready(function() {
     $("#CancelButton").on("click", function(){
    	self.location = "/ref/list";
     });
     });
      
   </script>
</body>

