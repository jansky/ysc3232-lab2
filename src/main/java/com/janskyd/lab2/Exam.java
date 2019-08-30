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
 * @author Ian Duncan
 */
@XmlRootElement
/* We help out JAXB by informing it of the classes that satisfy the ExamQuestion
   interface. Idea from: https://stackoverflow.com/a/14073899
*/
@XmlSeeAlso({MultipleChoiceExamQuestion.class, ExtendedAnswerExamQuestion.class, ShortAnswerExamQuestion.class})
public class Exam {
    
    @XmlElement
    private final String title;
    @XmlElement
    private final String welcomeText;
    @XmlElement
    private final String finishedText;
    
    // JAXB can't marshal / unmarshal interfaces by default. We give it a little
    // helpful push.
    // Idea from: https://stackoverflow.com/a/41736816
    @XmlElementWrapper(name="questions")
    @XmlElement(type = Object.class, name="question")
    private final List<ExamQuestion> questions;

    /**
     * Gets the exam's title
     * @return
     */
    public String title() {
        return this.title;
    }

    /**
     * Gets the exam's welcome text
     * @return
     */
    public String welcomeText() {
        return this.welcomeText;
    }

    /**
     * Gets the text to be displayed when the exam is finished
     * @return
     */
    public String finishedText() {
        return this.finishedText;
    }

    /**
     * Gets the list of exam question
     * @return
     */
    public List<ExamQuestion> questions() {
        return this.questions;
    }
    
    /*
     * This private, no-arg constructor is needed by JAXB to marshal and
     * unmarshal XML. We need to initialize all class members here to
     * prevent JAXB from throwing an exception on unmarshaling as well.
    */
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
    
    /**
     * Prints the user's answers and their correctness for each exam question.
     */
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
    
    /**
     * Serializes the exam and its questions to an XML file. Answers are not
     * serialized.
     * @param outFile The file to save the exam XML to
     * @throws JAXBException
     */
    public void toXML(File outFile) throws JAXBException {
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Exam.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

        //Print XML String to Console
        jaxbMarshaller.marshal(this, outFile);
        
    }
    
    /**
     * Loads an exam and its questions from an XML file.
     * @param inFile The file to load the XML data from.
     * @return The deserialized exam.
     * @throws JAXBException
     */
    public static Exam fromXML(File inFile) throws JAXBException {

        JAXBContext jContext = JAXBContext.newInstance(Exam.class);

        Unmarshaller unmarshallerObj = jContext.createUnmarshaller();

        Exam exam =(Exam) unmarshallerObj.unmarshal(inFile);

        return exam;
        
    }
    
    
    
}
