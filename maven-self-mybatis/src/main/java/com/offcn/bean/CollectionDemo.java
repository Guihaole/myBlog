package com.offcn.bean;

import java.util.List;

public class CollectionDemo {
    private List<Integer> idList;

    public CollectionDemo(List<Integer> idList) {
        this.idList = idList;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }
}
