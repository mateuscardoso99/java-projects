/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  mateus
 * Created: 27 de dez. de 2022
 */

CREATE TABLE users(
    id int serial,
    name varchar(100),
    email varchar(100),
    password varchar(255),
    phone varchar(20),
    PRIMARY KEY(id),
    CONSTRAINT unique_email UNIQUE(email)
);