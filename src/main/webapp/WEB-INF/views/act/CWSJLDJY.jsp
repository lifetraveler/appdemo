<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<div property="columns">
	<div type="indexcolumn"></div>
	<div field="location" width='0'></div>
	<div field="year" width="60" headerAlign="center" allowSort="true">
		年份 <input property="editor" class="mini-textbox" style="width: 100%;" />
	</div>
	<div header="活动人口经济">
		<div property="columns">
			<div field="c2" width="100" headerAlign="center">
				万人 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="城镇登记失业率" headerAlign="center">
		<div property="columns">
			<div field="c3" width="100">
				万人 <input property="editor" class="mini-textbox"
					style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="就业人口" headerAlign="center">
		<div property="columns">
			<div field="c4" width="60">
				万人 <input property="editor" class="mini-textbox"
					style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="按产业分" headerAlign="center">
		<div property="columns">
			<div header="#第一产业">
				<div property="columns">
					<div field="c5" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#第二产业" headerAlign="center">
				<div property="columns">
					<div field="c6" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#第三产业" headerAlign="center">
				<div property="columns">
					<div field="c7" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="按城乡分" headerAlign="center">
		<div property="columns">
			<div header="#城镇" headerAlign="center">
				<div property="columns">
					<div field="c8" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#乡村" headerAlign="center">
				<div property="columns">
					<div field="c9" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="城镇单位就业人员" headerAlign="center">
		<div property="columns">
			<div header="">
				<div property="columns">
					<div field="c10" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#企业" headerAlign="center">
				<div property="columns">
					<div field="c11" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#事业" headerAlign="center">
				<div property="columns">
					<div field="c12" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#机关" headerAlign="center">
				<div property="columns">
					<div field="c13" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="城镇私营和个体就业人员" headerAlign="center">
		<div property="columns">
			<div header="">
				<div property="columns">
					<div field="c14" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#私营" headerAlign="center">
				<div property="columns">
					<div field="c15" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#个体" headerAlign="center">
				<div property="columns">
					<div field="c16" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
