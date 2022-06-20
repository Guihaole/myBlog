<%@ page import="com.edu.bean.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrap-theme.min.css"/>
<script src="js/jquery-3.6.0.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    //全选  全不选
    $(function () {
        $("#all").click(function () {
            //全选
            $(".checkSimgle").prop("checked",$("#all").prop("checked"));
        });
       $(".checkSimgle").click(function () {
           //全不选
           var l1=$(".checkSimgle").length;
           var l2=$(".checkSimgle:checked").length
           if(l1==l2){
               $("#all").prop("checked",true);
           }else {
               $("#all").prop("checked",false);
           }
       });
       //清空
        $("#clear").click(function () {
            $("#bookname").prop("value","");
            $("#bookhistory").prop("selected",true);
        });
        //第几页跳转
        $("#totalPage").change(function () {
            var page=$("#totalPage").prop("value")
            window.location.href="book?method=selectBookAll&currentPage="+page+"&bookname=${bookname}&bookhistory=${bookhistory}&pageSize=${pageUtils.pageSize}";
        });
        //选择页容量大小
        $("#totalSize").change(function () {
            var size=$("#totalSize").prop("value")
            window.location.href="book?method=selectBookAll&pageSize="+size+"&bookname=${bookname}&bookhistory=${bookhistory}";
        });
    });
</script>
<style>
    #form{
        margin-left: 300px;
        margin-top: 20px;
    }
    .selectBook{
        width: 100px;
        height: 35px;
    }
</style>
<style>
    .xue{
        background-image: url(image/th.jpg);
        background-repeat: repeat;
    }
</style>
<body class="xue">
<form id="form" class="form-inline" action="book">
    <input type="hidden" name="method" value="selectBookAll"/>
    <div class="form-group">
        <label for="exampleInputName2">Name</label>
        <input type="text" name="bookname" value="${bookname}" class="form-control" id="exampleInputName2" placeholder="请输入书名">
    </div>
<%--    <input id="bookname" type="text" name="bookname" value="${bookname}"/>--%>
    <select class="selectBook" name="bookhistory">
        <option value="0" id="bookhistory">请选择学历</option>
        <option value="1" ${'1' eq bookhistory?"selected":""}>专科</option>
        <option value="2" ${'2' eq bookhistory?"selected":""}>本科</option>
        <option value="3" ${'3' eq bookhistory?"selected":""}>硕士</option>
        <option value="4" ${'4' eq bookhistory?"selected":""}>博士</option>
    </select>
    <input type="submit" class="btn btn-danger" value="查询"/>
    <input type="button" class="btn btn-danger" id="clear" value="清空"/>
</form>
<form action="book" class="form-inline">
<table class="table table-condensed" border="1px" width="700px" height="200px" cellspacing="0">
    <tr class="warning">
        <input type="hidden" name="method" value="deleteAllBookChecked"/>
        <th><input id="all" type="checkbox"/>全选</th>
        <th>书名</th>
        <th>价格</th>
        <th>作者</th>
        <th>出版社</th>
        <th>出版日期</th>
        <th>描述</th>
        <th>头像</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${bookList}" var="book" varStatus="vs">
    <tr class="success">
    <td><input class="checkSimgle" type="checkbox" name="select" value="${book.bid}"/></td>
    <td>${book.bookname}</td>
    <td>${book.bookprice}</td>
    <td>${book.bookathor}</td>
    <td>${book.booklocation}</td>
    <td>${book.bookdate}</td>
    <td>${book.bookstate}</td>
    <td>
        <img src="/photo/${book.bookphoto}" width="40px" height="40px">
    </td>
    <td>
        <button class="success" class="btn btn-warning" ><a href="book?method=detailBook&bid=${book.bid}&flag=detailbook">详情</a></button>
        <button class="success" class="btn btn-success" ><a href="book?method=detailBook&bid=${book.bid}&flag=updatebook">修改</a></button>
        <button class="success" class="btn btn-danger" ><a href="book?method=deleteBookById&id=${book.bid}&photo=${book.bookphoto}">删除</a></button>
    </td>
    </tr>
    </c:forEach>



    <%--分页功能实现    --%>
    <tr>
        &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
        &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
        <a href="book?method=selectBookAll&currentPage=1&bookname=${bookname}&bookhistory=${bookhistory}&pageSize=${pageUtils.pageSize}">首页</a>&nbsp; &nbsp;
        <%--        上一页--%>
        <c:if test="${pageUtils.currentPage==1}">
            上一页&nbsp; &nbsp;
        </c:if>
        <c:if test="${pageUtils.currentPage>1}">
            <a href="book?method=selectBookAll&currentPage=${pageUtils.currentPage-1}&bookname=${bookname}&bookhistory=${bookhistory}&pageSize=${pageUtils.pageSize}">上一页</a>&nbsp; &nbsp;
        </c:if>
        <%--        下一页--%>
        <c:if test="${pageUtils.currentPage==pageUtils.totalPages}">
            下一页&nbsp; &nbsp;
        </c:if>
        <c:if test="${pageUtils.currentPage<pageUtils.totalPages}">
            <a href="book?method=selectBookAll&currentPage=${pageUtils.currentPage+1}&bookname=${bookname}&bookhistory=${bookhistory}&pageSize=${pageUtils.pageSize}">下一页</a>&nbsp; &nbsp;
        </c:if>
        <a href="book?method=selectBookAll&currentPage=${pageUtils.totalPages}&bookname=${bookname}&bookhistory=${bookhistory}&pageSize=${pageUtils.pageSize}">尾页</a>&nbsp; &nbsp;
        当前页号/总页数：${pageUtils.currentPage}/${pageUtils.totalPages}&nbsp; &nbsp;
        总条数：${pageUtils.totalCount}&nbsp; &nbsp;&nbsp; &nbsp;
        跳转到第&nbsp;
        <select id="totalPage">
            <c:forEach var="i" begin="1" end="${pageUtils.totalPages}" step="1">
                <option ${pageUtils.currentPage==i?"selected":""} value="${i}">${i}</option>
            </c:forEach>
        </select>
        &nbsp;页&nbsp; &nbsp;
        每页显示&nbsp;
        <select id="totalSize">
            <c:forEach var="i" begin="1" end="${pageUtils.totalCount}" step="3">
                <option ${pageUtils.pageSize==i?"selected":""} value="${i}">${i}</option>
            </c:forEach>
        </select>
        &nbsp;条&nbsp;&nbsp;&nbsp;&nbsp;
    </tr>
    <input type="submit" class="btn btn-danger" value="批量删除"/>
</table>
</form>
</body>
</html>
