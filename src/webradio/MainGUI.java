/**
 * File: MainGUI.java
 * Desc: The main gui, what's shown after a successful login
 * Allows the traversing of other GUI's
 *
 * Author: Pat Ripley
 */
package webradio;

// imports
import java.awt.KeyboardFocusManager;
import java.awt.event.*;
import javax.swing.*;

public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainGUI
     * Uses a keylistener to find F1-F6 presses
     * Only pops a new window if the MainGUI is in focus
     */
    public MainGUI() {

        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher((KeyEvent e) -> {
                    if (this.isFocusOwner()) {
                        switch (e.getKeyCode()) {
                            case KeyEvent.VK_F1:
                                profileButton.doClick();
                                break;
                            case KeyEvent.VK_F2:
                                accountButton.doClick();
                                break;
                            case KeyEvent.VK_F3:
                                taskButton.doClick();
                                break;
                            case KeyEvent.VK_F4:
                                showButton.doClick();
                                break;
                            case KeyEvent.VK_F5:
                                financeButton.doClick();
                                break;
                            case KeyEvent.VK_F6:
                                reportButton.doClick();
                                break;
                        }

                        // <editor-fold defaultstate="collapsed" desc="sooper secret settings">
                        if (e.getKeyCode() == KeyEvent.VK_S) {
                            l();
                        } else {
                        }
                        // </editor-fold>
                    }
                    return false;
                });

        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="sooper secret settings">
    void l() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher((KeyEvent e) -> {
                    if (this.isFocusOwner()) {
                        if (e.getKeyCode() == KeyEvent.VK_L) {
                            o();
                        } else {
                        }
                    }
                    return false;
                });
    }
    
    void o() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher((KeyEvent e) -> {
                    if (this.isFocusOwner()) {
                        if (e.getKeyCode() == KeyEvent.VK_O) {
                            t();
                        } else {
                        }
                    }
                    return false;
                });
    }
    
    void t() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher((KeyEvent e) -> {
                    if (this.isFocusOwner()) {
                        if (e.getKeyCode() == KeyEvent.VK_T) {
                            h();
                        } else {
                        }
                    }
                    return false;
                });
    }
    
    void h() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher((KeyEvent e) -> {
                    if (this.isFocusOwner()) {
                        if (e.getKeyCode() == KeyEvent.VK_H) {
                            logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sloth.png")));
                        } else {
                        }
                    }
                    return false;
                });
    }
    // </editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileButton = new javax.swing.JButton();
        showButton = new javax.swing.JButton();
        reportButton = new javax.swing.JButton();
        financeButton = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        accountButton = new javax.swing.JButton();
        taskButton = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        scrollpane = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        textHeader = new javax.swing.JLabel();
        f1 = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        menubar = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        logoutItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        verstionItem = new javax.swing.JMenuItem();
        devItem = new javax.swing.JMenuItem();
        thanksItem = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        helpItem = new javax.swing.JMenuItem();
        bugItem = new javax.swing.JMenuItem();
        suggestionItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("W.R.A.P. - Web Radio Assistant Program");
        setIconImage(new ImageIcon("src\\images\\imageicon.png").getImage());
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        profileButton.setText("Profiles");
        profileButton.setFocusable(false);
        profileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileButtonMouseExited(evt);
            }
        });
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        showButton.setText("Shows");
        showButton.setFocusable(false);
        showButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showButtonMouseExited(evt);
            }
        });
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        reportButton.setText("Reports");
        reportButton.setFocusable(false);
        reportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportButtonMouseExited(evt);
            }
        });
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });

        financeButton.setText("Finances");
        financeButton.setFocusable(false);
        financeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                financeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                financeButtonMouseExited(evt);
            }
        });
        financeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financeButtonActionPerformed(evt);
            }
        });

        welcomeLabel.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        welcomeLabel.setText(" ");
        welcomeLabel.setFocusCycleRoot(true);
        welcomeLabel.setFocusTraversalPolicy(null);
        welcomeLabel.setFocusable(false);

        accountButton.setText("Accounts");
        accountButton.setFocusable(false);
        accountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountButtonMouseExited(evt);
            }
        });
        accountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButtonActionPerformed(evt);
            }
        });

        taskButton.setText("Tasks");
        taskButton.setFocusable(false);
        taskButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                taskButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                taskButtonMouseExited(evt);
            }
        });
        taskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskButtonActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wraplogo smaller.png"))); // NOI18N
        logo.setFocusable(false);

        scrollpane.setFocusable(false);

        text.setEditable(false);
        text.setBackground(new java.awt.Color(250, 250, 250));
        text.setColumns(20);
        text.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        text.setRows(5);
        text.setWrapStyleWord(true);
        text.setFocusable(false);
        scrollpane.setViewportView(text);

        textHeader.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        textHeader.setText(" ");
        textHeader.setFocusable(false);

        f1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        f1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        f1.setText(" ");
        f1.setFocusCycleRoot(true);
        f1.setFocusable(false);

        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        loginLabel.setText(" ");

        menubar.setFocusable(false);

        file.setText("File");

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

        jMenu1.setText("About");

        verstionItem.setText("Version");
        verstionItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verstionItemActionPerformed(evt);
            }
        });
        jMenu1.add(verstionItem);

        devItem.setText("Developer");
        devItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devItemActionPerformed(evt);
            }
        });
        jMenu1.add(devItem);

        thanksItem.setText("Special Thanks");
        thanksItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thanksItemActionPerformed(evt);
            }
        });
        jMenu1.add(thanksItem);

        menubar.add(jMenu1);

        help.setText("Help");

        helpItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/question.png"))); // NOI18N
        helpItem.setText("Open Help...");
        helpItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpItemActionPerformed(evt);
            }
        });
        help.add(helpItem);

        bugItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bug_PNG3980.png"))); // NOI18N
        bugItem.setText("Report a bug");
        bugItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bugItemActionPerformed(evt);
            }
        });
        help.add(bugItem);

        suggestionItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gear.png"))); // NOI18N
        suggestionItem.setText("Make a suggestion");
        suggestionItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suggestionItemActionPerformed(evt);
            }
        });
        help.add(suggestionItem);

        menubar.add(help);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(profileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accountButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taskButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(financeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reportButton))
                    .addComponent(scrollpane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(f1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(f1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profileButton)
                    .addComponent(accountButton)
                    .addComponent(taskButton)
                    .addComponent(showButton)
                    .addComponent(financeButton)
                    .addComponent(reportButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(logo)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Handles when window is closed
     *
     * @param evt
     */
    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        Main.LaunchProfileGUI();
    }//GEN-LAST:event_profileButtonActionPerformed

    /**
     * Handles when Link button is pressed
     * Not implemented yet, so shows a message dialog
     *
     * @param evt
     */
    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        Main.LaunchShowGUI();

    }//GEN-LAST:event_showButtonActionPerformed

    /**
     * Handles when Finance button is pressed
     * Not implemented yet, so shows a message dialog
     *
     * @param evt
     */
    private void financeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financeButtonActionPerformed
        Main.LaunchFinanceGUI();
    }//GEN-LAST:event_financeButtonActionPerformed

    /**
     * Handles when Report button is pressed
     * Not implemented yet, so shows a message dialog
     *
     * @param evt
     */
    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        Main.LaunchReportsGUI();
    }//GEN-LAST:event_reportButtonActionPerformed

    /**
     * Handles when the window is opened
     * Set the welcome label to a personalized greeting
     *
     * @param evt
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        welcomeLabel.setText("Welcome, " + Main.getUser().getName() + "!");
        text.setText("Welcome to WRAP!!!");
    }//GEN-LAST:event_formWindowOpened

    /**
     * Handles when Accounts button is pressed
     * Checks if user is an admin, and if not, shows error message
     * If user is an admin, launch account gui
     *
     * @param evt
     */
    private void accountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountButtonActionPerformed
        Main.LaunchAccountGUI();
    }//GEN-LAST:event_accountButtonActionPerformed

    /**
     * Handles when cursor goes into the button frame
     *
     * @param evt
     */
    private void profileButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileButtonMouseEntered
        textHeader.setText("Profiles");
        text.setText("Shows DJ's information, and allows for addition, deletion, and "
                + "\nediting of DJ's.");
        f1.setText("Shortcut key: F1");
    }//GEN-LAST:event_profileButtonMouseEntered

    /**
     * Handles when cursor leaves button frame
     *
     * @param evt
     */
    private void profileButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileButtonMouseExited
        textHeader.setText("");
        text.setText("Welcome to WRAP!");
        f1.setText("");
    }//GEN-LAST:event_profileButtonMouseExited

    /**
     * Handles when cursor goes into the button frame
     *
     * @param evt
     */
    private void accountButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonMouseEntered
        textHeader.setText("Accounts");
        text.setText("Allows addition and deletion of users of W.R.A.P. along"
                + "\nwith the editing of existing users."
                + "\nNote: You can only edit your own profile.");
        f1.setText("Shortcut key: F2");
    }//GEN-LAST:event_accountButtonMouseEntered

    /**
     * Handles when cursor leaves button frame
     *
     * @param evt
     */
    private void accountButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonMouseExited
        textHeader.setText("");
        text.setText("Welcome to WRAP!");
        f1.setText("");
    }//GEN-LAST:event_accountButtonMouseExited

    /**
     * Handles when cursor goes into the button frame
     *
     * @param evt
     */
    private void taskButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taskButtonMouseEntered
        textHeader.setText("Tasks");
        text.setText("Check the DJ requirements of a member.  Four main"
                + "\ntasks: Pay dues, send in a show time and description,"
                + "\nfill out the proper paperwork, and be trained on the board.");
        f1.setText("Shortcut key: F3");
    }//GEN-LAST:event_taskButtonMouseEntered

    /**
     * Handles when cursor leaves button frame
     *
     * @param evt
     */
    private void taskButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taskButtonMouseExited
        textHeader.setText("");
        text.setText("Welcome to WRAP!");
        f1.setText("");
    }//GEN-LAST:event_taskButtonMouseExited

    /**
     * Handles when cursor goes into the button frame
     *
     * @param evt
     */
    private void showButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonMouseEntered
        textHeader.setText("Shows");
        text.setText("Allows the addition or deletion of shows where you can add"
                + "\nthe show name, description, times, and hosts.");
        f1.setText("Shortcut key: F4");
    }//GEN-LAST:event_showButtonMouseEntered

    /**
     * Handles when cursor leaves button frame
     *
     * @param evt
     */
    private void showButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonMouseExited
        textHeader.setText("");
        text.setText("Welcome to WRAP!");
        f1.setText("");
    }//GEN-LAST:event_showButtonMouseExited

    /**
     * Handles when cursor goes into the button frame
     *
     * @param evt
     */
    private void financeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_financeButtonMouseEntered
        textHeader.setText("Finances");
        text.setText("Track finances, add money, and basically"
                + "\nanything that has to do with our funds.");
        f1.setText("Shortcut key: F5");
    }//GEN-LAST:event_financeButtonMouseEntered

    /**
     * Handles when cursor leaves button frame
     *
     * @param evt
     */
    private void financeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_financeButtonMouseExited
        textHeader.setText("");
        text.setText("Welcome to WRAP!");
        f1.setText("");
    }//GEN-LAST:event_financeButtonMouseExited

    /**
     * Handles when cursor goes into the button frame
     *
     * @param evt
     */
    private void reportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButtonMouseEntered
        textHeader.setText("Reports");
        text.setText("Generate reports based on member tasks, create"
                + "\na roster, or print report on individuals.");
        f1.setText("Shortcut key: F6");
    }//GEN-LAST:event_reportButtonMouseEntered

    /**
     * Handles when cursor leaves button frame
     *
     * @param evt
     */
    private void reportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportButtonMouseExited
        textHeader.setText("");
        text.setText("Welcome to WRAP!");
        f1.setText("");
    }//GEN-LAST:event_reportButtonMouseExited

    /**
     * Handles when Task button is pressed
     * Launches TaskGUI
     *
     * @param evt
     */
    private void taskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskButtonActionPerformed
        Main.LaunchTaskGUI();
    }//GEN-LAST:event_taskButtonActionPerformed

    /**
     * Handles when logout option is chosen in file menu
     * Sends the user back to Main, creates a new loginGUI
     *
     * @param evt
     */
    private void logoutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutItemActionPerformed
        Main.Logout();
        Main.CloseMainGUI();
    }//GEN-LAST:event_logoutItemActionPerformed

    /**
     * Handles when user chooses Report Bug from help menu
     * Launches TaskGUI
     *
     * @param evt
     */
    private void bugItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bugItemActionPerformed
        Main.LaunchBugReportGUI();
    }//GEN-LAST:event_bugItemActionPerformed

    /**
     * Handles when user chooses exit from file menu
     * Launches a confirmation dialog, exits if user wishes
     *
     * @param evt
     */
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
            // do nothing and return
        }
    }//GEN-LAST:event_exitItemActionPerformed

    /**
     * Displays version
     *
     * @param evt
     */
    private void verstionItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verstionItemActionPerformed
        JOptionPane.showMessageDialog(this, "W.R.A.P. - Web Radio Assistance Program\n"
                + "Version 1.0  :D \n\n"
                + "Profiles:  Manage contact info of club members\n"
                + "Accounts:  Manage user accounts (username, password, access, and name)\n"
                + "Tasks:     Manage members' requirements to join/remain in the club\n"
                + "Shows:     Manage shows, including names, descriptions, times, and hosts");
    }//GEN-LAST:event_verstionItemActionPerformed
    /**
     * Handles if user selects suggestion option in the menu bar
     * Calls LaunchSuggestionReportGUI()
     */
    private void suggestionItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suggestionItemActionPerformed
        Main.LaunchSuggestionReportGUI();
    }//GEN-LAST:event_suggestionItemActionPerformed

    /**
     * Handles when the form is loaded
     * Sets the text with the global user
     */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        loginLabel.setText("Logged in as " + Main.p.getUsername());
    }//GEN-LAST:event_formComponentShown

    /**
     * Handles if user selects the special thanks option in the menu bar
     *
     * @param evt
     */
    private void thanksItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thanksItemActionPerformed
        JOptionPane.showMessageDialog(this,
                "Special thanks to:\n"
                + "\t- Brian Stevens, for finding a lot of initial bugs in Phase I of testing\n"
                + "\t- Steve Buscemi, for his life of influential works");
    }//GEN-LAST:event_thanksItemActionPerformed

    /**
     * Handles if user selects the Dev option in the menu bar
     *
     * @param evt
     */
    private void devItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devItemActionPerformed
        JOptionPane.showMessageDialog(this,
                "Pat Ripley\n"
                + "(618)-570-5661\n"
                + "ripley307@gmail.com\n\n"
                + "Coded independantly since Fall 2015\n"
                + "Since I don't have copyrights, please don't\n"
                + "steal my code...");
    }//GEN-LAST:event_devItemActionPerformed

    private void helpItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpItemActionPerformed
        Main.LaunchHelpGUI();
    }//GEN-LAST:event_helpItemActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountButton;
    private javax.swing.JMenuItem bugItem;
    private javax.swing.JMenuItem devItem;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JLabel f1;
    private javax.swing.JMenu file;
    private javax.swing.JButton financeButton;
    private javax.swing.JMenu help;
    private javax.swing.JMenuItem helpItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel logo;
    private javax.swing.JMenuItem logoutItem;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton reportButton;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JButton showButton;
    private javax.swing.JMenuItem suggestionItem;
    private javax.swing.JButton taskButton;
    private javax.swing.JTextArea text;
    private javax.swing.JLabel textHeader;
    private javax.swing.JMenuItem thanksItem;
    private javax.swing.JMenuItem verstionItem;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
} // end MainGUI
