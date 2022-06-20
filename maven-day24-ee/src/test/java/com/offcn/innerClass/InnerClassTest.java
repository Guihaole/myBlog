package com.offcn.innerClass;

import com.offcn.collection.CollectionImpl;
import com.offcn.map.SearchMap;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InnerClassTest {
    private A.B b=new A().new B();
    private Inner inner=new Inner();
    @Test
    public void start1(){
       // b.B1();
       // inner.start();
       // inner.equals(new A());
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);
        System.out.println(instance.getTime());
        instance.set(2000,9-1,9);
        //System.out.println(instance);
        Date time = instance.getTime();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(time));
    }
    @Test
    public void set(){
        CollectionImpl collection = new CollectionImpl();
        collection.set();
    }
    @Test
    public void book(){
        CollectionImpl collection = new CollectionImpl();
        collection.equalsBook();
    }
    @Test
    public void map(){
        SearchMap searchMap = new SearchMap();
        searchMap.start();
    }
}
