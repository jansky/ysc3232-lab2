/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janskyd.lab2;

import javax.swing.JPanel;

/**
 *
 * @author jansky
 */
public interface ExamQuestion {
    
    String text();
    AnswerState score();
    
    void setAnswer(String answer) throws InvalidAnswerException;
    String answer();
    String correctAnswer();
    boolean hasAnswered();
    
    JPanel createJPanel();
}
