package tacho.data;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import tacho.models.Taco;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {
   Page<Taco> findAll(Pageable pageable); 

    Taco save(Taco design);

    Optional<Taco> findById(Long id);
}
