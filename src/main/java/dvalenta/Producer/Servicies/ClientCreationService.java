package dvalenta.Producer.Servicies;


import dvalenta.Producer.Models.Client;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClientCreationService {
    private static KafkaTemplate<String, Client> kafkaTemplate ;

    private static final String TOPIC = "jsonClient";

    public ClientCreationService(KafkaTemplate<String, Client> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceNewClient(Client newClient) {
        kafkaTemplate.send(TOPIC, new Client(newClient.getClientId(), newClient.getEmail()));
    }
}


