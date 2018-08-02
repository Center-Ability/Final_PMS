<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<title>B.A.P P_M_S</title>

<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Bootstrap 3.3.4 -->
<link
	href="<%=request.getContextPath()%>/resources/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- ADD calendar  -->
<link href="<%=request.getContextPath()%>/resources/css/calendar.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link
	href="<%=request.getContextPath()%>/resources/dist/css/adminlte.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/resources/fullcalendar/fullcalendar.min.css"
	rel='stylesheet' />
<link
	href='<%=request.getContextPath()%>/resources/fullcalendar/fullcalendar.print.min.css'
	rel='stylesheet' media='print' />
<script
	src='<%=request.getContextPath()%>/resources/fullcalendar/lib/moment.min.js'></script>
<script
	src='<%=request.getContextPath()%>/resources/fullcalendar/lib/jquery.min.js'></script>
<script
	src='<%=request.getContextPath()%>/resources/fullcalendar/fullcalendar.min.js'></script>
<!-- 모달 사용시 넣어줄 jQuery -->
<script
	src='<%=request.getContextPath()%>/resources/plugins/bootstrap/js/bootstrap.min.js'></script>
<style>
body {
	margin: 20px 0px;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
	height: 800px;
}
div#wrapp {
	width: 960px;
	margin: 0 auto;
}
</style>

</head>
<body class="hold-transition sidebar-mini">

	<div id="wrapp">
	<div class="wrapper">
		<div style="margin-left: 10px;">
			<!-- 상단바 -->
			<nav style="margin-left: 0px; margin-right: 0px;"
				class="main-header navbar navbar-expand bg-white navbar-light border-bottom">
				<!-- Left navbar links -->
				<ul class="navbar-nav">
					
					<c:choose>
						<c:when test="${loginUser.mem_rank eq '팀원'}">
							<li class="nav-item d-none d-sm-inline-block">
							<a href="/home/mem" class="nav-link" style="color: #343a40; margin-left: 0px;"><strong>HOME_PMS</strong></a></li>
						</c:when>
						<c:when test="${loginUser.mem_rank eq '팀장'}">
							<li class="nav-item d-none d-sm-inline-block">
							<a href="/home/pm" class="nav-link" style="color: #343a40; margin-left: 0px;"><strong>HOME_PMS</strong></a></li>
						</c:when>
						<c:when test="${loginUser.mem_rank eq '품질관리팀'}">
							<li class="nav-item d-none d-sm-inline-block">
							<a href="/home/qm" class="nav-link" style="color: #343a40; margin-left: 0px;"><strong>HOME_PMS</strong></a></li>
						</c:when>
						<c:when test="${loginUser.mem_rank eq '관리자'}">
							<li class="nav-item d-none d-sm-inline-block">
							<a href="/home/manager" class="nav-link" style="color: #343a40; margin-left: 0px;"><strong>HOME_PMS</strong></a></li>
						</c:when>
					</c:choose>
					
					<li class="nav-item d-none d-sm-inline-block"><a
						href="/project/detail" class="nav-link"
						style="color: #343a40; margin-left: 0px;"><strong>PROJECT</strong></a></li>
					
					<c:if test ='${loginUser.mem_rank eq "팀원"}'>
						<li class="nav-item d-none d-sm-inline-block"><a
						href="/task/list" class="nav-link"
						style="color: #343a40; margin-left: 0px;"><strong>TASK</strong></a></li>
					</c:if>
					
					<c:if test ='${loginUser.mem_rank eq "팀장"}'>
						<li class="nav-item d-none d-sm-inline-block"><a
						href="/task/list" class="nav-link"
						style="color: #343a40; margin-left: 0px;"><strong>TASK</strong></a></li>
					</c:if>
					
					<li class="nav-item d-none d-sm-inline-block"><a
						href="/notice/list" class="nav-link"
						style="color: #343a40; margin-left: 0px;"><strong>NOTICE</strong></a></li>
					
					<c:if test ='${loginUser.mem_rank eq "팀원" }'>
						<li class="nav-item d-none d-sm-inline-block"><a
							href="/sns/list" class="nav-link"
							style="color: #343a40; margin-left: 0px;"><strong>SNS</strong></a></li>
					</c:if>
					
					<c:if test ='${loginUser.mem_rank eq "팀장" }'>
						<li class="nav-item d-none d-sm-inline-block"><a
							href="/sns/list" class="nav-link"
							style="color: #343a40; margin-left: 0px;"><strong>SNS</strong></a></li>
					</c:if>
					
					<c:if test ='${loginUser.mem_rank eq "팀원" }'>
						<li class="nav-item d-none d-sm-inline-block"><a
						href="/project/unit" class="nav-link"
						style="color: #343a40; margin-left: 0px;"><strong>CALENDAR</strong></a></li>
					</c:if>
					
					<c:if test ='${loginUser.mem_rank eq "팀장" }'>
						<li class="nav-item d-none d-sm-inline-block"><a
						href="/project/unit" class="nav-link"
						style="color: #343a40; margin-left: 0px;"><strong>CALENDAR</strong></a></li>
					</c:if>
						
					<c:if test ='${loginUser.mem_rank eq "팀원"}'>
						<li class="nav-item d-none d-sm-inline-block"><a
						href="/ref/list" class="nav-link"
						style="color: #343a40; margin-left: 0px;"><strong>REFERENCE</strong></a></li>
					</c:if>
					
					<c:if test ='${loginUser.mem_rank eq "팀장"}'>
						<li class="nav-item d-none d-sm-inline-block"><a
						href="/ref/list" class="nav-link"
						style="color: #343a40; margin-left: 0px;"><strong>REFERENCE</strong></a></li>
					</c:if>
					
					<c:if test ="${loginUser.mem_rank == '관리자'}">
						<li class="nav-item d-none d-sm-inline-block">
						<a href="/manager/userlist" class="nav-link" style="color: #343a40; margin-left: 0px;">
						<strong>USER</strong></a></li>
					</c:if>
						
					<li class="nav-item d-none d-sm-inline-block"
						style="color: #343a40; margin-left: 50px; width:140px;"><a href="#"
						class="nav-link"><strong>${loginUser.mem_name}[${loginUser.mem_rank}]</strong></a></li>

					<li class="nav-item d-none d-sm-inline-block"
						style="color: #343a40; margin-left: 0px"><a
						href="/login/logout" class="nav-link"><strong>logout</strong></a></li>
					
				</ul>

			</nav>
		</div>
		</div>
		<button type="button" class="btn btn-primary" id="creUnitBtn"
			style="float: right; margin-right: 50px; margin-top: 10px;">등록하기</button>

		<div id=calendar></div>
	</div>


	<!--단위 업무 등록 모달 -->
	<div class="modal fade" id="createModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">단위업무 등록</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>프로젝트명</label>
						<input type="text" class="form-control" value="${pro_name}" disabled>
					</div>
					<form id="createForm">
						<div class="form-group">
							<label>단위업무명</label>
							<input type="text" class="form-control" id="unit_title" name="unit_title">
						</div>
						<div class="form-group">
							<label>담당자</label>
							<select class="form-control" id="unit_mem" name="mem_id"></select>
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows="3" id="unit_content" name="unit_content"></textarea>
						</div>
						<div class="form-group">
							<label>단위업무 기간</label>
							<div class="input-group">
								<div class="input-group-addon"></div>
								<input type="date" class="form-control pull-right"
									name="unit_start" style="width: 15px"/>
								<input type="date" class="form-control pull-right"
									name="unit_end" style="width: 15px"/>
							</div>
							<!-- /.input group -->
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="createUnitBtn">등록</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 세부 업무 모달 -->
	<div class="modal fade" id="detailModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">단위업무상세보기</h4>
				</div>
				<div class="modal-body">
						<div class="form-group">
							<label>프로젝트명</label> <input type="text" class="form-control"
								disabled="disabled" id="pro_name" name="pro_name">
								<input id="unit_no_str" name="unit_no_str" type="hidden"/>
						</div>

						<div class="form-group">
							<label>단위업무명</label> <input type="text" class="form-control"
								placeholder="Enter..." disabled="disabled" id="unit_title"
								name="unit_title">
						</div>

						<div class="form-group">
							<label>담당자</label> <input type="text" class="form-control"
								disabled="disabled" id="mem_name" name="mem_name">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows="3" placeholder="Enter ..."
								disabled="disabled" id="unit_content" name="unit_content"></textarea>
						</div>

						<div class="form-group">
							<label>진행 상황</label> <select class="form-control"
								id="unit_status" name="unit_status" disabled>
								<option value=0>대기중</option>
								<option value=1>진행중</option>
								<option value=2>완료</option>
							</select>
						</div>


						<div class="form-group">
							<label>단위업무 기간</label>

							<div class="input-group">
								<div class="input-group-addon"></div>
								<input type="text" class="form-control pull-right"
									disabled="disabled" id="unit_start2" name="unit_start2"
									style="width: 15px"> <input type="text"
									class="form-control pull-right" disabled="disabled"
									id="unit_end" name="unit_end" style="width: 15px">
							</div>
							<!-- /.input group -->
						</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id=deleteUnitBtn>삭제</button>
				</div>
			</div>
		</div>
	</div>

	<script>
		$('#creUnitBtn').on('click', function(event) {
			$("#createModal").modal('show');
			$.ajax({
				url : '/project/unit/create',
				type : 'get',
				datatype : 'json',
				success : function(data) {
					var TeamList = data.unitTeamList
					var select = $('#unit_mem');
					select.html("");
					
					for ( var index in TeamList) {
						var list = {};
						var option = $('<option>').val(TeamList[index].mem_id).text(TeamList[index].mem_name);
						select.append(option);

					}

				}

			});

		});

		$('#createUnitBtn').on('click', function(event) {
			
			var form = $('form[id="createForm"]');
			var data = form.serialize();
						
			$.ajax({
				url : '/project/unit/create',
				type : 'post',
				data : data,
				datatype : 'json',
				success : function(data) {
					alert(data);
					window.location.reload(true);
				}
			});
		});

		$('#deleteUnitBtn').on('click', function(event) {
			var value = document.getElementById('unit_no_str').getAttribute('value');
			
			
			var data = {"unit_no_str" : value}

			$.ajax({
				url : '/project/unit/delete',
				type : 'get',
				data : data,
				success : function(data) {
					alert(data);
				}
			});
			
			location.reload();

		});

		var calendar = function() {
			$('#calendar').fullCalendar({
				header : {
					left : 'prev,next today',
					center : 'title',
					right : 'month,basicWeek,basicDay'
				},
				defaultDate : new Date(),
				navLinks : true, // can click day/week names to navigate views 
				editable : false,
				eventLimit : true, // allow "more" link when too many events 

				events : function(start, end, timezone,callback) {
					$.ajax({
						url : '/project/unit',
						type : 'post',
						contentType : 'application/json; charset=UTF-8',
						datatype : 'json',
						success : function(data) {
							var list = data.unitDTOList;
							var events = [];
							for ( var index in list) {
								start = moment(list[index].unit_start).format('YYYY/MM/DD');
								end = moment(list[index].unit_end).format('YYYY/MM/DD hh:mm:ss');

								var event = {};

								event.unit_no = list[index].unit_no;
								event.title = list[index].unit_title;
								event.start = start;
								event.end = end;
								event.content = list[index].unit_content;
								event.status = list[index].unit_status;
								event.pro_num = list[index].pro_num;
								event.pro_name = list[index].pro_name;
								event.mem_id = list[index].mem_id;
								event.mem_name = list[index].mem_name;

								events.push(event);

							}

							callback(events);
						}
					});

				},

				eventClick : function(event, jsEvent, view) {
					$(".modal-body #unit_title").val(event.title);
					$(".modal-body #unit_content").val(event.content);
					$(".modal-body #unit_start2").val(moment(event.start).format('YYYY/MM/DD'));
					$(".modal-body #unit_end").val(moment(event.end).format('YYYY/MM/DD'));
					$(".modal-body #unit_status").val(event.status);
					$(".modal-body #mem_id").val(event.mem_id);
					$(".modal-body #mem_name").val(event.mem_name);
					$(".modal-body #pro_name").val(event.pro_name);
					$(".modal-body #pro_num").val(event.pro_num);
					$(".modal-body #unit_no_str").val(event.unit_no);
					
					$("#detailModal").modal('show');
				},

				dayClick : function(event, jsEvent, view) {
					
				}
			});
		}
		
		$(document).ready(function() {
			calendar();
		});
	</script>
</body>
