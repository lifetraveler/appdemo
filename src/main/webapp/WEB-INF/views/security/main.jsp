<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.Date"%>
<%@ include file="include.inc.jsp"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="com.zoc.entity.security.User"%>
<%
	Subject currentUser = SecurityUtils.getSubject();
	User user = (User)currentUser.getPrincipal();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>社会保障精算分析系统</title>


<style type="text/css">
body {
	margin: 0;
	padding: 0;
	border: 0;
	width: 100%;
	height: 100%;
	overflow: hidden;
}

.header {
	background: url("<%=basePath%>/scripts/super/images/header.gif") repeat-x 0 -1px;
}
</style>
</head>
<body>
	<!-- Layout -->
	<div id="mainLayout" class="mini-layout" style="width: 100%; height: 100%;">
		<div class="header" region="north" height="80" showSplit="false" showHeader="false">
			<h1 style="margin: 0; padding: 15px; cursor: default; font-family: 微软雅黑, 黑体, 宋体;">社会保障精算分析系统</h1>
			<div style="position: absolute; top: 18px; right: 10px;">
					<a class="mini-button mini-button-iconTop" iconCls="icon-add" onclick="onQuickClick" plain="true">快捷</a> 
					<a class="mini-button mini-button-iconTop" iconCls="icon-edit" onclick="onClick" plain="true">首页</a> 
					<a class="mini-button mini-button-iconTop" iconCls="icon-date" onclick="onClick" plain="true">消息</a>
					<a class="mini-button mini-button-iconTop" iconCls="icon-edit" onclick="onClick" plain="true">设置</a> 
					<a class="mini-button mini-button-iconTop" iconCls="icon-close" href="<%=basePath%>/logout" plain="true">关闭</a>
			</div>
			<div style="position:absolute;left:12px;bottom:5px;font-size:12px;line-height:25px;font-weight:normal;">
            <span style="color:Red;font-family:Tahoma">用户名：</span><%=user.getRealname() %>
             <span style="color:Red;font-family:Tahoma">所在地：</span><%=user.getLocation() %>
        	</div>
		</div>
		<div title="south" region="south" showSplit="false" showHeader="false" height="30">
		<div style="line-height: 28px; text-align: center; cursor: default">Super</div>
		</div>
		<div title="center" region="center" style="border: 0;" bodyStyle="overflow:hidden;">
			<!--Splitter-->
			<div class="mini-splitter" style="width: 100%; height: 100%;" borderStyle="border:0;">
				<!-- Left -->
				<div size="180" maxSize="250" minSize="100" showCollapseButton="true" style="border: 0;">
					<!--OutlookTree-->
				<%-- 	<div id="leftTree" class="mini-outlooktree" url="<%=basePath%>/outlooktree.txt" onnodeselect="onNodeSelect" textField="text" idField="id" parentField="pid">
					</div> --%>
					<div id="leftTree" class="mini-outlooktree" url="<%=basePath%>/menu/list" onnodeselect="onNodeSelect" textField="menu_desc" idField="menu_id" parentField="parent_id">
					</div>
				</div>
				<!-- Center -->
				<div showCollapseButton="false" style="border: 0;">
					<div id="mainTabs" class="mini-tabs" activeIndex="0" style="width: 100%; height: 100%;" plain="false">
						<div title="首页" url="<%=basePath%>/overview.html"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//init
		mini.parse();
		
		//left tree
		var tree = mini.get("leftTree");
		
		function showTab(node) {
		          var tabs = mini.get("mainTabs");
		
		          var id = "tab$" + node.menu_id;
		          var tab = tabs.getTab(id);
		          if (!tab) {
		              tab = {};
		              tab.name = id;
		              tab.title = node.menu_desc;
		              tab.showCloseButton = true;
		              tab.url = '<%=basePath%>' + node.menu_url;
		              tabs.addTab(tab);
		          }
		          tabs.activeTab(tab);
		      }
		
		      function onNodeSelect(e) {
		      
		          var node = e.node;
		          var isLeaf = e.isLeaf;
		
		          if (isLeaf) {
		              showTab(node);
		          }
		      }
		
		      function onClick(e) {
		          var text = this.getText();
		          alert(text);
		      }
		      function onQuickClick(e) {
		          tree.expandPath("data");
		          tree.selectNode("inner-2-1");
		      }
		      
		      function onCloseClick(e){
		    	  
		      }
		
	</script>
</body>
</html>