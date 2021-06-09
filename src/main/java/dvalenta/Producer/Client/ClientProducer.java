package dvalenta.Producer.Client;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClientProducer {

    final KafkaTemplate<String, Client> kafkaTemplate;
    private static final String TOPIC = "jsonClient";

    public ClientProducer(KafkaTemplate<String, Client> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(Client client) {
        kafkaTemplate.send(TOPIC, client);
    }

    @Bean
    public NewTopic createTopic(){
        return new NewTopic(TOPIC, 3,(short) 1);
    }
}




