<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<!-- Thêm Bootstrap để nút bấm hiển thị đẹp mắt -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="container text-center mt-5">
	<h1 class="mb-4">Quản Trị Hệ Thống</h1>
	<p class="text-muted mb-4">Vui lòng chọn chức năng quản lý bên
		dưới:</p>

	<div class="d-flex justify-content-center gap-3">
		<a href="/admin/categories" class="btn btn-primary btn-lg px-4">Quản
			lý Categories</a> <a href="/admin/users"
			class="btn btn-success btn-lg px-4">Quản lý Users</a>
	</div>
</body>
</html>