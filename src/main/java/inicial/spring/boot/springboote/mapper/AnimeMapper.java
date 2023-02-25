package inicial.spring.boot.springboote.mapper;

import inicial.spring.boot.springboote.domain.Anime;
import inicial.spring.boot.springboote.requests.AnimePostRequestBody;
import inicial.spring.boot.springboote.requests.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
  public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
  public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);
  public abstract Anime toAnime(AnimePutRequestBody animePostRequestBody);
}
