package entity;

/**
 * @author ljsy
 **/
public class Page {
    private int pageNo;
    private int totalPages;
    /**
     * 一页中的对象的数量
     */
    private int size = 10;

    public Page(int pageNo, int totalPages) {
        setTotalPages(totalPages);
        setPageNo(pageNo);
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        if (pageNo > totalPages) {
            pageNo = totalPages;
        }
        if (pageNo < 1) {
            pageNo = 1;
        }
        this.pageNo = pageNo;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        if (totalPages < 1) {
            totalPages = 1;
        }
        this.totalPages = totalPages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
