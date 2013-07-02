package com.zoc.entity.act;

import java.math.BigDecimal;

import com.zoc.common.poi.ExcelAnnotation;

public class CNNSDYCN extends BaseActEntity {

	@ExcelAnnotation(cellIndex = 1)
	BigDecimal c2;
	@ExcelAnnotation(cellIndex = 2)
	BigDecimal c3;
	@ExcelAnnotation(cellIndex = 3)
	BigDecimal c4;
	@ExcelAnnotation(cellIndex = 4)
	BigDecimal c5;

	public BigDecimal getC2() {
		return c2;
	}

	public void setC2(BigDecimal c2) {
		this.c2 = c2;
	}

	public BigDecimal getC3() {
		return c3;
	}

	public void setC3(BigDecimal c3) {
		this.c3 = c3;
	}

	public BigDecimal getC4() {
		return c4;
	}

	public void setC4(BigDecimal c4) {
		this.c4 = c4;
	}

	public BigDecimal getC5() {
		return c5;
	}

	public void setC5(BigDecimal c5) {
		this.c5 = c5;
	}

}
