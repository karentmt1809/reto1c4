package com.retomt1.reto1.controller;

import java.util.List;

import com.retomt1.reto1.model.User;
import com.retomt1.reto1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author karent_saenz
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    /**
     * Instancia que permite realizar las diferentes acciones
     */
    private UserService userService;
    
    @GetMapping("/all")
    /**
     * Metodo para obener todos los usuarios
     */
    public List<User> getAll() {
        return userService.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * Metodo para crear nuevos usuarios
     * @param user
     * @return
     */
    public User registrar(@RequestBody User user) {
        return userService.registrar(user);
    }
    
    @GetMapping("/{email}/{password}")
    /**
     * Metodo para que autrnticar usuarios
     * @param email
     * @param password
     * @return
     */
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }
    /**
     * Metodo para validar existencia
     * @param email
     * @return
     */
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }   
}
