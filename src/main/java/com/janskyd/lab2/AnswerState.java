/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janskyd.lab2;

/**
 * The possible scoring states for an answer to a question
 * @author Ian Duncan
 */
public enum AnswerState {

    /**
     * The given answer is correct
     */
    CORRECT_ANSWER,

    /**
     * The given answer is incorrect
     */
    INCORRECT_ANSWER,

    /**
     * The given answer cannot be automatically marked as correct or incorrect
     */
    UNSCORABLE_ANSWER
}
