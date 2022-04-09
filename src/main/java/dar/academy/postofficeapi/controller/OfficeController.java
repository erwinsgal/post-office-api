package dar.academy.postofficeapi.controller;

import dar.academy.postofficeapi.feign.ClientFeign;
import dar.academy.postofficeapi.feign.PostFeign;
import dar.academy.postofficeapi.model.ClientModel;
import dar.academy.postofficeapi.model.DetailsModel;
import dar.academy.postofficeapi.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    PostFeign postFeign;

    @Autowired
    ClientFeign clientFeign;

    @GetMapping("/check")
    public String check(){
        return "post-office-api is working";
    }

    @GetMapping("/post/check")
    public String checkPost(){
        return postFeign.checkPost();
    }

    @GetMapping("/post/all")
    public List<PostModel> getAllPosts() {
        return postFeign.getAllPosts();
    }

    @GetMapping("/post/{postId}")
    public PostModel getPostById(@PathVariable String postId){
        return postFeign.getPostById(postId);
    }

    @GetMapping("/client/check")
    public String checkClient(){
        return clientFeign.check();
    }

    @GetMapping("/client/all")
    public List<ClientModel> getAllClients(){
        return clientFeign.getAllClients();
    }

    @GetMapping("/client/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId){
        return clientFeign.getClientById(clientId);
    }


   @GetMapping("/details/{postId}")
    public DetailsModel getPostDetails(@PathVariable String postId){

        PostModel postDetails = postFeign.getPostById(postId);
        System.out.println(postDetails);
        ClientModel clientDetails = clientFeign.getClientById(postDetails.getClientId());
        ClientModel receiverDetails = clientFeign.getClientById(postDetails.getPostRecipientId());

        return new DetailsModel(postId,clientDetails, receiverDetails, postDetails.getPostItem(), postDetails.getStatus());
    }



}
