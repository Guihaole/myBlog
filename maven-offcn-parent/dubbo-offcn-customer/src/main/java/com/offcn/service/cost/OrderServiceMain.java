package com.offcn.service.cost;

import com.offcn.bean.Customer;
import com.offcn.service.CustomerService;
import com.offcn.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class OrderServiceMain {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        CustomerService customerService = (CustomerService)context.getBean("customerService");
        System.out.println(customerService);
        OrderService orderService = (OrderService) context.getBean("orderServiceImpl");
        List<Customer> list = orderService.getCustomerListOrder();
        System.out.println(list.size());
        list.forEach(System.out::println);
        System.in.read();
    }
}
