<%--
  Created by IntelliJ IDEA.
  User: liwei
  Date: 2021/7/6
  Time: 9:52 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <hr
        >
    龙鸣颜开
    <form action="http://localhost:8080/book/uploadServlet" method="post" enctype="multipart/form-data">
        请输入用户名：<input type="text" name="username" value="默认值"><br>
        选择合适的头像：<input type="file" name="photo"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
