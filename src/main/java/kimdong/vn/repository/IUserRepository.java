package kimdong.vn.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kimdong.vn.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	// Tìm kiếm User theo username hoặc fullname chứa từ khóa
	List<User> findByUsernameContainingOrFullnameContaining(String username, String fullname);
}