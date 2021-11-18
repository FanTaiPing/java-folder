package entity;

import java.util.List;

public class Page {
	/**
	 * 当前页
	 */
	private int currentPageNo = 1;
	/**
	 * 每页展示十条数据
	 */
	private int pageSize = 3;
	/**
	 * 新闻列表总记录数（共有多少新闻）
	 */
	private int totalCount;
	/**
	 * 根据总记录数和每页展示的多少调数据计算出可以分多少页（限制最大页数和负数的页码）
	 */
	private int totalPageCount;
	/**
	 * 分页后的新闻列表
	 */
	List<News> newsList;

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		if(currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		if(currentPageNo <= 0) {
			currentPageNo = 1;
		}
		this.currentPageNo = currentPageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if(totalCount >0) {
		this.totalCount = totalCount;	
		//计算总页数
		totalPageCount = (totalCount % pageSize ==0) ? (totalCount / pageSize) :((totalCount / pageSize)+1);
		}
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageConut(int totalPageConut) {

		this.totalPageCount = totalPageConut;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
}
