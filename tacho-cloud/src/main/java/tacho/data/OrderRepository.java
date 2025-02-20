package tacho.data;

import tacho.models.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
