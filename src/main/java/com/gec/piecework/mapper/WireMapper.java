package com.gec.piecework.mapper;


import com.gec.piecework.pojo.Wire;
import com.gec.piecework.pojo.WireExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WireMapper {
    long countByExample(WireExample example);

    int deleteByExample(WireExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Wire record);

    int insertSelective(Wire record);

    List<Wire> selectByExample(WireExample example);

    Wire selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Wire record, @Param("example") WireExample example);

    int updateByExample(@Param("record") Wire record, @Param("example") WireExample example);

    int updateByPrimaryKeySelective(Wire record);

    int updateByPrimaryKey(Wire record);
}