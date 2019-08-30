/*
 * Copyright 2019 Ian Duncan
 * For YSC3232 Software Engineering, 2019-20 Sem 1
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
