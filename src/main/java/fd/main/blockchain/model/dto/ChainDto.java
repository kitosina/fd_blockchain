package fd.main.blockchain.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.util.Date;
import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChainDto {

    private UUID transactionalId;

    @JsonProperty(value = "id")
    private String conasmgmentId;//Json properti как id

    @JsonProperty(value = "company_from")
    private String from;//id

    @JsonProperty(value = "company_to")
    private String to;//id UUID который

    private String signature;// просто строка подпись

    private String cargoDetails;//просто строка сохранить

    private Date timestamp;//

    private String previousHash;

    private String hash;

}
