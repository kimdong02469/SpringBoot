package kimdong.vn.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryId")
	private Long categoryId;

	@Column(name = "categoryname", columnDefinition = "NVARCHAR(255) NULL")
	private String categoryname;

	@Column(name = "images", columnDefinition = "NVARCHAR(255) NULL")
	private String images;

	@Column(name = "status")
	private int status;

	public Category() {
	}

	public Category(Long categoryId, String categoryname, String images, int status) {
		this.categoryId = categoryId;
		this.categoryname = categoryname;
		this.images = images;
		this.status = status;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}