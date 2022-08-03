<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
								<li><img style="max-width: 870px; max-height: 518px;" src="<c:url value='${poster.url}' />"
									alt="${poster.title}"></li>
							</c:forEach>



						</ul>
					</div>
				</div>
				<div class="col-md-3">
					<div class="row">
						<div class="col-sm-6 col-md-12">
							<div class="latest-movie poster-item">
								<a data-toggle="modal" data-target="#modal1"><img
									src="<c:url value='/poster_content/xom_tro_3d.jpg' />"
									alt="Movie 1"></a>
								<div class="modal fade" id="modal1" tabindex="-1" role="dialog"
									aria-labelledby="myLargeModalLabel" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLongTitle">Mô
													tả ngắn</h5>
												<button type="button" id="myStopClickButton"
													class="close myStopClickButton" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<h4 style="color: black;">Tên phim: XÓM TRỌ 3D</h4>

												<p>
													Trạng thái:<span class="modal-content-style"> HD
														Vietsub + TM</span>
												</p>
												<p>
													Đạo diễn: <span class="modal-content-style">Lana
														Wachowski</span>
												</p>
												<p>
													Quốc gia: <span class="modal-content-style">Mỹ</span>
												</p>
												<p>
													Năm sản xuất: <span class="modal-content-style">2021</span>
												</p>
												<p>
													Thời lượng: <span class="modal-content-style">148
														phút</span>
												</p>
												<p>
													Chất lượng: <span class="modal-content-style">Bản
														đẹp</span>
												</p>
												<p>
													Độ phân giải: <span class="modal-content-style">Full
														HD</span>
												</p>
												<p>
													Ngôn ngữ: <span class="modal-content-style">Phụ đề
														việt</span>
												</p>
												<p>
													Thể loại: <span class="modal-content-style">Chiếu
														Rạp, Gây Cấn, Hành Động, Viễn Tưởng</span>
												</p>
												<p>
													Lượt xem: <span class="modal-content-style">1.6K</span>
												</p>
												<p>
													Công ty SX: <span class="modal-content-style">Đang
														cập nhật</span>
												</p>

												<h6>Đánh giá phim (284 lượt)</h6>
												<span class="fa fa-star checked"></span> <span
													class="fa fa-star checked"></span> <span
													class="fa fa-star checked"></span> <span class="fa fa-star"></span>
												<span class="fa fa-star"></span>
												
												<h6>Diễn viên</h6>
												<a class="actor-profile-item" href="#"
													title="Diễn viên Jessica Henwick">
													<div class="actor-name">
														<span class="actor-name-a" itemprop="name">Jessica
															Henwick</span>
													</div>
												</a> <a class="actor-profile-item" href="#"
													title="Diễn viên Jessica Henwick">
													<div class="actor-name">
														<span class="actor-name-a" itemprop="name">Jessica
															Henwick</span>
													</div>
												</a>
												<h6>Trailer:</h6>
												<!-- 16:9 aspect ratio -->
												<div class="embed-responsive embed-responsive-4by3">
													<iframe class="embed-responsive-item myVideoClass"
														src="https://www.youtube.com/embed/zpOULjyy-n8?rel=0"></iframe>
												</div>
											</div>
											<div class="modal-footer">
												<button id="myStopClickButton" type="button"
													class="btn btn-secondary myStopClickButton"
													data-dismiss="modal">Close</button>
												<button type="button" class="btn btn-primary">Xem
													phim</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-6 col-md-12">
							<div class="latest-movie poster-item">
								<a data-toggle="modal" data-target="#modal2"><img
									src="<c:url value='/poster_content/mat_biec.jpg' />"
									alt="Movie 2"></a>
								<div class="modal fade" id="modal2" tabindex="-1" role="dialog"
									aria-labelledby="myLargeModalLabel" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLongTitle">Mô
													tả ngắn</h5>
												<button type="button" class="close myStopClickButton"
													data-dismiss="modal" aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<h4 style="color: black;">Tên phim: MẮT BIẾC</h4>

												<p>
													Trạng thái:<span class="modal-content-style"> HD
														Vietsub + TM</span>
												</p>
												<p>
													Đạo diễn: <span class="modal-content-style">Lana
														Wachowski</span>
												</p>
												<p>
													Quốc gia: <span class="modal-content-style">Mỹ</span>
												</p>
												<p>
													Năm sản xuất: <span class="modal-content-style">2021</span>
												</p>
												<p>
													Thời lượng: <span class="modal-content-style">148
														phút</span>
												</p>
												<p>
													Chất lượng: <span class="modal-content-style">Bản
														đẹp</span>
												</p>
												<p>
													Độ phân giải: <span class="modal-content-style">Full
														HD</span>
												</p>
												<p>
													Ngôn ngữ: <span class="modal-content-style">Phụ đề
														việt</span>
												</p>
												<p>
													Thể loại: <span class="modal-content-style">Chiếu
														Rạp, Gây Cấn, Hành Động, Viễn Tưởng</span>
												</p>
												<p>
													Lượt xem: <span class="modal-content-style">1.6K</span>
												</p>
												<p>
													Công ty SX: <span class="modal-content-style">Đang
														cập nhật</span>
												</p>

												<h6>Đánh giá phim (284 lượt)</h6>
												<span class="fa fa-star checked"></span> <span
													class="fa fa-star checked"></span> <span
													class="fa fa-star checked"></span> <span class="fa fa-star"></span>
												<span class="fa fa-star"></span>
												<h6>Diễn viên</h6>
												<a class="actor-profile-item" href="#"
													title="Diễn viên Jessica Henwick">
													<div class="actor-name">
														<span class="actor-name-a" itemprop="name">Jessica
															Henwick</span>
													</div>
												</a> <a class="actor-profile-item" href="#"
													title="Diễn viên Jessica Henwick">
													<div class="actor-name">
														<span class="actor-name-a" itemprop="name">Jessica
															Henwick</span>
													</div>
												</a>
												<h6>Trailer:</h6>
												<!-- 16:9 aspect ratio -->
												<div class="embed-responsive embed-responsive-4by3">
													<iframe class="embed-responsive-item myVideoClass"
														src="https://www.youtube.com/embed/zpOULjyy-n8?rel=0"></iframe>
												</div>
											</div>
											<div class="modal-footer">
												<button type="button"
													class="btn btn-secondary myStopClickButton"
													data-dismiss="modal">Close</button>
												<button type="button" class="btn btn-primary">Xem
													phim</button>
												
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- .row -->
			<div class="row">

				<c:forEach items="${poster_content.results}" var="poster">
					<div class="col-sm-6 col-md-3">
						<div class="latest-movie poster-item">
							<a data-toggle="modal" data-target="#modal_${poster.id}"><img
								src="<c:url value='${poster.url}' />" alt="${poster.title}"></a>
							<div class="modal fade" id="modal_${poster.id}" tabindex="-1"
								role="dialog" aria-labelledby="myLargeModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLongTitle">Mô tả
												ngắn</h5>
											<button type="button" class="close myStopClickButton"
												data-dismiss="modal" aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<h4 style="color: black;">Tên phim: ${poster.title}</h4>

											<p>
												Trạng thái:<span class="modal-content-style"> HD
													Vietsub + TM</span>
											</p>
											<p>
												Đạo diễn: <span class="modal-content-style">${poster.author}</span>
											</p>
											<p>
												Quốc gia: <span class="modal-content-style">Việt Nam</span>
											</p>
											<p>
												Năm sản xuất: <span class="modal-content-style">${poster.publishDate}</span>
											</p>
											<p>
												Thời lượng: <span class="modal-content-style">${poster.filmLength}</span>
											</p>
											<p>
												Chất lượng: <span class="modal-content-style">Bản đẹp</span>
											</p>
											<p>
												Độ phân giải: <span class="modal-content-style">Full
													HD</span>
											</p>
											<p>
												Ngôn ngữ: <span class="modal-content-style">Phụ đề
													việt</span>
											</p>
											<p>
												Thể loại: <span class="modal-content-style">${poster.categoryName}</span>
											</p>
											<p>
												Lượt xem: <span class="modal-content-style">1.6K</span>
											</p>
											<p>
												Công ty SX: <span class="modal-content-style">Đang
													cập nhật</span>
											</p>

											<h6>Đánh giá phim (${poster.quantityRate} lượt)</h6>
											
													<span class="fa fa-star fa-star-${poster.id}"></span>
												 	<span class="fa fa-star fa-star-${poster.id}"></span>
												  	<span class="fa fa-star fa-star-${poster.id}"></span>
												  	<span class="fa fa-star fa-star-${poster.id}"></span>
													<span class="fa fa-star fa-star-${poster.id}"></span>

													
											<div style="padding: 10px 0 5px 0">
													<select id="selectRate_${poster.id}" style="height: 30px;" class="form-select" aria-label="Default select example">
														<option value="0">Đánh giá của bạn</option>
														<c:forEach items="${listRate}" var="item">
														  <option value="${item.starNum}">${item.starDescription}</option>
														 </c:forEach>
													</select>
													<span id="textSuccess_${poster.id}" class="text-success"></span>
													<span id="textFail_${poster.id}" class="text-danger"></span>
												</div>
												<button id="btnRate_${poster.id}" type="button" style="margin: 0 0 10px 0;" class="btn btn-info">Chọn</button>
												<script>
													$('#btnRate_${poster.id}').click(function() {
														var starNum = $('#selectRate_${poster.id} :selected').val();
														if(starNum != "0") {
															var filmId = "${poster.id}";
															var data = {
																starNum : starNum,
																filmId : filmId
															}
															console.log(data);
															var domSuccess = $('#textSuccess_${poster.id}');
															var domError = $('#textFail_${poster.id}');
															rateFilm(data, domSuccess, domError);
														}
														else {
															$('#textFail_${poster.id}').html("Vui lòng chọn đánh giá!");
															$('#textFail_${poster.id}').fadeToggle(1500);
														}
													});
													
													
													// get star
													var everageStar = "${poster.everageRate}";
													var rates = $('.fa-star-${poster.id}');
													for(var i = 0; i < 5; i++){
														if(i < everageStar) {
															rates[i].className += " checked";
														}
													}
													//console.log(rates);
												</script>
											<h6>Diễn viên</h6>
											
												<div class="actor-name-${poster.id}">
													<script>
														var strNameActor = "${poster.actor}";
														var arrNameActor = strNameActor.trim().split(";");
														for(var i = 0; i<arrNameActor.length; i++) {
															$('.actor-name-${poster.id}').append("<p class='actor-name-a' itemprop='name'><a href='#'>"+arrNameActor[i]+"</a></p>")
														}
													</script>
												</div>

											<h6>Trailer:</h6>
											<!-- 16:9 aspect ratio -->
											<div class="embed-responsive embed-responsive-4by3">
												<iframe class="embed-responsive-item myVideoClass"
													src="${poster.trailer}"></iframe>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button"
												class="btn btn-secondary myStopClickButton"
												data-dismiss="modal">Close</button>
											<a href="/watch/${poster.id}"><button type="button" class="btn btn-primary">Xem
												phim</button>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>



			</div>
			<!-- .row -->

			<div class="row">
			
				<c:forEach items="${list_advertise}" var="item">
					<div class="col-md-4">
						<h2 class="section-title">${item.titleAdvertise}</h2>
						<p>${item.descriptionAdvertise}</p>
						<ul class="movie-schedule">
						
							<c:forEach items="${item.films}" var="itemFilm">
								<li>
									<div class="date premiereDate" id="premiereDate_${item.id}_${itemFilm.id}"></div>
									<script>
										var premiereDate = "${itemFilm.premiereDate}";
										var parsePremiereDate = premiereDate.split(' ')[0].slice(5).split('-');
										var parsePremiereDateResult = parsePremiereDate[1] + " / " + parsePremiereDate[0];
										$('#premiereDate_${item.id}_${itemFilm.id}').html(parsePremiereDateResult);
									</script>
									<h2 class="entry-title">
										<a href="/watch/${itemFilm.id}">${itemFilm.title}</a>
									</h2>
								</li>
							</c:forEach>
							
							
	
						</ul>
						<!-- .movie-schedule -->
					</div>
				</c:forEach>
			
				
			</div>
		</div>
	</div>
	<!-- .container -->
	<script>
		var visitCount = localStorage.getItem("page_view");
		if (visitCount) {
			visitCount = Number(visitCount) + 1;
			localStorage.setItem("page_view", visitCount);
		} else {
			visitCount = 1;
			localStorage.setItem("page_view", visitCount);
		}

		$('.myStopClickButton').click(function() {
			$('.myVideoClass').each(function() {
				var el_src = $(this).attr("src");
				$(this).attr("src", el_src);
			});
		});
		
		function rateFilm(data, domSuccess, domError) {
	        $.ajax({
	            url: '/api/film/rate',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            success: function (result) {
	            	// alert(result);
	            	domSuccess.html("Đánh giá thành công!");
	            	domSuccess.fadeToggle(1500);
	            },
	            error: function (error) {
	            	domError.html("Đánh giá thất bại!");
	            	domError.fadeToggle(1500);
	            }
	        });
		}
	</script>
</body>
</html>