/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janskyd.lab2;

import javax.swing.JPanel;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jansky
 */
@XmlRootElement
public class ShortAnswerExamQuestion implements ExamQuestion {
    
    @XmlElement
    private final String text;
    
    @XmlElement
    private final String correctAnswer;
    
    private String answer = "";
    
    private ShortAnswerExamQuestion() {
        this.text = "";
        this.correctAnswer = "";
        this.answer = "";
    }
    
    public ShortAnswerExamQuestion(String text, String correctAnswer) {
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String text() {
        return this.text;
    }

    @Override
    public AnswerState score() {
        if(this.correctAnswer.equals(this.answer)) {
            return AnswerState.CORRECT_ANSWER;
        } else {
            return AnswerState.INCORRECT_ANSWER;
        }
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
        return new ShortAnswerQuestionPanel(this);
    }

    @Override
    public String answer() {
        return this.answer;
    }

    @Override
    public String correctAnswer() {
        return this.correctAnswer;
    }
    
}
