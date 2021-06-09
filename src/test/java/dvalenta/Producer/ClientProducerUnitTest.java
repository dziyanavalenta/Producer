package dvalenta.Producer;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import dvalenta.Producer.Client.Client;
import dvalenta.Producer.Client.ClientProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SettableListenableFuture;


import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;


//To mock kafkaTemplate in ClientProducer and check that kafkaTemplate.send is called
@ExtendWith(MockitoExtension.class)
public class ClientProducerUnitTest {
    @Autowired
    ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks //Create an instance of the class that is on the test
    ClientProducer clientProducer;
    @Mock
    KafkaTemplate<String, Client> kafkaTemplate;

    @Test
    public void testProduce() throws JsonProcessingException {
        //given
        Client client = Client.builder()
                .clientId(5L)
                .email("test21@mail.ru")
                .build();

        String json = objectMapper.writeValueAsString(client);

        //when
        clientProducer.produce(client);
        //then
        verify(kafkaTemplate).send("jsonClient",client);
    }
}

