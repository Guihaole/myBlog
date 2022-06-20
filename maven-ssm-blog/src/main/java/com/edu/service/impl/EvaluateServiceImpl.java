package com.edu.service.impl;

import com.edu.bean.Evaluate;
import com.edu.bean.EvaluateExample;
import com.edu.mapper.EvaluateMapper;
import com.edu.service.EvaluateService;
import com.edu.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluateMapper evaluateMapper;
    @Override
    public PageInfo<Evaluate> getPageInfoEvaluate(Integer pageNum, String uname) {
        PageHelper.startPage(pageNum,3);
        List<Evaluate> evaluateList=null;
        //uname传到dao层有就拼接，没有就查询所有评论
        evaluateList=evaluateMapper.selectEvaluateByLikeUname(uname);
        PageInfo<Evaluate> pageInfo = new PageInfo<>(evaluateList,3);
        return pageInfo;
    }

    @Override
    public PageInfo<Evaluate> getPageInfoEvaluateByBid(Integer pageNum, Integer bid) {
        PageHelper.startPage(pageNum,3);
        List<Evaluate> evaluateList=null;
        EvaluateExample example = new EvaluateExample();
        if (bid!=null) {
            example.createCriteria().andBFkEqualTo(bid);
            evaluateList=evaluateMapper.selectByExample(example);
        }else {
            evaluateList=evaluateMapper.selectByExample(null);
        }
        PageInfo<Evaluate> pageInfo = new PageInfo<>(evaluateList,3);
        return pageInfo;
    }

    /**
     * 根据eid删除评论信息的方法
     * @param eid
     * @return
     */
    @Override
    public ResultVo deleteEvaluateByEid(Integer eid) {
        int i = evaluateMapper.deleteByPrimaryKey(eid);
        ResultVo vo=null;
        if (i==0) {
            vo=new ResultVo("202","删除失败",null);
        }else {
            vo=new ResultVo("200","删除成功",null);
        }
        return vo;
    }
}
