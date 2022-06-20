package com.edu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;

@TableName("t_product")
@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version
    //乐观锁版本号
    private Integer version;
}
