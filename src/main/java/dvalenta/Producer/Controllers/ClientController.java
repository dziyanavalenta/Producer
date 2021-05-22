package dvalenta.Producer.Controllers;

import dvalenta.Producer.Models.Client;
import dvalenta.Producer.Servicies.ClientCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")

public class ClientController {
    @Autowired
    ClientCreationService clientCreationService;

    @PostMapping("/clients")
    public String addClient(@RequestBody Client newClient) {

        clientCreationService.produceNewClient(newClient);
        return "new success with sending to kafka";
    }
}


