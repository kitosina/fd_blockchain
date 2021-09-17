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

    @Value("${NODE_NAME}")
    private String node;

    @Value("${coordinator.url")
    private String backendUrl;

    @PostConstruct
    public void creatorChain() {
        try {
            log.info("Rest request in params: HOST = {} and NODE = {}",
                    this.host, this.node);
            RestTemplate rest = new RestTemplate();
            CreatorDto creatorDto = new CreatorDto();
            creatorDto.host = this.host;
            creatorDto.nodeName = this.node;
            rest.postForObject("http://blockchain.core.borisof.ru/registry/", creatorDto, Object.class);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private class CreatorDto {
        private String host;
        @JsonProperty("node_name")
        private String nodeName;
    }

}
