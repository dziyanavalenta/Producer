package dvalenta.Producer.Controllers;

import dvalenta.Producer.Models.Client;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")

public class ClientController {

    @PostMapping("/clients")
    public String addClient(@RequestBody Client newClient) {
        System.out.println("This is id: " + newClient.getClientId());
        return "new success with kafka url";
    }
}


