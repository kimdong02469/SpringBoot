<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${user.isEdit ? 'Edit User' : 'Add New User'}</title>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h2>${user.isEdit ? 'Edit User' : 'Add New User'}</h2>
		</div>
		<div class="card-body">
			<form action="/admin/users/saveOrUpdate" method="post">
				<input type="hidden" name="userId" value="${user.userId}" /> <input
					type="hidden" name="isEdit" value="${user.isEdit}" />

				<div class="form-group mb-3">
					<label>Username:</label> <input type="text" class="form-control"
						name="username" value="${user.username}" required />
				</div>

				<div class="form-group mb-3">
					<label>Full Name:</label> <input type="text" class="form-control"
						name="fullname" value="${user.fullname}" />
				</div>

				<div class="form-group mb-3">
					<label>Email:</label> <input type="email" class="form-control"
						name="email" value="${user.email}" />
				</div>

				<div class="form-group mb-3">
					<label>Password:</label> <input type="password"
						class="form-control" name="password" value="${user.password}"
						required />
				</div>

				<div class="form-group mb-3">
					<label>Status:</label> <select class="form-control" name="status">
						<option value="1" ${user.status == 1 ? 'selected' : ''}>Hoạt
							động</option>
						<option value="0" ${user.status == 0 ? 'selected' : ''}>Khóa</option>
					</select>
				</div>

				<button type="submit" class="btn btn-primary">${user.isEdit ? 'Update' : 'Save'}</button>
				<a href="/admin/users" class="btn btn-secondary">Cancel</a>
			</form>
		</div>
	</div>
</body>
</html>