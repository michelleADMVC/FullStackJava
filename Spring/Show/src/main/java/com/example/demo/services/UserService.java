package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	public void newUser(String name, String lastName,String password, String email){
		User newUser = new User(name, lastName, password, email);
		this.saveUser(newUser);
	}
	public void updateUser(Long id ,String name, String lastName,String password, String email){
		User updatedUser = findById(id);
		if (updatedUser != null) {
			updatedUser.setFirst_name(name);
			updatedUser.setLast_name(name);
			updatedUser.setEmail(email);
			updatedUser.setPassword(password);
			this.saveUser(updatedUser);
			logger.info("User updated");
		}else {
			logger.error("User not found");
		}
		
	}
	
	public User findById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()){
			return optionalUser.get();
		}else {
			return null;
		}
	}
	
	public void deleteById(Long id){
		userRepository.deleteById(id);
	}
	public void saveUser(User user) {
		this.userRepository.save(user);
	}
	public void test(){
		User newUser = new User("Usuario test","Para el databeis","1234","data@gmail.com");
		this.saveUser(newUser);
	}
}
