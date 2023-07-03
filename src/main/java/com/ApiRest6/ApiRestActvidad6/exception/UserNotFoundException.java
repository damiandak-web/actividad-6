/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest6.ApiRestActvidad6.exception;

/**
 *
 * @author user
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("could not found the user with id" + id);
    }
}
