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
		
		ul.menu li.menu-item a:hover {
			text-decoration: none;
		}
		
		.dark-mode {
			background-color: black !important;
			color: white;
		}
		

.navbar-nav{
    width: 100%;
}

@media(min-width:568px){
    .end{
        margin-left: auto;
    }
}

@media(max-width:768px){
    #post{
        width: 100%;
    }
}
#clicked{
    padding-top: 1px;
    padding-bottom: 1px;
    text-align: center;
    width: 100%;
    background-color: #ecb21f;
    border-color: #a88734 #9c7e31 #846a29;
    color: black;
    border-width: 1px;
    border-style: solid;
    border-radius: 13px; 
}

#profile{
    background-color: unset;
    
} 

#post{
    margin: 10px;
    padding: 6px;
    padding-top: 2px;
    padding-bottom: 2px;
    text-align: center;
    background-color: #ecb21f;
    border-color: #a88734 #9c7e31 #846a29;
    color: black;
    border-width: 1px;
    border-style: solid;
    border-radius: 13px;
    width: 50%;
}

body{
    background-color: black;
}

#nav-items li a,#profile{
    text-decoration: none;
    color: rgb(224, 219, 219);
    background-color: black;
}


.comments{
    margin-top: 5%;
    margin-left: 20px;
}

.darker{
    border: 1px solid #ecb21f;
    background-color: black;
    float: right;
    border-radius: 5px;
    padding-left: 40px;
    padding-right: 30px;
    padding-top: 10px;
}

.comment{
    border: 1px solid rgba(16, 46, 46, 1);
    background-color: rgba(16, 46, 46, 0.973);
    float: none;
    border-radius: 5px;
    padding-left: 40px;
    padding-right: 30px;
    padding-top: 10px;
    
}
.comment h4,.comment span,.darker h4,.darker span{
    display: inline;
}

.comment p,.comment span,.darker p,.darker span{
    color: rgb(184, 183, 183);
}

h1,h4{
    color: white;
    font-weight: bold;
}
label{
    color: rgb(212, 208, 208);
}

#align-form{
    margin-top: 20px;
}
.form-group p a{
    color: white;
}

#checkbx{
    background-color: black;
}

#darker img{
    margin-right: 15px;
    position: static;
}

.form-group input,.form-group textarea{
    background-color: black;
    border: 1px solid rgba(16, 46, 46, 1);
    border-radius: 12px;
}

form#algin-form{
    border: 1px solid rgba(16, 46, 46, 1);
    background-color: rgba(16, 46, 46, 0.973);
    border-radius: 5px;
    padding: 20px;
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
	<script>
		var menu = "${menu}";
		if(menu != null && menu != "" && menu == "about") {
			$('#menuAbout').toggleClass("current-menu-item");
			$('#menuHome').toggleClass("current-menu-item");
			console.log($('#menuAbout'));
		}
	
	</script>
</body>

</html>