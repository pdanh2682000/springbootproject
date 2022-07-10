<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="site-header">
	<div class="container">
		<a href="index.html" id="branding"> <img src="<c:url value='/templates/web/images/logo.png' />"
			alt="" class="logo">
			<div class="logo-copy">
				<h1 class="site-title">DanhUy's Movie</h1>
				<small class="site-description">Xem phim thỏa thích tại đây</small><br />
				<p>
					<security:authorize access="isAuthenticated()">
 						Welcome, <security:authentication property="name"/>
					</security:authorize>
				</p>
			</div>
		</a>
		<!-- #branding -->

		<div class="main-navigation">
			<button type="button" class="menu-toggle">
				<i class="fa fa-bars"></i>
			</button>
			<ul class="menu">
				<li class="menu-item current-menu-item"><a href="index.html">Home</a></li>
				<li class="menu-item"><a href="about.html">About</a></li>
				<li class="menu-item"><a href="/signup">Register</a></li>
				<li class="menu-item"><a href="/admin">Manager</a></li>
				<security:authorize access="!isAuthenticated()">
 					<li class="menu-item"><a href="/login">Login</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
				  	<li class="menu-item"><a href="/logout">Logout</a></li>
				</security:authorize>
			</ul>
			<!-- .menu -->

			<form action="#" class="search-form">
				<input type="text" placeholder="Search...">
				<button>
					<i class="fa fa-search"></i>
				</button>
			</form>
		</div>
		<!-- .main-navigation -->

		<div class="mobile-navigation"></div>
	</div>
</header>