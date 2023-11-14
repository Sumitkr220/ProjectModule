package Registration.Repo;

import Registration.Request.UserDTO;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDTO, Long> {
    UserDTO findByUserId(String userId);
}