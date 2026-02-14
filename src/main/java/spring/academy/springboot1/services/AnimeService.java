package spring.academy.springboot1.services;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import spring.academy.springboot1.domain.Anime;
import spring.academy.springboot1.mapper.AnimeMapper;
import spring.academy.springboot1.repository.AnimeRepository;
import spring.academy.springboot1.requestDTO.AnimePostRequestBody;
import spring.academy.springboot1.requestDTO.AnimePutRequestBody;
import java.util.List;



@Service
@RequiredArgsConstructor
public class AnimeService {
   public final AnimeRepository animeRepository;

    public List<Anime> listAll(){
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name){
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestionException(long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not faond"));
    }

    public Anime Save(AnimePostRequestBody animePostRequestBody){
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(Long id){
        animeRepository.delete(findByIdOrThrowBadRequestionException(id));
    }

    public void repace(AnimePutRequestBody animePutRequestBody){
        Anime savedAnime = findByIdOrThrowBadRequestionException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }

}
