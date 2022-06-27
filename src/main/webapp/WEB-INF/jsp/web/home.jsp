<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DanhUy's Movie</title>
</head>
<body>

	<div class="container">
		<div class="page">
			<div class="row">
				<div class="col-md-9">
					<div class="slider">
						<ul class="slides">
						
							<c:forEach items="${poster_slide.results}" var="poster">
								<li>
									<a href="#"><img src="<c:url value='${poster.url}' />" alt="${poster.title}"></a>
								</li>
							</c:forEach>
						
						
							
						</ul>
					</div>
				</div>
				<div class="col-md-3">
					<div class="row">
						<div class="col-sm-6 col-md-12">
							<div class="latest-movie">
								<a href="#"><img src="<c:url value='/poster_content/xom_tro_3d.jpg' />" alt="Movie 1"></a>
							</div>
						</div>
						<div class="col-sm-6 col-md-12">
							<div class="latest-movie">
								<a href="#"><img src="<c:url value='/poster_content/mat_biec.jpg' />" alt="Movie 2"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- .row -->
			<div class="row">
			
				<c:forEach items="${poster_content.results}" var="poster">
					<div class="col-sm-6 col-md-3">
						<div class="latest-movie">
							<a href="#"><img src="<c:url value='${poster.url}' />" alt="${poster.title}"></a>
						</div>
					</div>
				</c:forEach>
			
				
			</div>
			<!-- .row -->

			<div class="row">
				<div class="col-md-4">
					<h2 class="section-title">Phim sắp ra mắt</h2>
					<p>Những bộ phim bom tấn sắp được công bố.</p>
					<ul class="movie-schedule">
						<li>
							<div class="date">16/12</div>
							<h2 class="entry-title">
								<a href="#">Perspiciatis unde omnis</a>
							</h2>
						</li>
						<li>
							<div class="date">16/12</div>
							<h2 class="entry-title">
								<a href="#">Perspiciatis unde omnis</a>
							</h2>
						</li>
						<li>
							<div class="date">16/12</div>
							<h2 class="entry-title">
								<a href="#">Perspiciatis unde omnis</a>
							</h2>
						</li>
						<li>
							<div class="date">16/12</div>
							<h2 class="entry-title">
								<a href="#">Perspiciatis unde omnis</a>
							</h2>
						</li>
					</ul>
					<!-- .movie-schedule -->
				</div>
				<div class="col-md-4">
					<h2 class="section-title">Phim nổi bật trong tháng</h2>
					<p>Những bộ phim hot nhất tháng.</p>
					<ul class="movie-schedule">
						<li>
							<div class="date">16/12</div>
							<h2 class="entry-title">
								<a href="#">Perspiciatis unde omnis</a>
							</h2>
						</li>
						<li>
							<div class="date">16/12</div>
							<h2 class="entry-title">
								<a href="#">Perspiciatis unde omnis</a>
							</h2>
						</li>
						<li>
							<div class="date">16/12</div>
							<h2 class="entry-title">
								<a href="#">Perspiciatis unde omnis</a>
							</h2>
						</li>
						<li>
							<div class="date">16/12</div>
							<h2 class="entry-title">
								<a href="#">Perspiciatis unde omnis</a>
							</h2>
						</li>
					</ul>
					<!-- .movie-schedule -->
				</div>
				<div class="col-md-4">
					<h2 class="section-title">Phim xem nhiều nhất</h2>
					<p>Những bộ phim nhiều người xem nhiều nhất.</p>
					<ul class="movie-schedule">
						<li>
							<div class="date">16/12</div>
							<h2 class="entry-title">
								<a href="#">Perspiciatis unde omnis</a>
							</h2>
						</li>
						<li>
							<div class="date">16/12</div>
							<h2 class="entry-title">
								<a href="#">Perspiciatis unde omnis</a>
							</h2>
						</li>
						<li>
							<div class="date">16/12</div>
							<h2 class="entry-title">
								<a href="#">Perspiciatis unde omnis</a>
							</h2>
						</li>
						<li>
							<div class="date">16/12</div>
							<h2 class="entry-title">
								<a href="#">Perspiciatis unde omnis</a>
							</h2>
						</li>
					</ul>
					<!-- .movie-schedule -->
				</div>
			</div>
		</div>
	</div>
	<!-- .container -->
</body>
</html>