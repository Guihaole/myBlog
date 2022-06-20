package com.edu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class User {
    private String uid;
    private String uName;
    private String uPassword;
}
