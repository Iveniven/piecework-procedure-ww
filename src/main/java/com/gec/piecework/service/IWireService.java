package com.gec.piecework.service;


import com.gec.piecework.pojo.Orders;
import com.gec.piecework.pojo.Wire;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gec
 * @since 2023-02-25
 */
public interface IWireService {

    public List<Wire> findWireByOrdNum(Orders orders);

}
