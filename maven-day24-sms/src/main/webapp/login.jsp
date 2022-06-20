<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>扁平化响应式登录界面设计</title>

    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <!-- 移动设备优先 -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <style type="text/css">
        body{
            width:100%;
            height:100%;
            background:url('image/31.jpg');
            background-repeat: no-repeat;
            background-size:100% 100%;
            background-attachment:fixed;
        }
        .middle {
            margin-top: 110px;
            margin-bottom: 110px;
            padding: 100px 50px 50px 50px;
            background-color: white;
            border-radius: 15px;
            box-shadow: 10px 10px 5px rgb(0,0,0,0.1);

        }
        .login {
            margin-left: 20px;
        }
        .font2 {
            font-size: 0.6em;
        }
        .btn {
            border-radius: 28px;
        }

    </style>
    <script src="js/jquery-3.6.0.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<%
    //5.获取cookie
    Cookie[] cookies = request.getCookies();
    if (cookies!=null) {
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            if ("username".equals(cookie.getName())) {
                session.setAttribute("username",cookie.getValue());
            }
            if ("password".equals(cookie.getName())) {
                session.setAttribute("password",cookie.getValue());
            }
        }
    }
%>
<div class="container">
    <div class="middle mx-auto h-75 w-75">
        <div class="row">
            <div class="col col-12 col-md-6">
                <img class="rounded img-fluid" src="image/1.gif" alt="web开发">
            </div>
            <div class="col col-12 col-md-6">
                <div class="login">
                    <h5 class="font-weight-bold">图书管理系统登录</h5>
                    <p class="font-weight-light font2">管理系统平台</p>

                    <form action="user">
                        <input type="hidden" name="method" value="login"/>
                        <div class="form-group">

                            <input type="text" class="form-control" id="name" name="username" value="${sessionScope.username}" placeholder="用户名">
                        </div>

                        <div class="form-group">
                            <label for="pwd" class="sr-only">Password:</label>
                            <input type="password" class="form-control" id="pwd" value="${sessionScope.password}" name="password" placeholder="密码">
                        </div>

                        <img id="img" src="code" />
                        <span style="color: red;">${error}</span>
                        <div class="form-group">
                            <input type="text" class="form-control" id="code" name="code" placeholder="验证码">
                        </div>
                        <div class="xuan custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" value="cookieFlag" id="customCheck" name="cookieFlag">
                            <label class="custom-control-label font-weight-light small" for="customCheck">记住用户名</label>
                        </div>

                        <br>
                        <input type="submit"  class="btn btn-primary btn-block w-75 mx-auto" value="登录"/>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $("#img").click(function(){
        $("#img").prop("src","code?name="+new Date().getMilliseconds());
    });
</script>
</body>
</html>
