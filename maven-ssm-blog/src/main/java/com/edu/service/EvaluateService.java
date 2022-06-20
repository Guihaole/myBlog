package com.edu.service;

import com.edu.bean.Evaluate;
import com.edu.vo.ResultVo;
import com.github.pagehelper.PageInfo;

public interface EvaluateService {
    //查询评论信息带模糊分页
    public PageInfo<Evaluate> getPageInfoEvaluate(Integer pageNum, String uname);
    //根据bid查询这个博客的所有评论信息并分页
    public PageInfo<Evaluate> getPageInfoEvaluateByBid(Integer pageNum, Integer bid);
    //根据eid删除评论信息的方法
    ResultVo deleteEvaluateByEid(Integer eid);
}
