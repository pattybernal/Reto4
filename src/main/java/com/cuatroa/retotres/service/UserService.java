package com.cuatroa.retotres.service;

import com.cuatroa.retotres.model.User;
import com.cuatroa.retotres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author  Olga Patricia Bernal
 * @version 1.0
 * @since   2021-12-09
 */
@Service
/**
 * *Clase para servicios de usuario*/
public class UserService {

    @Autowired
    private UserRepository userRepository;
    /**
     * Hacer llamados get
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }
    /**
     * Hacer llamados get por Id
     */
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }
     /*
     * peticion new (POST)
     */
    public User create(User user) {
        
        //obtiene el maximo id existente en la coleccion
        Optional<User> userIdMaximo = userRepository.lastUserId();
        
        //si el id del Usaurio que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (user.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (userIdMaximo.isEmpty())
                user.setId(1);
            //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo del usuario
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }
        Optional<User> e = userRepository.getUser(user.getId());
        if (e.isEmpty()) {
            if (emailExists(user.getEmail())==false){
                return userRepository.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    /**
     * peticion update para actualizar (PUT)
     */
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    /**
     * peticion update para borrar (DELETE)
     */
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    /**
     * clase verificar email
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }
    /**
     * Clase autenticar usuario
     */
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);
        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
}
