package webradio;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TaskGUI extends javax.swing.JFrame {

    public class ListElement {

        String fName, lName, id;

        public ListElement(String fName, String lName, String id) {
            this.fName = fName;
            this.lName = lName;
            this.id = id;
        }

        @Override
        public String toString() {
            return lName + ", " + fName;
        }
    }

    DefaultListModel<ListElement> people = new DefaultListModel<>();
    ListElement[] elements;
    Profile temp;

    private final int ADD = 0;
    private final int REMOVE = 1;

    public TaskGUI() {
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

        sp = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        errLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dpBox = new javax.swing.JCheckBox();
        ptiBox = new javax.swing.JCheckBox();
        sdtBox = new javax.swing.JCheckBox();
        btBox = new javax.swing.JCheckBox();
        editButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fNameField = new javax.swing.JTextField();
        lNameField = new javax.swing.JTextField();
        statusField = new javax.swing.JTextField();
        gear = new javax.swing.JLabel();
        menubar = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        closeItem = new javax.swing.JMenuItem();
        logoutItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        bugItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("W.R.A.P. - Tasks");
        setIconImage(new ImageIcon("src\\images\\imageicon.png").getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        list.setModel(FillList());
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        sp.setViewportView(list);

        errLabel.setText(" ");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Tasks for:");

        dpBox.setText("Dues Paid");
        dpBox.setEnabled(false);

        ptiBox.setText("Paperwork turned in");
        ptiBox.setEnabled(false);

        sdtBox.setText("Show Description/Time");
        sdtBox.setEnabled(false);

        btBox.setText("Board trained");
        btBox.setEnabled(false);

        editButton.setText("Edit");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.setEnabled(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Status:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Name:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("ID:");

        fNameField.setEditable(false);
        fNameField.setBackground(new java.awt.Color(255, 255, 255));

        lNameField.setEditable(false);
        lNameField.setBackground(new java.awt.Color(255, 255, 255));

        statusField.setEditable(false);
        statusField.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fNameField)
                            .addComponent(lNameField)
                            .addComponent(statusField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btBox)
                            .addComponent(dpBox)
                            .addComponent(ptiBox)
                            .addComponent(sdtBox))
                        .addGap(0, 73, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dpBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sdtBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ptiBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(editButton))
                .addContainerGap())
        );

        gear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gearMouseClicked(evt);
            }
        });

        file.setText("File");

        closeItem.setText("Close");
        closeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeItemActionPerformed(evt);
            }
        });
        file.add(closeItem);

        logoutItem.setText("Logout");
        logoutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutItemActionPerformed(evt);
            }
        });
        file.add(logoutItem);

        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        file.add(exitItem);

        menubar.add(file);

        help.setText("Help");

        bugItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bug_PNG3980.png"))); // NOI18N
        bugItem.setText("Report a bug");
        bugItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bugItemActionPerformed(evt);
            }
        });
        help.add(bugItem);

        menubar.add(help);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(gear))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(errLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errLabel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        if (!people.isEmpty()) {
            editButton.setEnabled(true);
            Show();
        } else {
            // do nothing
            // because it crashes if there's nothing in there
        }
    }//GEN-LAST:event_listMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Main.CloseTaskGUI();
    }//GEN-LAST:event_formWindowClosed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        setBoxesEnabled(true);
        editButton.setEnabled(false);
        submitButton.setEnabled(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        Submit();
        Show();

    }//GEN-LAST:event_submitButtonActionPerformed

    private void gearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gearMouseClicked
        Admin();
    }//GEN-LAST:event_gearMouseClicked

    private void closeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeItemActionPerformed
        Main.CloseTaskGUI();
    }//GEN-LAST:event_closeItemActionPerformed

    private void logoutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutItemActionPerformed
        Main.Logout();
        Main.CloseTaskGUI();
    }//GEN-LAST:event_logoutItemActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        int res = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to exit WRAP?",
                "",
                JOptionPane.YES_NO_OPTION);
        switch (res) {
            case 0:
                System.exit(0);
                break;
            default:
            // do nothing
        }
    }//GEN-LAST:event_exitItemActionPerformed

    private void bugItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bugItemActionPerformed
        Main.LaunchBugReportGUI();
    }//GEN-LAST:event_bugItemActionPerformed

    /**
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TaskGUI().setVisible(true);
        });
    }

    public DefaultListModel FillList() {
        Profile[] profiles = TaskController.sort(TaskController.getAllPeople());

        elements = new ListElement[profiles.length];
        int total = IOController.getTotalPeople();

        for (int i = 0; i < total; i++) {

            elements[i] = new ListElement(profiles[i].getfName(),
                    profiles[i].getlName(),
                    profiles[i].getId());
            people.add(i, elements[i]);
        }
        return people;
    }

    public void UpdateList(int action, ListElement element) {
        switch (action) {
            case ADD:         // add
                people.add(people.getSize(), element);
                break;
            case REMOVE:      // remove
                people.remove(list.getSelectedIndex());
                break;
        }
    }

    public void Show() {
        Profile p = ProfileController.SearchPerson(people.elementAt(list.getSelectedIndex()).id);

        fNameField.setText(p.getfName());
        lNameField.setText(p.getlName());
        if (!p.isDuesPaid() || !p.isPaperworkTurnedIn() || !p.isShowDesc() || !p.isTrained()) {
            statusField.setForeground(Color.red);
            statusField.setText("Bad");
        } else {
            statusField.setForeground(Color.blue);
            statusField.setText("Good");
        }

        dpBox.setSelected(p.isDuesPaid());
        ptiBox.setSelected(p.isPaperworkTurnedIn());
        sdtBox.setSelected(p.isShowDesc());
        btBox.setSelected(p.isTrained());
    }

    public void setBoxesEnabled(boolean b) {
        dpBox.setEnabled(b);
        ptiBox.setEnabled(b);
        sdtBox.setEnabled(b);
        btBox.setEnabled(b);
    }

    public void Submit() {
        boolean[] bool = new boolean[]{dpBox.isSelected(),
            ptiBox.isSelected(),
            sdtBox.isSelected(),
            btBox.isSelected()};

        errLabel.setForeground(Color.blue);
        errLabel.setText("Profile updated successfully");

        setBoxesEnabled(false);

        temp = IOController.SearchPerson(people.elementAt(list.getSelectedIndex()).id);
        Profile p = temp;

        ListElement t = new ListElement(p.getfName(),
                p.getlName(),
                p.getId());

        p.setDuesPaid(bool[0]);
        p.setPaperworkTurnedIn(bool[1]);
        p.setShowDesc(bool[2]);
        p.setTrained(bool[3]);

        ProfileController.DeletePerson(temp.getId());
        ProfileController.AddProfile(p);

        ListElement q = new ListElement(p.getfName(),
                p.getlName(),
                p.getId());

        UpdateList(REMOVE, t);
        UpdateList(ADD, q);

        submitButton.setEnabled(false);
        list.setSelectedIndex(list.getLastVisibleIndex());
    }

    public void Admin() {

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox btBox;
    private javax.swing.JMenuItem bugItem;
    private javax.swing.JMenuItem closeItem;
    private javax.swing.JCheckBox dpBox;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel errLabel;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JTextField fNameField;
    private javax.swing.JMenu file;
    private javax.swing.JLabel gear;
    private javax.swing.JMenu help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lNameField;
    private javax.swing.JList<String> list;
    private javax.swing.JMenuItem logoutItem;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JCheckBox ptiBox;
    private javax.swing.JCheckBox sdtBox;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTextField statusField;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
