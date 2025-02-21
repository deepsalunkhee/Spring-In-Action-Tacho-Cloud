package tacho.data;

import org.springframework.data.repository.CrudRepository;

import tacho.models.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    TacoOrder save(TacoOrder order);
}
