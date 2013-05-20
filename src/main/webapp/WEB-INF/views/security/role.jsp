<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.Date"%>
<%@ include file="../security/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>role</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	border: 0;
	width: 100%;
	height: 100%;
	overflow: hidden;
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
</head>
<body>
	<div class="mini-splitter" style="width: 100%; height: 100%;">
		<div size="300" showCollapseButton="true">
			<div class="mini-toolbar"
				style="padding: 2px; border-top: 0; border-left: 0; border-right: 0;">
				<span style="padding-left: 5px;">名称：</span> <input
					class="mini-textbox" /> <a class="mini-button"
					iconCls="icon-search" plain="true">查找</a>
			</div>
			<div id="datagrid1" class="mini-datagrid"
				style="width: 99%; height: 95%;" fitColumns="true"
				allowResize="false" sizeList="[20,30,50,100]" pageSize="20"
				pageIndex="1" url="<%=basePath%>/role/list">
				<div property="columns">
					<div type="indexcolumn"></div>
					<div field="role_id" width="100" headerAlign="center"
						allowSort="true">类别</div>
					<div field="role_desc" width="120" headerAlign="center"
						allowSort="true">类型</div>
				</div>
			</div>
		</div>
		<div>
			<div class="mini-toolbar"
				style="padding: 2px; border-top: 0; border-left: 0; border-right: 0;">
				<a class="mini-button" iconCls="icon-add" plain="true"
					onclick="addRow()">新增</a> <span class="separator"></span> <a
					class="mini-button" iconCls="icon-edit" plain="true"
					onclick="updateRow()">修改</a> <span class="separator"></span> <a
					class="mini-button" iconCls="icon-remove" plain="true"
					onclick="removeRow()">删除</a> <span class="separator"></span> <a
					class="mini-button" iconCls="icon-save" plain="true"
					onclick="saveData()">保存</a>
			</div>
			<div class="mini-fit" style="padding-left: 50px">
				<!-- 基本信息 -->
				<fieldset id="fd1" style="width: 650px;">
					<legend>
						<span>角色信息</span>
					</legend>
					<div class="fieldset-body">
						<input name="state" class="mini-hidden" />
						<table class="form-table" border="0" cellpadding="1"
							cellspacing="2">
							<tr>
								<td class="form-label" style="width: 60px;">角色编号：</td>
								<td style="width: 150px"><input name="role_id"
									class="mini-textbox" /></td>
								<td class="form-label" style="width: 60px;">角色名称：</td>
								<td style="width: 150px"><input name="role_desc"
									class="mini-textbox" /></td>
							</tr>
						</table>
					</div>
				</fieldset>
				<fieldset id="fd2" style="width: 650px; height: 350px">
					<legend>
						<span>菜单及资源分配</span>
					</legend>
					<div class="mini-splitter" style="width: 100%; height: 95%;">
						<div size=300 style="overflow: auto">
							<span style="margin: 0; line-height: 22px; font-size: 13px;">菜单选择：</span>
							<ul id="tree1" class="mini-tree" url="<%=basePath%>/menu/list"
								style="width: 100%;" showTreeIcon="true" textField="menu_desc"
								idField="menu_id" parentField="parent_id" resultAsTree="false"
								showCheckBox="true" checkRecursive="true">
							</ul>
						</div>
						<div class="mini-fit">
							<span
								style="margin: left:  10px; line-height: 22px; font-size: 13px;">权限选择：</span>
							<div id="permissionGrid" class="mini-datagrid"
								style="width: 100%; height: 100%; padding: 5px"
								showPageSize="false" showPageIndex="false"
								pagerStyle="padding:2px;" multiSelect="true"
								url="<%=basePath%>/permission/listPermissionByRoleIdMenuId">
								<div property="columns">
									<div type="checkcolumn" name="checked"></div>
									<div field="permission" width="150" headerAlign="center"
										allowSort="true">权限</div>
								</div>
							</div>
						</div>
					</div>
				</fieldset>
			</div>

		</div>
	</div>


	<script type="text/javascript">
	 	mini.parse();
		var grid = mini.get("datagrid1");
		var tree = mini.get("tree1");
		var permissionGrid = mini.get("permissionGrid");
		grid.load();
		
		var currentNode;
		
		var form = new mini.Form("fd1");
		
		readonlyModel(form);

		
        //加载菜单信息
		grid.on('rowclick',function(e){
			tree.load('<%=basePath%>/menu/listByRoleId?role_id=' + e.row.role_id);
			readonlyModel(form);
			form.setData(e.row);
		});
        
		tree.on("nodeselect", function (e) {
			
	 		 var selectedRole = grid.getSelected();
	 		 if(selectedRole == null ) return;
	 		 if(currentNode != null){
	 			 var permissions = permissionGrid.getSelecteds();
	 			 currentNode.node.permissions = permissions;
	 		 }
	 		 
	 		 permissionGrid.load({
	 			role_id : selectedRole.role_id,
	 			menu_id : e.node.menu_id
	 		},function(){
	 			for(var i = 0; i < permissionGrid.data.length; i++){
	 				var row = permissionGrid.getRow(i);
	 				for(var j = 0;j<e.node.permissions.length; j++){
	 					console.log()
	 					if(e.node.permissions[j].permission == row.permission){
	 						permissionGrid.setSelected(row);
	 					}
	 				}
	 			}
	 		});
	 		currentNode = e;
       });
		//////////////////////////////////////////////////////

        function search() {       
            var key = mini.get("key").getValue();
            grid.load({ code_name : key });
        }
        function onKeyEnter(e) {
            search();
        }
        function addRow() {
        	editModel(form,'added');
        	tree.load('<%=basePath%>/menu/list');
        	permissionGrid.clearRows();
        }
        
        function updateRow(){
        	editModel(form,'modified',function(field){
	 			if(field.name == 'role_id'){
	 				if (field.setReadOnly) field.setReadOnly(true);     //只读
		            if (field.addCls) field.addCls("asLabel");          //增加asLabel外观
	 			}
	 		});	
        	
        }
        
        function removeRow() {
            var rows = grid.getSelecteds();
            if (rows.length > 0) {
                grid.removeRows(rows, true);
            }
        }
        function saveData() {
        	
        	if(currentNode != null){
	 			 var permissions = permissionGrid.getSelecteds();
	 			 currentNode.node.permissions = permissions;
	 		 }
        	
        	var data = form.getData();
        	
        	var menuData = tree.getCheckedNodes();
        	
        	data.menus = menuData;
        	
            
            if(data.state == ''){
	 			alert('没有数据提交');
	 			return;
	 		}
            
            var json = mini.encode(data);
            
			$.ajax({
				url: "<%=basePath%>/role/save",
				data : {
					data : json
				},
				type : "post",
				success : function(text) {
					alert(text);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert(jqXHR.responseText);
				}
			});
		}
	</script>
</body>
</html>