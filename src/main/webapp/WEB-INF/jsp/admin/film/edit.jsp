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
			<h3 class="panel-title" style="color: yellowgreen; padding-bottom: 20px;">Thêm mới Film</h3>
		</div>
		<div class="panel-body">
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}" id="messageAndAlert">
					<spring:message code="${message}" />
				</div>
			</c:if>
			<form:form modelAttribute="filmDTO" method="POST" enctype="multipart/form-data">
				<form:errors cssClass="error" />
				<div class="form-group">
					<form:label path="title">Tên phim:</form:label>
					<form:input path="title" type="text" class="form-control"
						id="inputTitle" placeholder="Chị chị em em" />
					<form:errors path="title" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="categoryCode">Thể loại:</form:label>
					<form:select id="categoryCode" path="categoryCode">
				  	 	<form:option value="" label="--- Chọn thể loại ---" />
				  	 	<form:options items="${categories}" />
					</form:select>
					<form:errors path="categoryCode" cssClass="error" />
				</div>
				<div class="form-group">
					<label for="poster">Poster:</label>
					<input id="poster" name="file" type="file" class="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="content">Nội dung:</form:label>
					<form:textarea path="content" class="form-control"
						id="inputContent" placeholder="Kể về gia đình ..." />
					<form:errors path="content" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="shortDescription">Mô tả:</form:label>
					<form:input path="shortDescription" type="text" class="form-control"
						id="inputShortDescription" placeholder="Phim nói về ..." />
					<form:errors path="shortDescription" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="actor">Diễn viên ( phân biệt bởi ';' ):</form:label>
					<form:input path="actor" type="text" class="form-control"
						id="inputActor" placeholder="Chi Pu" />
					<form:errors path="actor" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="author">Tác giả:</form:label>
					<form:input path="author" type="text" class="form-control"
						id="inputAuthor" placeholder="Danh Uy Carry" />
					<form:errors path="author" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="publishDate">Năm sản xuất:</form:label>
					<form:input path="publishDate" type="text" class="form-control"
						id="inputPublishDate" placeholder="2022" />
					<form:errors path="publishDate" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="filmLength">Độ dài film:</form:label>
					<form:input path="filmLength" type="text" class="form-control"
						id="inputFilmLength" placeholder="1000" />
					<form:errors path="filmLength" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="trailer">Trailer URL:</form:label>
					<form:input path="trailer" type="text" class="form-control"
						id="inputTrailer" placeholder="https://www.youtube.com/embed/..." />
					<form:errors path="trailer" cssClass="error" />
				</div>
				<form:hidden path="id" id="filmId"/>
				<c:if test="${not empty filmDTO.id}">
					<button type="submit" class="btn btn-primary">Cập nhật</button>
				</c:if>
				<c:if test="${empty filmDTO.id}">
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
	var editor = ""; // data cua editor khi thay the cho textarea
	$(document).ready(function(){
		editor = CKEDITOR.replace('content');
	});
	$('#messageAndAlert').fadeOut(5000);
</script>
</body>
</html>