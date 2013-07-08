<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<div property="columns">
	<div type="indexcolumn"></div>
	<div field="c1" width="100" headerAlign="center">
		年龄 <input property="editor" class="mini-textbox" style="width: 100%;" />
	</div>
	<div header="">
		<div property="columns">
			<div header="合计" headerAlign="center">
				<div property="columns">
					<div field="c2" width="100" headerAlign="center">
						1 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="${UNIT}"
							style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="企业" headerAlign="center">
		<div property="columns">
			<div header="小计" headerAlign="center">
				<div property="columns">
					<div field="c3" width="100" headerAlign="center">
						2 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="${UNIT}"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="男" headerAlign="center">
				<div property="columns">
					<div field="c4" width="100" headerAlign="center">
						3 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="${UNIT}"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="女" headerAlign="center">
				<div property="columns">
					<div field="c5" width="100" headerAlign="center">
						4 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="${UNIT}"
							style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div header="其他人员" headerAlign="center">
		<div property="columns">
			<div header="小计" headerAlign="center">
				<div property="columns">
					<div field="c6" width="100" headerAlign="center">
						5 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="${UNIT}"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="男" headerAlign="center">
				<div property="columns">
					<div field="c7" width="100" headerAlign="center">
						6 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="${UNIT}"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div header="女" headerAlign="center">
				<div property="columns">
					<div field="c8" width="100" headerAlign="center">
						7 <input property="editor" class="mini-spinner"
							allowLimitValue=false decimalPlaces="${UNIT}"
							style="width: 100%;" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

