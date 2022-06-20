package com.edu.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "employee")
public class Employee implements Serializable {
    @TableId(value = "emp_id",type = IdType.ASSIGN_ID)
    private Long empId;
    @TableField(value = "emp_name",exist = true)
    private String empName;
    private String empGender;
    private Integer age;
    private String email;
}
