<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<div property="columns">
	<div type="indexcolumn"></div>
	<div field="year" width="60" headerAlign="center" allowSort="true">年
	 	<input property="editor" class="mini-textbox" style="width: 100%;" />
	</div>
	<div header="基本养老金发放情况" headerAlign="center">
		<div property="columns">
			<div header="实发金额" headerAlign="center">
				<div property="columns">
					<div field="c2" width="80" headerAlign="center">
						万元 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="当期拖欠" headerAlign="center">
				<div property="columns">
					<div field="c3" width="80" headerAlign="center">
						万元 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="补发历史拖欠" headerAlign="center">
				<div property="columns">
					<div field="c4" width="80" headerAlign="center">
						万元 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="社发率" headerAlign="center">
				<div property="columns">
					<div field="c5" width="80" headerAlign="center">
						% <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="社会化管理情况" headerAlign="center">
		<div property="columns">
			<div header="社区管理人数" headerAlign="center">
				<div property="columns">
					<div field="c6" width="80" headerAlign="center">
						万人 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="社区管理率" headerAlign="center">
				<div property="columns">
					<div field="c7" width="80" headerAlign="center">
						% <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
