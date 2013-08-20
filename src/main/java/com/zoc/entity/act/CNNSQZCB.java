package com.zoc.entity.act;

import java.math.BigDecimal;

import com.zoc.common.poi.ExcelAnnotation;

public class CNNSQZCB extends BaseActEntity {

	
	@ExcelAnnotation(cellIndex = 1)
	BigDecimal c2;
	
	public BigDecimal getC2() {
		return c2;
	}
	public void setC2(BigDecimal c2) {
		this.c2 = c2;
	}
}
