package fd.main.blockchain.service;

import fd.main.blockchain.model.dto.ChainBlockDto;
import fd.main.blockchain.model.entity.ChainBlock;
import fd.main.blockchain.repository.ChainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChainService {

    final ChainRepository repo;

    public void appendBlock(ChainBlockDto block) {

        String prevHash = repo.findTopByOrderByTimestampDesc()
                .orElse(ChainBlock.builder().hash("").build())
                .getHash();

        ChainBlock blockToAppend = ChainBlock.builder()
                .to(block.getTo())
                .from(block.getFrom())
                .conasamentId(block.getConasmgmentId())
                .cargoDetails(block.getCargoDetails())
                .signature(block.getSignature())
                .previousHash(prevHash)
                .build().calculateHash();

        repo.save(blockToAppend);

    }

    public List<ChainBlock> getAllByConasament(String id){
        return repo.findAllByConasamentIdOrderByTimestampDesc(id);
    }

    public ChainBlock getLastConsignmentBlock(String id){
        return repo.findTopByConasamentIdOrderByTimestampDesc(id)
                .orElseThrow(()->new RuntimeException("Not found"));
    }

    public Collection<ChainBlock> getAll(){
        return repo.findAll();
    }
}
