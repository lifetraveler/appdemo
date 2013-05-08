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
<title>欢迎登陆社会保障精算业务系统</title>
</head>
<body>
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