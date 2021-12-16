package com.cuatroa.retotres.service;

import com.cuatroa.retotres.model.User;
import com.cuatroa.retotres.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author  Olga Patricia Bernal
 * @version 1.0
 * @since   2021-12-14
 */
@Service
/**
*Clase para servicios de usuario
*/
public class UserService {

  @Autowired
    private UserRepository userRepository;
    
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

     public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);
        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }

    public User create(User user) {
        
        if (user.getId() != null) {
            Optional<User> usuario = userRepository.getUser(user.getId());
            if (usuario.isEmpty()) {
                if (userRepository.emailExists(user.getEmail()) == false) {
                    return userRepository.create(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

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

    public boolean delete(Integer id){
        boolean usuario= getUser(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return usuario;
    }
    
    public List <User> findByMonthBirthtDay (String birthday){
        return  userRepository.findByMonthBirthtDay(birthday);
    }
}
