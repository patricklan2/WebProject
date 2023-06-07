package org.lan.cinema.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageResult<T> {
    private Long pageTotal;
    private List<T> list;

    @Override
    public String toString() {
        return "PageResult{" +
                "pageTotal=" + pageTotal +
                ", list=" + list +
                '}';
    }

    public Long getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Long pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static <H> PageResult<H> build(List<H> lists){
        PageResult<H> pageResult = new PageResult<H>();
        PageInfo<H> pageInfo = new PageInfo<>(lists);
        pageResult.setList(pageInfo.getList());
        pageResult.setPageTotal(pageInfo.getTotal());
        return pageResult;
    }
}
