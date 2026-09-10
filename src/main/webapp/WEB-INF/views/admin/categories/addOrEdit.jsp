<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Categories</title>
</head>
<body>
	<c:if test="${message != null}">
		<div class="alert alert-primary" role="alert">
			<i>${message}</i>
		</div>
	</c:if>

	<div class="card">
		<div class="card-header">
			<h2>List Categories</h2>
			<div class="d-flex justify-content-between align-items-center mb-3">
				<form action="/admin/categories" method="get" class="form-inline">
					<div class="input-group">
						<input type="text" class="form-control" name="keyword"
							value="${keyword}" placeholder="Search category name...">
						<button class="btn btn-outline-primary" type="submit">Search</button>
						<c:if test="${not empty keyword}">
							<a href="/admin/categories"
								class="btn btn-outline-secondary ms-2">Reset</a>
						</c:if>
					</div>
				</form>
				<a href="/admin/categories/add" class="btn btn-success">Add New
					Category</a>
			</div>
		</div>
		<div class="card-body">
			<table class="table table-striped table-responsive">
				<thead class="thead-inverse">
					<tr>
						<th>Category ID</th>
						<th>Category Name</th>
						<th>Images</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categories}" var="category">
						<tr>
							<td scope="row">${category.categoryId}</td>
							<td>${category.categoryname}</td>
							<td>${category.images}</td>
							<td>${category.status}</td>
							<td><a href="/admin/categories/edit/${category.categoryId}"
								class="btn btn-outline-warning">Edit</a> <a
								href="/admin/categories/delete/${category.categoryId}"
								class="btn btn-outline-danger"
								onclick="return confirm('Are you sure to delete this category?');">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>