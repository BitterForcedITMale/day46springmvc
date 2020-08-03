<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2020/7/27
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>一,springmvc传统方式文件上传</h1>
  <form action="springmvc/fileUpload02" method="post" enctype="multipart/form-data">
    图片：<input type="file" name="upload"><br/>
    图片描述:<input type="text" name="pdesc"><br>
    <input type="submit" value="上传"/>
  </form>
  <h1>二,springmvc 跨服务器方式的文件上传</h1>
  <form action="springmvc/fileUpload03" method="post" enctype="multipart/form-data">
    图片：<input type="file" name="upload"><br/>
    图片描述:<input type="text" name="pdesc"><br>
    <input type="submit" value="上传"/>
  </form>
  <a href="user/queryUser">错误信息展示</a>
  </body>
</html>
