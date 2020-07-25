package com.example.app.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.app.models.User;
import com.example.app.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // registrar el usuario y hacer Hash a su password
    public void registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        userRepository.save(user);
    }
    public User newUser(String firstName, String lastName, String email, String password) {
    	return new User(firstName, lastName, email, password);
    }
    
    // encontrar un usuario por su email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // encontrar un usuario por su id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // autenticar usuario
    public boolean authenticateUser(String email, String password) {
        // primero encontrar el usuario por su email
        User user = userRepository.findByEmail(email);
        // si no lo podemos encontrar por su email, retornamos false
        if(user == null) {
            return false;
        } else {
            // si el password coincide devolvemos true, sino, devolvemos false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
