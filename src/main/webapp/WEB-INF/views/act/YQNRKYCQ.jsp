<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.Date"%>
<%@ include file="../security/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>Out_1_1</title>
<style type="text/css">
</style>
</head>
<body>
	<h1>预测期内人口预测情况</h1>
	<div style="width:1100px;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
        </div>
    </div>
	<div id="datagrid1" class="mini-datagrid" style="width:1100px;height:500px;"  fitColumns="false" showFooter="false">
		<div property="columns">
			<div type="indexcolumn"></div> 
			<div field="c1" width="100" headerAlign="center">年份
			</div>
			<div header="总人口">
				<div property="columns">
					<div field="c2" width="100" headerAlign="center">
					</div>
					<div field="c3" width="100" headerAlign="center">#农村
					</div>
				</div>
			</div>
			<div header="城镇">
				<div property="columns">
					<div field="c4" width="100" headerAlign="center">
					</div>
					<div field="c5" width="100" headerAlign="center">#15-50岁
					</div>
					<div field="c6" width="100" headerAlign="center">占比
					</div>
					<div field="c7" width="100" headerAlign="center">#60-100岁
					</div>
					<div field="c8" width="100" headerAlign="center">占比
					</div>
				</div>
			</div>
			<div field="c9" width="100" headerAlign="center">城镇化率
			</div>
			<div field="c10" width="100" headerAlign="center">老年负担系数
			</div>
		</div>
	</div>
	<script type="text/javascript">
	 	mini.parse();
		var grid = mini.get("datagrid1");
	    
		//////////////////////////////////////////////////////

        function search() {       
            var key = mini.get("key").getValue();
            grid.load({ c1 : key });
        }
        function onKeyEnter(e) {
            search();
        }
       
       function startDownload(){
    	   
       }
	</script>
</body>
</html>