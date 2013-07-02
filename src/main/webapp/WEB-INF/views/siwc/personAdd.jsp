<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.Date"%>
<%@ include file="../security/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>PersonAdd</title>
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
	<h1>人员增加</h1>
	<fieldset id="fd1" style="width: 650px;">
		<legend>
			<span>人员增加</span>
		</legend>
		<div class="fieldset-body">
			<input name="state" class="mini-hidden" />
			<table class="form-table" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="form-label" style="width: 60px;">人员编号：</td>
					<td style="width: 150px"><input name="person_id"
						class="mini-textbox" /></td>
					<td class="form-label" style="width: 60px;">人员名称：</td>
					<td style="width: 150px"><input name="person_name"
						class="mini-textbox" /></td>
				</tr>
			</table>
		</div>
	</fieldset>
	<script type="text/javascript">
		mini.parse();
	</script>
</body>
</html>