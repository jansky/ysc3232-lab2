/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janskyd.lab2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;



/**
 *
 * @author jansky
 */
@XmlRootElement
@XmlSeeAlso({MultipleChoiceExamQuestion.class, ExtendedAnswerExamQuestion.class, ShortAnswerExamQuestion.class})
public class Exam {
    
    @XmlElement
    private final String title;
    @XmlElement
    private final String welcomeText;
    @XmlElement
    private final String finishedText;
    
    @XmlElementWrapper(name="questions")
    @XmlElement(type = Object.class, name="question")
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
    
    private Exam() {
        this.title = "";
        this.welcomeText = "";
        this.finishedText = "";
        this.questions = new ArrayList<>();
        
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
    
    public void toXML(File outFile) throws JAXBException {
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Exam.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

        //Print XML String to Console
        jaxbMarshaller.marshal(this, outFile);
        
    }
    
    public static Exam fromXML(File inFile) throws JAXBException {
        
        //creating the JAXB context

        JAXBContext jContext = JAXBContext.newInstance(Exam.class);

        //creating the unmarshall object

        Unmarshaller unmarshallerObj = jContext.createUnmarshaller();

        //calling the unmarshall method

        Exam exam =(Exam) unmarshallerObj.unmarshal(inFile);

        return exam;
        
    }
    
    
    
}
