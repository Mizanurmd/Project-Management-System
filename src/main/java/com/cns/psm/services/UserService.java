package com.cns.psm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cns.psm.entities.User;
import com.cns.psm.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRep;
	public Optional<User> getUser(Integer id) {
		return userRep.findById(id);
	}
	
	 public List<User> getAllUsers() {
	        return userRep.findAll();
	    }

}
