<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Films</title>
</head>
<body>
	<div class="panel panel-primary" style="padding: 20px;">
		<div class="panel-heading">
			<h3 class="panel-title" style="color: yellowgreen; padding-bottom: 20px;">Thêm mới Role</h3>
		</div>
		<div class="panel-body">
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}" id="messageAndAlert">
					<spring:message code="${message}" />
				</div>
			</c:if>
			<form:form modelAttribute="roleDTO" method="POST">
				<form:errors cssClass="error" />
				<div class="form-group">
					<form:label path="name">Tên Role:</form:label>
					<form:input path="name" type="text" class="form-control"
						id="inputName" placeholder="ADMIN" />
					<form:errors path="name" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="code">Code:</form:label>
					<form:input path="code" type="text" class="form-control"
						id="inputCode" placeholder="ROLE_ADMIN" />
					<form:errors path="code" cssClass="error" />
				</div>
					<button type="submit" class="btn btn-primary">Thêm mới</button>
				<form:button class="btn btn-danger" type="reset">
					<i class="ace-icon fa fa-undo bigger-110"></i>
						Hủy
				</form:button>
			</form:form>
		</div>
	</div>
<script>
	$('#messageAndAlert').fadeOut(5000);
</script>
</body>
</html>