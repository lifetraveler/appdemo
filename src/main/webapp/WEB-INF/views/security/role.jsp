<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.Date"%>
<%@ include file="../security/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>role</title>
<style type="text/css">
</style>
</head>
<body>
	<h1>角色维护</h1>

	<div id="datagrid1" class="mini-datagrid" style="width: 700px; height: 280px;"  fitColumns="false"
	allowResize="true" sizeList="[20,30,50,100]" pageSize="20" pageIndex="1" url="<%=basePath%>/role/list">
		<div property="columns">
			<div type="indexcolumn"></div> 
			<div field="role_id" width="100" headerAlign="center" allowSort="true">类别</div>
			<div field="role_desc" width="120" headerAlign="center" allowSort="true">类型</div>
		</div>
	</div>
	<script type="text/javascript">
	 	mini.parse();
		var grid = mini.get("datagrid1");
	    grid.load();
	    
		//////////////////////////////////////////////////////

        function search() {       
            var key = mini.get("key").getValue();
            grid.load({ code_name : key });
        }
        function onKeyEnter(e) {
            search();
        }
        function addRow() {          
            var newRow = { name: "New Row" };
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
                url: "<%=basePath%>/standardcodet/list",
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

            alert("上传成功：" + e.serverData);

            this.setText("");
        }
        function onUploadError(e) {
            
        }

        function startUpload() {
            var fileupload = mini.get("fileupload1");
            fileupload.startUpload();
        }
	</script>
</body>
</html>