package com.edu.emens;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum SexEmen {
    MEN(1, "男"),
    WOMEN(0, "女");
    @EnumValue
    private Integer sex;
    private String sexName;

    SexEmen(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
