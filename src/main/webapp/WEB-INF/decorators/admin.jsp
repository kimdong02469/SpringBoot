<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang Web Layout</title>
</head>
<body>
    <!-- Header của web -->
    <h2>Header của web</h2>
    <hr/>

    <!-- Nội dung của web (Sitemesh sẽ tự động nhét nội dung trang con vào đây) -->
    <sitemesh:write property="body" />

    <hr/>
    <!-- Footer của web -->
    <h2>Footer của web</h2>
</body>
</html>