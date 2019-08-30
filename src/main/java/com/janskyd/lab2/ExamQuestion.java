/*
 * Copyright 2019 Ian Duncan
 * For YSC3232 Software Engineering, 2019-20 Sem 1
 */
package com.janskyd.lab2;

import javax.swing.JPanel;

/**
 * An interface that all exam questions must implement.
 * @author Ian Duncan
 */
public interface ExamQuestion {
    
    /**
     * Gets the question text
     * @return The question text
     */
    String text();

    /**
     * Scores the current answer to the question. This method should only be
     * called _after_ setting an answer to the question.
     * @return
     */
    AnswerState score();
    
    /**
     * Sets the current answer to the question.
     * @param answer The current answer to the question
     * @throws InvalidAnswerException
     */
    void setAnswer(String answer) throws InvalidAnswerException;

    /**
     * Gets the current answer to the question.
     * @return The current answer to the question.
     */
    String answer();

    /**
     * Gets the correct answer, if any, to the question, used for automatic
     * scoring. Question types which do not support automatic scoring should
     * return an empty string.
     * @return The correct answer to the question
     */
    String correctAnswer();

    /**
     * Gets whether an answer has been set for the question.
     * @return Whether an answer has been set for the question
     */
    boolean hasAnswered();
    
    /**
     * Creates a JPanel component that will be used to display the question to
     * the user and allow them to select or enter their answer.
     * @return The new JPanel component that displays the question.
     */
    JPanel createJPanel();
}
