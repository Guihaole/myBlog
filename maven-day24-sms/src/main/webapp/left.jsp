<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    a {
        font-family: 楷体;
        display: block;
        font-size: 30px;
        margin-left: 50px;
        margin-top: 50px;
    }
</style>
<style>
    .xue{
        background-image: url(image/th.jpg);
        background-repeat: repeat;
    }
</style>
<body class="xue">
<a href="book?method=selectBookAll" target="main">查询图书</a>
<a href="addBook.jsp" target="main">添加图书</a>
</body>
</html>
