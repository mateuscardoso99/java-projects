/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.springmvc.controller;

/**
 *
 * @author mateus
 */
import com.projeto.springmvc.model.UserDtls;
import com.projeto.springmvc.repository.UserRepository;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;

        //model eh usado para transferir dados entre a view e o controller
        //Ele atua como um contêiner de dados que contém os dados do aplicativo. 
        //Esses dados armazenados podem ser de qualquer forma, como String, Object, dados do banco de dados
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
            String email = p.getName();
            UserDtls user = userRepo.findByEmail(email);
            m.addAttribute("user", user);
	}

	@GetMapping("/")
	public String home() {
               return "user/home";
	}

}
