<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/commons/base.jsp"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
	<meta charset="utf-8" />
	<title>首页</title>
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
	<!-- BEGIN PAGE LEVEL STYLES --> 
	<link href="${ctxPath}/media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
	<link href="${ctxPath}/media/css/daterangepicker.css" rel="stylesheet" type="text/css" />
	<link href="${ctxPath}/media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>
	<link href="${ctxPath}/media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="${ctxPath}/media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
	<!-- END PAGE LEVEL STYLES -->
	<link rel="shortcut icon" href="${ctxPath}/media/image/favicon.ico" />
</head>

<body class="page-header-fixed">
	<!-- BEGIN HEADER -->
	<div class="header navbar navbar-inverse navbar-fixed-top">
		<!-- 顶部标题栏 -->
		<div class="navbar-inner">
			<div class="container-fluid">
				<!-- LOGO -->
				<a class="brand" href="index.html">
				<img src="media/image/logo.png" alt="logo"/>
				</a>

				<!-- BEGIN RESPONSIVE MENU TOGGLER -->
				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
				<img src="${ctxPath}/media/image/menu-toggler.png" alt="" />
				</a>          

				<!-- 右上角菜单 -->              
				<ul class="nav pull-right">
					<!-- 下拉1 -->   
					<li class="dropdown" id="header_notification_bar">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="icon-warning-sign"></i>
						<span class="badge">6</span>
						</a>
						<ul class="dropdown-menu extended notification">
							<li>
								<p>You have 14 new notifications</p>
							</li>
							<li>
								<a href="#">
								<span class="label label-success"><i class="icon-plus"></i></span>
								New user registered. 
								<span class="time">Just now</span>
								</a>
							</li>
							<li>
								<a href="#">
								<span class="label label-important"><i class="icon-bolt"></i></span>
								Server #12 overloaded. 
								<span class="time">15 mins</span>
								</a>
							</li>
							<li>
								<a href="#">
								<span class="label label-warning"><i class="icon-bell"></i></span>
								Server #2 not respoding.
								<span class="time">22 mins</span>
								</a>
							</li>
							<li>
								<a href="#">
								<span class="label label-info"><i class="icon-bullhorn"></i></span>
								Application error.
								<span class="time">40 mins</span>
								</a>
							</li>

							<li>
								<a href="#">
								<span class="label label-important"><i class="icon-bolt"></i></span>
								Database overloaded 68%. 
								<span class="time">2 hrs</span>
								</a>
							</li>

							<li>
								<a href="#">
								<span class="label label-important"><i class="icon-bolt"></i></span>
								2 user IP blocked.
								<span class="time">5 hrs</span>
								</a>
							</li>

							<li class="external">
								<a href="#">See all notifications <i class="m-icon-swapright"></i></a>
							</li>
						</ul>
					</li>

					<!-- 下拉2(信息箱) -->
					<li class="dropdown" id="header_inbox_bar">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="icon-envelope"></i>
						<span class="badge">5</span>
						</a>
						<ul class="dropdown-menu extended inbox">
							<li>
								<p>You have 12 new messages</p>
							</li>
							<li>
								<a href="inbox.html?a=view">
								<span class="photo"><img src="media/image/avatar2.jpg" alt="" /></span>
								<span class="subject">
								<span class="from">Lisa Wong</span>
								<span class="time">Just Now</span>
								</span>
								<span class="message">
								Vivamus sed auctor nibh congue nibh. auctor nibh
								auctor nibh...
								</span>  
								</a>
							</li>
							<li>
								<a href="inbox.html?a=view">
								<span class="photo"><img src="./media/image/avatar3.jpg" alt="" /></span>
								<span class="subject">
								<span class="from">Richard Doe</span>
								<span class="time">16 mins</span>
								</span>
								<span class="message">
								Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh
								auctor nibh...
								</span>  
								</a>
							</li>
							<li>
								<a href="inbox.html?a=view">
								<span class="photo"><img src="./media/image/avatar1.jpg" alt="" /></span>
								<span class="subject">
								<span class="from">Bob Nilson</span>
								<span class="time">2 hrs</span>
								</span>
								<span class="message">
								Vivamus sed nibh auctor nibh congue nibh. auctor nibh
								auctor nibh...
								</span>  
								</a>
							</li>

							<li class="external">
								<a href="inbox.html">See all messages <i class="m-icon-swapright"></i></a>
							</li>
						</ul>
					</li>

					<!-- 下拉3(待办箱) -->
					<li class="dropdown" id="header_task_bar">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="icon-tasks"></i>
						<span class="badge">5</span>
						</a>

						<ul class="dropdown-menu extended tasks">
							<li>
								<p>You have 12 pending tasks</p>
							</li>

							<li>
								<a href="#">
								<span class="task">
								<span class="desc">New release v1.2</span>
								<span class="percent">30%</span>
								</span>
								<span class="progress progress-success ">
								<span style="width: 30%;" class="bar"></span>
								</span>
								</a>
							</li>

							<li>
								<a href="#">
								<span class="task">
								<span class="desc">Application deployment</span>
								<span class="percent">65%</span>
								</span>
								<span class="progress progress-danger progress-striped active">
								<span style="width: 65%;" class="bar"></span>
								</span>
								</a>
							</li>

							<li>
								<a href="#">
								<span class="task">
								<span class="desc">Mobile app release</span>
								<span class="percent">98%</span>
								</span>
								<span class="progress progress-success">
								<span style="width: 98%;" class="bar"></span>
								</span>
								</a>
							</li>

							<li>
								<a href="#">
								<span class="task">
								<span class="desc">Database migration</span>
								<span class="percent">10%</span>
								</span>
								<span class="progress progress-warning progress-striped">
								<span style="width: 10%;" class="bar"></span>
								</span>
								</a>
							</li>

							<li>
								<a href="#">
								<span class="task">
								<span class="desc">Web server upgrade</span>
								<span class="percent">58%</span>
								</span>
								<span class="progress progress-info">
								<span style="width: 58%;" class="bar"></span>
								</span>
								</a>
							</li>

							<li>
								<a href="#">
								<span class="task">
								<span class="desc">Mobile development</span>
								<span class="percent">85%</span>
								</span>
								<span class="progress progress-success">
								<span style="width: 85%;" class="bar"></span>
								</span>
								</a>
							</li>
							<li class="external">
								<a href="#">See all tasks <i class="m-icon-swapright"></i></a>
							</li>
						</ul>
					</li>

					<!--下拉4(用户信息) -->
					<li class="dropdown user">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<img alt="" src="media/image/avatar1_small.jpg" />
						<span class="username">Bob Nilson</span>
						<i class="icon-angle-down"></i>
						</a>
						<ul class="dropdown-menu">
							<li><a href="extra_profile.html"><i class="icon-user"></i> My Profile</a></li>
							<li><a href="page_calendar.html"><i class="icon-calendar"></i> My Calendar</a></li>
							<li><a href="inbox.html"><i class="icon-envelope"></i> My Inbox(3)</a></li>
							<li><a href="#"><i class="icon-tasks"></i> My Tasks</a></li>
							<li class="divider"></li>
							<li><a href="extra_lock.html"><i class="icon-lock"></i> Lock Screen</a></li>
							<li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
    <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>

	<!-- BEGIN CONTAINER -->
	<div class="page-container">

		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar nav-collapse collapse" id="">
			<!-- 左侧菜单 -->        
			<ul class="page-sidebar-menu" id="ul-menu">
				<li>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler hidden-phone"></div>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				</li>
				<li>
					<!-- 搜索框 -->
					<form class="sidebar-search">
						<div class="input-box">
							<a href="javascript:;" class="remove"></a>
							<input type="text" placeholder="Search..." />
							<input type="button" class="submit" value=" " />
						</div>
					</form>
				</li>

				<!-- 第一个菜单(选中) -->
				<li class="start active ">
					<a href="javascript:void(0);" onclick="loadIndexContent();">
					<i class="icon-home"></i> 
					<span class="title">仪表盘</span>
					<span class="selected"></span>
					</a>
				</li>

				<li class="">
					<a href="javascript:;">
					<i class="icon-cogs"></i> 
					<span class="title">布局</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="layout_horizontal_sidebar_menu.html">
							水平和边栏菜单</a>
						</li>
						<li >
							<a href="layout_horizontal_menu1.html">
							水平菜单1</a>
						</li>
						<li >
							<a href="layout_horizontal_menu2.html">
							水平菜单2</a>
						</li>
						<li >
							<a href="layout_promo.html">
							宣传页</a>
						</li>
						<li >
							<a href="layout_email.html">
							电子邮件模板</a>
						</li>
						<li >
							<a href="layout_ajax.html">
							Ajax</a>
						</li>
						<li >
							<a href="layout_sidebar_closed.html">
							边栏页面</a>
						</li>
						<li >
							<a href="layout_blank_page.html">
							空白页</a>
						</li>
						<li >
							<a href="layout_boxed_page.html">
							盒装页</a>
						</li>
						<li >
							<a href="layout_boxed_not_responsive.html">
							无响应箱形布局</a>
						</li>
					</ul>
				</li>

				<li class="">
					<a href="javascript:;">
					<i class="icon-bookmark-empty"></i> 
					<span class="title">UI特征</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="ui_general.html">
							一般</a>
						</li>
						<li >
							<a href="ui_buttons.html">
							按钮</a>
						</li>
						<li >
							<a href="ui_modals.html">
							模态</a>
						</li>

						<li >
							<a href="ui_tabs_accordions.html">
							Tabs & Accordions</a>
						</li>
						<li >
							<a href="ui_jqueryui.html">
							jQuery UI组件</a>
						</li>
						<li >
							<a href="ui_sliders.html">
							Sliders</a>
						</li>
						<li >
							<a href="ui_tiles.html">
							Tiles</a>
						</li>
						<li >
							<a href="ui_typography.html">
							排版</a>
						</li>
						<li >
							<a href="ui_tree.html">
							树</a>
						</li>
						<li >
							<a href="ui_nestable.html">
							可嵌套列表</a>
						</li>
					</ul>
				</li>

				<li class="">
					<a href="javascript:;">
					<i class="icon-table"></i> 
					<span class="title">表单相关</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="form_layout.html">
							表单布局</a>
						</li>
						<li >
							<a href="form_samples.html">
							预案样本</a>
						</li>
						<li >
							<a href="form_component.html">
							表单组件</a>
						</li>
						<li >
							<a href="form_wizard.html">
							表单向导</a>
						</li>
						<li >
							<a href="form_validation.html">
							表单验证</a>
						</li>
						<li >
							<a href="form_fileupload.html">
							多文件上传</a>
						</li>
						<li >
							<a href="form_dropzone.html">
							下拉文件上传</a>
						</li>
					</ul>

				</li>

				<li class="">
					<a href="javascript:;">
					<i class="icon-gift"></i> 
					<span class="title">拓展</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="extra_lock.html">
							锁屏</a>
						</li>
						<li >
							<a href="inbox.html">
							收件箱</a>
						</li>
						<li >
							<a href="extra_search.html">
							搜索</a>
						</li>
						<li >
							<a href="${ctxPath}/media/html/extra_image_manager.html">
							图像管理</a>
						</li>

						<li >
							<a href="${ctxPath}/media/html/extra_404_option1.html">
							404页面1</a>
						</li>
						<li >
							<a href="${ctxPath}/media/html/extra_500_option1.html">
							500页面1</a>
						</li>
						<li >
							<a href="${ctxPath}/media/html/extra_500_option2.html">
							500页面2</a>
						</li>
					</ul>
				</li>
				
				<!-- 三级菜单 -->
				<li>
					<a class="active" href="javascript:;">
					<i class="icon-sitemap"></i> 
					<span class="title">三级菜单</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="javascript:;">
							Item 1
							<span class="arrow"></span>
							</a>
							<ul class="sub-menu">
								<li><a href="#">Sample Link 1</a></li>
								<li><a href="#">Sample Link 2</a></li>
								<li><a href="#">Sample Link 3</a></li>
							</ul>
						</li>
						<li>
							<a href="javascript:;">
							Item 1
							<span class="arrow"></span>
							</a>
							<ul class="sub-menu">
								<li><a href="#">Sample Link 1</a></li>
								<li><a href="#">Sample Link 1</a></li>
								<li><a href="#">Sample Link 1</a></li>
							</ul>
						</li>
						<li>
							<a href="#">
							Item 3
							</a>
						</li>
					</ul>
				</li>

				<!-- table -->
				<li class="">
					<a href="javascript:;">
					<i class="icon-th"></i> 
					<span class="title">数据表</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="${ctxPath}/media/html/table_basic.html">
							基本表</a>
						</li>
						<li >
							<a href="${ctxPath}/media/html/table_responsive.html">
							响应表</a>
						</li>
						<li >
							<a href="${ctxPath}/media/html/table_managed.html">
							托管表</a>
						</li>
						<li >
							<a href="${ctxPath}/media/html/table_editable.html">
							可编辑表</a>
						</li>
						<li >
							<a href="${ctxPath}/media/html/table_advanced.html">
							高级表</a>
						</li>
					</ul>
				</li>

				<!-- 系统模块 -->
				<li>
					<a class="active" href="javascript:;">
					<i class="icon-sitemap"></i> 
					<span class="title">系统模块</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="javascript:;">
							用户管理
							</a>
						</li>
						<li>
							<a href="javascript:;">
							菜单管理
							</a>
						</li>
						<li>
							<a href="#">
							角色管理
							</a>
						</li>
					</ul>
				</li>
				
				<!-- 最后一个菜单 -->
				<li class="last ">
					<a href="charts.html">
					<i class="icon-bar-chart"></i> 
					<span class="title">Visual Charts</span>
					</a>
				</li>
			</ul>
		</div>

		<!-- 首页内容 -->
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div id="portlet-config" class="modal hide">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button"></button>
					<h3>Widget Settings</h3>
				</div>
				<div class="modal-body">
					Widget settings form goes here
				</div>
			</div>
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN STYLE CUSTOMIZER -->
						<div class="color-panel hidden-phone">
							<div class="color-mode-icons icon-color"></div>
							<div class="color-mode-icons icon-color-close"></div>
							<div class="color-mode">
								<p>THEME COLOR</p>
								<ul class="inline">
									<li class="color-black current color-default" data-style="default"></li>
									<li class="color-blue" data-style="blue"></li>
									<li class="color-brown" data-style="brown"></li>
									<li class="color-purple" data-style="purple"></li>
									<li class="color-grey" data-style="grey"></li>
									<li class="color-white color-light" data-style="light"></li>
								</ul>
								<label>
									<span>Layout</span>
									<select class="layout-option m-wrap small">
										<option value="fluid" selected>Fluid</option>
										<option value="boxed">Boxed</option>
									</select>
								</label>
								<label>
									<span>Header</span>
									<select class="header-option m-wrap small">
										<option value="fixed" selected>Fixed</option>
										<option value="default">Default</option>
									</select>
								</label>
								<label>
									<span>Sidebar</span>
									<select class="sidebar-option m-wrap small">
										<option value="fixed">Fixed</option>
										<option value="default" selected>Default</option>
									</select>
								</label>
								<label>
									<span>Footer</span>
									<select class="footer-option m-wrap small">
										<option value="fixed">Fixed</option>
										<option value="default" selected>Default</option>
									</select>
								</label>
							</div>
						</div>
						<!-- END BEGIN STYLE CUSTOMIZER -->    

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							Dashboard <small>statistics and more</small>
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="index.html">Home</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="#">Dashboard</a></li>
							<li class="pull-right no-text-shadow">
								<div id="dashboard-report-range" class="dashboard-date-range tooltips no-tooltip-on-touch-device responsive" data-tablet="" data-desktop="tooltips" data-placement="top" data-original-title="Change dashboard date range">
									<i class="icon-calendar"></i>
									<span></span>
									<i class="icon-angle-down"></i>
								</div>
							</li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<div id="dashboard">
				</div>
			</div>
		</div>
	</div>

	<!-- 页脚 -->
	<div class="footer">
		<div class="footer-inner">
			2018 &copy; caihua would never disappointed you .
		</div>
		<div class="footer-tools">
			<span class="go-top">
			<i class="icon-angle-up"></i>
			</span>
		</div>
	</div>

	<!-- 主要插件 -->
	<script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>
	<script src="media/js/excanvas.min.js"></script>
	<script src="media/js/respond.min.js"></script>  
	<![endif]-->   
	
	<script src="${ctxPath}/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.blockui.min.js" type="text/javascript"></script>  
	<script src="${ctxPath}/media/js/jquery.cookie.min.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.uniform.min.js" type="text/javascript" ></script>
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="${ctxPath}/media/js/jquery.vmap.js" type="text/javascript"></script>   
	<script src="${ctxPath}/media/js/jquery.vmap.russia.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.vmap.world.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.vmap.europe.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.vmap.germany.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.vmap.usa.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  
	<script src="${ctxPath}/media/js/jquery.flot.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.flot.resize.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.pulsate.min.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/date.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/daterangepicker.js" type="text/javascript"></script>     
	<script src="${ctxPath}/media/js/jquery.gritter.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/fullcalendar.min.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/jquery.sparkline.min.js" type="text/javascript"></script>  
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${ctxPath}/media/js/app.js" type="text/javascript"></script>
	<script src="${ctxPath}/media/js/index.js" type="text/javascript"></script>        


	<script type="text/javascript">
		jQuery(document).ready(function() {    
		   App.init(); // initlayout and core plugins
		   Index.init();
		   Index.initJQVMAP(); // init index page's custom scripts
		   Index.initCalendar(); // init index page's custom scripts
		   Index.initCharts(); // init index page's custom scripts
		   Index.initChat();
		   Index.initMiniCharts();
		   Index.initDashboardDaterange();
		   Index.initIntro();
		   loadIndexContent();
		   loadMenu(menuData);
		});
		
		// 加载首页内容 
		function loadIndexContent() {
			//$("#dashboard").load("${ctxPath}/loadIndexContent.do");
		}
		
		// 渲染菜单栏 
		function loadMenu(data) {
			var html='';
			for(var key in data) {
				if (data[key]) {
					html +='<li><a class="" href="'+data[key]["link"]+'"><i class="icon-sitemap"></i> <span class="title">'+data[key]["name"]+'</span> <span class="arrow "></span></a>';
					if(data[key]["child"]) {
						html += createSubNode(data[key]["child"]);
					}
					html+='</li>';
				}
			}
			$('#ul-menu').append(html);
		}
		
		// 渲染子节点
		function createSubNode(data) {
			var html='<ul class="sub-menu">';
			for(var key in data) {
				if(data[key]["child"]) {
					html +='<li><a class="" href="'+data[key]["link"]+'"><i class="icon-sitemap"></i> <span class="title">'+data[key]["name"]+'</span><span class="arrow "></span></a>';
					html += createSubNode(data[key]["child"]);
				} else {
					html +='<li><a class="" href="'+data[key]["link"]+'"><i class="icon-sitemap"></i> <span class="title">'+data[key]["name"]+'</span></a>';
				}
				html += '</li>';
			}
			html += '</ul>';
			return html;
		}
		
		// 模拟菜单数据 
		var menuData = {
			"1":{
				name:"系统模块", 
			    link:"",
			    child: {
			    	"1-1":{
			    		name:"用户管理",
			    		link:"index.do",
			    		child: {
					    	"1-1-1":{name:"添加用户",link:"index.do"},
					    	"1-1-2":{name:"查看用户",link:"login.do"},
					    	"1-1-3":{name:"删除用户",link:"toLogin.do"}
			    		}
				    },
			    	"1-2":{
			    		name:"菜单管理",
			    		link:"login.do",
			    		child: {
					    	"1-2-1":{name:"添加用户",link:"index.do"},
					    	"1-2-2":{name:"查看用户",link:"login.do"},
					    	"1-2-3":{name:"删除用户",link:"toLogin.do"}
			    		}
		    		},
			    	"1-3":{name:"角色管理",link:"toLogin.do"}
			    }
			},
			"2":{
				name:"系统模块2", 
			    link:"",
			    child: {
			    	"2-1":{
			    		name:"用户管理2",
			    		link:"index.do",
			    		child: {
					    	"2-1-1":{name:"添加用户2",link:"index.do"},
					    	"2-1-2":{name:"查看用户2",link:"login.do"},
					    	"2-1-3":{name:"删除用户2",link:"toLogin.do"}
			    		}
				    },
			    	"2-2":{name:"菜单管理2",link:"login.do"},
			    	"2-3":{name:"角色管理2",link:"toLogin.do"}
			    }
			}
		}
	</script>
</body>
</html>