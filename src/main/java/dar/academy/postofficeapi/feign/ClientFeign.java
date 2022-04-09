package dar.academy.postofficeapi.feign;

import dar.academy.postofficeapi.model.ClientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("client-core-api")
public interface ClientFeign {

    @GetMapping("client/check")
    String check();

    @GetMapping("client/all")
    List<ClientModel> getAllClients();

    @GetMapping("client/{clientId}")
    ClientModel getClientById(@PathVariable String clientId);
}
