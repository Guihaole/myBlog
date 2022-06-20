<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图片下载</title>
</head>
<body>
<c:forEach items="${files}" var="file">
    <img src="http://localhost:6060/photo/${file}" width="200px" height="200px"/>
    <a href="download?filename=${file}">下载</a>
</c:forEach>
<img src="http://localhost:6060/image/4.gif" width="200px" height="200px"/>
<a href="download2?filename=4.gif">下载</a>
<img src="http://localhost:6060/image/1.webp" width="200px" height="200px"/>
<a href="download2?filename=1.webp">下载</a>
<img src="http://localhost:6060/image/2.webp" width="200px" height="200px"/>
<a href="download2?filename=2.webp">下载</a>
<img src="http://localhost:6060/image/3.webp" width="200px" height="200px"/>
<a href="download2?filename=3.webp">下载</a>

</body>
</html>
