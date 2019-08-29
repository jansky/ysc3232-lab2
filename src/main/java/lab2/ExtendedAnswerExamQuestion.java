/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import javax.swing.JPanel;

/**
 *
 * @author jansky
 */
public class ExtendedAnswerExamQuestion implements ExamQuestion {
    
    private final String text;
    
    private String answer = "";
    
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
