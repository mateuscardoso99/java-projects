/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.springmvc.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author mateus
 */

@Configuration
public class SessionHelper {   
    @Bean(name = "ppp")
    public NewInterface ppp() {
//        try {
//            //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            HttpSession session = request.getSession();
//            session.setAttribute("msg", "rtpprtprt");
//        } catch (RuntimeException ex) {
//            ex.printStackTrace();
//            
//        }
return () -> "";
        
    }
    
    public interface NewInterface {
        String removeVerificationMessageFromSession();
    }
}
