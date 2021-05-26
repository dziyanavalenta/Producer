package dvalenta.Producer.Client;

import lombok.extern.slf4j.Slf4j; //to see logs
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(value = "/kafka")
public class ClientController {
    private final ClientProducer producer;

    @Autowired
    ClientController(ClientProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> postClient(@RequestBody Client client) {
        //invoke kafka producer
        producer.produce(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }
}


