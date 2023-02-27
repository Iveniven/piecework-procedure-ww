package com.gec.piecework.service.impl;


import com.gec.piecework.mapper.ShippingMapper;
import com.gec.piecework.mapper.WireMapper;
import com.gec.piecework.pojo.Shipping;
import com.gec.piecework.pojo.ShippingExample;
import com.gec.piecework.pojo.Wire;
import com.gec.piecework.pojo.WireExample;
import com.gec.piecework.service.IShippingService;
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
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    public List<Shipping> queryByWireId(Wire wire){
        ShippingExample example = new ShippingExample();
        ShippingExample.Criteria criteria = example.createCriteria();
        criteria.andIdWireEqualTo(wire.getId());
        return shippingMapper.selectByExample(example);
    }

}
