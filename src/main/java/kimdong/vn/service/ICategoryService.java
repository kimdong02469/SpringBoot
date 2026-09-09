package kimdong.vn.service;

import java.util.List;
import java.util.Optional;
import kimdong.vn.entity.Category;

public interface ICategoryService {
	List<Category> findAll();

	Optional<Category> findById(long id);

	Category save(Category category);

	void deleteById(long id);
	
	List<Category> findByCategorynameContaining(String name);
}