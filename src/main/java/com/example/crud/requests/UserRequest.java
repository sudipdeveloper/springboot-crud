package requests;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
@Data
@NoArgsConstructor
public class UserRequest {
    private String name;
    private String phone;
    private String email;
    private String userName;
    private String password;
}
