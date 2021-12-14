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
 * @since   2021-12-09
 */
@Repository
public class GadgetRepository {
    
    @Autowired
    private GadgetCrudRepository gadgetCrudRepository;

    public List<Gadget> getAll() {
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
}
