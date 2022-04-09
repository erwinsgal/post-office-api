package dar.academy.postofficeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailsModel {

    private String postId;
    private ClientModel clientId;
    private ClientModel postRecipientId;
    private String postItem;
    private String status;
    
}