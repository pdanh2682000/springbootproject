<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DanhUy's Movie Admin</title>
</head>
<body>
	<div class="content-wrapper">
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-6">
						<div class="card">
							<div class="card-header border-0">
								<div class="d-flex justify-content-between">
									<h3 class="card-title">Online Store Visitors</h3>
									<a href="javascript:void(0);">View Report</a>
								</div>
							</div>
							<div class="card-body">
								<div class="d-flex">
									<p class="d-flex flex-column">
										<span class="text-bold text-lg" id="visitCounter"></span> <span>Visitors
											Over Time</span>
									</p>
								
									<p class="ml-auto d-flex flex-column text-right">
										<span class="text-success"> <i class="fas fa-arrow-up"></i>
											12.5%
										</span> <span class="text-muted">Since last week</span>
									</p>
								</div>
								<!-- /.d-flex -->

								<div class="position-relative mb-4">
									<canvas id="visitors-chart" height="200"></canvas>
								</div>

								<div class="d-flex flex-row justify-content-end">
									<span class="mr-2"> <i
										class="fas fa-square text-primary"></i> This Week
									</span> <span> <i class="fas fa-square text-gray"></i> Last
										Week
									</span>
								</div>
							</div>
							<button id="reset"
							style="	margin-top: 20px;
									background-color: #008cba;
									cursor: pointer;
									font-size: 18px;
									padding: 8px 20px;
									color: white;
									border: 0;
								"
							>Reset Visitors Count</button>
						</div>
						<!-- /.card -->
						
					</div>
				</div>
			</div>
		</div>
	</div>
<script>
	var visitCount = localStorage.getItem("page_view");
	$('#visitCounter').html(visitCount);
	$( "#reset" ).click(function() {
		visitCount = 0;
		localStorage.removeItem("page_view");
		$('#visitCounter').html(visitCount);
	});
</script>
</body>
</html>