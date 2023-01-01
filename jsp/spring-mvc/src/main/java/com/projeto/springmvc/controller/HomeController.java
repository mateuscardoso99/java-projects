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
import com.projeto.springmvc.service.UserService;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
        
        @Autowired
        private BCryptPasswordEncoder passwordEncode;

	@GetMapping("/")
	public String index() {
            return "index";
	}

	@GetMapping("/signin")
	public String login() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
                return "login";
            }
 
            return "redirect:/user/";
	}

	@GetMapping("/register")
	public String register() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
                return "register";
            }
            return "redirect:/user/";
	}

	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user, HttpSession session) {

		StringBuilder redirect = new StringBuilder();
                redirect.append("redirect:/register");

		boolean f = userService.checkEmail(user.getEmail());

		if (f) {
                    redirect.append("?error=Email Id alreday exists");
                    //session.setAttribute("msg", "Email Id alreday exists");
		}

		else {
			UserDtls userDtls = userService.createUser(user);
			if (userDtls != null) {
                            redirect.append("?success=Register Sucessfully");
                            //session.setAttribute("msg", "Register Sucessfully");
			} else {
                            redirect.append("?error=Error register");
                            //session.setAttribute("msg", "Something wrong on server");
			}
		}

		return redirect.toString();
	}
}
