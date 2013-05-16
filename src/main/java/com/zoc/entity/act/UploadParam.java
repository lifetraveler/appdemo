package com.zoc.entity.act;

import com.zoc.common.entity.AjaxEntity;

public class UploadParam extends AjaxEntity{
	
	String menu_id;
	
	String template_path;
	
	String work_book;
	
	String sheet_name;
	
	//从第一行开始
	int row_start;
	//从第几列开始
	int col_start;
	//到第几行结束
	int row_end;
	//到第几列结束
	int col_end;
	
	/**
	 * 年份坐标
	 */
	int row_year;
	
	int col_year;
	
	String row_check;

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public String getTemplate_path() {
		return template_path;
	}

	public void setTemplate_path(String template_path) {
		this.template_path = template_path;
	}

	public String getWork_book() {
		return work_book;
	}

	public void setWork_book(String work_book) {
		this.work_book = work_book;
	}

	public String getSheet_name() {
		return sheet_name;
	}

	public void setSheet_name(String sheet_name) {
		this.sheet_name = sheet_name;
	}

	public int getRow_start() {
		return row_start;
	}

	public void setRow_start(int row_start) {
		this.row_start = row_start;
	}

	public int getCol_start() {
		return col_start;
	}

	public void setCol_start(int col_start) {
		this.col_start = col_start;
	}

	public int getRow_end() {
		return row_end;
	}

	public void setRow_end(int row_end) {
		this.row_end = row_end;
	}

	public int getCol_end() {
		return col_end;
	}

	public void setCol_end(int col_end) {
		this.col_end = col_end;
	}

	public int getRow_year() {
		return row_year;
	}

	public void setRow_year(int row_year) {
		this.row_year = row_year;
	}

	public int getCol_year() {
		return col_year;
	}

	public void setCol_year(int col_year) {
		this.col_year = col_year;
	}

	public String getRow_check() {
		return row_check;
	}

	public void setRow_check(String row_check) {
		this.row_check = row_check;
	}
	
	
	
	
	
	

}
