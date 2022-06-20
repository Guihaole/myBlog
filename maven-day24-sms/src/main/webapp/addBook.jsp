<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
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
<form action="book" method="post" enctype="multipart/form-data">
    <table class="table" border="1" cellspacing="0" width="300px" height="200px">
        <tr>
            <th colspan="2">添加新图书</th>
        </tr>
        <tr>
            <input type="hidden" name="method" value="addBook"/>
            <td>书名：</td>
            <td><input type="text" name="bookname"></td>
        </tr>
        <tr>
            <td>价格：</td>
            <td><input type="number" name="bookprice"></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="bookathor"></td>
        </tr>
        <tr>
            <td>出版社</td>
            <td><input type="text" name="booklocation"></td>
        </tr>
        <tr>
            <td>出版日期</td>
            <td><input type="date" name="bookdate"></td>
        </tr>
        <tr>
            <td>图书简介</td>
            <td><textarea name="bookstate"></textarea></td>
        </tr>
        <tr>
            <td>头像</td>
            <td>
                <input type="file" name="fileName">
            </td>
        </tr>
        <tr>
            <td>类型</td>
            <td>
                <input type="checkbox" name="bookhobby" value="文学">文学
                <input type="checkbox" name="bookhobby" value="历史">历史
                <input type="checkbox" name="bookhobby" value="职场">职场
            </td>
        </tr>
        <tr>
            <td>学历</td>
            <td>
                <select name="bookhistory">
                    <option value="0">请选择学历</option>
                    <option value="1">专科</option>
                    <option value="2">本科</option>
                    <option value="3">硕士</option>
                    <option value="4">博士</option>
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
