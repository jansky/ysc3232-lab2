/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author jansky
 */
public class ExamMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidQuestionException {
        // TODO code application logic here
        
        ArrayList<String> answerOptions = new ArrayList<>();
        answerOptions.add("C");
        answerOptions.add("Go");
        answerOptions.add("OCaml");
        answerOptions.add("JavaScript");
        
        ExamQuestion question1 = new MultipleChoiceExamQuestion("Which of the following languages is known for having robust support for concurrency built-in to the language?", answerOptions, "Go");
        ExamQuestion question2 = new ShortAnswerExamQuestion("What language are we using in YSC3232", "Java");
        ExamQuestion question3 = new ExtendedAnswerExamQuestion("What is your preferred programming paradigm (e.g. imperative, object-oriented, functional, etc.)? Provide an argument for why this paradigm is superior to others.");
        
        ArrayList<ExamQuestion> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        
        Exam exam = new Exam("Programming Language Exam", "You are going to complete a short exam testing your knowledge of different programming languages. Good luck!", "You have finished the exam.", questions);
        
        
        JFrame examFrame = new ExamFrame(exam);
        examFrame.setVisible(true);
        
    }
    
}
