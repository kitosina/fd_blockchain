package fd.main.blockchain.repository;

import fd.main.blockchain.model.entity.ChainBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChainRepository extends JpaRepository<ChainBlock, Long> {

    Optional<ChainBlock> findTopByOrderByTimestampDesc();

    List<ChainBlock> findAllByConasamentIdOrderByTimestampDesc(String conasamentId);

    Optional<ChainBlock> findTopByConasamentIdOrderByTimestampDesc(String conasamentId);

    @Query("select cb from ChainBlock cb")
    List<ChainBlock> findAllBlocks();

}
