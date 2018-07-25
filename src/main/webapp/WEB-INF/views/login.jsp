<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>办公管理系统-登录页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
	<meta name="Keywords" content="keyword1,keyword2,keyword3"/>
	<meta name="Description" content="网页信息的描述" />
	<meta name="Author" content="gdcct.gov.cn" />
	<meta name="Copyright" content="All Rights Reserved." />
	<link href="${path}/dota2.ico" rel="shortcut icon" type="image/x-icon" />
	<link href="${path}/pujin.ico" rel="shortcut icon" type="image/x-icon" />
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<style type="text/css">
		body{ 
			background-repeat: repeat; 
			background-positon: 100%, 100%; 
		} 
		li{
			margin-left:20px;
		}
	</style>
	<script type="text/javascript">
	$(function(){
		/** 验证码看不清,绑定看不清验证码的a标签 */
		$("#change").click(function(){
			/** 设置属性,更换验证码图片 */
			$("#vimg").attr("src","${path}/verify.jspx?random="+Math.random());
		});
		/** 实现把鼠标放在验证码图片上变成手状的功能 */
		$("#vimg").mouseover(function(){
			$(this).css("cursor","pointer");
		}).click(function(){
			$("#change").trigger("click");//触发点击事件
		});
		/** 登录表单验证 */
		$("#login_btn").click(function(){
			var userId = $("#userId");
			var password = $("#password");
			var vcode = $("#vcode");
			var msg = "";
			/** 判空 */
			if ($.trim(userId.val())==null){
				msg = "用户名不能为空!";
				userId.focus();//重新获取焦点
			}else if (!/^\w{5,20}$/.test($.trim(userId.val()))){
				msg="用户格式不正确!";
				userId.focus();
			}else if ($.trim(password.val())==null){
				msg="密码不能为空!";
				userId.focus();
			}else if (!/^\w{6,20}$/.test($.trim(password.val()))){
				msg="密码格式不正确!";
				userId.focus();
			}else if ($.trim(vcode.val())==null){
				msg="验证码不能为空!";
				userId.focus();
			}else if (!/^[a-zA-Z0-9]{4}$/.test($.trim(vcode.val()))){
				msg="验证码格式不正确!";
				userId.focus();
			}
			if(msg!=""){
				alert(msg);
			}else{
				/** 把登录表单中的input元素序列化成get请求字符串 */
				var params = $("#loginForm").serialize();
				//alert(params);
				/** 异步请求登录 */
				$.ajax({
					url : "${path}/admin/loginAjax.jspx",
					type : "post",
					data : params,
					dataType : "json",
					async : true,
					success : function(data){
						if(data.status == 0){
							window.location.href = "${path}/admin/main.jspx";
						}else{
							alert(data.tip);
							/** 更换验证码 (触发验证码单击事件)*/
							$("#change").trigger("click");
						};
					},
					error : function(){//请求失败
						alert("数据加载失败");
					}
				});
			};
		});
		/** 添加'按下回车一样可以提交表单'功能 */
		/** 监听用户是否按下了回车键 */
		$(document).keydown(function(event){
			//event.keyCode 事件对象的按键号
			//alert(event.keyCode);
			if(event.keyCode == 13){
				$("#login_btn").trigger("click");
			}
		});
	});
	
	</script>
</head>
<body background="${path}/images/login/9.png">
	<div align="center" style="height:100%">
		<form  method="post" id="loginForm">
			<table border="0" cellpadding="0" cellspacing="0" style="margin-top:120px;">
				<tr>
					<td colspan="2" width="447" height="104" style="background-image: url('${path}/images/login/1_01.jpg');"></td>
				</tr>
				<tr>
					<td width="92" height="200" style="background-image: url('${path}/images/login/1_02.gif');">&nbsp;</td>
					<td width="355" height="200" style="background-image: url('${path}/images/login/1_03.gif');">
						<table style="font-size:13px;margin:0 0 0 30px;" >
							<tr align="left">
								<td>用户名：</td>
								<td colspan="2">
									<input type="text" name="userId" size="15" id="userId"/>
								</td>
								
							</tr>
							<tr align="left">
								<td>密&nbsp;&nbsp;码：</td>
								<td>
									<input type="password" name="password" size="15" id="password"/>
								</td>
								<td>
									<a href="javascript:void(0)" id="findpwd" style="font-size:12px;color:white;">忘了密码?</a>
								</td>
							</tr>
						   <tr align="left">
								<td>验证码：</td>
								<td>
									<div style="float:left;">
										<input type="text" name="vcode" size="4" maxlength="4" id="vcode"/>
									</div>
									<div style="float:left;padding:0 0 0 5px;">
										<img src="${path}/verify.jspx" width="60" height="22" title="验证码" id="vimg"/>
									</div>
								</td>
								<td align="left">
									<a href="javascript:void(0);" id="change" style="font-size:12px;color:white;">看不清楚</a>
								</td>
						   </tr>
						   <tr align="left">
						   		<td>&nbsp;</td>
								<td colspan="2"><input type="checkbox" name="key" value="1" id="key"/>记住用户</td>
						   </tr>
						 
						  <tr align="center">
							<td colspan="3">
								<input type="button" value="登 录" width="67" height="22" id="login_btn"/>&nbsp;
								<input type="reset" value="重 置"/>
							</td>
						  </tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="3" width="447" height="34" style="background-image: url('${path}/images/login/1_04.gif');"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>