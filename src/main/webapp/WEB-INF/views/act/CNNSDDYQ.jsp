<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<div property="columns">
	<div type="indexcolumn"></div>
	<div field="location" width='0'></div>
	<div field="c1" width="60" headerAlign="center" allowSort="true">
		地区 <input property="editor" class="mini-textbox" style="width: 100%;" />
	</div>
	<div header="参保职工人数">
		<div property="columns">
			<div field="c2" width="100" headerAlign="center">
				万人 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="缴费人数" headerAlign="center">
		<div property="columns">
			<div field="c3" width="100">
				万人 <input property="editor" class="mini-textbox"
					style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="比例" headerAlign="center">
		<div property="columns">
			<div field="c4" width="60">
				% <input property="editor" class="mini-textbox" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="离退休人数" headerAlign="center">
		<div property="columns">
			<div field="c5" width="80">
				万人 <input property="editor" class="mini-textbox"
					style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="离休人员" headerAlign="center">
		<div property="columns">
			<div field="c6" width="60">
				人 <input property="editor" class="mini-textbox" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="负担系数" headerAlign="center">
		<div property="columns">
			<div field="c7" width="60">
				<input property="editor" class="mini-textbox" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="基金收缴率" headerAlign="center">
		<div property="columns">
			<div field="c8" width="80">
				% <input property="editor" class="mini-textbox" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="月人均缴费工资" headerAlign="center">
		<div property="columns">
			<div field="c9" width="100">
				元 <input property="editor" class="mini-textbox" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="离退休人员月人均养老金" headerAlign="center">
		<div property="columns">
			<div field="c10" width="160">
				元 <input property="editor" class="mini-textbox" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="月人均离休金" headerAlign="center">
		<div property="columns">
			<div field="c11" width="80">
				元 <input property="editor" class="mini-textbox" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="退休人员人均养老金" headerAlign="center">
		<div property="columns">
			<div field="c12" width="160">
				元 <input property="editor" class="mini-textbox" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="个人账户累计记账额" headerAlign="center">
		<div property="columns">
			<div field="c13" width="160">
				元 <input property="editor" class="mini-textbox" style="width: 100%;" />
			</div>
		</div>
	</div>
</div>
