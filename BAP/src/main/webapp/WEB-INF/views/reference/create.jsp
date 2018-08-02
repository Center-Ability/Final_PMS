<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<% 
 response.setHeader("Cache-Control","no-cache"); 
 response.setHeader("Pragma","no-cache"); 
 response.setDateHeader("Expires",0); 
%>
<!DOCTYPE html>
<body>

   <div id="wrap" class="card card-warning" style="margin:10px auto; width: 960px; height: 755px;">
      <div class="card-header" style="background: #ffc107;">
         <h3 class="card-title">게시글 작성</h3>
      </div>
      <div class="card-body" style="overflow-y: scroll; height: 654px;">
         <form id="createForm" role="form" name="createForm" enctype="multipart/form-data">
            <div class="form-group">
               <label>제목</label>
               <input name="doc_title" type="text" class="form-control" placeholder="Enter ...">
            </div>
            <div class="form-group">
               <label>내용</label>
               <textarea name="doc_content" class="form-control" rows="10" placeholder="Enter ..."></textarea>
            </div>
            <div class="form-group">
               <label for="exampleInputFile" style="margin-right: 50px;">파일 선택</label>
               <div class="input-group">
                  <div class="custom-file">
                     <input name="file" class="custom-file-input" type="file" id="InputFile1" onchange="fileUpload(this)">
                     <label id="fileLabel1" class="custom-file-label" for="InputFile1">파일을 선택해주세요.</label>
                     <input id="file_nameInput1" type="hidden" name="file_name" value="123123"/>
                  </div>
               </div>
            </div>
            
            <div id="addFileDiv" class="form-group">
               <button id="addFileInput" type="button" class="btn btn-block btn-default"><i class="fa fa-plus"></i> 추가</button>
            </div>
            
            <div class="form-group">
               <label>작성자</label>
               <input name="mem_name" value="${loginUser.mem_name}" type="text" class="form-control" disabled="">
               <input type="hidden" name="mem_id" value="${loginUser.mem_id}"/>
            </div>
         </form>
      </div>
      <div class="card-footer">
         <button id="createSubmitButton" type="submit" class="btn btn-info">등록</button>
         <button id="createCancelButton" type="submit" class="btn btn-default float-right">취소</button>
      </div>
   </div>
   
   <!-- jQuery -->
   <script src="<%=request.getContextPath()%>/resources/plugins/jquery/jquery.min.js"></script>
   
   <script>
   var inputCount = 2;
   
   $(document).ready(function() {
      var formObj = $("form[role='form']");
      console.log(formObj);

      $("#createSubmitButton").on("click", function() {
         formObj.attr("action", "/ref/create");
         formObj.attr("method", "post");
         formObj.submit();
      });
      
      $("#createCancelButton").on("click", function(){
    	 self.location="/ref/list"; 
      });
      
      
      
      // 파일 등록 폼 추가 버튼 이벤트
      $("#addFileInput").on("click", function() {
         var div1 = $('<div id="addFormDiv'+inputCount+'" class="form-group">');
         var label1 = $('<label style="margin-right: 50px;" for="exampleInputFile">파일 선택</label>');
         var button = $('<button id="removeInputButton'+inputCount+'" onclick="removeInputForm(this)" style="display: inline; width: 50px;" type="button" class="btn btn-block btn-danger btn-sm">')
         var div2 = $('<div class="input-group">');
         var div3 = $('<div class="custom-file">');
         var input2 = $('<input id="file_nameInput'+inputCount+'" type="hidden" name="file_name" value="123"/>')
         var input = $('<input name="file" class="custom-file-input" type="file" id="InputFile'+inputCount+'" onchange="fileUpload(this)">');
         var label2 = $('<label id="fileLabel'+inputCount+'" class="custom-file-label" for="InputFile'+inputCount+'">');
         var str = "파일을 선택해주세요.";
         var str2 = "삭제";
         
         label2.append(str);
         button.append(str2);
         div3.append(input).append(label2).append(input2);
         div2.append(div3);
         div1.append(label1).append(button).append(div2);
         
         $("#addFileDiv").before(div1);
         
         inputCount++;
      });
      
   });
   
   function removeInputForm(e) {
      var id = document.getElementById(e.getAttribute("id")).getAttribute("id");
      var num = id.replace("removeInputButton","");
      $('#addFormDiv'+num).remove();
      inputCount--;
   }
   
   function fileUpload(fis) {
      var idNum = document.getElementById(fis.getAttribute("id")).getAttribute("id");
      var LabelNum = idNum.replace("InputFile","");
      document.getElementById("fileLabel"+LabelNum).innerHTML = fis.value.substring(fis.value.lastIndexOf("\\")+1);
      $('#file_nameInput'+LabelNum).attr('value', fis.value.substring(fis.value.lastIndexOf("\\")+1));
   }
   
   </script>
</body>














