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
	<h1>批量导入</h1>
	 <fieldset id="fd_data"  style="width:85%;margin: 10px;">
        <legend><label><input type="checkbox"  id="checkbox1" onclick="toggleFieldSet(this, 'fd_data')" />数据导入</label></legend>
        <div class="fieldset-body">
        	 <label for="textbox1$text">第一步：数据年限：</label>
        	 <input id="uploadYear"  name="uploadYear" type="textbox" /><br/>
        	 <label for="textbox1$text">第二步：文件上传：</label>
        	<input id="fileupload1" class="mini-fileupload" name="Fdata" limitType="*.xls" flashUrl="<%=swfPath %>" uploadUrl="<%=basePath %>/batch/upload" 
                       	onuploadsuccess="onUploadSuccess" onuploaderror="onUploadError" onfileselect="onFileSelect" />
               <a class="mini-button" iconCls="icon-upload" onclick="startUpload()" >EXCEL上传</a>
        </div>
    </fieldset> 
    <div id="datagrid1" class="mini-datagrid" style="width:100%;height:90%;" allowCellEdit="true" allowCellSelect="true" multiSelect="true" editNextOnEnterKey="true" fitColumns="false" showPager="false" >
		<div property="columns">
			<div type="indexcolumn"></div>
			<div field="name" width="300" headerAlign="center" allowSort="true"> 名称 </div>
			<div field="result" width="200" headerAlign="center" allowSort="true">  导入结果 </div>
		</div>
	</div>
    <script type="text/javascript">
	 	mini.parse();
	 	var grid = mini.get("datagrid1");
      
        function onFileSelect(e) {
            //alert("选择文件");
        }
        function onUploadSuccess(e) {
        	var result = eval(e.serverData);
        	grid.clearRows();
        	grid.addRows(result,0);
            console.log(result.length);
            
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
        
	</script>
</body>
</html>