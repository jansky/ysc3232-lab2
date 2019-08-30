/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janskyd.lab2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

/**
 * A JPanel component that displays multiple choice questions.
 * @author Ian Duncan
 */
public class MultipleChoiceQuestionPanel extends javax.swing.JPanel {
    
    private MultipleChoiceExamQuestion question;
    
    private ButtonGroup answerOptionsButtonGroup;

    /**
     * Creates a new JPanel component to display the given multiple choice exam
     * question.
     * @param question
     */
    public MultipleChoiceQuestionPanel(MultipleChoiceExamQuestion question) {
        
        this.question = question;
        
        initComponents();
        
        /* We need this for our answer radio buttons to work properly (i.e. only
        one can be selected at once).
        */
        this.answerOptionsButtonGroup = new ButtonGroup();
        
        /*
        JLabels do not support text wrapping when given plain text to display.
        They, do, however, support text wrapping when given HTML. We take
        advantage of this by wrapping our plain welcome text in a minimal HTML
        document.
        */
        this.questionTextLabel.setText("<html><body>" + this.question.text() + "</body></html>");
        
        for(String answer : this.question.answerOptions()) {
            
            JRadioButton answerButton = new JRadioButton(answer);
            /* This allows us to know which answer has been selected in the event
               handler.
            */
            answerButton.setActionCommand(answer);
            
            /* When the user clicks the button, set the answer */
            answerButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        MultipleChoiceQuestionPanel.this.question.setAnswer(e.getActionCommand());
                    } catch (InvalidAnswerException ex) {
                        Logger.getLogger(MultipleChoiceQuestionPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            });
            
            
            this.answerOptionsButtonGroup.add(answerButton);
            
            /* This panel uses a box layout, so all buttons will appear in a
               vertical row.
            */
            this.answerOptionsPanel.add(answerButton);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questionTextLabel = new javax.swing.JLabel();
        answerOptionsPanel = new javax.swing.JPanel();

        questionTextLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        questionTextLabel.setText("Question Text");
        questionTextLabel.setToolTipText("");
        questionTextLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        answerOptionsPanel.setLayout(new javax.swing.BoxLayout(answerOptionsPanel, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(questionTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(answerOptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(questionTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answerOptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel answerOptionsPanel;
    private javax.swing.JLabel questionTextLabel;
    // End of variables declaration//GEN-END:variables
}
