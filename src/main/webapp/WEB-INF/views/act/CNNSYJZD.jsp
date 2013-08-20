<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<div property="columns">
	<div type="indexcolumn"></div>
	<div field="year" width="60" headerAlign="center" allowSort="true">年
	 	<input property="editor" class="mini-textbox" style="width: 100%;" />
	</div>
	<div header="收入" headerAlign="center">
		<div property="columns">
			<div field="c2" width="100" headerAlign="center">
				合计 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
			<div header="增缴收入" headerAlign="center">
				<div property="columns">
					<div field="c3" width="60">
						<input property="editor" class="mini-textbox" style="width: 100%;" />
					</div>
					<div field="c4" width="80">
						#当期征缴 <input property="editor" class="mini-textbox"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<div field="c5" width="80" headerAlign="center">
				利息 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
			<div field="c6" width="80" headerAlign="center">
				财政补助 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
			<div field="c7" width="80" headerAlign="center">
				其他 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="支出" headerAlign="center">
		<div property="columns">
			<div field="c8" width="100" headerAlign="center">
				合计 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
			<div field="c9" width="80" headerAlign="center">
				养老金支出 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
			<div field="c10" width="80" headerAlign="center">
				医疗 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
			<div field="c11" width="80" headerAlign="center">
				丧葬 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
			<div field="c12" width="80" headerAlign="center">
				其他 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="收入-支出" headerAlign="center">
		<div property="columns">
			<div field="c13" width="100" headerAlign="center">
				当期结余 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
			<div field="c14" width="80" headerAlign="center">
				#负结余 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="征缴收入-支出 （缺口情况）" headerAlign="center">
		<div property="columns">
			<div field="c15" width="100" headerAlign="center">
				当期结余 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
			<div field="c16" width="80" headerAlign="center">
				缺口 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div header="当期征缴收入+财政补贴-支出" headerAlign="center">
		<div property="columns">
			<div field="c17" width="100" headerAlign="center">
				当期结余 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
			<div field="c18" width="80" headerAlign="center">
				#负结余 <input property="editor" class="mini-spinner"
					allowLimitValue=false decimalPlaces="2" style="width: 100%;" />
			</div>
		</div>
	</div>
	<div field="c19" width="60" headerAlign="center" allowSort="true">
		累计结余 <input property="editor" class="mini-textbox"
			style="width: 100%;" />
	</div>
</div>
