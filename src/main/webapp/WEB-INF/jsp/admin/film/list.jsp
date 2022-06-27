<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Film</title>
</head>
<body>
	<div class="widget-box table-filter">
		<div class="table-btn-controls">
			<div class="pull-right tableTools-container">
				<h1 class="text-center" style="color: yellowgreen;">Films</h1>
				<div class="dt-buttons btn-overlap btn-group" style="float: right; padding-bottom: 10px;">
				
					<c:url var="createFilmURL" value="./edit" />
					
					<a flag="info"
						class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
						data-toggle="tooltip" title='Thêm bài viết' href='${createFilmURL}'>
						<span> <i class="fa fa-plus-circle bigger-110 purple"></i>
					</span>
					</a>
					<button id="btnDelete" type="button"
						onclick="warningBeforeDelete()"
						class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
						data-toggle="tooltip" title='Xóa bài viết' style="border-left: 1px solid white">
						<ion-icon name="trash-outline"></ion-icon>
					</button>
				</div>
			</div>
		</div>
	</div>
<c:if test="${not empty message}">
	<div class="alert alert-${alert}">
		<spring:message code="${message}" />
	</div>
</c:if>
<form action="<c:url value='/admin/film/list'/>" id="formSubmit" method="get">
	<div class="table-responsive">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkAll"></th>
					<th>Tên film</th>
					<th>Tác giả</th>
					<th>Diễn viên</th>
					<th>Nội dung</th>
					<th>Mô tả ngắn</th>
					<th>Thể loại</th>
					<th>Thời lượng</th>
					<th>Năm sản xuất</th>
					<th>Url</th>
					<th>Thao tác</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${list_film.results}">
					<tr>
						<td><input type="checkbox" id="checkbox_${item.id}"
							value="${item.id}"></td>
						<td>${item.title}</td>
						<td>${item.actor}</td>
						<td>${item.author}</td>
						<td>${item.content}</td>
						<td>${item.shortDescription}</td>
						<td>${item.categoryName}</td>
						<td>${item.filmLength}</td>
						<td>${item.publishDate}</td>
						<td>${item.url}</td>
						<td style="text-align: center;">
							<c:url var="updateFilmURL" value="./edit">
								<c:param name="id" value="${item.id}"></c:param>
							</c:url>
							<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
								title="Cập nhật bài viết" href='${updateFilmURL}'> <ion-icon
									name="create-outline" title="Cập nhật bài viết"></ion-icon>
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
<script type="text/javascript">
	var totalPages = ${list_film.totalPage};
	var currentPage = ${list_film.page};
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
</script>
</body>
</html>