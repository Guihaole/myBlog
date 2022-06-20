package com.offcn.service.impl;
import com.offcn.bean.Customer;
import com.offcn.service.CustomerService;
import com.offcn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CustomerService customerService;
    @Override
    public List<Customer> getCustomerListOrder() {
        return customerService.getCustomerList();
    }
}
