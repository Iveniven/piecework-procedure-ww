package com.gec.piecework.service;


import com.gec.piecework.pojo.Orders;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gec
 * @since 2023-02-25
 */
public interface IOrdersService {

    public List<Orders> findAllOrders();

}
