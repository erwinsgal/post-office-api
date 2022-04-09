package dar.academy.postofficeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientModel {
    private String clientId;
    @Email
    private String email;
    private String name;
    private String surname;
}
