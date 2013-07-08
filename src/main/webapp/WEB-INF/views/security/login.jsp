<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ page
	import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ include file="include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>社会保险精算基础数据管理平台</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/scripts/login/css/layout.css" />
<style type="text/css">
.STYLE1 {
	font-size: 11pt;
	font-weight: bold;
}
.login {
	background-image:url(<%=basePath%>/scripts/login/images/loginbg.png);
	width:517px;
	height:339px;
	margin:15% auto 0 auto;
}
#form1{
padding:150px 0 0 0;
float:left;
}

</style>
<script type="text/javascript">  
(function($){
	$.fn.supersized = function() {
		$.inAnimation = false;
		$.paused = false;
		var options = $.extend($.fn.supersized.defaults, $.fn.supersized.options);
		
		$(window).bind("load", function(){
			$('#loading').hide();
			$('#supersize').fadeIn('fast');
			
			
		});
				
		$(document).ready(function() {
			$('#supersize').resizenow(); 
		});
		
		$(window).bind("resize", function(){
    		$('#supersize').resizenow(); 
		});
		
	};
	
	//Adjust image size
	$.fn.resizenow = function() {
		var options = $.extend($.fn.supersized.defaults, $.fn.supersized.options);
	  	return this.each(function() {
	  		
			//Define image ratio
			var ratio = options.startheight/options.startwidth;
			
			//Gather browser and current image size
			var imagewidth = $(this).width();
			var imageheight = $(this).height();
			var browserwidth = $(window).width();
			var browserheight = $(window).height();
			var offset;
			

			//Resize image to proper ratio
			if ((browserheight/browserwidth) > ratio){
			    $(this).height(browserheight);
			    $(this).width(browserheight / ratio);
			    $(this).children().height(browserheight);
			    $(this).children().width(browserheight / ratio);
			} else {
			    $(this).width(browserwidth);
			    $(this).height(browserwidth * ratio);
			    $(this).children().width(browserwidth);
			    $(this).children().height(browserwidth * ratio);
			}
			if (options.vertical_center == 1){
				$(this).children().css('left', (browserwidth - $(this).width())/2);
				$(this).children().css('top', (browserheight - $(this).height())/2);
			}
			return false;
		});
	};
	
})(jQuery);


$(function(){
	$.fn.supersized.options = {  
		startwidth: 1440,  
		startheight: 900,
		vertical_center: 1,
		slideshow: 1,
		navigation: 1,
		transition: 1, 
		pause_hover: 0,
		slide_counter: 1,
		slide_captions: 1,
		slide_interval: 1000  
	};
	$('#supersize').supersized(); 
});
	
</script>
</head>
<body>
	<div id="supersize">
        <a href="javascript:;">
        	<img src="<%=basePath%>/scripts/login/images/bg.jpg" alt="" title="Forestt Studio" />
        </a>
	</div>
	<div id="loginWindow" class="mini-window" title="用户登录"
		style="width: 350px; height: 165px;" showModal="true"
		showCloseButton="false">
		<div id="loginForm" style="padding: 15px; padding-top: 10px;">
			<form  id="loginform" action="<%=basePath%>/login" method="post">
				<table>
					<tr>
						<td style="width: 60px;"><label for="username$text">帐号：</label></td>
						<td><input id="username" name="username"
							onvalidation="onUserNameValidation" class="mini-textbox"
							required="true" style="width: 150px;"  value="admin"/></td>
					</tr>
					<tr>
						<td style="width: 60px;"><label for="pwd$text">密码：</label></td>
						<td><input id="pwd" name="password" onvalidation="onPwdValidation"
							class="mini-password" requiredErrorText="密码不能为空" required="true"
							style="width: 150px;" onenter="onLoginClick" value="admin" /> 
					</tr>
					<tr>
						<td></td>
						<td style="padding-top: 5px;"><a onclick="onLoginClick"
							class="mini-button" style="width: 60px;">登录</a> <a
							onclick="onResetClick" class="mini-button" style="width: 60px;">重置</a>
						</td>
					</tr>
					<tr>
						<td colspan="2">${error }</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

			<%
				String error = (String) request
						.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
				if (error != null) {
			%>
				<div>登录失败，请重试...<%=error %></div>
			<%
				}
			%>
			
	<script type="text/javascript">
		mini.parse();
	    var loginWindow = mini.get("loginWindow");
	    loginWindow.show();
	    
	    function onLoginClick(){
	    	document.forms["loginform"].submit();
	    }
    </script>
</body>
</html>