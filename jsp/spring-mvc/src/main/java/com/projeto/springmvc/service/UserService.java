/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.springmvc.service;

import com.projeto.springmvc.model.UserDtls;
import org.springframework.stereotype.Service;

/**
 *
 * @author mateus
 */
@Service
public interface UserService {
    public UserDtls createUser(UserDtls user);
    public boolean checkEmail(String email);
}
