<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
	String basePath = request.getContextPath();
	String swfPath = basePath + "/scripts/swfupload/swfupload.swf";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="<%=basePath%>/scripts/super/css/demo.css" rel="stylesheet" type="text/css" />
<style type="text/css">

body {
	margin: 0;
	padding: 0;
	border: 0;
	width: 100%;
	height: 100%;
}
fieldset {
	border: solid 1px #aaa;
}

.hideFieldset {
	border-left: 0;
	border-right: 0;
	border-bottom: 0;
}

.hideFieldset .fieldset-body {
	display: none;
}

.asLabel .mini-textbox-border,.asLabel .mini-textbox-input,.asLabel .mini-buttonedit-border,.asLabel .mini-buttonedit-input,.asLabel .mini-textboxlist-border
	{
	border: 0;
	background: none;
	cursor: default;
}

.asLabel .mini-buttonedit-button,.asLabel .mini-textboxlist-close {
	display: none;
}

.asLabel .mini-textboxlist-item {
	padding-right: 8px;
}
</style>

<script src="<%=basePath%>/scripts/boot.js" type="text/javascript"></script>

<!--引入皮肤样式-->
<link href="<%=basePath%>/scripts/miniui/themes/blue/skin.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>/scripts/swfupload/swfupload.js" type="text/javascript"></script>
<script src="<%=basePath%>/scripts/super/super.js" type="text/javascript"></script>

</head>
</html>

