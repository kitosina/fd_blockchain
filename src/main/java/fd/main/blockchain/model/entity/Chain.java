package fd.main.blockchain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chain", schema = "chain_schema")
public class Chain {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "transactionalId", updatable = false, nullable = false)
    private UUID transactionalId;

    private String conasmgmentId;//Json properti как id

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


}
