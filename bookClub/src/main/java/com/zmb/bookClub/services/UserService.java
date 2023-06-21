package com.zmb.bookClub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.zmb.bookClub.models.LoginUser;
import com.zmb.bookClub.models.User;
import com.zmb.bookClub.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // TO-DO - Reject values: 
        // Reject if email is taken (present in database)
    	Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
        // 1. Find user in the DB by email    
        // 2. if the email is present , reject
    	if(optionalUser.isPresent()) {
    		result.rejectValue("email", "unique", "Email is already registered");
    	}
        // Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "matches", "confirm password doesn't match");
    	}
        // if result has errors, return 
    	if(result.hasErrors()) {
    		return null;
    	}
        // Hash and set password, save user to database  
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
    }
        
    public User login(LoginUser newLogin, BindingResult result) {
    // TO-DO - Reject values: 
        // Find user in the DB by email
        // 1. Find user in the DB by email    
    	Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
        // 2. if the email is not present , reject  
    	if(!optionalUser.isPresent()) {
    		result.rejectValue("email", "unique", "email is not registered");
    		return null;
    	}
        // 3.1 grab the user from potential user
    	User user = optionalUser.get();
        // 3.2 if BCrypt password match fails
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "matches", "Invalid Password!");
    	}
        // 4 if result has errors,return
    	if(result.hasErrors()) {
    		return null;
    	}else {
    		return user;
    	}
        // Otherwise, return the user object
    }
}
