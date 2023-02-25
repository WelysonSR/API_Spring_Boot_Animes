package inicial.spring.boot.springboote.repository;

import inicial.spring.boot.springboote.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
  List<Anime> findByName(String name);
}
