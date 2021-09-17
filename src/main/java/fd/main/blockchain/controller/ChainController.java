package fd.main.blockchain.controller;

import fd.main.blockchain.model.dto.ChainBlockDto;
import fd.main.blockchain.model.entity.ChainBlock;
import fd.main.blockchain.service.ChainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/chain")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ChainController {

    final ChainService service;

    @PostMapping("/append")
    public ResponseEntity<String> appendChain(
            @RequestBody ChainBlockDto block) {

        service.appendBlock(block);
        return new ResponseEntity<>("OK", HttpStatus.OK);

    }

    @GetMapping("")
    public ResponseEntity<Collection<ChainBlock>> getAllBlocks(){
        return ResponseEntity.ok()
                .body(service.getAll());
    }

}
