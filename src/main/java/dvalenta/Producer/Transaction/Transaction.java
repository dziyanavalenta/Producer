package dvalenta.Producer.Transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Transaction {
    private String bank;
    private Long clientId;
    private TransactionType orderType;
    private Integer quantity;
    private Double price;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    public LocalDateTime createdAt;

    public Transaction(String bank, Long clientId, TransactionType orderType, Integer quantity, Double price, LocalDateTime createdAt) {
        this.bank = bank;
        this.clientId = clientId;
        this.orderType = orderType;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
    }

    public String getBank() {
        return bank;
    }

    public Long getClientId() {
        return clientId;
    }

    public TransactionType getOrderType() {
        return orderType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

