<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>

<c:url var="FilmAPI" value="/api/film"/>
<c:url var="FilmURL" value="/admin/film/list"/>
<c:url var="CreateFilmURL" value="./edit" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Film</title>
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
				<h1 class="text-center" style="color: yellowgreen;">Films</h1>
				<div class="dt-buttons btn-overlap btn-group" style="float: right; padding-bottom: 10px;">
					
					<a flag="info"
						class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
						data-toggle="tooltip" title='Thêm film' href='${CreateFilmURL}'>
						<span> <i class="fa fa-plus-circle bigger-110 purple"></i>
					</span>
					</a>
					<button id="btnDelete" type="button"
						onclick="warningBeforeDelete()"
						class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
						data-toggle="tooltip" title='Xóa films' style="border-left: 1px solid white" disabled>
						<ion-icon name="trash-outline"></ion-icon>
					</button>
				</div>
			</div>
		</div>
	</div>
<form action="<c:url value='/admin/film/list'/>" id="formSubmit" method="get">
	<div class="table-responsive">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>All<input type="checkbox" onClick="checkAll(this)"></th>
					<th>Tên film</th>
					<th>Tác giả</th>
					<th>Diễn viên</th>
					<th>Nội dung</th>
					<th>Mô tả ngắn</th>
					<th>Thể loại</th>
					<th>Thời lượng</th>
					<th>Năm sản xuất</th>
					<th>Url</th>
					<th>Trailer</th>
					<th>Slide</th>
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
						<td>${item.trailer}</td>
						<td>${item.posterSlide}</td>
						<td style="text-align: center;">
							<c:url var="updateFilmURL" value="./edit">
								<c:param name="id" value="${item.id}"></c:param>
							</c:url>
							<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
								title="Cập nhật film" href='${updateFilmURL}'> <ion-icon
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
    
    $("tbody input[type=checkbox]").on("change", function(){
    	  if ($("tbody input[type=checkbox]:checked").length > 0)
    	  {
    	      $("#btnDelete").removeAttr('disabled','disabled');
    	      // console.log($("tbody input[type=checkbox]:checked").length);
    	  }
    	  else
    	  {
    	      $("#btnDelete").attr('disabled','disabled');
    	  }
    });
    
    function checkAll(source) {
    	  checkboxes = $('tbody input[type=checkbox]');
    	  for(var i=0, n=checkboxes.length;i<n;i++) {
    	    checkboxes[i].checked = source.checked;
    	  }
    	  if ($("tbody input[type=checkbox]:checked").length > 0)
    	  {
    	      $("#btnDelete").removeAttr('disabled','disabled');
    	      console.log($("tbody input[type=checkbox]:checked").length);
    	  }
    	  else
    	  {
    	      $("#btnDelete").attr('disabled','disabled');
    	  }
    }
    
    function warningBeforeDelete() {
		swal({
			  title: "${confirmDelete}",
			  text: "${confirmDeleteText}",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonClass: "btn-success",
			  cancelButtonClass: "btn-danger",
			  confirmButtonText: "${confirmButtonText}",
			  cancelButtonText: "${cancelButtonText}",
			}).then(function(isConfirm) {
			  if (isConfirm.value == true) {
				  	// get data
					var ids = $('tbody input[type=checkbox]:checked').map(function () {
			            return $(this).val();
			        }).get();
					
					// call API DELETE, boot thẳng vào mảng luôn, không cần convert Object, Spring mà đương nhiên mạnh
					deleteNew(ids);
				// console.log('ok!');
			  }
			});
	}
	
	function deleteNew(data) {
        $.ajax({
            url: '${FilmAPI}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
            	window.location.href = "${FilmURL}?message=delete_film_success&alert=success";
            },
            error: function (error) {
            	window.location.href = "${FilmURL}?message=delete_film_fail&alert=danger";
            }
        });
	}
	
	$('#messageAndAlert').fadeOut(5000);
</script>
</body>
</html>