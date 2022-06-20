package com.edu.service;

import com.edu.bean.Blog;
import com.edu.bean.Btype;
import com.edu.vo.ResultVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BtypeService {
    //做分页处理类别信息
    public PageInfo getPageInfoBtypeList(Integer pageNum);

    public  ResultVo addBTypeBig(String typename, String typedes);

    public ResultVo updateBTypeBig(Integer typeid, String typename, String typedes);
    //根据typeid删除博客及其子类
    public void deleteBlogByTypeId(Integer typeid);
    //根据typeid查询所有的小类信息并分页
    public PageInfo getPageInfoSmallByTypePid(Integer pageNum,Integer typeid);

    public ResultVo deleteSmallBtypeByid(Integer byteid);

    public  ResultVo addTypeSmall(Btype btype);
    //根据bid查询一级分类和二级分类
    public List<Btype> selectBtypeList(Integer bid);
    //根据typeId查询大类信息
    public Btype selectBtypeByBid(Integer typeId);

}
