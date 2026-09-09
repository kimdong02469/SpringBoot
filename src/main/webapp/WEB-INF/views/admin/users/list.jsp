<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Users</title>
</head>
<body>
	<c:if test="${message != null}">
		<div class="alert alert-primary" role="alert">
			<i>${message}</i>
		</div>
	</c:if>

	<div class="card">
		<div class="card-header">
			<h2>List Users</h2>
			<div class="d-flex justify-content-between align-items-center mb-3">
				<form action="/admin/users" method="get" class="form-inline">
					<div class="input-group">
						<input type="text" class="form-control" name="keyword"
							value="${keyword}" placeholder="Search username or fullname...">
						<button class="btn btn-outline-primary" type="submit">Search</button>
						<c:if test="${not empty keyword}">
							<a href="/admin/users" class="btn btn-outline-secondary ms-2">Reset</a>
						</c:if>
					</div>
				</form>
				<a href="/admin/users/add" class="btn btn-success">Add New User</a>
			</div>
		</div>
		<div class="card-body">
			<table class="table table-striped table-responsive">
				<thead class="thead-inverse">
					<tr>
						<th>User ID</th>
						<th>Username</th>
						<th>Full Name</th>
						<th>Email</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="u">
						<tr>
							<td>${u.userId}</td>
							<td>${u.username}</td>
							<td>${u.fullname}</td>
							<td>${u.email}</td>
							<td>${u.status}</td>
							<td><a href="/admin/users/edit/${u.userId}"
								class="btn btn-outline-warning btn-sm">Edit</a> <a
								href="/admin/users/delete/${u.userId}"
								class="btn btn-outline-danger btn-sm"
								onclick="return confirm('Are you sure to delete this user?');">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>