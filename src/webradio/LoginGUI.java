/**
 * File: LoginGUI.java
 * Desc: First GUI to prompt user for username and password
 *
 * Author: Pat Ripley
 */
package webradio;

// imports
import java.awt.event.*;

public class LoginGUI extends javax.swing.JFrame {

    /**
     * Creates new form LoginGUI
     */
    public LoginGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        uLabel = new javax.swing.JLabel();
        pLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        headerLabel = new javax.swing.JLabel();
        SubmitButton = new javax.swing.JButton();
        ErrLabel = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        uLabel.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        uLabel.setText("Username:");

        pLabel.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        pLabel.setText("Password:");

        usernameField.setNextFocusableComponent(passwordField);
        usernameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFieldFocusGained(evt);
            }
        });
        usernameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameFieldKeyPressed(evt);
            }
        });

        passwordField.setNextFocusableComponent(usernameField);
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });

        headerLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        headerLabel.setText("Login");

        SubmitButton.setText("Submit");
        SubmitButton.setNextFocusableComponent(usernameField);
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        ErrLabel.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        ErrLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headerLabel)
                        .addGap(0, 151, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ErrLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SubmitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pLabel)
                            .addComponent(uLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameField)
                            .addComponent(passwordField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uLabel)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SubmitButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ErrLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sends the info to the submit function
     * @param evt 
     */
    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        submit();
    }//GEN-LAST:event_SubmitButtonActionPerformed

    /**
     * If enter is pressed on username field, submit()
     * @param evt 
     */
    private void usernameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            submit();
        }
    }//GEN-LAST:event_usernameFieldKeyPressed

    /**
     * If enter is pressed on password field, submit()
     * @param evt 
     */
    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            submit();
        }
    }//GEN-LAST:event_passwordFieldKeyPressed

    /**
     * Highlights all the text when username field is focused
     * @param evt 
     */
    private void usernameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFieldFocusGained
        usernameField.selectAll();
    }//GEN-LAST:event_usernameFieldFocusGained

    /**
     * Highlights all the text when password field is focused
     * @param evt 
     */
    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        passwordField.selectAll();
    }//GEN-LAST:event_passwordFieldFocusGained

    /**
     * submit()
     * 
     * Tests the input, and sees if it's valid
     * If it is, send the info to the Login() function in IOController
     * If a match is found, send it to Main to set the global user
     * Else not found, update errLabel and reset the graphics
     */
    private void submit() {

        // tests if there's actually text in the fields
        if (usernameField.getText().equals("")
                || usernameField.getText().equals("Username")
                || passwordField.getText().equals("")
                || passwordField.getText().equals("Password")) {
            usernameField.setText("");
            ErrLabel.setText("Invalid credentials");
            usernameField.requestFocus();
            return;
        }

        // tests for the split character "/"
        if (!Util.sepCheck(usernameField.getText()) || !Util.sepCheck(passwordField.getText())) {
            ErrLabel.setText("Invalid character");

            passwordField.setText("");
            usernameField.requestFocus();
            return;
        }

        // input validated, sending to AccountController
        Account res = AccountController.Login(usernameField.getText(), passwordField.getText());
        
        if (res == null) {
            // no match found
            ErrLabel.setText("Invalid credentials");
            usernameField.setText("");
            passwordField.setText("");
            usernameField.requestFocus();

        } else {
            // match found
            this.setVisible(false);
            Main.SetUser(res);
            Main.LaunchMainGUI();
        }
    }

    /**
     * main()
     * 
     * You already know what main is if you're reading this
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrLabel;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel uLabel;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
} // end LoginGUI
