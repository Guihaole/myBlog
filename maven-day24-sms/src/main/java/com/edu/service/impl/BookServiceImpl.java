package com.edu.service.impl;

import com.edu.bean.Book;
import com.edu.dao.BookMapper;
import com.edu.dao.impl.BookMapperImpl;
import com.edu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookMapper bookMapper=new BookMapperImpl();
    @Override
    public List<Book> selectBookList(String bookname, String bookhistory, int startIndex, int pageSize) {
        return bookMapper.selectBookList(bookname,bookhistory,startIndex,pageSize);
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBookByBid(int bookid) {
        return bookMapper.deleteBookByBid(bookid);
    }

    @Override
    public Book selectBookById(int bookId) {
        return bookMapper.selectBookById(bookId);
    }

    @Override
    public int updateBookById(Book book) {
        return bookMapper.updateBookById(book);
    }

    @Override
    public int deleteBookAll(int[] bidInts) {
        return bookMapper.deleteBookAll(bidInts);
    }

    @Override
    public int bookTotalCount(String bookname, String bookhistory) {
        return bookMapper.bookTotalCount(bookname,bookhistory);
    }
}
