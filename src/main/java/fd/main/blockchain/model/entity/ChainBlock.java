package fd.main.blockchain.model.entity;

import fd.main.blockchain.model.Hashing;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

import static fd.main.blockchain.model.Hashing.SHA256;

@Setter
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chain")
public class ChainBlock {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "transactionId", updatable = false, nullable = false)
    private UUID transactionalId;

    private String conasamentId;//Json properti как id

    @Column(name = "company_from")
    private String from;//id

    @Column(name = "company_to")
    private String to;//id UUID который

    @Column
    private String signature;// просто строка подпись

    @Column
    private String cargoDetails;//просто строка сохранить

    @CreationTimestamp
    private Date timestamp;//

    @Column
    private String previousHash;

    @Column
    private String hash;

    public ChainBlock calculateHash() {
        this.hash = SHA256(toString());
        return this;
    }


}
