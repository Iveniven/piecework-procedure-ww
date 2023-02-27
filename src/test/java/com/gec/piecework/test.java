package com.gec.piecework;

import com.gec.piecework.pojo.Orders;
import com.gec.piecework.pojo.PageResp;
import com.gec.piecework.pojo.ResultBean;
import com.gec.piecework.pojo.Wire;
import com.gec.piecework.service.impl.OrdersServiceImpl;
import com.gec.piecework.service.impl.WireServiceImpl;
import com.gec.piecework.tool.TimeTool;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author iven
 * @version 2021.2.3
 * @date 2023/2/25 2:14
 */
@SpringBootTest
public class test {

    @Autowired
    private OrdersServiceImpl ordersService;

    @Test
    public void test1(){
        PageHelper.startPage(1, 5);
        Page<Orders> page = (Page<Orders>) ordersService.findAllOrders();
        PageResp resp = new PageResp();
        resp.setList(page.getResult());
        resp.setTotal(page.getTotal());
        System.out.println(resp);
    }
}
