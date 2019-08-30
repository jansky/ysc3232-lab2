/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janskyd.lab2;

/**
 * Indicates that the user has entered an invalid answer to a question.
 * @author Ian Duncan
 */
public class InvalidAnswerException extends Exception {
    
    InvalidAnswerException(String message) {
        super(message);
    }
    
}
