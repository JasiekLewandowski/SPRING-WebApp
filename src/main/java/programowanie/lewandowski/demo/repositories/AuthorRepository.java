package programowanie.lewandowski.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import programowanie.lewandowski.demo.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
