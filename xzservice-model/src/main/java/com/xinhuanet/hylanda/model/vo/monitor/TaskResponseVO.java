package com.xinhuanet.hylanda.model.vo.monitor;

import com.xinhuanet.hylanda.model.common.OpResult;
import com.xinhuanet.hylanda.model.common.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */

public class TaskResponseVO {

    /**
     * 响应信息
     */
    private OpResult resp = new OpResult(OpResult.OP_SUCCESS,OpResult.OpMsg.OP_SUCCESS);

    /**
     * 数据列表
     */
    private List<TaskListVO> datalist;

    /**
     * 分页信息
     */
    private Page page;

    public OpResult getResp() {
        return resp;
    }

    public void setResp(OpResult resp) {
        this.resp = resp;
    }

    public List<TaskListVO> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<TaskListVO> datalist) {
        this.datalist = datalist;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
