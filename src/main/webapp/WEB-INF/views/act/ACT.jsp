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
    <div class="mini-fit">
    	<fieldset id="fd_search" class="hideFieldset" style="width:85%;margin: 10px;">
	        <legend><label><input type="checkbox"  id="checkbox1" onclick="toggleFieldSet(this, 'fd_search')" />查询</label></legend>
	        <div class="fieldset-body">
	            <table class="form-table" border="0" cellpadding="1" cellspacing="2">
	                <tr>
	                    <td class="form-label" style="width:60px;">数据年限：</td>
	                    <td style="width:700px">
	                        <div id="cbl1" class="mini-checkboxlist" repeatItems="3" 
	       					 textField="text" valueField="id" value="2011"  url="countrys.txt" >
	    					</div>
	                    </td>
	                </tr> 
	                <tr>
	                	<td class="form-label" style="width:60px;">地区划分</td>
	                    <td style="width:700px">
	                        <div id="cbl2" class="mini-checkboxlist" repeatItems="3" 
	       					 textField="code_value" valueField="code_type" value="100000"  url="<%=basePath%>/standardcode/location" >
	    					</div>
	                    </td>
	                </tr>  
	                <tr>
	                	<td>
	                	<a class="mini-button" iconCls="icon-search" onclick="search()" >查询</a> 
	                	</td>
	                	<td>
	                	<a class="mini-button" iconCls="icon-undo" onclick="reset()" >重置</a> 
	                	</td>
	                </tr>            
	            </table>
	        </div>
	    </fieldset> 
	    <fieldset id="fd_data" class="hideFieldset" style="width:85%;margin: 10px;">
	        <legend><label><input type="checkbox"  id="checkbox1" onclick="toggleFieldSet(this, 'fd_data')" />数据导入</label></legend>
	        <div class="fieldset-body">
	        	 <label for="textbox1$text">第一步：数据年限：</label>
	        	 <input id="uploadYear"  name="uploadYear" type="textbox" /><br/>
	        	 <label for="textbox1$text">第二步：文件上传：</label>
	        	<input id="fileupload1" class="mini-fileupload" name="Fdata" limitType="*.xls" flashUrl="<%=swfPath %>" uploadUrl="<%=basePath %>/${MENUID}/upload" 
                        	onuploadsuccess="onUploadSuccess" onuploaderror="onUploadError" onfileselect="onFileSelect" />
                <a class="mini-button" iconCls="icon-upload" onclick="startUpload()" >EXCEL上传</a>
	        </div>
	    </fieldset> 
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
                        <a class="mini-button" iconCls="icon-download" href="<%=basePath %>/${MENUID}/download" plain="true">EXCEL导出</a>
                    </td>
                </tr>
            </table>           
        </div>
	    <div id="datagrid1" class="mini-datagrid" style="width:100%;height:90%;" allowCellEdit="true" allowCellSelect="true" multiSelect="true" editNextOnEnterKey="true" fitColumns="false" showPager="false" 
		url="<%=basePath%>/${MENUID}/list">
			<c:choose>
				<c:when test="${fn:contains(MENUID,'CNS') }">
					<c:import url="CN.jsp"></c:import>
				</c:when>
				<c:otherwise>
					<c:import url="${MENUID}.jsp"></c:import>
				</c:otherwise>
			</c:choose>
		</div>
    </div>
	
	<script type="text/javascript">
	 	mini.parse();
		var grid = mini.get("datagrid1");
	    grid.load({},function(){
	    	if('${MENUID}'.indexOf('CNS') >= 0){
	    		initData();
	    	}
	    });
	    
		//////////////////////////////////////////////////////
		
		
		function search() {       
            var obj = {};
            if("" != mini.get("cbl1").getValue()){
            	obj.yearSection = mini.get("cbl1").getValue();
            }
            var locationSection = mini.get("cbl2").getValue();
            if("" != locationSection && locationSection.indexOf("100000") < 0){
            	obj.locationSection = mini.get("cbl2").getValue();
            }
            var json = mini.encode(obj);
            grid.load({ key: json });
        }
        
        function reset(){
        	mini.get("cbl1").setValue();
        	mini.get("cbl2").setValue();
        }
        
        function addRow() {          
            var newRow = { name: "New Row",year :'${year}' };
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
            
            for(var i=0;i<data.length;i++){
            	data[i].location = '${location}';
            }
            
            var json = mini.encode(data);
            
            console.log(data);
            
            grid.loading("保存中，请稍后......");
            $.ajax({
                url: "<%=basePath%>/${MENUID}/save",
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
        	var uploadYear = $("#uploadYear").val();
        	if(uploadYear == ""){
        		alert("请输入上传年份");
        		return;
        	}
        	mini.confirm('该操作会覆盖之前上传的同年数据，请确定','确定？',
        			function(action){
        		if(action == 'ok'){
        			var fileupload = mini.get("fileupload1");
        			fileupload.setPostParam({year:uploadYear});
                    fileupload.startUpload();
        		}else{
        			return ;
        		}
        	} );
            
        }
        function toggleFieldSet(ck, id) {
            var dom = document.getElementById(id);
            dom.className = !ck.checked ? "hideFieldset" : "";
        }
        
        function initData(e){
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
        }
        
	</script>
	<c:if test="${fn:contains(MENUID,'CNS') }">
		<script type="text/javascript">
			//////////////////////////////////////////////////////
			grid.on("cellbeginedit",function(e){
				if(e.row.c1 == '合计' || e.column.field == 'c1' || e.column.field == 'c2' || e.column.field == 'c3' || e.column.field == 'c6' ){
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
				initData(e);
			});
		</script>
	</c:if>
</body>
</html>