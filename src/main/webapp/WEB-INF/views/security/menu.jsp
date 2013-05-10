<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.Date"%>
<%@ include file="../security/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>menu</title>
<style type="text/css">
    body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
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
	
    .asLabel .mini-textbox-border,
    .asLabel .mini-textbox-input,
    .asLabel .mini-buttonedit-border,
    .asLabel .mini-buttonedit-input,
    .asLabel .mini-textboxlist-border
    {
        border:0;background:none;cursor:default;
    }
    .asLabel .mini-buttonedit-button,
    .asLabel .mini-textboxlist-close
    {
        display:none;
    }
    .asLabel .mini-textboxlist-item
    {
        padding-right:8px;
    }    
    </style>  
</head>
<body>
	<div class="mini-splitter" style="width:100%;height:100%;">
		<div size="240" showCollapseButton="true">
			 <div class="mini-toolbar" style="padding:2px;border-top:0;border-left:0;border-right:0;">                
	            <span style="padding-left:5px;">名称：</span>
	            <input class="mini-textbox" />
	            <a class="mini-button" iconCls="icon-search" plain="true">查找</a>                  
	        </div>
	        <div class="mini-fit">
	            <ul id="tree1" class="mini-tree" url="<%=basePath%>/menu/list" style="width:100%;"
	                showTreeIcon="true" textField="menu_desc" idField="menu_id" parentField="parent_id" resultAsTree="false" >        
	            </ul>
	        </div>
		</div>
		<div >
			<div class="mini-toolbar"
				style="padding: 2px; border-top: 0; border-left: 0; border-right: 0;">

				<a class="mini-button" iconCls="icon-add" plain="true" onclick="addRow()">新增</a> 
				<span class="separator"></span> 
				<a class="mini-button" iconCls="icon-edit" plain="true" onclick="updateRow()">修改</a> 
				<span class="separator"></span> 
				<a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeRow()">删除</a> 
				<span class="separator"></span> 
				<a class="mini-button" iconCls="icon-save" plain="true" onclick="saveData()">保存</a>
			</div>
			<div class="mini-fit" style="padding-left:50px">
			<!-- 基本信息 -->
				<fieldset id="fd1" style="width: 650px;">
					<legend>
						<span>菜单信息</span>
					</legend>
					<div class="fieldset-body">
					<input  name="state" class="mini-hidden" />
						<table class="form-table" border="0" cellpadding="1" cellspacing="2">
							<tr>
								<td class="form-label" style="width: 60px;">菜单编号：</td>
								<td style="width: 150px"><input name="menu_id"
									class="mini-textbox" /></td>
								<td class="form-label" style="width: 60px;">菜单名称：</td>
								<td style="width: 150px"><input name="menu_desc"
									class="mini-textbox" /></td>
							</tr>
							<tr>
								<td class="form-label">上级菜单：</td>
								<td style="width: 150px">
									<input name="parent_id" class="mini-treeselect"  url="<%=basePath%>/menu/list"  textField="menu_desc" valueField="menu_id"  parentField="parent_id" resultAsTree="false" />
								</td>
								<td class="form-label">显示顺序：</td>
								<td><input name="menu_order" class="mini-spinner" /></td>
							</tr>
							<tr>
								<td class="form-label">菜单路径：</td>
								<td colspan="3" >
									<input name="menu_url" class="mini-textbox"  style="width:344px"></input>
								</td>
							</tr>
						</table>
					</div>
				</fieldset>
				<!-- Permission -->
				<fieldset id="fd2" style="width: 650px;">
					<legend>
						<span>权限信息</span>
					</legend>
					<div style=" line-height: 23px; padding: 5px;">
					<div>
						<span>权限：</span> <input id="keyText" class="mini-textbox"
							style="width: 160px;" onenter="onSearchClick" /> <a
							class="mini-button" onclick="onSearchClick"
							style="width: 60px; height: 20px;">查找</a>
					</div>
					</div>
					<div style="padding-left: 5px; padding-right: 5px;">
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<span style="margin: 0; line-height: 22px; font-size: 13px;">权限列表：</span>
									<div id="serachGrid" class="mini-datagrid"
										style="width: 250px; height: 200px;" showPageSize="false"
										showPageIndex="false" pagerStyle="padding:2px;" multiSelect="true"
										url="<%=basePath %>/permission/list">
										<div property="columns">
											<div type="checkcolumn"></div>
											<div field="permission" width="150" headerAlign="center"
												allowSort="true">权限</div>
										</div>
									</div>
								</td>
								<td style="padding: 5px;"><a  class="mini-button"
									onclick="addSelected()" style="width: 50px;">选择</a><br /></td>
								<td>
									<span style="margin: 0; line-height: 22px; font-size: 13px;">已选权限：</span>
									<div id="selectedList" class="mini-listbox"
										style="width: 250px; height: 200px;" showCheckBox="true"
										multiSelect="true">
										<div property="columns">
											<div field="permission" width="150" headerAlign="center"
												allowSort="true">权限</div>
										</div>
									</div>
								</td>
								<td style="padding: 5px;">
									<a class="mini-button" type="button"  onclick="removeSelecteds()" style="width: 55px; margin-bottom: 2px;" >删除</a>
									<br /> 
									<a class="mini-button" type="button"  onclick="removeAllSelecteds()" style="width: 55px;" >清空</a>
									<br />
								</td>
							</tr>
						</table>
					</div>
				</fieldset>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	 	mini.parse();
	 	var tree = mini.get("tree1");
	 	var grid = mini.get("serachGrid");
	 	var selectedList = mini.get("selectedList");
	 	var keyText = mini.get("keyText");
	 	var form = new mini.Form("fd1");
	 	var selectedNode;
	 	grid.load();
	 	readonlyModel();
	 	
	 	tree.on("nodeselect", function (e) {
	 		 selectedNode = e;
	 		 readonlyModel();
	 		 selectedList.removeAll();
	 		 $.ajax({
	 			url  : '<%=basePath%>/menu/fetchByPermission',
	 			type : 'post',
	 			data : {menu_id : e.node.menu_id},
	 			success : function(menu){
	 					form.setData(menu);
	 					selectedList.addItems(menu.permissions);
	 			}	 
	 		 });
	 		 
        });
	 	
	 	function readonlyModel(){
	 		var fields = form.getFields();
	 		for (var i = 0, l = fields.length; i < l; i++) {
	            var c = fields[i];
	            if (c.setReadOnly) c.setReadOnly(true);     //只读
	            if (c.addCls) c.addCls("asLabel");          //增加asLabel外观
	        }
	 	}
	 	
	 	function editModel(callback){
	 		var fields = form.getFields();
            for (var i = 0, l = fields.length; i < l; i++) {
                var c = fields[i];
                if (c.setReadOnly) c.setReadOnly(false);
                if (c.removeCls) c.removeCls("asLabel");
                if(callback) callback(c);
            }
            mini.repaint(document.body);
	 	}
	 	
	 	function onSearchClick(e) {
            grid.load({
                permission: keyText.value
            });
        }
	 	
	 	function addRow(){
	 		editModel();
            form.reset();
            form.setData({state:'added'});
	 	}
	 	
	 	function updateRow(){
	 		editModel(function(field){
	 			if(field.name == 'menu_id'){
	 				if (field.setReadOnly) field.setReadOnly(true);     //只读
		            if (field.addCls) field.addCls("asLabel");          //增加asLabel外观
	 			}
	 			if(field.name == 'state'){
	 				field.value = 'modified';
	 			}
	 		});
	 	}
	 	
	 	function deleteRow(message){
	 		mini.confirm(message, "确定？",
		            function (action) {            
		                if (action == "ok") {
		                	$.ajax({
		        	 			url  : '<%=basePath%>/menu/remove',
		        	 			type : 'post',
		        	 			data : {data:mini.encode(selectedNode.node)},
		        	 			success : function(text){
		        	 				alert('提交成功');
		        	 				tree.load('<%=basePath%>/menu/list');
		        	 			}
		        	 		});	
		                }
		            }
 			    );	
	 	}
	 	
	 	function removeRow(){
	 		if(selectedNode){
	 			deleteRow(selectedNode.isLeaf ? '确定删除记录？' : '该菜单下有子菜单，是否删除？');
	 		}else{
	 			alert('请选择要删除的菜单');
	 		}
	 	}
	 	
	 	function saveData(){
	 		var data = form.getData();
	 		var permissions = selectedList.getData();
	 		data.permissions = permissions;
	 		if(data.state == ''){
	 			alert('没有数据提交');
	 			return;
	 		}
	 		var json = mini.encode(data);
	 		$.ajax({
	 			url  : '<%=basePath%>/menu/save',
	 			type : 'post',
	 			data : {data:json},
	 			success : function(text){
	 				alert('提交成功');
	 			}
	 		});
	 	}
	 	
	 	function addSelected(){
	 		var items = grid.getSelecteds();
	 		
	 		
	 		//根据id属性，来甄别要加入选中的记录
            var idField = grid.getIdField();
	 		
	 		//把已选中的数据，用key-value缓存，以便进一步快速匹配
            var idMaps = {};
            var selecteds = selectedList.getData();
            for (var i = 0, l = selecteds.length; i < l; i++) {
                var o = selecteds[i];
                var id = o._uid;
                idMaps[id] = o;
            }

            //遍历要加入的数组
            for (var i = items.length - 1; i >= 0; i--) {
                var o = items[i];
                var id = o._uid;
                if (idMaps[id] != null) items.removeAt(i);
            }
	 		
            selectedList.addItems(items);
	 		
	 	}
	 	
	 	function removeSelecteds() {
            var items = selectedList.getSelecteds();
            selectedList.removeItems(items);
        }
        function removeAllSelecteds() {
            selectedList.removeAll();
        }
	</script>
</body>
</html>