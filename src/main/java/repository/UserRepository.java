package repository;

import java.util.Set;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long>{
    public User findByUsername(String username);
    @Query(value="SELECT user.`user_id`, user.`name`, user.`lastname`, user.`earnings`, user.`username`, user.`email`, user.`password` FROM user WHERE user.username LIKE %:query%",nativeQuery = true)
    public Set<User> search(String query);
}
