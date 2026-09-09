package kimdong.vn.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long userId;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "fullname", columnDefinition = "NVARCHAR(255) NULL")
	private String fullname;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private int status;

	public User() {
	}

	public User(Long userId, String username, String fullname, String email, String password, int status) {
		this.userId = userId;
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.status = status;
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
}