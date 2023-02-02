package ad.spring.ejemploguitarras.repositories;

import ad.spring.ejemploguitarras.model.Guitar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuitarRepository extends JpaRepository<Guitar,Long> {
}
