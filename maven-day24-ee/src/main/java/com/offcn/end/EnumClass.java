package com.offcn.end;

//枚举
public enum EnumClass {
    RED("红色"),
    GREEN("绿色"),
    BLANK("白色"),
    YELLO("黄色");
    // 成员变量
    private String name;
    // 构造方法
    private EnumClass(String name) {
        this.name = name;
    }
    //覆盖方法
    @Override
    public String toString() {
        return this.name+"";
    }
}
