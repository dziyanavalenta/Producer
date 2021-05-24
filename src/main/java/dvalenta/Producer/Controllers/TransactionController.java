package dvalenta.Producer.Controllers;

import dvalenta.Producer.Models.Transaction;
import dvalenta.Producer.Servicies.TransactionCreationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j

public class TransactionController {
    @Autowired
    TransactionCreationService transactionCreationService;

    @PostMapping("/kafka/transactions")
    public ResponseEntity<Transaction> postTransaction(@RequestBody Transaction transaction) {
        //invoke kafka producer
        log.info("before sendTransaction");
        transactionCreationService.produce(transaction);
        log.info("after sendTransaction");
        return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    }
}
