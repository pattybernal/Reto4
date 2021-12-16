package com.cuatroa.retotres.repository;

import com.cuatroa.retotres.model.User;
import com.cuatroa.retotres.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * @author  Olga Patricia Bernal
 * @version 1.0
 * @since   2021-12-14
 */
@Repository
/**
 * Repositorio de {USER}
 */
public class UserRepository {

    @Autowired
    /**
     * Metodos Crud USER (MongoDB Repository)
     */
    private UserCrudRepository userCrudRepository;
    /**
     * GET -> Traer todos los usuarios
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    /**
     * GET ->Hacer llamados get por Id
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
     /*
     * peticion new (POST)
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    /**
     * PUT -> Metodo actualizar para USER
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }
    /**
     * peticion update para borrar (DELETE)
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    /**
     * clase verificar email
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    /**
     * Clase autenticar usuario
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    /**
     * Clase consultar por lastUserId
     */
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
    /**
     * Clase consultar por monthBirthtDay
     */
     public List <User> findByMonthBirthtDay (String birthday){
        return  userCrudRepository.findByMonthBirthtDay(birthday);
    }
}
