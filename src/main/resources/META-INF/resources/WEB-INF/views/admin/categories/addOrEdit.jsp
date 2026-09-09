<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add or Edit Category</title>
</head>
<body>
	<form action="<c:url value="/admin/categories/saveOrUpdate" />"
		method="POST" enctype="multipart/form-data">
		<div class="card">
			<div class="card-header">
				<h2>${category.isEdit ? 'Edit Category' : 'Add New Category'}</h2>
			</div>
			<div class="card-body">
				<!-- Hidden field để truyền trạng thái isEdit về Controller -->
				<input type="hidden" name="isEdit" value="${category.isEdit}">

				<div class="mb-3">
					<label for="categoryId" class="form-label">Category ID:</label> <input
						type="text" readonly="readonly" class="form-control"
						value="${category.categoryId}" id="categoryId" name="categoryId"
						placeholder="Category Id">
				</div>

				<div class="mb-3">
					<label for="categoryname" class="form-label">Category Name:</label>
					<input type="text" class="form-control"
						value="${category.categoryname}" id="categoryname"
						name="categoryname" placeholder="Category Name"
						required="required">
				</div>

				<div class="mb-3">
					<label for="images" class="form-label">Images:</label> <input
						type="text" class="form-control" value="${category.images}"
						id="images" name="images" placeholder="Image file name">
				</div>

				<div class="mb-3">
					<label for="status" class="form-label">Status:</label> <input
						type="number" class="form-control" value="${category.status}"
						id="status" name="status" placeholder="Status">
				</div>
			</div>
			<div class="card-footer text-muted">
				<a href="<c:url value="/admin/categories/add"/>"
					class="btn btn-secondary">New</a> <a
					href="<c:url value="/admin/categories" />" class="btn btn-success">List
					Categories</a>
				<button class="btn btn-primary" type="submit">
					<c:if test="${category.isEdit}">
						<span>Update</span>
					</c:if>
					<c:if test="${!category.isEdit}">
						<span>Save</span>
					</c:if>
				</button>
			</div>
		</div>
	</form>
</body>
</html>