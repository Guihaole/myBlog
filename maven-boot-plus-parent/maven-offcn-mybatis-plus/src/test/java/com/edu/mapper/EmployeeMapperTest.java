package com.edu.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.bean.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    public void baseMapperApiInsert(){
        Employee employee = new Employee(null, "归浩乐", "男", 20, "guihaole@qq.com");
        System.out.println(employeeMapper.insert(employee));
        //主键回填
        System.out.println(employee.getEmpId());
    }
    @Test
    public void baseMapperApiUpdate(){
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.le("age",100);
        employeeMapper.selectList(wrapper).forEach(System.out::println);
    }
    @Test
    public void baseMapperApiDelete(){
        LambdaQueryWrapper<Employee> wrapper=new LambdaQueryWrapper<>();
        wrapper.le(Employee::getAge,100);
        employeeMapper.selectList(wrapper).forEach(System.out::println);
    }
    @Test
    public void baseMapperApiSelect(){

    }
}
