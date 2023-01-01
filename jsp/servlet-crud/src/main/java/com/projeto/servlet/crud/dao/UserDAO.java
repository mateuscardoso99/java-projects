/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.servlet.crud.dao;

import com.projeto.servlet.crud.connection.ConnectionFactory;
import com.projeto.servlet.crud.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author mateus
 */
public class UserDAO {
    
    public boolean save(User user) throws SQLException {
	// try-with-resource statement will auto close the connection.
        boolean rowCount;
                
	try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement p = connection.prepareStatement("INSERT INTO users(name,email,password,phone) VALUES (?,?,?,?);"))
            {
		p.setString(1, user.getName());
                p.setString(2, user.getEmail());
                p.setString(3, new BCryptPasswordEncoder().encode(user.getPassword()));
                p.setString(4, user.getPhone());

                rowCount = p.executeUpdate() > 0;
	}
        
        return rowCount;
    }

    public User selectUser(User u) throws SQLException {
	User user = new User();
	// Step 1: Establishing a Connection
	try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement p = connection.prepareStatement("SELECT * FROM users WHERE email = ?;");)
        {
            p.setString(1, u.getEmail());
            
            ResultSet rs = p.executeQuery();
        
            if(rs.next()){ 
                if(new BCryptPasswordEncoder().matches(u.getPassword(), rs.getString("password"))){
                    user.setId(rs.getInt("id"));
                    user.setEmail(rs.getString("email"));
                    user.setName(rs.getString("name"));
                    user.setPhone(rs.getString("phone"));
                }
                else{
                    user=null;
                }
            }
            else{
                user = null;
            }
	} catch (SQLException e) {
            printSQLException(e);
	}
        
	return user;
    }

    private void printSQLException(SQLException ex) {
	for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
