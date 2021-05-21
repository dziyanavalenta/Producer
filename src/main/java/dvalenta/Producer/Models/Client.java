package dvalenta.Producer.Models;

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
