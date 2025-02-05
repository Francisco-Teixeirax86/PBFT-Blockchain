package core.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Block {

    @Id
    private String hash;

    @Column(nullable = false)
    private String previousHash;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    private long timestamp;

    private int nonce;
}
