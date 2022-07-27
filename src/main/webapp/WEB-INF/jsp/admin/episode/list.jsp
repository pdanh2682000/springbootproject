<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<c:url var="CreateEpisodeURL" value="./add" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Episode</title>
</head>
<body>
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
	<div class="widget-box table-filter">
		<div class="table-btn-controls">
			<div class="pull-right tableTools-container">
				<h1 class="text-center" style="color: yellowgreen;">Episode</h1>
				<div class="dt-buttons btn-overlap btn-group" style="float: left; padding-left: 10px; padding-bottom: 10px;">
				
					
					<a flag="info"
						class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
						data-toggle="tooltip" title='Thêm episode' href='${CreateEpisodeURL}'>
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
					<th>Episode Name</th>
					<th>Episode Description</th>
					<th>Episode Url</th>
					<th>Episode</th>
					<th>Film Name</th>
					<th>Film Id</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${list_episode.results}">
					<tr>
						<td>${item.episodeName}</td>
						<td>${item.episodeDescription}</td>
						<td>${item.episodeUrl}</td>
						<td>${item.episode}</td>
						<td>${item.filmName}</td>
						<td>${item.filmId}</td>
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