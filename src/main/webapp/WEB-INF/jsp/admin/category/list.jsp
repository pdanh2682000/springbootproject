<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<c:url var="CreateCategoryURL" value="./add" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Thể loại</title>
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
				<h1 class="text-center" style="color: yellowgreen;">Thể loại</h1>
				<div class="dt-buttons btn-overlap btn-group" style="float: left; padding-left: 10px; padding-bottom: 10px;">
				
					
					<a flag="info"
						class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
						data-toggle="tooltip" title='Thêm bài viết' href='${CreateCategoryURL}'>
						<span> <i class="fa fa-plus-circle bigger-110 purple"></i>
					</span>
					</a>
				</div>
			</div>
		</div>
	</div>
<form action="" id="formSubmit" method="get">
	<div class="table-responsive">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Code</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${list_category.results}">
					<tr>
						<td>${item.name}</td>
						<td>${item.code}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="hidden" value="" id="page" name="page"/>
		<input type="hidden" value="" id="limit" name="limit"/>	
	</div>
</form>
<script type="text/javascript">
	$('#messageAndAlert').fadeOut(5000);
</script>
</body>
</html>