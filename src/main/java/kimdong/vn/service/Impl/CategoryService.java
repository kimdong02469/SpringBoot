package kimdong.vn.service.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import kimdong.vn.entity.Category;
import kimdong.vn.repository.ICategoryRepository;
import kimdong.vn.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	private final ICategoryRepository categoryRepository;

	public CategoryService(ICategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findById(long id) {
		return categoryRepository.findById((int) id);
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteById(long id) {
		categoryRepository.deleteById((int) id);
	}

	@Override
	public List<Category> findByCategorynameContaining(String name) {
	    return categoryRepository.findByCategorynameContaining(name);
	}
}