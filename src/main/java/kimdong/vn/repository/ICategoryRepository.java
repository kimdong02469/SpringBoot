package kimdong.vn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kimdong.vn.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
	
	// Tìm kiếm danh mục theo tên (có thể chứa ký tự gần đúng)
    List<Category> findByCategorynameContaining(String name);
}
