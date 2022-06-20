package com.edu.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.edu.emens.SexEmen;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
//@TableName("s_user")
public class User {
    //注意bigint要用 Long接收
    //1.作用一:就是这个字段不是id的时候，将字段变为主键字段
    //2.type: 当你需要主键自增的方式就去使用
    //3.value: id 和数据库字段不同的时候
    //@TableId(value = "uid",type = IdType.AUTO)
    @TableId(value = "uid")
    private Long id;
    @TableField(value = "user_name")
    //代表字段映射关系
    private String name;
    private Integer age;
    private SexEmen sex;
    private String email;
    //mybatis_plus自动开启驼峰映射规则
    @TableLogic
    //逻辑删除字段
    private Integer isDeleted;






    public User(Long l, String guihaole, Object o, Object o1, Object o2) {
    }
}
