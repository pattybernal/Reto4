package com.cuatroa.retotres.repository.crud;

import com.cuatroa.retotres.model.Gadget;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @author  Olga Patricia Bernal
 * @version 1.0
 * @since   2021-12-14
 */
public interface GadgetCrudRepository extends MongoRepository<Gadget, Integer> {
     public List<Gadget> findByPriceLessThanEqual(double price);
    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Gadget> findByDescriptionLike(String description);
}
