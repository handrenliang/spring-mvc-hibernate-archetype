package com.joinme.icook.util;

import java.util.List;

public class PageView<T> {
    private List<T> records;
    private PageIndex pageIndex;
    private long totalPage = 1;
    private int maxResult = 12;
    private int currentPage = 1;
    private long totalRecord;
    private int pageCode = 10;

    public PageView(int maxResult, int currentPage) {
        this.maxResult = maxResult;
        this.currentPage = currentPage;
    }

    public int getFirstResult() {
        return (this.currentPage - 1) * this.maxResult;
    }

    public void setQueryResult(QueryResult<T> qr) {
        this.setTotalRecord(qr.getTotalRecord());
        this.setRecords(qr.getResultList());
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public PageIndex getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(PageIndex pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
        this.pageIndex = PageIndex.getPageIndex(pageCode, currentPage,
                totalPage);
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
        setTotalPage(this.totalRecord % this.maxResult == 0 ? this.totalRecord
                / this.maxResult : this.totalRecord / this.maxResult + 1);
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }
}
