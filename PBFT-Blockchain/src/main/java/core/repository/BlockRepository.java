package core.repository;

import core.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, String> {
    Block findTopByOrderByTimestampDesc();
}
