/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janskyd.lab2;

import javax.swing.JPanel;
import javax.xml.bind.annotation.*;

/**
 * An exam question that accepts long-form responses. This question type does
 * not support automatic scoring.
 * @author Ian Duncan
 */
@XmlRootElement
public class ExtendedAnswerExamQuestion implements ExamQuestion {
    
    @XmlElement
    private final String text;
    
    private String answer = "";
    
    private ExtendedAnswerExamQuestion() {
        this.text = "";
    }
    
    ExtendedAnswerExamQuestion(String text) {
        this.text = text;
    }

    @Override
    public String text() {
        return this.text;
    }

    @Override
    public AnswerState score() {
        return AnswerState.UNSCORABLE_ANSWER;
    }

    @Override
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean hasAnswered() {
        return this.answer.trim().length() > 0;
    }

    @Override
    public JPanel createJPanel() {
        return new ExtendedAnswerQuestionPanel(this);
    }

    @Override
    public String answer() {
        return this.answer;
    }

    @Override
    public String correctAnswer() {
        return "";
    }
    
    
    
}
