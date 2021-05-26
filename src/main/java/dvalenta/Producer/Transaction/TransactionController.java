package dvalenta.Producer.Transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j

@RequestMapping(value = "/kafka")
public class TransactionController {
    private final TransactionProducer producer;

    @Autowired
    TransactionController(TransactionProducer transactionProducer) {
        this.producer = transactionProducer;
    }

    @PostMapping("/transactions")
    public ResponseEntity<Transaction> postTransaction(@RequestBody Transaction transaction) {
        //invoke kafka producer
        log.info("before sendTransaction");
        producer.produce(transaction);
        log.info("after sendTransaction");
        return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    }
}
