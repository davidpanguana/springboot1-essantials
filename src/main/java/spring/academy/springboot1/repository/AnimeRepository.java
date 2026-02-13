package spring.academy.springboot1.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import spring.academy.springboot1.domain.Anime;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
