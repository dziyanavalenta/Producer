package dvalenta.Producer.Client;

import dvalenta.Producer.Client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClientCreationService {
    @Autowired
    KafkaTemplate<String, Client> kafkaTemplate;

    private static final String TOPIC = "jsonClient";

    public void produce(Client client) {
        kafkaTemplate.send(TOPIC, client);
    }
}


