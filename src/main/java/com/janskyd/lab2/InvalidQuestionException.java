/*
 * Copyright 2019 Ian Duncan
 * For YSC3232 Software Engineering, 2019-20 Sem 1
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
