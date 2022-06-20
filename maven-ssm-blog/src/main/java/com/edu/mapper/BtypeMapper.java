package com.edu.mapper;

import com.edu.bean.Btype;
import com.edu.bean.BtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BtypeMapper {
    int countByExample(BtypeExample example);

    int deleteByExample(BtypeExample example);

    int deleteByPrimaryKey(Integer typeid);

    int insert(Btype record);

    int insertSelective(Btype record);

    List<Btype> selectByExample(BtypeExample example);

    Btype selectByPrimaryKey(Integer typeid);

    int updateByExampleSelective(@Param("record") Btype record, @Param("example") BtypeExample example);

    int updateByExample(@Param("record") Btype record, @Param("example") BtypeExample example);

    int updateByPrimaryKeySelective(Btype record);

    int updateByPrimaryKey(Btype record);
    //查询类别信息，一级一个类下的小类信息
    public List<Btype> selectBtypeList(BtypeExample example);
    //根据 type_id查询类别
    public List<Btype> selectBtypeListByTypeId(Integer typeId);
}
