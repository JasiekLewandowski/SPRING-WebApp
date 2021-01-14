package programowanie.lewandowski.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import programowanie.lewandowski.demo.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
