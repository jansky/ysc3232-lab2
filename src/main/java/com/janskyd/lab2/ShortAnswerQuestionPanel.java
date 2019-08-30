/*
 * Copyright 2019 Ian Duncan
 * For YSC3232 Software Engineering, 2019-20 Sem 1
 */
package com.janskyd.lab2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 * A JPanel component that displays short answer questions.
 * @author Ian Duncan
 */
public class ShortAnswerQuestionPanel extends javax.swing.JPanel {
    
    private ShortAnswerExamQuestion question;

    /**
     * Creates a new JPanel component to display the given short answer question.
     * @param question
     */
    public ShortAnswerQuestionPanel(ShortAnswerExamQuestion question) {
        
        this.question = question;
        
        initComponents();
        
        /*
        JLabels do not support text wrapping when given plain text to display.
        They, do, however, support text wrapping when given HTML. We take
        advantage of this by wrapping our plain welcome text in a minimal HTML
        document.
        */
        this.questionTextLabel.setText("<html><body>" + this.question.text() + "</body></html>");
        
        // When the user updates the answer text field, update the question's
        // answer.
        this.shortAnswerTextField.getDocument().addDocumentListener(new DocumentListener() {
            
            private void updateText(DocumentEvent e) {
                Document doc = e.getDocument();
                
                
                try {
                    ShortAnswerQuestionPanel.this.question.setAnswer(doc.getText(0, doc.getLength()));
                } catch (BadLocationException ex) {
                    Logger.getLogger(ShortAnswerQuestionPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                
                updateText(e);

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateText(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateText(e);
            }
        });
        
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
        answerLabel = new javax.swing.JLabel();
        shortAnswerTextField = new javax.swing.JTextField();

        questionTextLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        questionTextLabel.setText("jLabel1");
        questionTextLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        answerLabel.setText("Answer:");
        answerLabel.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(answerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shortAnswerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 186, Short.MAX_VALUE))
            .addComponent(questionTextLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(questionTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerLabel)
                    .addComponent(shortAnswerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel answerLabel;
    private javax.swing.JLabel questionTextLabel;
    private javax.swing.JTextField shortAnswerTextField;
    // End of variables declaration//GEN-END:variables
}
