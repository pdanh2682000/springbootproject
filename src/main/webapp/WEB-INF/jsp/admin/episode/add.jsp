<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Episode</title>
</head>
<body>
	<div class="panel panel-primary" style="padding: 20px;">
		<div class="panel-heading">
			<h3 class="panel-title"
				style="color: yellowgreen; padding-bottom: 20px;">Thêm mới
				episode</h3>
		</div>
		<div class="panel-body">
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}" id="messageAndAlert">
					<spring:message code="${message}" />
				</div>
			</c:if>
			<c:if test="${empty message}">
				<c:if test="${param.message != null}">
					<div class="alert alert-${param.alert}" id="messageAndAlert">
						<spring:message code="${param.message}" />
					</div>
				</c:if>
			</c:if>
			<form:form modelAttribute="episodeDTO" method="POST"
				enctype="multipart/form-data">
				<form:errors cssClass="error" />
				<div class="form-group">
					<form:label path="filmId">Tên phim:</form:label>
					<form:select id="filmId" path="filmId">
						<form:option value="" label="--- Chọn phim ---" />
						<form:options items="${listFilmName}" />
					</form:select>
					<form:errors path="filmId" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="episodeName">Tên episode:</form:label>
					<form:input path="episodeName" type="text" class="form-control"
						id="inputEpisodeName" placeholder="Bộ tập phim về ..." />
					<form:errors path="episodeName" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="episodeDescription">Mô tả episode:</form:label>
					<form:input path="episodeDescription" type="text"
						class="form-control" id="inputEpisodeDescription"
						placeholder="Kể về một gia đình ..." />
					<form:errors path="episodeDescription" cssClass="error" />
				</div>
				<div class="form-group">
					<label for="episodeUrl">Episode url:</label> <input id="episodeUrl"
						name="file" type="file" class="form-control" />
					<form:errors path="episodeUrl" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="episode">Episode:</form:label>
					<form:input path="episode" type="text" class="form-control"
						id="inputEpisode" placeholder="0, 1, 2, ..." />
					<form:errors path="episode" cssClass="error" />
				</div>
				<button type="submit" class="btn btn-primary">Thêm mới</button>
				<button class="btn btn-danger" type="reset">
					<i class="ace-icon fa fa-undo bigger-110"></i> Hủy
				</button>
			</form:form>
		</div>
	</div>
	<script>
		$('#messageAndAlert').fadeOut(5000);
	</script>
</body>
</html>