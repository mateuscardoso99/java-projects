/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.springmvc.repository;

/**
 *
 * @author mateus
 */
import com.projeto.springmvc.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDtls, Integer> {
	public boolean existsByEmail(String email);
	public UserDtls findByEmail(String email);
}
