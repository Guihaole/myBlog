package com.offcn.collection;

import java.util.Objects;

public class Book {
    private Integer id;
    private String bookname;
    private String bookImage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(bookname, book.bookname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookname);
    }

    public Book() {
    }

    public Book(Integer id, String bookname, String bookImage) {
        this.id = id;
        this.bookname = bookname;
        this.bookImage = bookImage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", bookImage='" + bookImage + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }
}
