package com.cuatroa.retotres.repository.crud;

import com.cuatroa.retotres.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @author  Olga Patricia Bernal
 * @version 1.0
 * @since   2021-12-14
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    
    //Retorna las órdenes de pedido que coinciden con la zona recibida como parámetro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(String zone);
    
    //Retorna las ordenes x estado
    //@Query("{status: ?0}")
    //List<Order> findByStatus(final String status);
    
    //Para seleccionar la orden con el id máximo
    Optional<Order> findTopByOrderByIdDesc();
}
