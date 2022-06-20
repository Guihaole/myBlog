package com.edu.service;

import com.edu.bean.Book;

import java.util.List;

public interface BookService {
    List<Book> selectBookList(String bookname, String bookhistory, int startIndex, int pageSize);

    int addBook(Book book);

    int deleteBookByBid(int bookid);

    Book selectBookById(int bookId);

    int updateBookById(Book book);

    int deleteBookAll(int[] bidInts);

    int bookTotalCount(String bookname, String bookhistory);
}
