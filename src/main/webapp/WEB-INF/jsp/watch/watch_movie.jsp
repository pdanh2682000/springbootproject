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
							<h2>${poster.title}- Tập ${ep_current == 0 ? 'Full' : ep_current}</h2>
							<div class="row align-items-center">
								<div class="col-lg-8 mb-4 mb-lg-0">
									<video id="myVideo" width="100%" height="100%" controls
										style="border-radius: 5px;">
										<source src="<c:url value='..${episode}' />" type="video/mp4">
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
												id="btnAutoNext" onclick="autoNextVideo()"
												style="margin-left: 10px;">AutoNext: Off</button>
											<button type="button" class="btn btn-secondary"
												id="btnZoomIn" style="margin-left: 10px;"
												onclick="zoomInVideo()">Phóng to</button>
											<button type="button" class="btn btn-secondary"
												onclick="darkMode()" style="margin-left: 10px;">
												<img src="<c:url value='../icons/lamp.png' />" alt="Share"
													width="20px"> Tắt đèn
											</button>
										</div>
									</div>
								</div>
								<div class="col-lg-4 px-xl-10" id="detailInfomation"
									style="margin-top: -80px !important">
									<h4 style="color: inherit;">Tên phim: ${poster.title}</h4>
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
									Bạn đang xem phim <a href="#"> ${poster.title} </a> online chất
									lượng cao miễn phí tại server phim GD 1.
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

							<c:if test="${length_episode == 0}">
								<div style="margin: 0; padding: 0;">
									<a href="#"><button type="button"
											class="btn btn-info btn-feature">Tập Full</button></a>
								</div>
							</c:if>
							<c:if test="${length_episode > 0}">
								<%!int i = 0;%>
								<div style="margin: 0; padding: 0;">
									<c:forEach items="${list_episode}" var="item">
										<%
										i++;
										%>
										<a href="/watch/${poster.id}?ep=<%= i %>"><button
												type="button" class="btn btn-secondary btn-feature"
												id="<%=i%>">
												Tập
												<%=i%></button></a>
									</c:forEach>
									<%
									i = 0;
									%>
								</div>
								<script>
									var ep_cur = "${ep_current}";
									$("#${ep_current}").removeClass(
											"btn-secondary");
									$("#${ep_current}").addClass("btn-info");
								</script>
							</c:if>
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

						<nav class="navbar navbar-expand-sm navbar-dark">
							<img src="https://i.imgur.com/CFpa3nK.jpg" width="20" height="20"
								class="d-inline-block align-top rounded-circle" alt=""> <a
								class="navbar-brand ml-2" href="#" data-abc="true"><a href="#">${poster.author}</a>
							<button class="navbar-toggler" type="button"
								data-toggle="collapse" data-target="#navbarColor02"
								aria-controls="navbarColor02" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
						</nav>
						<!-- Main Body -->
						<section>
							<div class="container" style="background: #2193b0;">
								<div class="row">
									<div class="col-sm-5 col-md-6 col-12 pb-4">
										<h1 id="contentComments">Comments</h1>
										
										<!-- <div class="comment mt-4 text-justify">
											<img src="https://i.imgur.com/yTFUilP.jpg" alt=""
												class="rounded-circle" width="40" height="40">
											<h6 style="margin-bottom: 0; padding-bottom: 0;">Jhon Doe</h6>
											<span style="font-size: 12px; margin-top: 0; padding-top: 0;">- 20 October, 2018</span> <br>
											<p style="font-size: 14px;">Lorem ipsum dolor sit, amet consectetur adipisicing
												elit. Accusamus numquam assumenda hic aliquam vero sequi
												velit molestias doloremque molestiae dicta?</p>
										</div>
										 -->
									</div>
									<div
										class="col-lg-4 col-md-5 col-sm-4 offset-md-1 offset-sm-1 col-12 mt-4">
										<form id="algin-form" >
											<div class="form-group" id="formPostComment">
												
												<h4>Leave a comment</h4>
												<label for="message">Message</label>
												<textarea name="msg" id="msg" msg cols="30" rows="5"
													class="form-control" style="background-color: black; color:white"></textarea>
											</div>

											<div class="form-group">
												<p class="text-secondary">
													If you have a <a href="#" class="alert-link">gravatar
														account</a> your address will be used to display your profile
													picture.
												</p>
											</div>
											<div class="form-inline">
												<input type="checkbox" name="check" id="checkbx"
													class="mr-1"> <label for="subscribe">Subscribe
													me to the newlettter</label>
											</div>
											<div class="form-group">
												<button type="button" id="post" class="btn">Post
													Comment</button>
											</div>
											<script>
												const DEFAULT_LIMIT_COMMENT = 2;
												const DEFAULT_PAGE_COMMENT = 1;
											
												function postComment(data) {
											        $.ajax({
											            url: '/web/api/comment',
											            type: 'POST',
											            async: false, 
											            contentType: 'application/json',
											            data: JSON.stringify(data),
											            success: function (result) {
											            	 //alert(result);
											            	 //alert("post");
											            	 if(result != "Not authenticated")
											            		$('#formPostComment').append("<div class='alert alert-success messageAndAlertSuccess' style='margin-top: 5px;' id='messageAndAlertSuccess'><h6>Đã post comment!</h6></div>");
											            	 else
											            		$('#formPostComment').append("<div class='alert alert-danger messageAndAlertFail' style='margin-top: 5px;' id='messageAndAlertFail'><h6>Bạn cần đăng nhập!</h6></div>");
											            	
											            	$('.messageAndAlertSuccess').fadeOut(3000);
											            	$('.messageAndAlertFail').fadeOut(3000);
											            },
											            error: function (error) {
											            	//alert(error);
											            	$('#formPostComment').append("<div class='alert alert-danger messageAndAlertFail' style='margin-top: 5px;' id='messageAndAlertFail'><h6>Post comment thất bại!</h6></div>");
											            	$('.messageAndAlertFail').fadeOut(3000);
											            }
											        });
												}
												
												function getComment(page, limit) {
											        $.ajax({
											            url: '/web/api/comment?filmId=${poster.id}&pageComment='+page+'&limitComment='+limit,
											            type: 'GET',
											            async: false, 
											            success: function (result) {
											            	//alert("get");
											            	//console.log(result);
											            	for(var i=0; i<result.results.length; i++) {
											            		//console.log(result[i].content);
											            		$('#contentComments').append(`
											            			<div class="comment mt-4 text-justify myComment">
																		<img src="\${result.results[i].avatarUser}" alt=""
																			class="rounded-circle" width="40" height="40">
																		<h6 style="margin-bottom: 0; padding-bottom: 0;">\${result.results[i].userName}</h6>
																		<span style="font-size: 12px; margin-top: 0; padding-top: 0;">- \${new Date(result.results[i].createdDate).toString().split(' ').slice(0, 5).join(' ')}</span> <br>
																		<p style="font-size: 14px;">\${result.results[i].content}</p>
																	</div>	
											            		`);
											            	}
											            	if(result.totalItem > DEFAULT_LIMIT_COMMENT) {
											            		$('#btnMoreComment').remove(); // clear old
											            		$('#contentComments').append(`
											            			<button style="background-color: #ecb21f;
											            				border: none;
											            				  color: black;
											            				  padding: 15px 32px;
											            				  text-align: center;
											            				  text-decoration: none;
											            				  display: inline-block;
											            				  font-size: 16px;
											            			" id="btnMoreComment">Xem thêm bình luận</button>
											            		`);
											            		$('#btnMoreComment').click(function (){
											            			$('.myComment').remove(); // clear old
											            			getComment(DEFAULT_PAGE_COMMENT, limit + DEFAULT_LIMIT_COMMENT);
																});
											            	}
											            },
											            error: function (error) {
											            	console.log(error);
											            }
											        });
												}
												
												$('#post').click(function (){
													var msg = $('#msg').val();
													if(msg != "") {
														var filmId = "${poster.id}";
														var data = {
															msg : msg,
															filmId : filmId
														}
														$('.myComment').remove(); // clear old
														postComment(data);
														getComment(DEFAULT_PAGE_COMMENT, DEFAULT_LIMIT_COMMENT);
													}
												});
												
												
												
												$(document).ready(function() {
													$('.myComment').remove();  // clear old
													getComment(DEFAULT_PAGE_COMMENT, DEFAULT_LIMIT_COMMENT); 
												});
												
											</script>
										</form>
									</div>
								</div>
							</div>
						</section>



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

		var checkZoomIn = false;
		function zoomInVideo() {
			if (!checkZoomIn) {
				$('#detailInfomation').hide();
				var video = $('video');
				video.height("150%");
				video.width("150%");
				$('#btnZoomIn').html("Thu nhỏ");
				checkZoomIn = true;
			} else {
				$('#detailInfomation').show();
				var video = $('video');
				video.height("100%");
				video.width("100%");
				$('#btnZoomIn').html("Phóng to");
				checkZoomIn = false;
			}
		}

		var checkAutoNext = false;
		function autoNextVideo() {
			if (!checkAutoNext) {
				$('#btnAutoNext').html("AutoNext: On");
				$('#btnAutoNext').removeClass("btn-secondary");
				$('#btnAutoNext').addClass("btn-primary");
				checkAutoNext = true;
			} else {
				$('#btnAutoNext').html("AutoNext: Off");
				$('#btnAutoNext').removeClass("btn-primary");
				$('#btnAutoNext').addClass("btn-secondary");
				checkAutoNext = false;
			}

		}

		var vid = document.getElementById("myVideo");
		vid.onended = function() {
			// alert("The video has ended");
			var length_episode = "${length_episode}";
			var ep_current = "${ep_current}";
			if ((ep_current < length_episode) && checkAutoNext) {
				window.location.href = "/watch/${poster.id}?ep=${ep_current + 1}";
			}
		};
		
		
	</script>
</body>
</html>