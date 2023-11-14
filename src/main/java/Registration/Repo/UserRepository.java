package Registration.Repo;

import Registration.Request.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<UserDTO, Long> {
    UserDTO findByUserId(String userId);
}