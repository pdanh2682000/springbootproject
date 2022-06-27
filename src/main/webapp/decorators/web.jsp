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
	
	<title>DanhUy's Movie</title>
	
	
	<!-- Loading third party fonts -->
	<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|"
		rel="stylesheet" type="text/css">
	<link href="<c:url value='/templates/web/fonts/font-awesome.min.css' />" rel="stylesheet" type="text/css">
	
	<!-- Loading main css file -->
	<link rel="stylesheet" href="<c:url value='/templates/web/style.css' />">
	
	<!--[if lt IE 9]>
		<script src="<c:url value='/templates/web/js/ie-support/html5.js' />"></script>
		<script src="<c:url value='/templates/web/js/ie-support/respond.js' />"></script>
	<![endif]-->
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