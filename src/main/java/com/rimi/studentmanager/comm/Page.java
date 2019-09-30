package com.rimi.studentmanager.comm;

import java.util.List;

/**
 * @author admin
 * @date 2019/9/25 16:43
 */
public class Page<T> {
    private List<T> pageData;
    private Integer currentPage = 1;
    private Integer pageSize = 5;
    private Integer totalCount;

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pagaSize) {
        this.pageSize = pagaSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageCount() {
        if (this.totalCount % this.pageSize == 0) {
            return this.totalCount / this.pageSize;
        }
        return this.totalCount / this.pageSize + 1;
    }

    public static Page of(Integer currentPage) {
        Page page = new Page();
        page.setCurrentPage(currentPage);
        return page;
    }

    public Integer getCurrentsSize() {
        Integer cp = this.currentPage;
        if (cp > 0) {
            cp -= 1;
        } else {
            cp = 0;
        }
        int currentSize = cp * this.pageSize;
        if (currentSize > this.totalCount) {
            currentSize = (this.currentPage - 1) * pageSize;
        }
        return currentSize;
    }
}
