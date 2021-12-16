package com.cuatroa.retotres.controller;

import com.cuatroa.retotres.model.User;
import com.cuatroa.retotres.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  Olga Patricia Bernal
 * @version 1.0
 * @since   2021-12-14
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
/**
*Clase para UserController
*/
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
     /**
     * Hacer llamados get
     */
    public List<User> getAll() {
        return userService.getAll();
    }
    @GetMapping("/{id}")
    /**
     * Hacer llamados get por id.
     */
    public Optional <User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
     /*
     * peticion new (POST)
     */
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * peticion update para actualizar (PUT)
     */
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /**
     * peticion update para borrar (DELETE)
     */
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    
    @GetMapping("/{email}/{password}")
    /**
     * Clase autenticar usuario
     */
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    
    @GetMapping("/emailexist/{email}")
     /**
     * clase verificar email
     */
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
    
    @GetMapping("/birthday/{birthday}")
    public List <User> findByMonthBirthtDay(@PathVariable("birthday") String birthday){
        return userService.findByMonthBirthtDay(birthday);
    }
}
