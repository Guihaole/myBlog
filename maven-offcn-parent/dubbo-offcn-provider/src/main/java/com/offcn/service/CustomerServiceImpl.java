package com.offcn.service;

import com.offcn.bean.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public List<Customer> getCustomerList() {
        ArrayList<Customer> list = new ArrayList<>();
        list.add(new Customer(1,"张三1",15,"上海市1"));
        list.add(new Customer(1,"张三2",15,"上海市2"));
        list.add(new Customer(1,"张三3",15,"上海市3"));
        list.add(new Customer(1,"张三4",15,"上海市4"));
        list.add(new Customer(1,"张三5",15,"上海市5"));
        return list;
    }
}
