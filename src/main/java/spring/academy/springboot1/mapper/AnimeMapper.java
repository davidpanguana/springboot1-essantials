package spring.academy.springboot1.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import spring.academy.springboot1.domain.Anime;
import spring.academy.springboot1.requestDTO.AnimePostRequestBody;
import spring.academy.springboot1.requestDTO.AnimePutRequestBody;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);
}
