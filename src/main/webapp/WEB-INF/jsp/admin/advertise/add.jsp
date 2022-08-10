<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Advertise</title>
</head>
<body>
	<div class="panel panel-primary" style="padding: 20px;">
		<div class="panel-heading">
			<h3 class="panel-title" style="color: yellowgreen; padding-bottom: 20px;">Thêm mới quảng cáo</h3>
		</div>
		<div class="panel-body">
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}" id="messageAndAlert">
					<spring:message code="${message}" />
				</div>
			</c:if>
			<form:form modelAttribute="advertiseDTO" method="POST">
				<form:errors cssClass="error" />
				<div class="form-group">
					<form:label path="titleAdvertise">Tên quảng cáo:</form:label>
					<form:input path="titleAdvertise" type="text" class="form-control"
						id="inputTitleAdvertise" />
					<form:errors path="titleAdvertise" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="descriptionAdvertise">Mô tả quảng cáo:</form:label>
					<form:input path="descriptionAdvertise" type="text" class="form-control"
						id="inputDescriptionAdvertise" />
					<form:errors path="descriptionAdvertise" cssClass="error" />
				</div>
					<button type="submit" class="btn btn-primary">Thêm mới</button>
				<button class="btn btn-danger" type="reset">
					<i class="ace-icon fa fa-undo bigger-110"></i>
						Hủy
				</button>
			</form:form>
		</div>
	</div>
<script>
	$('#messageAndAlert').fadeOut(5000);
</script>
</body>
</html>