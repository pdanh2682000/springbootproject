<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0,maximum-scale=1">
	
	<title><sitemesh:write property='title'/></title>
	
	
	<!-- Loading third party fonts -->
	<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|"
		rel="stylesheet" type="text/css">
	<link href="<c:url value='/templates/web/fonts/font-awesome.min.css' />" rel="stylesheet" type="text/css">
	
	<!-- Loading main css file -->
	<link rel="stylesheet" href="<c:url value='/templates/web/style.css' />">
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<!--[if lt IE 9]>
		<script src="<c:url value='/templates/web/js/ie-support/html5.js' />"></script>
		<script src="<c:url value='/templates/web/js/ie-support/respond.js' />"></script>
	<![endif]-->
	<style>
		.checked {
  			color: orange;
		}
		
		.poster-item {
			cursor: pointer;
		}
		
		.section-title {
			font-weight: 300;
			color: #dd5e89;
		}
		
		.modal-title {
			color: #02aab0;
		}
		
		.modal-content-style {
			font-style: italic;
		}
	</style>
</head>
<body>

	<div id="site-content">
	
		<%@ include file="/commons/web/header.jsp"%>	
		
		<main class="main-content">
			<sitemesh:write property='body'/>
		</main>
		
		<%@include file="/commons/web/footer.jsp"%>
		
	</div>
	
	
	<script src="<c:url value='/templates/web/js/jquery-1.11.1.min.js' />"></script>
	<script src="<c:url value='/templates/web/js/plugins.js' />"></script>
	<script src="<c:url value='/templates/web/js/app.js' />"></script>
	
</body>

</html>