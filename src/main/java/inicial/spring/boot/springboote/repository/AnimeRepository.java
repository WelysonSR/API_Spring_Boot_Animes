package inicial.spring.boot.springboote.repository;

import inicial.spring.boot.springboote.domain.Anime;

import java.util.List;

public interface AnimeRepository {
  List<Anime> listAll();
}
