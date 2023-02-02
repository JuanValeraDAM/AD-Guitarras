package ad.spring.ejemploguitarras.repositories;

import ad.spring.ejemploguitarras.model.GuitarPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuitarPlayerRepository extends JpaRepository<GuitarPlayer,Long> {
    List<GuitarPlayer> findGuitarPlayersByTrainingTimeGreaterThan(int amount);
}
