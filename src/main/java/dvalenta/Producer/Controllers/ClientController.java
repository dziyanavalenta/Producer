package dvalenta.Producer.Controllers;

import dvalenta.Producer.Models.Client;
import dvalenta.Producer.Servicies.ClientCreationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ClientController {
    @Autowired
    ClientCreationService clientCreationService;

    @PostMapping("/kafka/clients")
    public ResponseEntity<Client> postClient(@RequestBody Client client){
        //invoke kafka producer
        log.info("before sendClient"); //just to see asynchronization (different port)
        clientCreationService.produceNewClient(client);
        log.info("after sendClient");
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }
}


