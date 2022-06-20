package com.edu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ToString
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;
    private String createTime;
}
