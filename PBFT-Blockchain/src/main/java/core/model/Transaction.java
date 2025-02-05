package core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Transaction {

    @Id
    private String id;

    private String sender;
    private String recipient;
    private double amount;
    private String signature;
}
