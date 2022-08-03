<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
</head>
<body>
	<div class="panel panel-primary" style="padding: 20px;">
		<div class="panel-heading">
			<h3 class="panel-title" style="color: yellowgreen; padding-bottom: 20px;">Thêm mới User</h3>
		</div>
		<div class="panel-body">
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}" id="messageAndAlert">
					<spring:message code="${message}" />
				</div>
			</c:if>
			<form:form modelAttribute="userDTO" method="POST" enctype="multipart/form-data">
				<form:errors cssClass="error" />
				<div class="form-group">
					<form:label path="username">Username:</form:label>
					<form:input path="username" type="text" class="form-control"
						id="username" placeholder="your username" />
					<form:errors path="username" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="roleCode">Role:</form:label>
					<form:select id="roleCode" path="roleCode">
				  	 	<form:options items="${roles}" />
					</form:select>
					<form:errors path="roleCode" cssClass="error" />
				</div>
				<div class="form-group">
					<label for="avatar">Avatar</label>
					<input id="avatar" name="file" type="file" class="form-control"/>
				</div>
					<div class="form-group">
						<form:label path="password">Password:</form:label>
						<form:input path="password" type="password" class="form-control"
							id="password" placeholder="your password" />
						<form:errors path="password" cssClass="error" />
					</div>
				<div class="form-group">
					<form:label path="fullName">Full Name:</form:label>
					<form:input path="fullName" type="text" class="form-control"
						id="fullName" placeholder="Phan Duy Anh" />
					<form:errors path="fullName" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="email">Email:</form:label>
					<form:input path="email" type="email" class="form-control"
						id="email" placeholder="demo@gmail.com" />
					<form:errors path="email" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="phone">Phone:</form:label>
					<form:input path="phone" type="text" class="form-control"
						id="phone" placeholder="" />
					<form:errors path="phone" cssClass="error" />
				</div>
				<form:hidden path="id" id="userId"/>
				<c:if test="${not empty userDTO.id}">
					<button type="submit" class="btn btn-primary">Cập nhật</button>
				</c:if>
				<c:if test="${empty userDTO.id}">
					<button type="submit" class="btn btn-primary">Thêm mới</button>
				</c:if>
				<button class="btn btn-danger" type="reset">
					<i class="ace-icon fa fa-undo bigger-110"></i>
						Hủy
				</button>
			</form:form>
		</div>
	</div>
<script>
	/* 
	var editor = ""; // data cua editor khi thay the cho textarea
	$(document).ready(function(){
		editor = CKEDITOR.replace('content');
	});
	*/
	
	var checkRequiredField = "${userDTO.id}";
	if(checkRequiredField == ""){
		$("#username, #password, #email").attr("required", true);
	}
	
	$('#messageAndAlert').fadeOut(5000);
</script>
</body>
</html>