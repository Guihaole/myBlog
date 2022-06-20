<%@ page import="com.edu.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrap-theme.min.css"/>
<script src="js/bootstrap.min.js"></script>
<style>
    div{
        display: inline;
    }
    .img{
        width: 50px;
        height: 50px;
        line-height: 50px;
        border-radius: 50%;
        margin-left: 70px;
    }
    span {
        font-size: 50px;
        margin-top: 100px;
        text-align: center;
        text-decoration: none;
        margin-left: 500px;
        color: darkorange;
    }
</style>
<style>
    .xue{
        background-image: url(image/th.jpg);
        background-repeat: repeat;
    }
</style>
<body class="xue">

<div class="img" id="img">
    <img src="image/${user.photo}" width="30px" height="30px"/>
</div>
<div class="username" id="username">${user.username}</div>
<div class="logout">
    <button class="success" class="btn btn-warning"><a href="user?method=loginOut" target="_top">注销</a></button>
</div>
<div class="title">
    <span>
        图书管理系统
    </span>
</div>

</body>

</html>
