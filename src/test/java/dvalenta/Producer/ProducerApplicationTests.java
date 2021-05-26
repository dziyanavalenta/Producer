package dvalenta.Producer;

import dvalenta.Producer.Client.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProducerApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
	/*void contextLoads() {
	}*/
    void postClientEvent() {
        //given
        Client client = Client.builder()
                .clientId(5L)
                .email("test21@mail.ru")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("content=type", MediaType.APPLICATION_JSON.toString());
        HttpEntity<Client> request = new HttpEntity<>(client, headers);
        //when
        ResponseEntity<Client> responseEntity = restTemplate.exchange("/kafka/clients", HttpMethod.POST, request, Client.class);
        //then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }
}
