package kimdong.vn.model;

public class UserModel {
	private Long userId;
	private String username;
	private String fullname;
	private String email;
	private String password;
	private int status;
	private Boolean isEdit = false;

	public UserModel() {
	}

	public UserModel(Long userId, String username, String fullname, String email, String password, int status,
			Boolean isEdit) {
		this.userId = userId;
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.status = status;
		this.isEdit = isEdit;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
}