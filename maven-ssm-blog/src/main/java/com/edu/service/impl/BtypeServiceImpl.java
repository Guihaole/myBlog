package com.edu.service.impl;

import com.edu.bean.Btype;
import com.edu.bean.BtypeExample;
import com.edu.mapper.BtypeMapper;
import com.edu.service.BtypeService;
import com.edu.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BtypeServiceImpl implements BtypeService {
    @Autowired
    private BtypeMapper btypeMapper;

    /**
     * 做分页处理类别信息
     *
     * @param pageNum 当前页
     * @return
     */
    @Override
    public PageInfo getPageInfoBtypeList(Integer pageNum) {
        PageHelper.startPage(pageNum, 3);
        BtypeExample btypeExample = new BtypeExample();
        btypeExample.createCriteria().andTypePidIsNull();
        List<Btype> btypeList = btypeMapper.selectBtypeList(btypeExample);
        PageInfo<Btype> pageInfo = new PageInfo<>(btypeList, 3);
        return pageInfo;
    }

    /**
     * 添加大类信息
     *
     * @param typename
     * @param typedes
     * @return
     */
    @Override
    public ResultVo addBTypeBig(String typename, String typedes) {
        Btype btype = new Btype();
        btype.setTypedes(typedes);
        btype.setTypename(typename);
        btype.setTypePid(null);
        int i = btypeMapper.insertSelective(btype);
        ResultVo vo = null;
        if (i == 0) {
            vo = new ResultVo("202", "添加失败", null);
        } else {
            vo = new ResultVo("200", "添加成功", null);
        }
        return vo;
    }

    /**
     * 修改大类信息
     *
     * @param typeid
     * @param typename
     * @param typedes
     * @return
     */
    @Override
    public ResultVo updateBTypeBig(Integer typeid, String typename, String typedes) {
        Btype btype = new Btype();
        btype.setTypeid(typeid);
        btype.setTypedes(typedes);
        btype.setTypename(typename);
        int i = btypeMapper.updateByPrimaryKeySelective(btype);
        ResultVo vo = null;
        if (i == 0) {
            vo = new ResultVo("202", "修改失败", null);
        } else {
            vo = new ResultVo("200", "修改成功", null);
        }
        return vo;
    }

    /**
     * 根据typeid删除博客及其子类
     *
     * @param typeid
     */
    @Transactional
    @Override
    public void deleteBlogByTypeId(Integer typeid) {
        //1.删除子类
        BtypeExample btypeExample = new BtypeExample();
        btypeExample.createCriteria().andTypePidEqualTo(typeid);
        btypeMapper.deleteByExample(btypeExample);
        //2.删除大类
        btypeMapper.deleteByPrimaryKey(typeid);
    }

    /**
     * 根据typeid查询所有的小类信息并分页
     *
     * @param typeid
     * @return
     */
    @Override
    public PageInfo getPageInfoSmallByTypePid(Integer pageNum, Integer typeid) {
        PageHelper.startPage(pageNum, 3);
        BtypeExample btypeExample = new BtypeExample();
        btypeExample.createCriteria().andTypePidEqualTo(typeid);
        List<Btype> btypeList = btypeMapper.selectBtypeList(btypeExample);
        PageInfo<Btype> pageInfo = new PageInfo<>(btypeList, 3);
        return pageInfo;
    }

    /**
     * 根据typeid删除小类信息
     * 也可删除大类信息----复用
     * @param byteid
     * @return
     */
    @Override
    public ResultVo deleteSmallBtypeByid(Integer byteid) {
        int i = btypeMapper.deleteByPrimaryKey(byteid);
        if (i == 0) {
            return new ResultVo("202", "删除失败", null);
        } else {
            return new ResultVo("200", "删除成功", null);
        }
    }

    /**
     * 添加小类信息
     *
     * @param btype
     * @return
     */
    @Override
    public ResultVo addTypeSmall(Btype btype) {
        int i = btypeMapper.insertSelective(btype);
        if (i == 0) {
            return new ResultVo("202", "新增失败", null);
        } else {
            return new ResultVo("200", "新增成功", null);
        }
    }

    /**
     * 根据bid查询一级分类和二级分类
     *
     * @param bid bid为null或者为0查询一级分类，else二级分类
     * @return
     */
    @Override
    public List<Btype> selectBtypeList(Integer bid) {
        List<Btype> btypeList=null;
        BtypeExample btypeExample = new BtypeExample();
        if (bid == null || bid <= 0) {
            btypeExample.createCriteria().andTypePidIsNull();
            btypeList=btypeMapper.selectBtypeList(btypeExample);
        }else {
            btypeExample.createCriteria().andTypePidEqualTo(bid);
            btypeList=btypeMapper.selectBtypeList(btypeExample);
        }
        return btypeList;
    }

    /**
     * 根据bid查询大类信息
     * @param typeId
     * @return
     */
    @Override
    public Btype selectBtypeByBid(Integer typeId) {
        return btypeMapper.selectByPrimaryKey(typeId);
    }
}
