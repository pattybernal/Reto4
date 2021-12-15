package com.cuatroa.retotres.repository;

import com.cuatroa.retotres.model.Gadget;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retotres.repository.crud.GadgetCrudRepository;

/**
 * @author  Olga Patricia Bernal
 * @version 1.0
 * @since   2021-12-14
 */
@Repository
public class GadgetRepository {
    
    @Autowired
    private GadgetCrudRepository gadgetCrudRepository;

    public List<Gadget>getAll() {
        return gadgetCrudRepository.findAll();
    }

    public Optional<Gadget> getGadget(int id) {
        return gadgetCrudRepository.findById(id);
    }
    
    public Gadget create(Gadget gadget) {
        return gadgetCrudRepository.save(gadget);
    }

    public void update(Gadget gadget) {
        gadgetCrudRepository.save(gadget);
    }
    
    public void delete(Gadget gadget) {
        gadgetCrudRepository.delete(gadget);
    }
    //Reto 5
    //Consultar por Precio
    public List<Gadget> gadgetsByPrice(double price) {
        return gadgetCrudRepository.findByPriceLessThanEqual(price);
    }
    //Reto 5
    //Consultar por Descripción
    public List<Gadget> findByDescriptionLike(String description) {
        return gadgetCrudRepository.findByDescriptionLike(description);
    }
}
