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
<script src="<%=basePath%>/scripts/boot.js" type="text/javascript"></script>
<script src="<%=basePath%>/scripts/swfupload/swfupload.js" type="text/javascript"></script>
<script src="<%=basePath%>/scripts/super/super.js" type="text/javascript"></script>
</head>
</html>

