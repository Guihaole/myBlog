package com.edu.dao.impl;

import com.edu.bean.Book;
import com.edu.dao.BookMapper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class BookMapperImpl implements BookMapper {
    private DataSource dataSource=new ComboPooledDataSource();
    private QueryRunner queryRunner=new QueryRunner(dataSource);
    /**
     *查询所有图书+模糊查询  拼接where 1==1
     * @param bookname
     * @param bookhistory
     * @param startIndex
     * @param pageSize
     */
    @Override
    public List<Book> selectBookList(String bookname, String bookhistory, int startIndex, int pageSize) {
        String sql="select * from book where 1=1";
        if (bookname!=null&&!"".equals(bookname)) {
            sql=sql+" and bookname like '%"+bookname+"%'";
        }
        if (bookhistory!=null&&!"".equals(bookhistory)&&!"0".equals(bookhistory)) {
            sql=sql+" and bookhistory like '"+bookhistory+"'";
        }
        sql=sql+" limit ?,?";
        List<Book> bookList=null;
        try {
            bookList=queryRunner.query(sql,new BeanListHandler<Book>(Book.class),startIndex,pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }
    /**
     * 查询书的总记录数
     * @return
     * @param bookname
     * @param bookhistory
     */
    @Override
    public int bookTotalCount(String bookname, String bookhistory) {
        String sql="select count(*) from book where 1=1";
        StringBuilder sqlStr = new StringBuilder(sql);
        if(bookname!=null&&!"".equals(bookname)){
            sqlStr.append(" and bookname like '%"+bookname+"%'");
        }
        if (bookhistory!=null&&!"".equals(bookhistory)&&!"0".equals(bookhistory)){
            sqlStr.append(" and bookhistory like '"+bookhistory+"'");
        }
        Long res=null;
        try {
            res=queryRunner.query(sqlStr.toString(),new ScalarHandler<Long>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res.intValue();
    }
    //添加图书
    @Override
    public int addBook(Book book) {
        String sql="insert into book (bookname,bookprice,bookathor,booklocation,bookdate,bookstate,bookhobby,bookhistory,bookphoto)values(?,?,?,?,?,?,?,?,?)";
        Object[] obj={book.getBookname(),book.getBookprice(),book.getBookathor(),
                book.getBooklocation(),book.getBookdate(),book.getBookstate(),book.getBookhobby(),book.getBookhistory(),book.getBookphoto()};
        int res=0;
        try {
            res=queryRunner.update(sql,obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }
    //根据id删除图书
    @Override
    public int deleteBookByBid(int bookid) {
        String sql="delete from book where bid=?";
        int res=0;
        try {
            res=queryRunner.update(sql,bookid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }
   // 根据id修改图书
    @Override
    public int updateBookById(Book book) {
        String sql="update book set bookname=?,bookprice=?,bookathor=?,booklocation=?,bookdate=?,bookstate=?,bookphoto=? where bid=?";
        Object[] obj={book.getBookname(),book.getBookprice(),book.getBookathor(),
                book.getBooklocation(), book.getBookdate(),book.getBookstate(),book.getBookphoto(),book.getBid()};
        int res=0;
        try {
            res=queryRunner.update(sql,obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    /**
     * 批量删除
     * @param bidInts
     * @return
     */
    @Override
    public int deleteBookAll(int[] bidInts) {
        int res=0;
        String sql="delete from book where bid=?";
        try {
            for (int bidInt : bidInts) {
                queryRunner.update(sql,bidInt);
                res++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public Book selectBookById(int bookId) {
        String sql="select * from book where bid=?";
        Object[] obj={bookId};
        Book book=null;
        try {
            book=queryRunner.query(sql,new BeanHandler<>(Book.class),obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }
}
