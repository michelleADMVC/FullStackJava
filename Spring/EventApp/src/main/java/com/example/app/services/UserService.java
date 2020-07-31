package com.example.app.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.models.Location;
import com.example.app.models.User;
import com.example.app.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	public UserService(UserRepository inject) {
		this.userRepo = inject;
	}
	public void saveUser(User user){
		this.userRepo.save(user);
	}
	public User registerUser(String firstName,
			String lastName,String email,String password,Location location) {
        String hashedPass = BCrypt.hashpw(password, BCrypt.gensalt());
       User newUser = new User(firstName, lastName, email, hashedPass, location);
       userRepo.save(newUser);
       return newUser;
    }
	 public boolean authenticateUser(String email, String password) {
	        User user = userRepo.findByEmail(email);
	        if(user == null) {
	            return false;
	        } else {
	            if(BCrypt.checkpw(password, user.getPassword())) {
	                return true;
	            } else {
	                return false;
	            }
	        }
	    }
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	public boolean userExists(String email){
		if (this.findByEmail(email) != null) {
			return true;
		}else {
			return false;
		}
	}
}
