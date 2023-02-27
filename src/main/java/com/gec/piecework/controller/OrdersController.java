package com.gec.piecework.controller;


import com.gec.piecework.pojo.Orders;
import com.gec.piecework.pojo.PageReq;
import com.gec.piecework.pojo.PageResp;
import com.gec.piecework.pojo.ResultBean;
import com.gec.piecework.service.impl.OrdersServiceImpl;
import com.gec.piecework.tool.TimeTool;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
@RequestMapping("/piecework/orders")
public class OrdersController {

    @Autowired
    private OrdersServiceImpl ordersService;

    @GetMapping("/queryAllOrders")
    public ResultBean queryAllSpec(PageReq pageReq) {
        PageHelper.startPage(pageReq.getPage(), pageReq.getSize());
        Page<Orders> page = (Page<Orders>) ordersService.findAllOrders();
        PageResp resp = new PageResp();
        resp.setList(page.getResult());
        resp.setTotal(page.getTotal());
        return ResultBean.ok(resp);
    }

    @PostMapping("/queryByCompany")
    public ResultBean queryByCompany() {
        return ResultBean.ok();
    }

    @PostMapping("/queryByCompletion")
    public ResultBean queryByCompletion() {
        return ResultBean.ok();
    }

}
