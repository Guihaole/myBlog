package com.offcn.end;

import java.io.Serializable;

public class Photo implements Serializable {
    private Integer width;
    private Integer height;
    private int size;
    private Integer area;

    public Photo() {
    }

    @Override
    public String toString() {
        return "Photo{" +
                "width=" + width +
                ", height=" + height +
                ", size=" + size +
                ", area=" + area +
                '}';
    }
    @Spring(str = "123",username = "guigege",a=1,value = Reflection.class)
    private void startPrivate(){
        System.out.println("我是一个私有的方法");
    }
    public void setArea(Integer width, Integer height) {
        this.area=width*height;
    }
    public Photo(Integer width, Integer height, int size, Integer area) {
        this.width = width;
        this.height = height;
        this.size = size;
        this.area = area;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}
