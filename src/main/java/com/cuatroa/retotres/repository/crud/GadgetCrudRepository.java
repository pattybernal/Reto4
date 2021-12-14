package com.cuatroa.retotres.repository.crud;

import com.cuatroa.retotres.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author  Olga Patricia Bernal
 * @version 1.0
 * @since   2021-12-09
 */
public interface GadgetCrudRepository extends MongoRepository<Gadget, Integer> {
    
}
