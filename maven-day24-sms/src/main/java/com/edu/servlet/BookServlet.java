package com.edu.servlet;

import cn.hutool.json.JSONUtil;
import com.edu.bean.Book;
import com.edu.service.BookService;
import com.edu.service.impl.BookServiceImpl;
import com.edu.util.BaseServlet;
import com.edu.util.PageUtils;
import com.edu.util.UploadFileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet("/book")
@MultipartConfig
public class BookServlet extends BaseServlet {
    private BookService bookService=new BookServiceImpl();

    /**
     * 根据多选删除
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void deleteAllBookChecked(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] bids = req.getParameterValues("select");
        int[] bidInts=new int[bids.length];
        for (int i = 0; i < bids.length; i++) {
            bidInts[i]=Integer.parseInt(bids[i]);
        }
        //处理数据
        int res=bookService.deleteBookAll(bidInts);
        //响应
        PrintWriter pw = resp.getWriter();
        if (res>0) {
            resp.sendRedirect("book?method=selectBookAll");
        }else {
            pw.write("批量删除失败");
        }
    }
    /**
     * 根据id删除书本
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void deleteBookById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("id");
        int bookid = Integer.parseInt(bid);
        //处理数据
        String photo = req.getParameter("photo");
        File file = new File("E:\\photo\\"+photo);
        if (file.exists()) {
            file.delete();
        }
        int res=bookService.deleteBookByBid(bookid);
        PrintWriter printWriter = resp.getWriter();
        //响应
        if (res>0) {
            resp.sendRedirect("book?method=selectBookAll");
        }else {
            printWriter.write("删除失败");
        }
    }
    /**
     * 修改后进行提交
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void updateBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收参
        Map<String, String[]> parameterMap = req.getParameterMap();
        String bid = parameterMap.get("bid")[0];
        String bookName = parameterMap.get("bookname")[0];
        String bookPrice = parameterMap.get("bookprice")[0];
        String bookAthor = parameterMap.get("bookathor")[0];
        String bookLocation = parameterMap.get("booklocation")[0];
        String bookDate = parameterMap.get("bookdate")[0];
        String bookState = parameterMap.get("bookstate")[0];
        //复选框
        String[] bookhobbies = parameterMap.get("bookhobby");
        //拼接
        StringBuilder resStr = new StringBuilder();
        for (String bookhobby : bookhobbies) {
            resStr.append(bookhobby+"#");
        }
        String bookhobby=resStr.substring(0,resStr.length()-1);
        String bookhistory = parameterMap.get("bookhistory")[0];

        //处理修改头像
        Part part = req.getPart("newphoto");
        String photo="";
        if (part.getSize()>0) {
            //重新上传并删除原来的图片
            String oldphoto = req.getParameter("oldphoto");
            File file = new File("E:\\photo\\"+oldphoto);
            if (file.exists()) {
                file.delete();
            }
            photo = UploadFileUtils.uploadFile(part);
        }else {
            //没有修改图片
            photo=req.getParameter("oldphoto");
        }
        //处理数据
        Book book = new Book(Integer.parseInt(bid),bookName, Double.parseDouble(bookPrice), bookAthor, bookLocation, bookDate, bookState,bookhobby,bookhistory,photo);
        int res=bookService.updateBookById(book);
        PrintWriter pw = resp.getWriter();
        if (res>0) {
            resp.sendRedirect("book?method=selectBookAll");
        }else {
            pw.write("修改失败");
        }
    }

    /**
     * 查询单个书回显数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void selectByIdBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        String bid = req.getParameter("bid");
        int bookId = Integer.parseInt(bid);
        Book book=bookService.selectBookById(bookId);
        //响应
        String str = JSONUtil.toJsonStr(book);
        resp.getWriter().write(str);
    }
    /**
     * 书的详情
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void detailBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");
        int bookId = Integer.parseInt(bid);
        String flag = req.getParameter("flag");
        Book book=bookService.selectBookById(bookId);
        //响应
        req.setAttribute("book",book);
        if("detailbook".equals(flag)){
            req.getRequestDispatcher("detail.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("update.jsp").forward(req,resp);
        }

    }
    /**
     * 查询所有
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void selectBookAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收数据
        String bookname = req.getParameter("bookname");
        String bookhistory = req.getParameter("bookhistory");
        //分页
        String pageSizeReq=req.getParameter("pageSize");
        if (pageSizeReq==null||"".equals(pageSizeReq)) {
            pageSizeReq="3";
        }
        int pageSize=Integer.parseInt(pageSizeReq);
        //总条数
        int totalCount=bookService.bookTotalCount(bookname,bookhistory);
        String currentPage=req.getParameter("currentPage");
        PageUtils pageUtils = new PageUtils(pageSize,totalCount,currentPage);
        //查询所有
        List<Book> bookList=bookService.selectBookList(bookname,bookhistory,pageUtils.getStartIndex(),pageUtils.getPageSize());
        //响应数据
        if (bookList!=null) {
            req.setAttribute("bookList",bookList);
            req.setAttribute("bookname",bookname);
            req.setAttribute("bookhistory",bookhistory);
            req.setAttribute("pageUtils",pageUtils);
            req.getRequestDispatcher("select.jsp").forward(req,resp);
        }
    }

    /**
     * 添加图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收参
        Map<String, String[]> parameterMap = req.getParameterMap();
        String bookName = parameterMap.get("bookname")[0];
        String bookPrice = parameterMap.get("bookprice")[0];
        String bookAthor = parameterMap.get("bookathor")[0];
        String bookLocation = parameterMap.get("booklocation")[0];
        String bookDate = parameterMap.get("bookdate")[0];
        String bookState = parameterMap.get("bookstate")[0];
        //复选框
        String[] bookhobbies = parameterMap.get("bookhobby");
        //拼接
        StringBuilder resStr = new StringBuilder();
        for (String bookhobby : bookhobbies) {
            resStr.append(bookhobby+"#");
        }
        String bookhobby=resStr.substring(0,resStr.length()-1);
        String bookhistory = parameterMap.get("bookhistory")[0];

        //头像上传操作
        Part part = req.getPart("fileName");
        String bookphoto = UploadFileUtils.uploadFile(part);
        //处理数据
        Book book = new Book(bookName, Double.parseDouble(bookPrice), bookAthor, bookLocation, bookDate, bookState,bookhobby,bookhistory,bookphoto);
        int res=bookService.addBook(book);
        PrintWriter pw = resp.getWriter();
        if (res>0) {
            //添加成功
            resp.sendRedirect("book?method=selectBookAll");
        }else {
            pw.write("添加失败");
        }
    }
}
