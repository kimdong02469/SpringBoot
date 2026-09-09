package kimdong.vn.model;

public class CategoryModel {
	private Long categoryId;
	private String categoryname;
	private String images;
	private int status;
	private Boolean isEdit = false;

	// Constructor mặc định
	public CategoryModel() {
	}

	// Constructor đầy đủ
	public CategoryModel(Long categoryId, String categoryname, String images, int status, Boolean isEdit) {
		this.categoryId = categoryId;
		this.categoryname = categoryname;
		this.images = images;
		this.status = status;
		this.isEdit = isEdit;
	}

	// Getter và Setter thủ công cho từng thuộc tính
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

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
}