<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/commons/base.jsp"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<head>
	<meta charset="utf-8" />
	<title>登录页面</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<link href="${ctxPath}/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="${ctxPath}/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="${ctxPath}/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="${ctxPath}/media/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="${ctxPath}/media/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="${ctxPath}/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="${ctxPath}/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="${ctxPath}/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<link href="${ctxPath}/media/css/login-soft.css" rel="stylesheet" type="text/css"/>
	<link rel="shortcut icon" href="${ctxPath}/media/image/favicon.ico" />
</head>

<body class="login">
	<!-- 图标 -->
	<div class="logo">
		<img src="${ctxPath}/media/image/logo-big.png" alt="" /> 
	</div>
	
	<!-- 登录框 -->
	<div class="content">
		<form class="form-vertical login-form" action="${ctxPath}/login.do" method="post">
			<h3 class="form-title">Login to your account</h3>
			<c:if test="${error}">
				<div class="alert alert-error">
					<button class="close" data-dismiss="alert"></button>
					<span>Enter the correct username and password.</span>
				</div>
			</c:if>
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">Username</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="Username" name="username"/>
					</div>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Password</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" type="password" placeholder="Password" name="password"/>
					</div>
				</div>
			</div>

			<div class="form-actions">
				<label class="checkbox">
				<input type="checkbox" name="remember" value="1"/> Remember me
				</label>
				<button type="submit" class="btn blue pull-right">
				Login <i class="m-icon-swapright m-icon-white"></i>
				</button>            
			</div>

			<!-- 忘记密码 -->
			<div class="forget-password">
				<h4>Forgot your password ?</h4>
				<p>
					no worries, click <a href="javascript:;" class="" id="forget-password">here</a>
					to reset your password.
				</p>
			</div>
			<!-- 注册按钮 -->
			<div class="create-account">
				<p>
					Don't have an account yet ?&nbsp; 
					<a href="javascript:;" id="register-btn" class="">Create an account</a>
				</p>
			</div>

		</form>

		<!-- 找回密码 -->
		<form class="form-vertical forget-form" action="index.html">
			<h3 class="">Forget Password ?</h3>
			<p>Enter your e-mail address below to reset your password.</p>
			<div class="control-group">
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-envelope"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="Email" name="email" />
					</div>
				</div>
			</div>
			<div class="form-actions">
				<button type="button" id="back-btn" class="btn">
				<i class="m-icon-swapleft"></i> Back
				</button>
				<button type="submit" class="btn blue pull-right">
				Submit <i class="m-icon-swapright m-icon-white"></i>
				</button>            
			</div>
		</form>

		<!-- 注册表单 -->
		<form class="form-vertical register-form" action="index.html">
			<h3 class="">Sign Up</h3>
			<p>Enter your account details below:</p>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Username</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="Username" name="username"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Password</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" type="password" id="register_password" placeholder="Password" name="password"/>
					</div>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Re-type Your Password</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-ok"></i>
						<input class="m-wrap placeholder-no-fix" type="password" placeholder="Re-type Your Password" name="rpassword"/>
					</div>
				</div>
			</div>

			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">Email</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-envelope"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="Email" name="email"/>
					</div>
				</div>
			</div>

			<div class="control-group">
				<div class="controls">
					<label class="checkbox">
					<input type="checkbox" name="tnc"/> I agree to the <a href="#">Terms of Service</a> and <a href="#">Privacy Policy</a>
					</label>  
					<div id="register_tnc_error"></div>
				</div>
			</div>

			<div class="form-actions">
				<button id="register-back-btn" type="button" class="btn">
				<i class="m-icon-swapleft"></i>  Back
				</button>
				<button type="submit" id="register-submit-btn" class="btn blue pull-right">
				Sign Up <i class="m-icon-swapright m-icon-white"></i>
				</button>            
			</div>
		</form>
	</div>
	
	<!-- 版权-->
	<div class="copyright">
		2018 &copy; caihua would never disappointed you .
	</div>

	<!--javascripts在底部引用,会先加载页面元素,让用户体验更好 -->
	<!-- BEGIN CORE PLUGINS -->
	<script src="${ctxPath}/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="${ctxPath}/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="${ctxPath}/media/js/bootstrap.min.js" type="text/javascript"></script>
	<!--[if lt IE 9]>
	<script src="media/js/excanvas.min.js"></script>
	<script src="media/js/respond.min.js"></script>  
	<![endif]-->   
	<script src="${ctxPath}/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.blockui.min.js" type="text/javascript"></script>  
	<script src="${ctxPath}/media/js/jquery.cookie.min.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.uniform.min.js" type="text/javascript" ></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="${ctxPath}/media/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.backstretch.min.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${ctxPath}/media/js/app.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/login-soft.js" type="text/javascript"></script>      
	<!-- END PAGE LEVEL SCRIPTS --> 
	
	<script type="text/javascript">
		jQuery(document).ready(function() {     
		  App.init();
		  Login.init();
		});
		
		// 登录方法
		function loginFun() {
			var data = $('.login-form').serialize();
        	var submitData = decodeURIComponent(data, true);
        	$.ajax({
        		type:'POST',
        		url:'${ctxPath}/login.do',
        	    data:submitData,
        	    success:function(result){
        	    	if (result.success) {
        	    		window.location.href = "${ctxPath}/index.do";
        	    	} else {
        	    		$('.alert-error', $('.login-form')).show();
        	    	}
        	    },
        	})
		}
		// 回车键监控 
		$('.login-form input').keypress(function (e) {
            if (e.which == 13) {
                if ($('.login-form').validate().form()) {
                	$($('.login-form').submit();
                }
                return false;
            }
        });
	</script>

</body>
</html>