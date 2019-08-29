/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author jansky
 */
public class MultipleChoiceExamQuestion implements ExamQuestion {
    
    private final String text;
    private final List<String> answers;
    private final String correctAnswer;
    
    private boolean hasAnswered = false;
    private String answer;
    
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
