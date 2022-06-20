package com.edu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Value("guihaolecid")
    String cid;
    @Value("#{20-2}")
    String cart_sum;
    @Value("${cart_state}")
    String cart_state;
    @Value("${cart_price}")
    String cart_price;
    Student student;
}
