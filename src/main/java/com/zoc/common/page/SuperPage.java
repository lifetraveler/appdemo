package com.zoc.common.page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator 分页的模版类
 * 
 */
public class SuperPage<T> {

	// 从哪一条开始
	private Integer pageOffset;

	// 每次查询条数
	private Integer pageSize;

	// 当前第几页
	private Integer pageIndex;

	// 总条数
	private Integer total;

	private List<T> data;

	public SuperPage() {
		this.data = new ArrayList<T>();
		this.pageSize = 10;
		this.pageIndex = 0;
		this.pageOffset = pageSize * pageIndex;
	}

	/**
	 * @return the pageOffset
	 */
	public Integer getPageOffset() {
		return pageIndex * pageSize;
	}

	/**
	 * @param pageOffset
	 *            the pageOffset to set
	 */
	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex
	 *            the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
	}

}
