package com.gec.piecework.service.impl;


import com.gec.piecework.mapper.OrdersMapper;
import com.gec.piecework.pojo.Orders;
import com.gec.piecework.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gec
 * @since 2023-02-25
 */
@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    public List<Orders> findAllOrders() {
        return ordersMapper.selectByExample(null);
    }
}
