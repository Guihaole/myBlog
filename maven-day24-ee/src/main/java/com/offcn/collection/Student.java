package com.offcn.collection;

public class Student implements Comparable<Student> {
    private String username;
    private String password;

    public Student() {
    }

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student stu) {
        //满足条件代表stu大
        return stu.getUsername().length()-this.getUsername().length();
    }
}
