package dvalenta.Producer.Transaction;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducer {
    final KafkaTemplate<String, Transaction> kafkaTemplate;

    private static final String TOPIC = "jsonTransaction";

    public TransactionProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(Transaction transaction) {

        kafkaTemplate.send(TOPIC, transaction);
    }
}







