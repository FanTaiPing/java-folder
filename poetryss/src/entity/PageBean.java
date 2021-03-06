package entity;

import java.util.List;
/**
 * 分页对象
 * @author y
 *
 * @param <T>
 */
public class PageBean<T> {
	private int totalCount; // 总记录数
	private int totalPage; // 总页码
	private List<T> list; // 每页显示的数据(T表示想要显示的数据对象，如用户数据显示或者其他信息显示，是可变的)
	private int currentPage; // 当前页码
	private int rows; // 每页显示的记录数

	public PageBean() {

	}

	public PageBean(int totalCount, int totalPage, List<T> list, int currentPage, int rows) {
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.list = list;
		this.currentPage = currentPage;
		this.rows = rows;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageBean [totalCount=" + totalCount + ", totalPage=" + totalPage + ", list=" + list + ", currentPage="
				+ currentPage + ", rows=" + rows + "]";
	}
}
