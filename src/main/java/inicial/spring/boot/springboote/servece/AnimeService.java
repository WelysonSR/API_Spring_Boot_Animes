package inicial.spring.boot.springboote.servece;

import inicial.spring.boot.springboote.domain.Anime;
import inicial.spring.boot.springboote.exception.BadRequestException;
import inicial.spring.boot.springboote.mapper.AnimeMapper;
import inicial.spring.boot.springboote.repository.AnimeRepository;
import inicial.spring.boot.springboote.requests.AnimePostRequestBody;
import inicial.spring.boot.springboote.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {
  private final AnimeRepository animeRepository;

  public List<Anime> listAll() {
    return animeRepository.findAll();
  }

  public List<Anime> findByName(String name) {
    return animeRepository.findByName(name);
  }

  public Anime findByIdOrThrowBadRequestsException(long id) {
    return animeRepository.findById(id)
            .orElseThrow(() -> new BadRequestException("Anime not Found"));
  }

  public Anime save(AnimePostRequestBody animePostRequestBody) {
    return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
  }

  public void delete(long id) {
    animeRepository.delete(findByIdOrThrowBadRequestsException(id));
  }

  public void replace(AnimePutRequestBody animePutRequestBody) {
    Anime saveAnime = findByIdOrThrowBadRequestsException(animePutRequestBody.getId());
    Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
    anime.setId(saveAnime.getId());
    animeRepository.save(anime);
  }
}
