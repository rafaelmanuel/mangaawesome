<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<!-- Loading Bootstrap -->
    	<link href="assets/ui/Flat-UI-master/dist/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

		<!-- Loading Flat UI -->
		<link href="assets/ui/Flat-UI-master/dist/css/flat-ui.css" rel="stylesheet">
		 
		<title>Login</title>
	</head>
	<body style="background:#2C3E50">
		<jsp:include page="header.jsp" />
		<p id="message"></p>
		<div class="container">
			<div class="row">
				<div
					class="col-md-5 col-md-offset-4 col-lg-4 col-lg-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1"
					style="background:#34495e;
					padding:40px;
					padding-left:25px;
					padding-right:25px;
					padding-bottom:5px;
					border-radius:5px;
					text-align:center;">

					<div class="form-group">
						<input type="email" name="email" id="email" placeholder="Email" class="form-control" required/>
					</div>
					<div class="form-group">
						<input type="password" name="password" id="password" placeholder="Password" class="form-control" required/>
					</div>
		
					<div class="form-group">
						<a class="btn btn-primary" id="submit" style="width:100%">Login</a>
					</div>
					<label>
						<a href="#">Forgot Password</a>
					</label>

				</div>		
			</div>
			
		</div>
		
		
		<script src="assets/ui/Flat-UI-master/dist/js/vendor/jquery.min.js"></script>
		<script src="assets/ui/Flat-UI-master/dist/js/flat-ui.min.js"></script>
		<script src="assets/ui/Flat-UI-master/docs/assets/js/application.js"></script>
		<script src="assets/js/login.js" ></script>
	</body>
	
</html>