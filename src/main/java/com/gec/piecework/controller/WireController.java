package com.gec.piecework.controller;


import com.gec.piecework.pojo.*;
import com.gec.piecework.service.impl.ShippingServiceImpl;
import com.gec.piecework.service.impl.WireServiceImpl;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gec
 * @since 2023-02-25
 */
@RestController
@RequestMapping("/piecework/wire")
public class WireController {

    @Autowired
    private WireServiceImpl wireService;

    @Autowired
    private ShippingServiceImpl shippingService;

    @PostMapping("/queryByIdOrders")
    public ResultBean queryByIdOrders(@RequestBody Orders orders) {
        List<Wire> list = wireService.findWireByOrdNum(orders);

        for (Wire w : list) {
            w.setShippingList(shippingService.queryByWireId(w));
            if (w.getShippingList().size() > 0) {
                w.setUpdatetime(w.getShippingList().get(w.getShippingList().size() - 1).getCreattime());
            }
        }

        return ResultBean.ok(list);
    }
}
