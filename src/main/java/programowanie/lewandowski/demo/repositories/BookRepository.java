package programowanie.lewandowski.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import programowanie.lewandowski.demo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
