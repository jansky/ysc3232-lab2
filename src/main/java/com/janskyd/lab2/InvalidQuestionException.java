/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janskyd.lab2;

/**
 * Indicates that the question has been incorrectly initialized by the arguments
 * passed to its constructor.
 * @author Ian Duncan
 */
public class InvalidQuestionException extends Exception {
    

    InvalidQuestionException(String message) {
        super(message);
    }
    
}
