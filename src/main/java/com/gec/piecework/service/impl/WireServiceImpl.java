package com.gec.piecework.service.impl;


import com.gec.piecework.mapper.WireMapper;
import com.gec.piecework.pojo.Orders;
import com.gec.piecework.pojo.Wire;
import com.gec.piecework.pojo.WireExample;
import com.gec.piecework.service.IWireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gec
 * @since 2023-02-25
 */
@Service
public class WireServiceImpl implements IWireService {

    @Autowired
    private WireMapper wireMapper;

    public List<Wire> findWireByOrdNum(Orders orders){
        WireExample example = new WireExample();
        WireExample.Criteria criteria = example.createCriteria();
        criteria.andOrdernumEqualTo(orders.getId());
        List<Wire> list = wireMapper.selectByExample(example);


        return list;
    }

}
