<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<sitemesh:write property="head" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
		<div class="container">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>
			<a class="nav-link text-white"
				href="${pageContext.request.contextPath}/admin/categories">Categories</a>
		</div>
	</nav>
	<div class="container">
		<sitemesh:write property="body" />
	</div>
</body>
</html>
