<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.Date"%>
<%@ include file="../security/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>CWSJLDJY</title>
<style type="text/css">
</style>
</head>
<body >
	<h1>劳动就业</h1>
	<div style="width:1100px;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="mini-button" iconCls="icon-add" onclick="addRow()" plain="true">增加</a>
                        <span class="separator"></span>
                        <a class="mini-button" iconCls="icon-remove" onclick="removeRow()" plain="true">删除</a>
                        <span class="separator"></span>
                        <a class="mini-button" iconCls="icon-save" onclick="saveData()" plain="true">保存</a> 
                        <span class="separator"></span>
                        <input id="fileupload1" class="mini-fileupload" name="Fdata" limitType="*.xls" flashUrl="<%=swfPath %>" uploadUrl="<%=basePath %>/CWSJLDJY/upload" 
                        	onuploadsuccess="onUploadSuccess" onuploaderror="onUploadError" onfileselect="onFileSelect" />
                        <a class="mini-button" iconCls="icon-upload" onclick="startUpload()" plain="true">EXCEL上传</a>
                        <a class="mini-button" iconCls="icon-download" href="<%=basePath %>/CWSJLDJY/download" plain="true">EXCEL导出</a>
                    </td>
                </tr>
            </table>           
        </div>
    </div>
	<div id="datagrid1" class="mini-datagrid" style="width:1100px;" allowCellEdit="true" allowCellSelect="true" multiSelect="true" editNextOnEnterKey="true" fitColumns="false" showFooter="false" 
	url="<%=basePath%>/CWSJLDJY/list">
		<div property="columns">
			<div type="indexcolumn"></div> 
			<div field="location" width='0'></div>
			<div field="year" width="60" headerAlign="center" allowSort="true">年份
				<input property="editor" class="mini-textbox" style="width:100%;" />
			</div>
			<div header="活动人口经济">
				<div property="columns">
					<div field="c2" width="100" headerAlign="center">万人
						<input property="editor" class="mini-spinner" allowLimitValue=false  decimalPlaces="2" style="width:100%;"/>
					</div>
				</div>
			</div>
			<div header="城镇登记失业率" headerAlign="center">
				<div property="columns">
					<div field="c3" width="100">万人
						<input property="editor" class="mini-textbox" style="width:100%;" />
					</div>
				</div>
			</div>
			<div header="就业人口" headerAlign="center">
				<div property="columns">
					<div field="c4" width="60">万人
						<input property="editor" class="mini-textbox" style="width:100%;" />
					</div>
				</div>
			</div>
			<div header="按产业分" headerAlign="center">
				<div property="columns">
					<div header="#第一产业">
						<div property="columns">
							<div field="c5" width="100" headerAlign="center">万人
								<input property="editor" class="mini-spinner" allowLimitValue=false  decimalPlaces="2" style="width:100%;"/>
							</div>
						</div>
					</div>
					<div header="#第二产业" headerAlign="center">
						<div property="columns">
							<div field="c6" width="100" headerAlign="center">万人
								<input property="editor" class="mini-spinner" allowLimitValue=false  decimalPlaces="2" style="width:100%;"/>
							</div>
						</div>
					</div>
					<div header="#第三产业" headerAlign="center">
						<div property="columns">
							<div field="c7" width="100" headerAlign="center">万人
								<input property="editor" class="mini-spinner" allowLimitValue=false  decimalPlaces="2" style="width:100%;"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div header="按城乡分" headerAlign="center">
				<div property="columns">
					<div header="#城镇" headerAlign="center">
						<div property="columns">
							<div field="c8" width="100" headerAlign="center">万人
								<input property="editor" class="mini-spinner" allowLimitValue=false  decimalPlaces="2" style="width:100%;"/>
							</div>
						</div>
					</div>
					<div header="#乡村" headerAlign="center">
						<div property="columns">
							<div field="c9" width="100" headerAlign="center">万人
								<input property="editor" class="mini-spinner" allowLimitValue=false  decimalPlaces="2" style="width:100%;"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div header="城镇单位就业人员" headerAlign="center">
				<div property="columns">
					<div header="">
						<div property="columns">
							<div field="c10" width="100" headerAlign="center">万人
								<input property="editor" class="mini-textbox" style="width:100%;" />
							</div>
						</div>
					</div>
					<div header="#企业" headerAlign="center">
						<div property="columns">
							<div field="c11" width="100" headerAlign="center">万人
								<input property="editor" class="mini-textbox" style="width:100%;" />
							</div>
						</div>
					</div>
					<div header="#事业" headerAlign="center">
						<div property="columns">
							<div field="c12" width="100" headerAlign="center">万人
								<input property="editor" class="mini-textbox" style="width:100%;" />
							</div>
						</div>
					</div>
					<div header="#机关" headerAlign="center">
						<div property="columns">
							<div field="c13" width="100" headerAlign="center">万人
								<input property="editor" class="mini-textbox" style="width:100%;" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div header="城镇私营和个体就业人员" headerAlign="center">
				<div property="columns">
					<div header="">
						<div property="columns">
							<div field="c14" width="100" headerAlign="center">万人
								<input property="editor" class="mini-textbox" style="width:100%;" />
							</div>
						</div>
					</div>
					<div header="#私营" headerAlign="center">
						<div property="columns">
							<div field="c15" width="100" headerAlign="center">万人
								<input property="editor" class="mini-textbox" style="width:100%;" />
							</div>
						</div>
					</div>
					<div header="#个体" headerAlign="center">
						<div property="columns">
							<div field="c16" width="100" headerAlign="center">万人
								<input property="editor" class="mini-textbox" style="width:100%;" />
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
	    grid.load();
	    
		//////////////////////////////////////////////////////

        function search() {       
            var key = mini.get("key").getValue();
            grid.load({ c1 : key });
        }
        function onKeyEnter(e) {
            search();
        }
        function addRow() {          
            var newRow = { name: "New Row",location : '${location}',year :'${year}' };
            grid.addRow(newRow, 0);
        }
        function removeRow() {
            var rows = grid.getSelecteds();
            if (rows.length > 0) {
                grid.removeRows(rows, true);
            }
        }
        function saveData() {
            var data = grid.getChanges();
            
            if(data.length == 0) return;
            
            var json = mini.encode(data);
            
            grid.loading("保存中，请稍后......");
            $.ajax({
                url: "<%=basePath%>/CWSJLDJY/save",
                data: { data: json },
                type: "post",
                success: function (text) {
                    grid.reload();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
        }
        function onFileSelect(e) {
            //alert("选择文件");
        }
        function onUploadSuccess(e) {

            alert(e.serverData);
            grid.load();
            this.setText("");
        }
        function onUploadError(e) {
        	alert('文件上传异常');
            
        }

        function startUpload() {
        	mini.confirm('该操作会覆盖之前上传的同年数据，请确定','确定？',
        			function(action){
        		if(action = 'ok'){
        			var fileupload = mini.get("fileupload1");
                    fileupload.startUpload();
        		}
        	} );
            
        }
	</script>
</body>
</html>