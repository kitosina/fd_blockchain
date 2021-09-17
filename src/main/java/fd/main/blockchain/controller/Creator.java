package fd.main.blockchain.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@Data
public class Creator {

    @Value("${virtual.host}")
    private String host;

    @Value("${virtual.node}")
    private String node;

    private String backendUrl = "http://localhost:8080/registry";

    @PostConstruct
    public void creatorChain() {
        log.info("Rest request in params: HOST = {} and NODE = {}",
                this.host, this.node);
        RestTemplate rest = new RestTemplate();
        CreatorDto creatorDto = new CreatorDto();
        creatorDto.host = this.host;
        creatorDto.nodeName = this.node;
        rest.postForObject(backendUrl, creatorDto, Object.class);

    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private class CreatorDto {
        private String host;
        @JsonProperty("node_name")
        private String nodeName;
    }

}
