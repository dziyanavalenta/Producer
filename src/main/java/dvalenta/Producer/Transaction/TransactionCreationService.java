package dvalenta.Producer.Transaction;

import dvalenta.Producer.Transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionCreationService {
    @Autowired
    KafkaTemplate<String, Transaction> kafkaTemplate;

    private static final String TOPIC = "jsonTransaction";

    public void produce(Transaction transaction){
        kafkaTemplate.send(TOPIC, transaction);
    }
}







