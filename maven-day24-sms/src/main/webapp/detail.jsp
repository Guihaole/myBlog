<%@ page import="com.edu.bean.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrap-theme.min.css"/>
<script src="js/bootstrap.min.js"></script>
<style>
    .xue{
        background-image: url(image/th.jpg);
        background-repeat: repeat;
    }
</style>
<body class="xue">
<table class="table table-condensed" cellspacing="0" border="1">
    <tr class="warning">
        <th>书名</th>
        <td>${book.bookname}</td>
    </tr>
    <tr class="success">
        <th>价格</th>
        <td>${book.bookprice}</td>
    </tr>
    <tr class="info">
        <th>作者</th>
        <td>${book.bookathor}</td>
    </tr>
    <tr class="danger">
        <th>出版社</th>
        <td>${book.booklocation}</td>
    </tr>
    <tr  class="active">
        <th>出版日期</th>
        <td>${book.bookdate}</td>
    </tr>
    <tr class="info">
        <th>描述</th>
        <td>${book.bookstate}</td>
    </tr>
    <tr class="danger">
        <th>头像</th>
        <td>
            <img src="/photo/${book.bookphoto}" width="40px" height="30px"/>
        </td>
    </tr>
    <tr>
        <th>类型</th>
        <td>${book.bookhobby}</td>
    </tr>
    <tr>
        <th>历史</th>
        <td>
           <c:choose>
               <c:when test="${'1' eq book.bookhistory}">专科</c:when>
               <c:when test="${'2' eq book.bookhistory}">本科</c:when>
               <c:when test="${'3' eq book.bookhistory}">硕士</c:when>
               <c:when test="${'4' eq book.bookhistory}">博士</c:when>
               <c:otherwise>无</c:otherwise>
           </c:choose>
        </td>
    </tr>
</table>
</body>
</html>
