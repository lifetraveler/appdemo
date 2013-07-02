<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.Date"%>
<%@ include file="../security/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>${MENUID}</title>
<style type="text/css">
</style>
</head>
<body>
	<h1>${TITLE}</h1>
	<div style="width:1100px;overflow:auto;">
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
                        <input id="fileupload1" class="mini-fileupload" name="Fdata" limitType="*.xls" flashUrl="<%=swfPath %>" uploadUrl="<%=basePath %>/${MENUID}/upload" 
                        	onuploadsuccess="onUploadSuccess" onuploaderror="onUploadError" onfileselect="onFileSelect" />
                        <a class="mini-button" iconCls="icon-upload" onclick="startUpload()" plain="true">EXCEL上传</a>
                        <a class="mini-button" iconCls="icon-download" href="<%=basePath %>/${MENUID}/download" plain="true">EXCEL导出</a>
                    </td>
                </tr>
            </table>           
        </div>
    </div>
	<div id="datagrid1" class="mini-datagrid" style="width:1100px;height:400px" allowCellEdit="true" allowCellSelect="true" multiSelect="true" showFooter="false" 
	url="<%=basePath%>/${MENUID}/list">
		<div property="columns">
			<div field="location" width='0'>${LOCATION}</div>
			<div field="year" width='0'>2011</div>
			<div type="indexcolumn"></div> 
			<div field="c1" width="100" headerAlign="center">年龄
				<input property="editor" class="mini-textbox" style="width:100%;" />
			</div>
			<div header="">
				<div property="columns">
					<div header="合计" headerAlign="center">
						<div property="columns">
							<div field="c2" width="100" headerAlign="center">1
								<input property="editor" class="mini-spinner" allowLimitValue=false  decimalPlaces="${UNIT}" style="width:100%;"/>		
							</div>
						</div>
					</div>
				</div>
			</div>
			<div header="企业" headerAlign="center">
				<div property="columns">
					<div header="小计" headerAlign="center">
						<div property="columns">
							<div field="c3" width="100" headerAlign="center">2
								<input property="editor" class="mini-spinner" allowLimitValue=false  decimalPlaces="${UNIT}" style="width:100%;"/>		
							</div>
						</div>
					</div>
					<div header="男" headerAlign="center">
						<div property="columns">
							<div field="c4" width="100" headerAlign="center">3
								<input property="editor" class="mini-spinner" allowLimitValue=false  decimalPlaces="${UNIT}" style="width:100%;"/>		
							</div>
						</div>
					</div>
					<div header="女" headerAlign="center">
						<div property="columns">
							<div field="c5" width="100" headerAlign="center">4
								<input property="editor" class="mini-spinner" allowLimitValue=false  decimalPlaces="${UNIT}" style="width:100%;"/>		
							</div>
						</div>
					</div>
				</div>
			</div>
			<div header="其他人员" headerAlign="center">
				<div property="columns">
					<div header="小计" headerAlign="center">
						<div property="columns">
							<div field="c6" width="100" headerAlign="center">5
								<input property="editor" class="mini-spinner" allowLimitValue=false  decimalPlaces="${UNIT}" style="width:100%;"/>		
							</div>
						</div>
					</div>
					<div header="男" headerAlign="center">
						<div property="columns">
							<div field="c7" width="100" headerAlign="center">6
								<input property="editor" class="mini-spinner" allowLimitValue=false  decimalPlaces="${UNIT}" style="width:100%;"/>		
							</div>
						</div>
					</div>
					<div header="女" headerAlign="center">
						<div property="columns">
							<div field="c8" width="100" headerAlign="center">7
								<input property="editor" class="mini-spinner" allowLimitValue=false  decimalPlaces="${UNIT}" style="width:100%;"/>		
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
		
		
	
		grid.on("cellbeginedit",function(e){
			if(e.row.c1 == '合计' || e.column.field == 'c3' || e.column.field == 'c6' ){
				e.cancel = true;
			}
			
		});
		
		
		grid.on("drawcell",function(e){
			var record = e.record;
			var sum_row = grid.getRow(0);
			
			if(e.field == 'c2'){
				e.cellHtml = Math.round(record.c4 + record.c5 + record.c7 + record.c8);
				
			}
			if(e.field == 'c3'){
				e.cellHtml = Math.round(record.c4 + record.c5);
			}
			if(e.field == 'c6'){
				e.cellHtml = Math.round(record.c7 + record.c8);
			}
			
		});
		grid.on("cellendedit",function(e){
			var data = grid.data;
			var sum_row = {c2:0,c3:0,c4:0,c5:0,c6:0,c7:0,c8:0};
			for(var i=1;i<data.length;i++){
				sum_row.c4 += data[i].c4;
				sum_row.c5 += data[i].c5;
				sum_row.c7 += data[i].c7;
				sum_row.c8 += data[i].c8;
				sum_row.c3 = sum_row.c4 + sum_row.c5;
				sum_row.c6 = sum_row.c7 + sum_row.c8;
				sum_row.c2 = sum_row.c3 + sum_row.c6;
			}
			grid.updateRow(grid.getRow(0),sum_row);
		});

        function search() {       
            var key = mini.get("key").getValue();
            grid.load({ c1 : key });
        }
        function onKeyEnter(e) {
            search();
        }
        function addRow() {          
            var newRow = { name: "New Row",location : '${LOCATION}',year : 2011 };
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
                url: "<%=basePath%>/${MENUID}/save",
                data: { data: json },
                type: "post",
                success: function (text) {
                	alert(text);
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