<!-- <!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>IMS | Dashboard</title>
  Tell the browser to be responsive to screen width
  <meta name="viewport" content="width=device-width, initial-scale=1">
  Font Awesome
  <link rel="stylesheet" href="resources/css/all.min.css">
  Ionicons
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
	
  Theme style
  <link rel="stylesheet" href="resources/css/adminlte.css">
  overlayScrollbars
  <link rel="stylesheet" href="resources/css/OverlayScrollbars.min.css">
  <link rel="stylesheet" href="resources/css/fontawesome.min.css">
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
   <link rel="stylesheet" href="resources/css/sweetalert2.min.css" type="text/css" />
   Tempusdominus Bbootstrap 4
  <link rel="stylesheet" href="resources/css/tempusdominus-bootstrap-4.min.css">

<style>
	.login-card-body, .register-card-body, .card {
		border-radius: 2% !important;
	}
	
	.error {
		color : red;
	}
	
	label:not(.form-check-label):not(.custom-file-label) {
    	font-weight: 400;
	}
</style>
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="#	"><b>Inventory</b>Mangement</a>
  </div>
  /.login-logo
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">Sign in to Go</p>

      <form id="loginForm" action="" method="post">
        <div class="input-group mb-2">
          <input type="text" class="form-control" placeholder="Username" id="username" name="username">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fa fa-user"></span>
            </div>
          </div>
          
        </div>
        <label id="username-error" class="error" for="username"></label>
        <div class="input-group mb-2">
          <input type="password" class="form-control" placeholder="Password" id="pass"  name="pass">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
 	<label id="pass-error" class="error" for="pass"></label>
 		
          /.col
          <div style="text-align : center">
            <button type="submit" class="btn btn-primary ">Sign In</button>
          </div>
          /.col
 
      </form>
    </div>
    /.login-card-body
  </div>
</div>
/.login-box

<script src="resources/js/jquery.min.js"></script>
Bootstrap 4
<script src="resources/js/bootstrap.bundle.min.js"></script>
<script src="resources/js/adminlte.min.js"></script>
<script src="resources/js/jquery.validate.min.js"></script>
</body>

<script>
$( document ).ready(function() {
	$('#loginForm').validate({
		  rules: {
		    username: 'required',
		    pass : 'required'
		
		   },
		  messages: {
		    username: 'Username is required',
		    pass: 'Password is required'
		  }
	});
});
</script>
</html> -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="footer.jsp"></jsp:include>