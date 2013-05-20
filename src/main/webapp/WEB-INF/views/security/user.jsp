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
	<h1>用户管理</h1>
	<div style="width:700px;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="mini-button" iconCls="icon-add" onclick="add()">增加</a>
                        <a class="mini-button" iconCls="icon-add" onclick="edit()">编辑</a>
                        <a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>       
                    </td>
                    <td style="white-space:nowrap;">
                        <input id="key" class="mini-textbox" emptyText="请输入用户名" style="width:150px;" onenter="onKeyEnter"/>   
                        <a class="mini-button" onclick="search()">查询</a>
                    </td>
                </tr>
            </table>           
        </div>
    </div>
	<div id="datagrid1" class="mini-datagrid" style="width: 700px; height: 280px;"  fitColumns="false"
	allowResize="true" sizeList="[20,30,50,100]" pageSize="20" url="<%=basePath%>/user/list">
		<div property="columns">
			<div type="indexcolumn"></div> 
			<div field="username" width="100" headerAlign="center" allowSort="true">用户名</div>
			<div field="realname" width="120" headerAlign="center" allowSort="true">姓名</div>
			<div field="status" width="160" headerAlign="center" allowSort="true">状态</div>
			<div field="location" width="160" headerAlign="center" allowSort="true">所在地</div>
			<div field="home_branch" width="160" headerAlign="center" allowSort="true">所在机构</div>
		</div>
	</div>
	
	<div id="editWindow" class="mini-window" title="用户维护"
		style="width: 650px;" showModal="true" allowResize="true"
		allowDrag="true">
		<div id="editform" class="form">
			<input class="mini-hidden" name="state" />
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
					<td colspan="3"><input name="home_branch" id="home_branch" class="mini-buttonedit" onbuttonclick="lovClick"/></td>
					<td clospan="2"><a class="mini-button" iconCls="icon-note" onclick="userRole()">用户角色信息</a></td>
				</tr>
				<tr>
					<td
						style="text-align: right; padding-top: 5px; padding-right: 20px;"
						colspan="6">
						<a class="Update_Button" href="javascript:updateRow()">保存</a> 
						<a class="Cancel_Button" href="javascript:cancelRow()">取消</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	<script type="text/javascript">
	 	mini.parse();
		var grid = mini.get("datagrid1");
	    grid.load();
	    
	    var editWindow = mini.get("editWindow");
	    
		//////////////////////////////////////////////////////
		
		function userRole(){
			
		}
		
		function add(){
			var o = {state :'added'};
			editFormShow(o);
		}
		
		function edit(){
			var row = grid.getSelected();
			row.state = 'modified';
			editFormShow(row);
		}
		
		function editFormShow(data){
			editWindow.show();
            var form = new mini.Form("#editform");
            form.clear();
            var o = mini.decode(data);
            form.setData(o);
           
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
       
        function lovClick(e){
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