package Registration.Service;

import Registration.Repo.UserRepository;
import Registration.Request.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(Long id,String userId, String password,String state,String country,
                            String firstName,String lastName,String authId) {
        UserDTO userDTO=UserDTO.builder()
                .id(id)
                .userEmail(userId)
                .state(state)
                .country(country)
                .firstName(firstName)
                .lastName(lastName)
                .authId(authId)
                .passwordHash(passwordEncoder.encode(password))
                .build();
        userRepository.save(userDTO);
    }

    public UserDTO findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}
