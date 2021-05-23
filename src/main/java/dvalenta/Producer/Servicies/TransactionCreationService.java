package dvalenta.Producer.Servicies;

import dvalenta.Producer.Models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionCreationService {
    @Autowired
    KafkaTemplate<String, Transaction> kafkaTemplate;

    private static final String TOPIC = "jsonTransaction";

    public void produceNewTransaction(Transaction transaction){
        kafkaTemplate.send(TOPIC, new Transaction(transaction.getBank(),transaction.getClientId(), transaction.getOrderType(),
                transaction.getQuantity(), transaction.getPrice(), transaction.getCreatedAt()));
    }
}







