package com.blog.common;

public class PageEntity {
	private int pageIndex;
	private int pageSize;
	private int pageStart;
	private int totalCount;
	private String jsFunction;

	public PageEntity(int pageIndex, int pageSize, String jsFunction) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		pageStart = (pageIndex - 1) * pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public int getPageStart() {
		return pageStart;
	}

	public int getPageSize() {
		return pageSize;
	}

	public String getJsFunction() {
		return this.jsFunction;
	}

	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int  totalCount ){
		this.totalCount = totalCount ;
	}

}
