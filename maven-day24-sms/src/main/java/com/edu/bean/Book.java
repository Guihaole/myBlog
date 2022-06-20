package com.edu.bean;
public class Book {

    private Integer bid;
    private String bookname;
    private Double bookprice;
    private String bookathor;
    private String booklocation;
    private String bookdate;
    private String bookstate;
    private String bookhobby;
    private String bookhistory;
    private String bookphoto;

    public Book(String bookname, Double bookprice, String bookathor, String booklocation, String bookdate, String bookstate, String bookhobby, String bookhistory, String bookphoto) {
        this.bookname = bookname;
        this.bookprice = bookprice;
        this.bookathor = bookathor;
        this.booklocation = booklocation;
        this.bookdate = bookdate;
        this.bookstate = bookstate;
        this.bookhobby = bookhobby;
        this.bookhistory = bookhistory;
        this.bookphoto = bookphoto;
    }

    public Book(Integer bid, String bookname, Double bookprice, String bookathor, String booklocation, String bookdate, String bookstate, String bookhobby, String bookhistory, String bookphoto) {
        this.bid = bid;
        this.bookname = bookname;
        this.bookprice = bookprice;
        this.bookathor = bookathor;
        this.booklocation = booklocation;
        this.bookdate = bookdate;
        this.bookstate = bookstate;
        this.bookhobby = bookhobby;
        this.bookhistory = bookhistory;
        this.bookphoto = bookphoto;
    }

    public Book(Integer bid, String bookname, Double bookprice, String bookathor, String booklocation, String bookdate, String bookstate, String bookhobby, String bookhistory) {
        this.bid = bid;
        this.bookname = bookname;
        this.bookprice = bookprice;
        this.bookathor = bookathor;
        this.booklocation = booklocation;
        this.bookdate = bookdate;
        this.bookstate = bookstate;
        this.bookhobby = bookhobby;
        this.bookhistory = bookhistory;
    }

    public Book(String bookname, Double bookprice, String bookathor, String booklocation, String bookdate, String bookstate, String bookhobby, String bookhistory) {
        this.bookname = bookname;
        this.bookprice = bookprice;
        this.bookathor = bookathor;
        this.booklocation = booklocation;
        this.bookdate = bookdate;
        this.bookstate = bookstate;
        this.bookhobby = bookhobby;
        this.bookhistory = bookhistory;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bookname='" + bookname + '\'' +
                ", bookprice=" + bookprice +
                ", bookathor='" + bookathor + '\'' +
                ", booklocation='" + booklocation + '\'' +
                ", bookdate='" + bookdate + '\'' +
                ", bookstate='" + bookstate + '\'' +
                ", bookhobby='" + bookhobby + '\'' +
                ", bookhistory='" + bookhistory + '\'' +
                ", bookphoto='" + bookphoto + '\'' +
                '}';
    }

    public String getBookphoto() {
        return bookphoto;
    }

    public void setBookphoto(String bookphoto) {
        this.bookphoto = bookphoto;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Double getBookprice() {
        return bookprice;
    }

    public void setBookprice(Double bookprice) {
        this.bookprice = bookprice;
    }

    public String getBookathor() {
        return bookathor;
    }

    public void setBookathor(String bookathor) {
        this.bookathor = bookathor;
    }

    public String getBooklocation() {
        return booklocation;
    }

    public void setBooklocation(String booklocation) {
        this.booklocation = booklocation;
    }

    public String getBookdate() {
        return bookdate;
    }

    public void setBookdate(String bookdate) {
        this.bookdate = bookdate;
    }

    public String getBookstate() {
        return bookstate;
    }

    public void setBookstate(String bookstate) {
        this.bookstate = bookstate;
    }

    public String getBookhobby() {
        return bookhobby;
    }

    public void setBookhobby(String bookhobby) {
        this.bookhobby = bookhobby;
    }

    public String getBookhistory() {
        return bookhistory;
    }

    public void setBookhistory(String bookhistory) {
        this.bookhistory = bookhistory;
    }
}
