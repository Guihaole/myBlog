<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script src="js/jquery-3.6.0.js"></script>
<style>
    .table {
        margin-left: 200px;
        margin-top: 20px;
        font-family: 楷体;
    }
</style>
<style>
    .xue{
        background-image: url(image/th.jpg);
        background-repeat: repeat;
    }
</style>
<body class="xue">
<form id="form" action="book?method=updateBook" method="post" enctype="multipart/form-data">
    <table class="table" border="1" cellspacing="0" width="300px" height="200px">
        <tr>
            <th colspan="2">修改新图书</th>
        </tr>
        <tr>
            <td>书名：</td>
            <td>
                <input type="hidden" name="bid" value="${book.bid}">
                <input type="text" name="bookname" value="${book.bookname}">
            </td>
        </tr>
        <tr>
            <td>价格：</td>
            <td><input type="number" name="bookprice" value="${book.bookprice}"></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="bookathor" value="${book.bookathor}"></td>
        </tr>
        <tr>
            <td>出版社</td>
            <td><input type="text" name="booklocation" value="${book.booklocation}"></td>
        </tr>
        <tr>
            <td>出版日期</td>
            <td><input type="date" name="bookdate" value="${book.bookdate}"></td>
        </tr>
        <tr>
            <td>头像</td>
            <td>
                <img src="/photo/${book.bookphoto}" width="40px" height="30px"/>
                <input type="hidden" name="oldphoto" value="${book.bookphoto}"/>
                <input type="file" name="newphoto"/>
            </td>
        </tr>
        <tr>
            <td>图书简介</td>
            <td><textarea name="bookstate" value="${book.bookstate}">${book.bookstate}</textarea></td>
        </tr>
        <tr>
            <td>类型</td>
            <td>
                <input type="checkbox" <c:if test="${fn:contains(book.bookhobby,'文学')}">checked</c:if> name="bookhobby" value="文学">文学
                <input type="checkbox" <c:if test="${fn:contains(book.bookhobby,'历史')}">checked</c:if> name="bookhobby" value="历史">历史
                <input type="checkbox" <c:if test="${fn:contains(book.bookhobby,'职场')}">checked</c:if> name="bookhobby" value="职场">职场
            </td>
        </tr>
        <tr>
            <td>学历</td>
            <td>
                <select name="bookhistory">
                    <option value="0">请选择学历</option>
                    <option value="1" ${'1' eq book.bookhistory ? 'selected':''}>专科</option>
                    <option value="2" ${'2' eq book.bookhistory ? 'selected':''}>本科</option>
                    <option value="3" ${'3' eq book.bookhistory ? 'selected':''}>硕士</option>
                    <option value="4" ${'4' eq book.bookhistory ? 'selected':''}>博士</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
                <input type="reset" value="取消">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
