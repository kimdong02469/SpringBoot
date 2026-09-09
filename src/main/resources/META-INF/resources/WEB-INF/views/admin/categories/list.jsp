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
			<a href="/admin/categories/add" class="btn btn-success mb-2">Add
				New Category</a>
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