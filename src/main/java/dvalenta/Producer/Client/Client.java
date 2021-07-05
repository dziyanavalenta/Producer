package dvalenta.Producer.Client;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Client {
    private Long clientId;
    private String email;

    public Client(Long clientId, String email) {
        this.clientId = clientId;
        this.email = email;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getEmail() {

        return email;
    }

}
