<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    form {
        display: inline;
    }
</style>
<body>
    <form action="paramsDate" method="post">
        name car：<input type="text" name="name" placeholder="请输入车名"/> <br>
        color car：<input type="text" name="color" placeholder="请输入车颜色"/> <br>
        date car：<input type="date" name="date"/> <br>
        <input type="submit" value="提交">
    </form>
    <form action="type" method="post">
        用户名：<input type="text" name="username" placeholder="请输入用户名"/> <br>
        密码：<input type="text" name="password" placeholder="请输入密码"/> <br>
        <input type="submit" value="登录">
    </form>
    <%--    参数类型练习--%>
    <%--    同名策略--%>
    <form action="paramsEquals" method="post">
        用户名：<input type="text" name="username" placeholder="请输入用户名"/> <br>
        密码：<input type="text" name="password" placeholder="请输入密码"/> <br>
        <input type="submit" value="登录">
    </form>
    <%--    对象同属性策略--%>
    <form action="paramsObject" method="post">
        用户名：<input type="text" name="username" placeholder="请输入用户名"/> <br>
        密码：<input type="text" name="password" placeholder="请输入密码"/> <br>
        地址：<input type="text" name="address" placeholder="请输入地址"/> <br>
        <input type="submit" value="注册">
    </form>
    <%--    复杂映射--%>
    <form action="paramsObjects" method="post">
        用户名：<input type="text" name="username" placeholder="请输入用户名"/> <br>
        密码：<input type="text" name="password" placeholder="请输入密码"/> <br>
        地址：<input type="text" name="address" placeholder="请输入地址"/> <br>
        name car：<input type="text" name="name" placeholder="请输入车名"/> <br>
        color car：<input type="text" name="color" placeholder="请输入车颜色"/> <br>
        <input type="submit" value="注册">
    </form>
    <form action="paramsStuAndCar" method="post">
        用户名：<input type="text" name="username" placeholder="请输入用户名"/> <br>
        密码：<input type="text" name="password" placeholder="请输入密码"/> <br>
        地址：<input type="text" name="address" placeholder="请输入地址"/> <br>
        name car：<input type="text" name="car.name" placeholder="请输入车名"/> <br>
        color car：<input type="text" name="car.color" placeholder="请输入车颜色"/> <br>
        <input type="submit" value="注册">
    </form>
    <form action="paramsStuAndCarList" method="post">
        用户名：<input type="text" name="username" placeholder="请输入用户名"/> <br>
        密码：<input type="text" name="password" placeholder="请输入密码"/> <br>
        地址：<input type="text" name="address" placeholder="请输入地址"/> <br>
        name car：<input type="text" name="carList[0].name" placeholder="请输入车名"/> <br>
        color car：<input type="text" name="carList[0].color" placeholder="请输入车颜色"/> <br>
        name car：<input type="text" name="carList[1].name" placeholder="请输入车名"/> <br>
        color car：<input type="text" name="carList[1].color" placeholder="请输入车颜色"/> <br>
        <input type="submit" value="注册">
    </form>
    <form action="paramsStuAndCarSet" method="post">
        用户名：<input type="text" name="username" placeholder="请输入用户名"/> <br>
        密码：<input type="text" name="password" placeholder="请输入密码"/> <br>
        地址：<input type="text" name="address" placeholder="请输入地址"/> <br>
        name car：<input type="text" name="carSet[0].name" placeholder="请输入车名"/> <br>
        color car：<input type="text" name="carSet[0].color" placeholder="请输入车颜色"/> <br>
        name car：<input type="text" name="carSet[1].name" placeholder="请输入车名"/> <br>
        color car：<input type="text" name="carSet[1].color" placeholder="请输入车颜色"/> <br>
        <input type="submit" value="注册">
    </form>
    <form action="paramsStuAndMap" method="post">
        用户名：<input type="text" name="username" placeholder="请输入用户名"/> <br>
        密码：<input type="text" name="password" placeholder="请输入密码"/> <br>
        地址：<input type="text" name="address" placeholder="请输入地址"/> <br>
        name car：<input type="text" name="map['aa'].name" placeholder="请输入车名"/> <br>
        color car：<input type="text" name="map['aa'].color" placeholder="请输入车颜色"/> <br>
        name car：<input type="text" name="map['bb'].name" placeholder="请输入车名"/> <br>
        color car：<input type="text" name="map['bb'].color" placeholder="请输入车颜色"/> <br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
