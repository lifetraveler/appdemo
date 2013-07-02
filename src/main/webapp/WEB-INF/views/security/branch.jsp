<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.Date"%>
<%@ include file="../security/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>branch</title>
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
	            <ul id="tree1" class="mini-tree" url="<%=basePath%>/branch/list" style="width:100%;"
	                showTreeIcon="true" textField="branch_name" idField="branch_code" parentField="parent_branch" resultAsTree="false"  expandOnLoad='0'>        
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
						<span>机构信息</span>
					</legend>
					<div class="fieldset-body">
					<input  name="state" class="mini-hidden" />
						<table class="form-table" border="0" cellpadding="1" cellspacing="2">
							<tr>
								<td class="form-label" style="width: 60px;">机构代码：</td>
								<td style="width: 150px"><input name="branch_code"
									class="mini-textbox" /></td>
								<td class="form-label" style="width: 60px;">机构名称：</td>
								<td style="width: 150px"><input name="branch_name"
									class="mini-textbox" /></td>
							</tr>
							<tr>
								<td class="form-label">上级机构：</td>
								<td style="width: 150px">
									<input name="parent_branch" class="mini-treeselect"  url="<%=basePath%>/branch/list"  textField="branch_name" valueField="branch_code"  parentField="parent_branch" resultAsTree="false" />
								</td>
								<td class="form-label">显示顺序：</td>
								<td><input name="branch_order" class="mini-spinner" /></td>
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
	 	var keyText = mini.get("keyText");
	 	var form = new mini.Form("fd1");
	 	var selectedNode;
	 	readonlyModel(form);
	 	
	 	tree.on("nodeselect", function (e) {
	 		 selectedNode = e;
	 		 readonlyModel(form);
	 		form.setData(e.node);
        });
	 	
	 	
	 	function onSearchClick(e) {
            grid.load({
                permission: keyText.value
            });
        }
	 	
	 	function addRow(){
	 		editModel(form,'added');
	 	}
	 	
	 	function updateRow(){
	 		editModel(form,'modified',function(field){
	 			if(field.name == 'branch_code'){
	 				if (field.setReadOnly) field.setReadOnly(true);     //只读
		            if (field.addCls) field.addCls("asLabel");          //增加asLabel外观
	 			}
	 		});
	 	}
	 	
	 	function deleteRow(message){
	 		mini.confirm(message, "确定？",
		            function (action) {            
		                if (action == "ok") {
		                	$.ajax({
		        	 			url  : '<%=basePath%>/branch/remove',
		        	 			type : 'post',
		        	 			data : {data:mini.encode(selectedNode.node)},
		        	 			success : function(text){
		        	 				alert(text);
		        	 				tree.load('<%=basePath%>/branch/list');
		        	 			}
		        	 		});	
		                }
		            }
 			    );	
	 	}
	 	
	 	function removeRow(){
	 		if(selectedNode){
	 			deleteRow(selectedNode.isLeaf ? '确定删除记录？' : '该机构下有子机构，是否删除？');
	 		}else{
	 			alert('请选择要删除的机构');
	 		}
	 	}
	 	
	 	function saveData(){
	 		var data = form.getData();
	 		if(data.state == ''){
	 			alert('没有数据提交');
	 			return;
	 		}
	 		var json = mini.encode(data);
	 		$.ajax({
	 			url  : '<%=basePath%>/branch/save',
	 			type : 'post',
	 			data : {data:json},
	 			success : function(text){
	 				alert(text);
	 			}
	 		});
	 	}
	</script>
</body>
</html>