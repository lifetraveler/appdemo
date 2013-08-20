<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<div property="columns">
	<div type="indexcolumn"></div>
	<div field="location" width='10'></div>
	<div field="year" width="60" headerAlign="center" allowSort="true">
		年份 <input property="editor" class="mini-textbox" style="width: 100%;" />
	</div>
	<div header="总人口" headerAlign="center">
		<div property="columns">
			<div header="">
				<div property="columns">
					<div field="c2" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="按年龄分" headerAlign="center">
		<div property="columns">
			<div header="#0-14岁">
				<div property="columns">
					<div field="c3" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#15-59岁" headerAlign="center">
				<div property="columns">
					<div field="c4" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#60岁以上" headerAlign="center">
				<div property="columns">
					<div field="c5" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#15-64岁" headerAlign="center">
				<div property="columns">
					<div field="c6" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#65岁以上" headerAlign="center">
				<div property="columns">
					<div field="c7" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="按性别" headerAlign="center">
		<div property="columns">
			<div header="#男">
				<div property="columns">
					<div field="c8" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#女" headerAlign="center">
				<div property="columns">
					<div field="c9" width="100" headerAlign="center">
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
					<div field="c10" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#农村" headerAlign="center">
				<div property="columns">
					<div field="c11" width="100" headerAlign="center">
						万人 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="出生率" headerAlign="center">
		<div property="columns">
			<div header="">
				<div property="columns">
					<div field="c12" width="100" headerAlign="center">
						% <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="死亡率" headerAlign="center">
		<div property="columns">
			<div header="">
				<div property="columns">
					<div field="c13" width="100" headerAlign="center">
						% <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="自然增长率" headerAlign="center">
		<div property="columns">
			<div header="">
				<div property="columns">
					<div field="c14" width="100" headerAlign="center">
						% <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
