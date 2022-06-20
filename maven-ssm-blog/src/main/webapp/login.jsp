<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>css3动态背景登录框代码</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script src="js/jquery.min.js?v=2.1.4"></script>
	<%--提示消息插件--%>
    <script src="js/Dream-Msg/lib/dream-msg.min.js"></script>
</head>
<script>
    $(function(){
        $("#login-button").click(function () {
            var uname=$("#uname").val();
            var upass=$("#upass").val();
            if(uname!=""&&upass!=""){
                $.ajax({
                    url:"user/login",
                    data:{
                        "username":uname,
                        "password":upass
                    },
                    type:"get",
                    dataType:"json",
                    success:function (res) {
                        Dreamer.success(res.msg);
                        if(res.status=="200"){
                            window.location.href="index.jsp";
                        }
                    },
                    error:function (error) {
                        Dreamer.error("程序出错啦");
                    }
                });
            }else {
                Dreamer.error("用户名或者密码不能为null");
            }
        });
    });
</script>
<body>
<div class="wrapper">

    <div class="container">
        <h1>博客后台管理系统</h1>
        <form id="userForm" class="form" action="#">
            <span id="error" style="color: red"></span>
            <input type="text" name="uname" id="uname" value="root" placeholder="Username">
            <input type="password" name="upass" id="upass" value="123" placeholder="Password"><br>
            <input type="button"  value="提交"  id="login-button"/>
        </form>
    </div>
    <ul class="bg-bubbles">
        <li></li>
        <li></li>
    </ul>
</div>
</body>
</html>
