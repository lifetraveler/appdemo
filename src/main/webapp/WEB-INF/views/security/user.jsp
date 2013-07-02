<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.Date"%>
<%@ include file="../security/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>User</title>
<style type="text/css">
.New_Button,.Edit_Button,.Delete_Button,.Update_Button,.Cancel_Button {
	font-size: 11px;
	color: #1B3F91;
	font-family: Verdana;
	margin-right: 5px;
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
			<div id="datagrid1" class="mini-datagrid" style="width: 700px; height: 95%;"  fitColumns="false"
	allowResize="true" sizeList="[20,30,50,100]" pageSize="20" url="<%=basePath%>/user/list">
				<div property="columns">
					<div type="indexcolumn"></div> 
					<div field="username" width="100" headerAlign="center" allowSort="true">用户名</div>
					<div field="realname" width="120" headerAlign="center" allowSort="true">姓名</div>
				</div>
			</div>
		</div>
		<div>
			<div class="mini-toolbar" style="padding: 2px; border-top: 0; border-left: 0; border-right: 0;">
				<a class="mini-button" iconCls="icon-add" onclick="add()">增加</a>
				<span class="separator"></span>
                <a class="mini-button" iconCls="icon-add" onclick="edit()">编辑</a>
                <span class="separator"></span>
                <a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a> 
                <span class="separator"></span>
                <a class="mini-button" iconCls="icon-save" plain="true" onclick="saveData()">保存</a>   
			</div>
			<div class="mini-fit" style="padding-left: 50px">
				<!-- 基本信息 -->
				<fieldset id="fd1" style="width: 650px;">
					<legend>
						<span>用户信息</span>
					</legend>
					<table style="width: 100%;">
						<tr>
							<td style="width: 80px;">姓名：</td>
							<td style="width: 150px;"><input name="username"
								class="mini-textbox" /></td>
							<td style="width: 80px;">真实姓名：</td>
							<td style="width: 150px;"><input name="realname"
								class="mini-textbox" /></td>
						</tr>
						<tr>
							<td style="width: 80px;">密码：</td>
							<td style="width: 150px;"><input name="password"
								class="mini-password"></input></td>
							<td style="width: 80px;">所在地：</td>
							<td style="width: 150px;">
							<input name="location"
								class="mini-combobox" style="width:150px;" 
								textField="code_value" valueField="code_type" emptyText="请选择所在地" 
								url="<%=basePath%>/standardcode/list?code_name=location"  required="true" allowInput="true" showNullItem="true" nullItemText="请选择..."/></td>
						</tr>
						<tr>
							<td style="width: 80px;">所在机构：</td>
							<td colspan="5"><input name="home_branch" id="home_branch" class="mini-buttonedit" onbuttonclick="lov_branch"/></td>
						</tr>
					</table>
				</fieldset>
				<div id="userTabs" class="mini-tabs" activeIndex="0" style="width:90%;height:90%;padding-top:10px" plain="false">
					<div title="用户角色设定" >
					 	<div style="width:95%;">
					        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
					            <table style="width:100%;">
					                <tr>
					                    <td style="width:100%;">
					                        <a class="mini-button" iconCls="icon-add" onclick="userRoleListAdd()">增加</a>
					                        <a class="mini-button" iconCls="icon-remove" onclick="userRoleListRemove()">删除</a>       
					                    </td>
					                </tr>
					            </table>           
					        </div>
					    </div>
						<div id="datagrid2" class="mini-datagrid" style="width: 95%; height: 80%;"  fitColumns="false" allowCellEdit="true" allowCellSelect="true">
							<div property="columns">
								<div type="indexcolumn"></div> 
								<div field="branch_code" width="100" headerAlign="center" allowSort="true">机构号码
									<input property="editor" class="mini-buttonedit" onbuttonclick="lov_branch" />
								</div>
								<div field="role_id" width="120" headerAlign="center" allowSort="true">角色代码
									<input property="editor" class="mini-buttonedit" onbuttonclick="lov_role" />
								</div>
								<div field="role_desc" width="120" headerAlign="center" allowSort="true">角色名称</div>
							</div>
						</div>
					</div>
			</div>
			</div>
			
			
		</div>
	</div>
	
	<script type="text/javascript">
	 	mini.parse();
		var grid = mini.get("datagrid1");
		var userRoleGrid = mini.get("datagrid2");
	    grid.load();
	    
	    var form = new mini.Form("fd1");
	    
	    readonlyModel(form);
	    
	    
	    
		//////////////////////////////////////////////////////
		
		//加载菜单信息
		grid.on('rowclick',function(e){
			readonlyModel(form);
			form.setData(e.row);
		});
		
		function userRoleListAdd(){
			var username = form.getData().username;
			if(username == null || username == ''){
				alert('用户名为空');
				return;
			}
			var newRow = { username: username };
			userRoleGrid.addRow(newRow, 0);
		}
		
		function add(){
			var o = {state :'added'};
			editFormShow(o);
		}
		
		function edit(){
			editModel(form,'modified',function(field){
	 			if(field.name == 'username'){
	 				if (field.setReadOnly) field.setReadOnly(true);     //只读
		            if (field.addCls) field.addCls("asLabel");          //增加asLabel外观
	 			}
	 		});	
		}
		
		function saveData(){
			var data = form.getData();
			
			var roleData = userRoleGrid.getChanges();
			
			data.roles = roleData;
			
			console.log(data);
		}
		
		function updateRow() {            
            var form = new mini.Form("#editform");
            var o = form.getData();

            grid.loading("保存中，请稍后......");
            var json = mini.encode([o]);
            $.ajax({
                url: "<%=basePath%>/user/save",
                data: { data: json },
                success: function (text) {
                    grid.reload();
                    editWindow.hide();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });

             
        }
		
		function cancelRow() {
            grid.reload();
            editWindow.hide();
        }
		
		 
        function search() {       
            var key = mini.get("key").getValue();
            grid.load({ code_name : key });
        }
        function onKeyEnter(e) {
            search();
        }
       
        function lov_role(e){
        	var lov_field = this;
        	mini.open({
        		url: "<%=basePath%>/lov/lov_role",
                title: "选择列表",
                width: 650,
                height: 380,
                ondestroy: function (action) {
                    //if (action == "close") return false;
                    if (action == "ok") {
                        var iframe = this.getIFrameEl();
                        var data = iframe.contentWindow.GetData();
                        data = mini.clone(data);    //必须
                        if (data) {
                        	var row = userRoleGrid.getSelected();
                        	lov_field.setValue(data.role_id);
                        	row.role_desc = data.role_desc;
                        }
                    }

                }
        	});
        }
        
        function lov_branch(e){
        	var lov_field = this;
        	mini.open({
        		url: "<%=basePath%>/lov/lov_branch",
                title: "选择列表",
                width: 650,
                height: 380,
                ondestroy: function (action) {
                    //if (action == "close") return false;
                    if (action == "ok") {
                        var iframe = this.getIFrameEl();
                        var data = iframe.contentWindow.GetData();
                        data = mini.clone(data);    //必须
                        if (data) {
                        	lov_field.setValue(data.branch_code);
                        	lov_field.setText(data.branch_name);
                        }
                    }

                }
        	});
        }
	</script>
</body>
</html>