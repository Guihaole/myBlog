package com.offcn.service;

import com.offcn.bean.Customer;

import java.util.List;

public interface CustomerService {
    //查询所有的customer
    public List<Customer> getCustomerList();
}
