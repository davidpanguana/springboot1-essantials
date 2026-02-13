package spring.academy.springboot1.services;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import spring.academy.springboot1.domain.Anime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
    private static List<Anime> animes;

    static {
        animes = new ArrayList<>(List.of(new Anime(1L, "Boko on Hero"), new Anime(2L, "Berserk")));
    }
    public List<Anime> listAll(){
        return animes;
    }

    public Anime findById(long id){
        return animes.stream()
                .filter(anime -> anime.getId().equals(id) )
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not faond"));
    }

    public Anime Save(Anime anime){
        anime.setId(ThreadLocalRandom.current().nextLong(3, 1000000));
        animes.add(anime);
        return anime;
    }

    public void delete(long id){
        animes.remove(findById(id));
    }
}
