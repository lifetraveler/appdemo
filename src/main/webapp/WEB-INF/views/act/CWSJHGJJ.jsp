<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<div property="columns">
	<div type="indexcolumn"></div>
	<div field="location" width='0'></div>
	<div field="year" width="60" headerAlign="center" allowSort="true">
		年份 <input property="editor" class="mini-textbox" style="width: 100%;" />
	</div>
	<div header="GDP" headerAlign="center">
		<div property="columns">
			<div header="">
				<div property="columns">
					<div field="c2" width="100" headerAlign="center">
						亿元 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="增速" headerAlign="center">
				<div property="columns">
					<div field="c3" width="60">
						<input property="editor" class="mini-textbox" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#第一产业" headerAlign="center">
				<div property="columns">
					<div field="c4" width="100" headerAlign="center">
						亿元 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#第二产业" headerAlign="center">
				<div property="columns">
					<div field="c5" width="100" headerAlign="center">
						亿元 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#第三产业" headerAlign="center">
				<div property="columns">
					<div field="c6" width="100" headerAlign="center">
						亿元 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="财政收入" headerAlign="center">
		<div property="columns">
			<div header="">
				<div property="columns">
					<div field="c7" width="100" headerAlign="center">
						亿元 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#中央" headerAlign="center">
				<div property="columns">
					<div field="c8" width="100" headerAlign="center">
						亿元 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#地方" headerAlign="center">
				<div property="columns">
					<div field="c9" width="100" headerAlign="center">
						亿元 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="财政支出" headerAlign="center">
		<div property="columns">
			<div header="">
				<div property="columns">
					<div field="c10" width="100" headerAlign="center">
						亿元 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#中央" headerAlign="center">
				<div property="columns">
					<div field="c11" width="100" headerAlign="center">
						亿元 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#地方" headerAlign="center">
				<div property="columns">
					<div field="c12" width="100" headerAlign="center">
						亿元 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="CPI" headerAlign="center">
		<div property="columns">
			<div header="">
				<div property="columns">
					<div field="c13" width="100" headerAlign="center">
						% <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#城市" headerAlign="center">
				<div property="columns">
					<div field="c14" width="100" headerAlign="center">
						% <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="#农村" headerAlign="center">
				<div property="columns">
					<div field="c15" width="100" headerAlign="center">
						% <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
