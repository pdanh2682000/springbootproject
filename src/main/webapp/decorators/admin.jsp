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
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome Icons -->
<link rel="stylesheet" href="<c:url value='/templates/admin/plugins/fontawesome-free/css/all.min.css' />">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="<c:url value='/templates/admin/plugins/overlayScrollbars/css/OverlayScrollbars.min.css' />">
<!-- Theme style -->
<link rel="stylesheet" href="<c:url value='/templates/admin/dist/css/adminlte.min.css' />">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
<!-- sweet alert  -->
<script src="<c:url value='/templates/admin/sweetalert/sweetalert2.min.js' />"></script>
<link rel="stylesheet" href="<c:url value='/templates/admin/sweetalert/sweetalert2.min.css' />" />
<style>
	form .error {
		color: yellow;
	}
	
	table th,td {
		text-align: center;
	}
	
	input[type=radio] {
		margin-left: 40px;
	}
	
	#myRadioButton label {
		padding: 10px;
	}
</style>
</head>
<body
	class="hold-transition dark-mode sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">

	<div class="wrapper">

		<%@ include file="/commons/admin/header.jsp"%>
		<div class="content-wrapper">
			<sitemesh:write property='body' />
		</div>
		<%@include file="/commons/admin/footer.jsp"%>

	</div>


	<!-- REQUIRED SCRIPTS -->
	<!-- jQuery -->
	<script src="<c:url value='/templates/admin/plugins/jquery/jquery.min.js' />"></script>
	<!-- Bootstrap -->
	<script src="<c:url value='/templates/admin/plugins/bootstrap/js/bootstrap.bundle.min.js' />"></script>
	<!-- overlayScrollbars -->
	<script
		src="<c:url value='/templates/admin/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js' />"></script>
	<!-- AdminLTE App -->
	<script src="<c:url value='/templates/admin/dist/js/adminlte.js' />"></script>

	<!-- PAGE PLUGINS -->
	<!-- jQuery Mapael -->
	<script src="<c:url value='/templates/admin/plugins/jquery-mousewheel/jquery.mousewheel.js' />"></script>
	<script src="<c:url value='/templates/admin/plugins/raphael/raphael.min.js' />"></script>
	<script src="<c:url value='/templates/admin/plugins/jquery-mapael/jquery.mapael.min.js' />"></script>
	<script src="<c:url value='/templates/admin/plugins/jquery-mapael/maps/usa_states.min.js' />"></script>
	<!-- ChartJS -->
	<script src="<c:url value='/templates/admin/plugins/chart.js/Chart.min.js' />"></script>

	<!-- AdminLTE for demo purposes -->
	<script src="<c:url value='/templates/admin/dist/js/demo.js' />"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="<c:url value='/templates/admin/dist/js/pages/dashboard2.js' />"></script>
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script src="<c:url value='/templates/paging/jquery.twbsPagination.js'/>"></script>
		<!-- CKEDITOR -->
	<script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
	<script>
		var menu = '${menu}';
		$(document).ready(function(){
			switch(menu){
				case 'menu_film': {
				    $("#menu_film").removeClass('active');
				    $("#menu_film").addClass('active');
					break;
				}
				case 'menu_category': {
				    $("#menu_category").removeClass('active');
				    $("#menu_category").addClass('active');
					break;
				}
				case 'menu_role': {
				    $("#menu_role").removeClass('active');
				    $("#menu_role").addClass('active');
					break;
				}
				case 'menu_user': {
				    $("#menu_user").removeClass('active');
				    $("#menu_user").addClass('active');
					break;
				}
				case 'menu_episode': {
				    $("#menu_episode").removeClass('active');
				    $("#menu_episode").addClass('active');
					break;
				}
				case 'menu_advertise': {
				    $("#menu_advertise").removeClass('active');
				    $("#menu_advertise").addClass('active');
					break;
				}
			}
		})
	
		
	</script>
</body>
</html>