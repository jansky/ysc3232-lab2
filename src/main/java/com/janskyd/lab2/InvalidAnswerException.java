/*
 * Copyright 2019 Ian Duncan
 * For YSC3232 Software Engineering, 2019-20 Sem 1
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
