package spring.academy.springboot1.services;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.academy.springboot1.domain.Anime;
import spring.academy.springboot1.exception.BadRequestException;
import spring.academy.springboot1.mapper.AnimeMapper;
import spring.academy.springboot1.repository.AnimeRepository;
import spring.academy.springboot1.requestDTO.AnimePostRequestBody;
import spring.academy.springboot1.requestDTO.AnimePutRequestBody;
import java.util.List;



@Service
@RequiredArgsConstructor
public class AnimeService {
   public final AnimeRepository animeRepository;
    private final AnimeMapper animeMapper;


    public Page<Anime> listAll(Pageable pageable){
        return animeRepository.findAll(pageable);
    }

    public List<Anime> findByName(String name){
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestionException(long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not faond"));
    }


    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody){
        return animeRepository.save(animeMapper.toAnime(animePostRequestBody));
    }

    public void delete(Long id){
        animeRepository.delete(findByIdOrThrowBadRequestionException(id));
    }

    @Transactional
    public void replace(AnimePutRequestBody animePutRequestBody){
        Anime savedAnime = findByIdOrThrowBadRequestionException(animePutRequestBody.getId());

        savedAnime.setName(animePutRequestBody.getName());

        animeRepository.save(savedAnime);
    }


}
