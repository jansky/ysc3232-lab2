/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janskyd.lab2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.swing.JFrame;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Ian Duncan
 */
public class ExamMain {
    
    // Idea from: https://stackoverflow.com/a/34895730
    private static String getRandomXMLFilename() {
        
        return UUID.randomUUID().toString() + ".xml";
        
    }

    /**
     * @param args the command line arguments
     * @throws com.janskyd.lab2.InvalidQuestionException
     * @throws javax.xml.bind.JAXBException
     */
    public static void main(String[] args) throws InvalidQuestionException, JAXBException {
        
        /*
         To test, we create an exam object, marshal it to a temporary file,
         unmarshal this file to an exam object, and display the exam UI with
         this unmarshalled exam.
        */
        List<String> answerOptions1 = Arrays.asList("C", "Go", "OCaml", "JavaScript");
        List<String> answerOptions2 = Arrays.asList("C++", "Java", "JavaScript", "Haskell", "F#");
        
        ExamQuestion question1 = new MultipleChoiceExamQuestion("Which of the following languages is known for having robust support for concurrency built-in to the language?", answerOptions1, "Go");
        ExamQuestion question2 = new MultipleChoiceExamQuestion("Which of the following languages uses promises to support asynchronous, event-based programming?", answerOptions2, "JavaScript");
        ExamQuestion question3 = new ShortAnswerExamQuestion("What language are we using in YSC3232?", "Java");
        ExamQuestion question4 = new ExtendedAnswerExamQuestion("What is your preferred programming paradigm (e.g. imperative, object-oriented, functional, etc.)? Provide an argument for why this paradigm is superior to others.");
        
        ArrayList<ExamQuestion> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        
        String tmpFileName = getRandomXMLFilename();
        
        Exam toWrite = new Exam("Programming Language Exam", "You are going to complete a short exam testing your knowledge of different programming languages. Good luck!", "You have finished the exam.", questions);        toWrite.toXML(new File(tmpFileName));
        
        Exam fromMarshalled = Exam.fromXML(new File(tmpFileName));
        
        // The marshalled and unmarshalled exams should be structurally equal.
        assert(toWrite.equals(fromMarshalled));
        
        new File(tmpFileName).delete();
        
        JFrame examFrame = new ExamFrame(fromMarshalled);
        examFrame.setVisible(true);
        
    }
    
}
