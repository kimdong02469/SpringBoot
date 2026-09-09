package kimdong.vn.service;

import java.util.List;
import java.util.Optional;
import kimdong.vn.entity.User;

public interface IUserService {
	List<User> findAll();

	Optional<User> findById(Long id);

	User save(User user);

	void deleteById(Long id);

	List<User> search(String keyword);
}