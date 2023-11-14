package Registration.Request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
@Entity
public class UserDTO {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Id
    private String userEmail;
    private String firstName;
    private String lastName;
    private String state;
    private String country;
    private String passwordHash;
    private String authId;
}
