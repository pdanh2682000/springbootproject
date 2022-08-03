<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>

<c:url var="UserAPI" value="/api/user"/>
<c:url var="UserURL" value="/admin/user/list"/>
<c:url var="CreateUserURL" value="./edit" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách User</title>
</head>
<body>
<c:if test="${not empty message}">
	<div class="alert alert-${alert}" id="messageAndAlert">
		<spring:message code="${message}" />
	</div>
</c:if>
	<div class="widget-box table-filter">
		<div class="table-btn-controls">
			<div class="pull-right tableTools-container">
				<h1 class="text-center" style="color: yellowgreen;">Users</h1>
				<div class="dt-buttons btn-overlap btn-group" style="float: left; padding-left: 10px; padding-bottom: 10px;">
					
					<a flag="info"
						class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
						data-toggle="tooltip" title='Thêm user' href='${CreateUserURL}'>
						<span> <i class="fa fa-plus-circle bigger-110 purple"></i>
					</span>
					</a>
				</div>
			</div>
		</div>
	</div>
<form action="<c:url value='/admin/user/list'/>" id="formSubmit" method="get">
	<div class="table-responsive">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>Fullname</th>
					<th>Email</th>
					<th>Avatar</th>
					<th>Phone</th>
					<th>Status</th>
					<th>Thao tác</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${list_user.results}">
					<tr>
						<td>${item.username}</td>
						<td>${item.password}</td>
						<td>${item.fullName}</td>
						<td>${item.email}</td>
						<td>${item.avatar}</td>
						<td>${item.phone}</td>
						<td>${item.status}</td>
						<td style="text-align: center;">
							<c:url var="updateUserURL" value="./edit">
								<c:param name="id" value="${item.id}"></c:param>
							</c:url>
							<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
								title="Cập nhật user" href='${updateUserURL}'> <ion-icon
									name="create-outline" title="Cập nhật user"></ion-icon>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul style="padding-bottom: 20px;" class="pagination" id="pagination"></ul>
		<input type="hidden" value="" id="page" name="page"/>
		<input type="hidden" value="" id="limit" name="limit"/>	
	</div>
</form>
<spring:message var="confirmDelete" code="confirm_delete"/>
<spring:message var="confirmDeleteText" code="confirm_delete_text"/>
<spring:message var="confirmButtonText" code="confirm_button_text"/>
<spring:message var="cancelButtonText" code="cancel_button_text"/>
<script type="text/javascript">
	var totalPages = ${list_user.totalPage};
	var currentPage = ${list_user.page};
	var limit = 5;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
            	if (currentPage != page) {
        			$('#limit').val(limit);
        			$('#page').val(page);
        			$('#formSubmit').submit();
            	}
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
    
	$('#messageAndAlert').fadeOut(5000);
</script>
</body>
</html>