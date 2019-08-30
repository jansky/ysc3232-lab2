/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janskyd.lab2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This question accepts one of several pre-specified answer choices. This
 * question type supports automatic scoring.
 * @author Ian Duncan
 */
@XmlRootElement
public class MultipleChoiceExamQuestion implements ExamQuestion {
    
    @XmlElement
    private final String text;
    
    /* We tell JAXB to create an XML collection for the answer choices. When
       marshalled, it will look like:
    
      <answers>
        <answer>...</answer>
        <answer>...</answer>
      </answers>
    */
    @XmlElementWrapper(name="answers")
    @XmlElement(name="answer")
    private final List<String> answers;
    
    @XmlElement
    private final String correctAnswer;
    
    private boolean hasAnswered = false;
    private String answer;
    
    /* This private, no-arg constructor is required by JAXB for unmarshaling from
       XML. We also have to initialize all class properties here to prevent JAXB
       from throwing an exception upon unmarshaling.
    */
    private MultipleChoiceExamQuestion() {
        this.text = "";
        this.answers = new ArrayList<>();
        this.correctAnswer = "";
        this.hasAnswered = false;
        this.answer = "";
        
    }
    
    MultipleChoiceExamQuestion(String text, List<String> answers, String correctAnswer) throws InvalidQuestionException {
        this.text = text;
        this.answers = answers;
        
        if(!answers.contains(correctAnswer)) {
            throw new InvalidQuestionException("Correct answer is not one of the answer choices");
        }
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
    public void setAnswer(String answer) throws InvalidAnswerException {
        
        if(!this.answers.contains(answer)) {
            throw new InvalidAnswerException(answer + " is not a valid answer choice.");
        }
        

        this.answer = answer;
        this.hasAnswered = true;
        
    }

    @Override
    public boolean hasAnswered() {
        return this.hasAnswered;
    }
    
    @Override
    public JPanel createJPanel() {
        return new MultipleChoiceQuestionPanel(this);
    }
    
    /**
     * Gets the answer options of the question
     * @return
     */
    public List<String> answerOptions() {
        return this.answers;
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
