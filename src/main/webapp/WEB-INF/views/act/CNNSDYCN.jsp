<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<div property="columns">
	<div type="indexcolumn"></div>
	<div field="location" width='0'></div>
	<div field="c1" width="60" headerAlign="center" allowSort="true">
		地区 <input property="editor" class="mini-textbox" style="width: 100%;" />
	</div>
	<div header="2011年" headerAlign="center">
		<div property="columns">
			<div field="c2" width="100" headerAlign="center">
				万人 <input property="editor" class="mini-textbox"
					style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="2010年" headerAlign="center">
		<div property="columns">
			<div field="c3" width="100" headerAlign="center">
				万人 <input property="editor" class="mini-textbox"
					style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="净增减人数" headerAlign="center">
		<div property="columns">
			<div field="c4" width="100" headerAlign="center">
				万人 <input property="editor" class="mini-textbox"
					style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="增长率" headerAlign="center">
		<div property="columns">
			<div field="c5" width="100" headerAlign="center">
				% <input property="editor" class="mini-textbox" style="width: 100%;" />
			</div>
		</div>
	</div>
</div>
