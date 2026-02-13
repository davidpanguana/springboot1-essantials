package spring.academy.springboot1.repository;




import spring.academy.springboot1.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
