/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.springmvc.service;

/**
 *
 * @author mateus
 */
import com.projeto.springmvc.model.UserDtls;
import com.projeto.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncode;

    @Override
    public UserDtls createUser(UserDtls user) {
	user.setPassword(passwordEncode.encode(user.getPassword()));
	user.setRole("ROLE_USER");
	return userRepo.save(user);
    }

    @Override
    public boolean checkEmail(String email) {
	return userRepo.existsByEmail(email);
    }
}
