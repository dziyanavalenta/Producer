package dvalenta.Producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import dvalenta.Producer.Client.Client;
import dvalenta.Producer.Client.ClientController;
import dvalenta.Producer.Client.ClientProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Unit test for the endpoint that is build in ClientController
@WebMvcTest(ClientController.class) //This annotation is used to write Unit tests for controller layers
@AutoConfigureMockMvc
public class ClientControllerUnitTest {
    @Autowired //MockMvs is used to simulate behavior of end point
    MockMvc mockMvc; //mockMvc will have the access to all endpoints in ClientController

    ObjectMapper objectMapper = new ObjectMapper();
    @MockBean //MockBean is used to inject external dependencies
    ClientProducer producer;

    @Test
    void PostClient() throws Exception {
        //given
        Client client = Client.builder()
                .clientId(5L)
                .email("test21@mail.ru")
                .build();

        String json = objectMapper.writeValueAsString(client);
        System.out.println("This is json "+json);
        doNothing().when(producer).produce(isA(Client.class));//Mockito is used to mock behavior

        //when
        mockMvc.perform(post("/kafka/clients")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        //then

    }
}
