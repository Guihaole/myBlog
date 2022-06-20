package com.edu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Account {
    private Integer id;
    private String name;
    private Double money;
    private String createTime;
}
