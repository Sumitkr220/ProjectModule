package Registration;

import Registration.Request.RegistrationDao;
import Registration.Request.UserDTO;
import Registration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class RegistrationControler {

    private final UserService userService;

    @Autowired
    public RegistrationControler(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationDao request) {
        String userId = request.getUserEmail();
        String password = request.getPasswordHash();
        Long id=request.getId();
        String state=request.getState();
        String country=request.getCountry();
        String firstName=request.getFirstName();
        String lastName=request.getLastName();
        String authId=request.getAuthId();

        // Check if user already exists
        if (userService.findByUserId(userId) != null) {
            return "User already exists";
        }

        // Save the user
        userService.saveUser(id, userId,  password, state, country,
                     firstName, lastName, authId);
        return "User registered successfully";
    }
}
