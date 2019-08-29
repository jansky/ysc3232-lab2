/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.List;

/**
 *
 * @author jansky
 */
public class Exam {
    
    private final String title;
    private final String welcomeText;
    private final String finishedText;
    private final List<ExamQuestion> questions;

    public String title() {
        return this.title;
    }

    public String welcomeText() {
        return this.welcomeText;
    }

    public String finishedText() {
        return this.finishedText;
    }

    public List<ExamQuestion> questions() {
        return this.questions;
    }
    
    Exam(String title, String welcomeText, String finishedText, List<ExamQuestion> questions) {
        this.title = title;
        this.welcomeText = welcomeText;
        this.finishedText = finishedText;
        this.questions = questions;
    }
    
    public void printScoreReport() {
        
        for(int i = 0; i < this.questions.size(); i++) {
            
            ExamQuestion question = this.questions.get(i);
            
            System.out.printf("Question %d: %s\n", i+1, question.text());
            
            if(question.hasAnswered()) {
                
                AnswerState score = question.score();
                System.out.printf("Your Answer: %s\n", question.answer());
                
                switch(score) {
                    case CORRECT_ANSWER:
                        System.out.printf("Score: Correct\n");
                        break;
                    case INCORRECT_ANSWER:
                        System.out.printf("Score: Incorrect (Correct answer was %s)\n", question.correctAnswer());
                        break;
                    case UNSCORABLE_ANSWER:
                        System.out.printf("Score: Unable to score automatically\n");
                        break;
                }            
                
            } else {
                System.out.printf("Unanswered\n");
            }
            
            System.out.println();
            
        }
        
    }
    
}
