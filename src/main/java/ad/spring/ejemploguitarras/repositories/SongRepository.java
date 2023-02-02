package ad.spring.ejemploguitarras.repositories;

import ad.spring.ejemploguitarras.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song,Long> {
}
