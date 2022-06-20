package com.offcn.util;

public class PageUtils {
    private int pageSize; //页容量 每页显示的数量   5
    private int totalCount;  // 总记录数  count(*)
    private int currentPage; // 当前页
    private int startIndex;  // 起始的行下标
    private int totalPages;  // 总页码
    private int prePage;   // 上一页
    private int nextPage;  //下一页

    public PageUtils(int pageSize, int totalCount, String currentPage) {
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        initCurrentPage(currentPage);
        initStartIndex() ;
        initTotalPages();
        initPrePage();
        initNextPage();
    }

    //给当前页码赋值
    private void initCurrentPage(String currentPage) {
        if (currentPage==null) {
            this.currentPage = 1;
        }else {
            this.currentPage = Integer.valueOf(currentPage);
        }
    }
    //给每个页的第一条记录的超始下标赋值
    private void initStartIndex() {

        this.startIndex = this.pageSize*(this.currentPage-1);
    }
    //给总页码赋值

    private void initTotalPages() {
        this.totalPages = totalCount%pageSize==0 ? totalCount/pageSize :totalCount/pageSize+1;
    }
    //给上一页赋值
    private void initPrePage() {
        if (currentPage == 1) {
            this.prePage=1;
        }else {
            this.prePage=this.currentPage-1;
        }
    }
    //给下一页赋值
    private void initNextPage() {
        if (currentPage == totalPages) {
            this.nextPage = totalPages;
        }else {
            this.nextPage = currentPage + 1;
        }
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
        this.totalCount = totalCount;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getStartIndex() {
        return startIndex;
    }
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public int getPrePage() {
        return prePage;
    }
    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }
    public int getNextPage() {
        return nextPage;
    }
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

}
