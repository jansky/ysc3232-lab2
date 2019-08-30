/*
 * Copyright 2019 Ian Duncan
 * For YSC3232 Software Engineering, 2019-20 Sem 1
 */
package com.janskyd.lab2;

import javax.swing.JPanel;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The short answer exam question accepts short-form free responses. It is
 * designed to support automatic scoring.
 * @author Ian Duncan
 */
@XmlRootElement
public class ShortAnswerExamQuestion implements ExamQuestion {
    
    @XmlElement
    private final String text;
    
    @XmlElement
    private final String correctAnswer;
    
    private String answer = "";
    
    /*
     This private, no-arg constructor is used by JAXB marshaling. We must also
     initialize all class members, otherwise JAXB will throw an exception upon
     unmarshaling.
    */
    private ShortAnswerExamQuestion() {
        this.text = "";
        this.correctAnswer = "";
        this.answer = "";
    }
    
    /**
     * Creates a new short answer exam question
     * @param text The question text
     * @param correctAnswer The correct answer
     */
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
