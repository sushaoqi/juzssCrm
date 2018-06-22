package com.juzss.crm.domain;

import java.util.List;

/**
 * 分页显示：
 *  1.当前页
 *  2.每页最多显示的记录数
 *  3.总页数
 *  4.总记录数
 *  5.查询的集合
 * */
public class PageBean<T> {
    private Integer currPage;  // 当前页
    private Integer pageSize;  // 每页最多显示的记录数
    private Integer totalCount; // 总记录数
    private Integer totalPage;  // 总页数
    private List<T> list;  // 查询集合

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


}
