<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Watch</title>
</head>
<body>
	<section class="bg-light" id="content-container">
		<div class="container" id="content-container1">
			<c:if test="${param.message == null}">
				<c:if test="${not empty message}">
					<div class="alert alert-${alert}" id="messageAndAlert">
						<h3>
							<spring:message code="${message}" />
						</h3>
					</div>
				</c:if>
			</c:if>
			<c:if test="${param.message != null}">
				<div class="alert alert-${param.alert}" id="messageAndAlert">
					<h3>
						<spring:message code="${param.message}" />
					</h3>
				</div>
			</c:if>
			<div class="row" id="content-container2">
				<div class="col-lg-12 mb-4 mb-sm-5"
					style="margin-bottom: 0 !important;">
					<div class="card card-style1 border-0" id="content-container3">
						<div class="card-body p-1-9 p-sm-2-3 p-md-6 p-lg-7">
							<h2>${poster.title}</h2>
							<div class="row align-items-center">
								<div class="col-lg-8 mb-4 mb-lg-0">
									<video width="100%" height="100%" controls
										style="border-radius: 5px;">
										<source src="<c:url value='../${episode}' />" type="video/mp4">
										<!-- <src="https://www.w3schools.com/tags/movie.mp4" type="video/mp4"> -->
										Your browser does not support the video tag.
									</video>
									<div class="share">
										<div class="row">
											<button type="button" class="btn btn-secondary btn-feature"
												style="margin-left: 12px">
												<img src="<c:url value='../icons/plus.png' />" alt="Share"
													width="20px"> Thêm vào hộp
											</button>
											<button type="button" class="btn btn-primary share_fb"
												style="margin-left: 10px;">

												<img
													src="<c:url value="../icons/facebook_square_lightblue-512.png" />"
													alt="Share" width="20px"> Share
											</button>
											<button type="button" class="btn btn-secondary"
												style="margin-left: 10px;">AutoNext: On</button>
											<button type="button" class="btn btn-secondary"
												style="margin-left: 10px;">Phóng to</button>
											<button type="button" class="btn btn-secondary"
												onclick="darkMode()" style="margin-left: 10px;">
												<img src="<c:url value='../icons/lamp.png' />" alt="Share"
													width="20px"> Tắt đèn
											</button>
										</div>
									</div>
								</div>
								<div class="col-lg-4 px-xl-10"
									style="margin-top: -80px !important">
									<h4>Tên phim: ${poster.title}</h4>
									<p>
										Thời lượng: <span class="modal-content-style">${poster.filmLength}</span>
									</p>
									<p>
										Độ phân giải: <span class="modal-content-style">Full HD</span>
									</p>
									<p>
										Ngôn ngữ: <span class="modal-content-style">Phụ đề việt</span>
									</p>
									<p>
										Thể loại: <span class="modal-content-style">${poster.categoryName}</span>
									</p>
									<p>
										Năm sản xuất: <span class="modal-content-style">${poster.publishDate}</span>
									</p>
									<p>
										Giới thiệu: <span class="modal-content-style">${poster.shortDescription}</span>
									</p>
								</div>
							</div>
							<div class="row align-items-center" style="padding: 25px;">
								<p>
									Bạn đang xem phim <a href="#"> ${poster.title} </a> online chất lượng cao
									miễn phí tại server phim GD 1.
								</p>
								<fieldset>
									<legend>Hướng khắc phục lỗi xem phim</legend>
									<ul>
										<li>Sử dụng DNS 8.8.8.8, 8.8.4.4 hoặc 208.67.222.222,
											208.67.220.220 để xem phim nhanh hơn.</li>
										<li>Chất lượng phim mặc định chiếu là 360. Để xem phim
											chất lượng cao hơn xin vui lòng chọn trên player.</li>
										<li>Xem phim nhanh hơn với trình duyệt Google Chrome, Cốc
											Cốc</li>
										<li>Nếu bạn không xem được phim vui lòng nhấn CTRL + F5
											hoặc CMD + R trên MAC vài lần.</li>
									</ul>
								</fieldset>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-12 mb-4 mb-sm-5"
					style="padding-top: 0; margin-top: 0;">
					<div>
						<p>
						<p>
							<span class="section-title text-primary mb-3 mb-sm-4">Đánh
								giá phim (${poster.quantityRate} lượt)</span>
						</p>
						<span class="fa fa-star" style="font-size: 25px;"></span> <span
							class="fa fa-star" style="font-size: 25px;"></span> <span
							class="fa fa-star" style="font-size: 25px;"></span> <span
							class="fa fa-star" style="font-size: 25px;"></span> <span
							class="fa fa-star" style="font-size: 25px;"></span>
						<script>
							// get star
							var everageStar = "${poster.everageRate}";
							var rates = $('.fa-star');
							for (var i = 0; i < 5; i++) {
								if (i < everageStar) {
									rates[i].className += " checked";
								}
							}
						</script>
						</p>
						<span class="section-title text-primary mb-3 mb-sm-4">Bình
							luận về phim</span>
						<p>Edith is simply dummy text of the printing and typesetting
							industry. Lorem Ipsum has been the industry's standard dummy text
							ever since the 1500s, when an unknown printer took a galley of
							type and scrambled it to make a type specimen book.</p>
						<p class="mb-0">It is a long established fact that a reader
							will be distracted by the readable content of a page when looking
							at its layout. The point of using Lorem Ipsum is that it has a
							more-or-less normal distribution of letters, as opposed.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script>
		function darkMode() {
			var element = document.getElementById("content-container");
			element.classList.toggle("dark-mode");
			var element = document.getElementById("content-container1");
			element.classList.toggle("dark-mode");
			var element = document.getElementById("content-container2");
			element.classList.toggle("dark-mode");
			var element = document.getElementById("content-container3");
			element.classList.toggle("dark-mode");
		}
	</script>
</body>
</html>