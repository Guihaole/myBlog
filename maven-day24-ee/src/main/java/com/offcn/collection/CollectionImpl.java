package com.offcn.collection;

import java.util.*;

//集合
public class CollectionImpl {
    public void start(){
        //1.集合分为两大类   list,set
        //遍历方式
        List<String> stringList=new ArrayList<>();
        for (String s : stringList) {
            System.out.println(s);
        }
        Iterator<String> iterator = stringList.iterator();
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Stack<String> stack=new Stack<>();
        stack.add("username");
    }
    //set集合
    public void set(){
        Set<Integer> set=new TreeSet<>();
        Set<Student> studentSet=new TreeSet<>();
        studentSet.add(new Student("admin","123456"));
        studentSet.add(new Student("guihaole","123456"));
        studentSet.add(new Student("ad","ad"));
        studentSet.add(new Student("guihaoleadmin","123456"));
        System.out.println(studentSet);
        TreeSet<User> userSet = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        userSet.add(new User(1,23));
        userSet.add(new User(2,24));
        userSet.add(new User(3,18));
        System.out.println(userSet);
    }
    public void equalsBook(){
        Set<Book> bookSet=new HashSet<>();
        bookSet.add(new Book(1,"admin","123456"));
        bookSet.add(new Book(1,"adminguihaole","1.jpg"));
        System.out.println(bookSet);
    }
}
