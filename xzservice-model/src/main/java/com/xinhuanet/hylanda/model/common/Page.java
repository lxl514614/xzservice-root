package com.xinhuanet.hylanda.model.common;


/**
 * 分页信息基础类
 * Created by Administrator on 2017/1/9.
 */
public class Page {

	/**
     * 记录总数
     */
    private Long total_recorders;

    /**
     * 页号
     */
    private Integer  page_index;

    /**
     * 每页显示条数
     */
    private Integer page_size;

    /**
     * 总页数
     */
    private Integer total_page;

    /**
     * 对象集合
     */
//    private List<T> list;


    public Long getTotal_recorders() {
        return total_recorders;
    }

    public void setTotal_recorders(Long total_recorders) {
        this.total_recorders = total_recorders;
    }

    public Integer getPage_index() {
        return page_index;
    }

    public void setPage_index(Integer page_index) {
        this.page_index = page_index;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public Integer getTotal_page() {
        return total_page;
    }

    public void setTotal_page(Integer total_page) {
        this.total_page = total_page;
    }
}

