/**
 * File: FinanceGUI.java
 * Desc: Sends input to FinanceController and handles all the GUI related events
 *
 * Author: Pat Ripley
 */
package webradio;

// imports
import java.awt.Color;
import java.awt.Desktop;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class FinanceGUI extends javax.swing.JFrame {

    /**
     * Minor inner class used to create the list on the right side of the panel
     */
    // <editor-fold defaultstate="collapsed" desc="ListElement">
    public class ListElement {

        String amount, store, id;

        public ListElement(String amount, String store, String id) {
            this.amount = amount;
            this.store = store;
            this.id = id;
        }

        @Override
        public String toString() {
            double d = Double.valueOf(amount);
            return "$" + money.format(d) + " - " + store;
        }
    }
    // </editor-fold>

    /**
     * Minor inner class used to limit th amount of text in a text field
     */
    // <editor-fold defaultstate="collapsed" desc="JTextFieldLimit">
    class JTextFieldLimit extends PlainDocument {

        private final int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        JTextFieldLimit(int limit, boolean upper) {
            super();
            this.limit = limit;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) {
            if (str == null) {
                return;
            }

            if ((getLength() + str.length()) <= limit) {
                try {
                    super.insertString(offset, str, attr);
                } catch (BadLocationException ex) {
                    Util.error(ex.toString(), ex.getMessage());
                }
            }
        }
    }
    // </editor-fold>

    // things that have to do with money
    DecimalFormat money = new DecimalFormat("0.00");
    double pennies;
    double nickels;
    double dimes;
    double quarters;
    double halfdollars;
    double dollarcoins;
    double dollars;
    double fives;
    double tens;
    double twenties;
    double fifties;
    double hundreds;

    // transaction variables, global list of transactions and temp for editing
    DefaultListModel<ListElement> transactions = new DefaultListModel<>();
    DefaultComboBoxModel<String> days = new DefaultComboBoxModel<>();
    Transaction temp;

    public static final int ADD = 0;
    public static final int REMOVE = 1;

    /**
     * Creates new form FinanceGUI
     */
    public FinanceGUI() {

        // picks up enter being pressed
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher((KeyEvent e) -> {
                    if (e.getID() == KeyEvent.KEY_PRESSED) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (tabs.getTitleAt(tabs.getSelectedIndex()).equals("Transactions")) {
                                if (transTabs.getTitleAt(transTabs.getSelectedIndex()).equals("Search")) {
                                    if (submitButton.isEnabled()) {
                                        submitButton.doClick();
                                    }
                                } else if (transTabs.getTitleAt(transTabs.getSelectedIndex()).equals("Add")) {
                                    addButton.doClick();
                                }
                            } else if (tabs.getTitleAt(tabs.getSelectedIndex()).equals("Accounts")) {
                                if (accountsTabs.getTitleAt(accountsTabs.getSelectedIndex()).equals("Bank Account")) {
                                    if (bankSubmitButton.isEnabled()) {
                                        bankSubmitButton.doClick();
                                        bankEditButton.requestFocus();
                                    }
                                } else if (accountsTabs.getTitleAt(accountsTabs.getSelectedIndex()).equals("Cash")) {
                                    if (cashSubmitButton.isEnabled()) {
                                        cashSubmitButton.doClick();
                                        cashEditButton.requestFocus();
                                    }
                                } else if (accountsTabs.getTitleAt(accountsTabs.getSelectedIndex()).equals("8-Account")) {
                                    if (ateSubmitButton.isEnabled()) {
                                        ateSubmitButton.doClick();
                                        ateEditButton.requestFocus();
                                    }
                                }
                            }
                        }
                    } else {
                        // don't pick up keytyped or keyreleased
                    }
                    return false;
                });

        // inits the components
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

        tabs = new javax.swing.JTabbedPane();
        transactionPanel = new javax.swing.JPanel();
        transTabs = new javax.swing.JTabbedPane();
        searchPanel = new javax.swing.JPanel();
        L1 = new javax.swing.JLabel();
        L2 = new javax.swing.JLabel();
        L3 = new javax.swing.JLabel();
        L4 = new javax.swing.JLabel();
        L5 = new javax.swing.JLabel();
        L6 = new javax.swing.JLabel();
        sStoreField = new javax.swing.JTextField();
        sMonthBox = new javax.swing.JComboBox<>();
        sDateBox = new javax.swing.JComboBox<>();
        sYearBox = new javax.swing.JComboBox<>();
        sPurchaserField = new javax.swing.JTextField();
        sAmountField = new javax.swing.JFormattedTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        sReasonField = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        sNotesField = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        addPanel = new javax.swing.JPanel();
        L7 = new javax.swing.JLabel();
        L8 = new javax.swing.JLabel();
        L9 = new javax.swing.JLabel();
        L10 = new javax.swing.JLabel();
        L11 = new javax.swing.JLabel();
        L12 = new javax.swing.JLabel();
        aStoreField = new javax.swing.JTextField();
        aMonthBox = new javax.swing.JComboBox<>();
        aDateBox = new javax.swing.JComboBox<>();
        aYearBox = new javax.swing.JComboBox<>();
        aPurchaserField = new javax.swing.JTextField();
        aAmountField = new javax.swing.JFormattedTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        aReasonField = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        aNotesField = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        accountsPanel = new javax.swing.JPanel();
        accountsTabs = new javax.swing.JTabbedPane();
        bankPanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        bankField = new javax.swing.JTextField();
        bankSubmitButton = new javax.swing.JButton();
        bankEditButton = new javax.swing.JButton();
        cashPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        cashField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cashEditButton = new javax.swing.JButton();
        cashSubmitButton = new javax.swing.JButton();
        atePanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        ateField = new javax.swing.JTextField();
        ateEditButton = new javax.swing.JButton();
        ateSubmitButton = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        totalField = new javax.swing.JTextField();
        moneycounterPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pennyL = new javax.swing.JLabel();
        nickelL = new javax.swing.JLabel();
        dimeL = new javax.swing.JLabel();
        quarterL = new javax.swing.JLabel();
        halfdollarL = new javax.swing.JLabel();
        dollarcoinL = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        totalL = new javax.swing.JLabel();
        pennySpinner = new javax.swing.JSpinner();
        nickelSpinner = new javax.swing.JSpinner();
        dimeSpinner = new javax.swing.JSpinner();
        quarterSpinner = new javax.swing.JSpinner();
        halfdollarSpinner = new javax.swing.JSpinner();
        dollarcoinSpinner = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        dollarSpinner = new javax.swing.JSpinner();
        dollarL = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fiveSpinner = new javax.swing.JSpinner();
        fiveL = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tenSpinner = new javax.swing.JSpinner();
        tenL = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        twentySpinner = new javax.swing.JSpinner();
        twentyL = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fiftySpinner = new javax.swing.JSpinner();
        fiftyL = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        hundredSpinner = new javax.swing.JSpinner();
        hundredL = new javax.swing.JLabel();
        errLabel = new javax.swing.JLabel();
        adminLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        calcButton = new javax.swing.JButton();
        menubar = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        closeItem = new javax.swing.JMenuItem();
        logoutItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        links = new javax.swing.JMenu();
        webradioItem = new javax.swing.JMenuItem();
        SIUeMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        profilesMenu = new javax.swing.JMenu();
        collegiatelinkItem = new javax.swing.JMenuItem();
        facebookItem = new javax.swing.JMenuItem();
        financesMenu = new javax.swing.JMenu();
        paypalItem = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        helpItem = new javax.swing.JMenuItem();
        bugItem = new javax.swing.JMenuItem();
        suggestionItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("W.R.A.P. - Finances");
        setIconImage(new ImageIcon("src/images/goose.png").getImage());
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        L1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L1.setText("Store:");

        L2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L2.setText("Date:");

        L3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L3.setText("Purchaser:");

        L4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L4.setText("Amount:");

        L5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L5.setText("Reason:");

        L6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L6.setText("Notes:");

        sStoreField.setEditable(false);
        sStoreField.setFocusCycleRoot(true);
        sStoreField.setNextFocusableComponent(sMonthBox);
        sStoreField.setPreferredSize(new java.awt.Dimension(166, 20));
        sStoreField.setDocument(new JTextFieldLimit(30));
        sStoreField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sStoreFieldFocusGained(evt);
            }
        });

        sMonthBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        sMonthBox.setEnabled(false);
        sMonthBox.setNextFocusableComponent(sDateBox);
        sMonthBox.setPreferredSize(new java.awt.Dimension(74, 20));
        sMonthBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMonthBoxActionPerformed(evt);
            }
        });

        sDateBox.setModel(sUpdateDayBoxModel(0));
        sDateBox.setEnabled(false);
        sDateBox.setNextFocusableComponent(sYearBox);
        sDateBox.setPreferredSize(new java.awt.Dimension(75, 20));

        sYearBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));
        sYearBox.setEnabled(false);
        sYearBox.setNextFocusableComponent(sPurchaserField);
        sYearBox.setPreferredSize(new java.awt.Dimension(72, 20));
        sYearBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sYearBoxActionPerformed(evt);
            }
        });

        sPurchaserField.setEditable(false);
        sPurchaserField.setNextFocusableComponent(sAmountField);
        sPurchaserField.setPreferredSize(new java.awt.Dimension(166, 20));
        sPurchaserField.setDocument(new JTextFieldLimit(30));
        sPurchaserField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sPurchaserFieldFocusGained(evt);
            }
        });

        sAmountField.setEditable(false);
        sAmountField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        sAmountField.setNextFocusableComponent(sReasonField);
        sAmountField.setPreferredSize(new java.awt.Dimension(166, 20));
        sAmountField.setDocument(new JTextFieldLimit(10));
        sAmountField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sAmountFieldFocusGained(evt);
            }
        });

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        sReasonField.setEditable(false);
        sReasonField.setBackground(new java.awt.Color(240, 240, 240));
        sReasonField.setColumns(20);
        sReasonField.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        sReasonField.setLineWrap(true);
        sReasonField.setRows(5);
        sReasonField.setTabSize(0);
        sReasonField.setWrapStyleWord(true);
        sReasonField.setNextFocusableComponent(sNotesField);
        sReasonField.setPreferredSize(new java.awt.Dimension(166, 76));
        sReasonField.setDocument(new JTextFieldLimit(60));
        sReasonField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sReasonFieldFocusGained(evt);
            }
        });
        sReasonField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sReasonFieldKeyPressed(evt);
            }
        });
        jScrollPane8.setViewportView(sReasonField);
        sReasonField.setTabSize(0);

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        sNotesField.setEditable(false);
        sNotesField.setBackground(new java.awt.Color(240, 240, 240));
        sNotesField.setColumns(20);
        sNotesField.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        sNotesField.setLineWrap(true);
        sNotesField.setRows(5);
        sNotesField.setTabSize(0);
        sNotesField.setWrapStyleWord(true);
        sNotesField.setNextFocusableComponent(sStoreField);
        sNotesField.setPreferredSize(new java.awt.Dimension(166, 76));
        sNotesField.setDocument(new JTextFieldLimit(60));
        sNotesField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sNotesFieldFocusGained(evt);
            }
        });
        sNotesField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sNotesFieldKeyPressed(evt);
            }
        });
        jScrollPane9.setViewportView(sNotesField);
        sNotesField.setTabSize(0);

        submitButton.setText("Submit");
        submitButton.setEnabled(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(0, 46, Short.MAX_VALUE)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitButton))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(L5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(L6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchPanelLayout.createSequentialGroup()
                                .addComponent(sMonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sDateBox, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sYearBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(sPurchaserField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sStoreField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane9)
                            .addComponent(jScrollPane8)
                            .addComponent(sAmountField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sStoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sYearBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sMonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sDateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(L2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sPurchaserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L4))
                .addGap(8, 8, 8)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L6)))
                    .addComponent(L5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        transTabs.addTab("Search", searchPanel);

        L7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L7.setText("Store:");

        L8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L8.setText("Date:");

        L9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L9.setText("Purchaser:");

        L10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L10.setText("Amount:");

        L11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L11.setText("Notes:");

        L12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        L12.setText("Reason:");

        aStoreField.setFocusCycleRoot(true);
        aStoreField.setMinimumSize(new java.awt.Dimension(166, 20));
        aStoreField.setNextFocusableComponent(aMonthBox);
        aStoreField.setPreferredSize(new java.awt.Dimension(166, 20));
        aStoreField.setDocument(new JTextFieldLimit(30));
        aStoreField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aStoreFieldFocusGained(evt);
            }
        });

        aMonthBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        aMonthBox.setName(""); // NOI18N
        aMonthBox.setNextFocusableComponent(aDateBox);
        aMonthBox.setPreferredSize(new java.awt.Dimension(74, 20));
        aMonthBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aMonthBoxActionPerformed(evt);
            }
        });

        aDateBox.setModel(aUpdateDayBoxModel(0));
        aDateBox.setNextFocusableComponent(aYearBox);
        aDateBox.setPreferredSize(new java.awt.Dimension(66, 20));

        aYearBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));
        aYearBox.setNextFocusableComponent(aPurchaserField);
        aYearBox.setPreferredSize(new java.awt.Dimension(82, 20));
        aYearBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aYearBoxActionPerformed(evt);
            }
        });

        aPurchaserField.setNextFocusableComponent(aAmountField);
        aPurchaserField.setPreferredSize(new java.awt.Dimension(166, 20));
        aPurchaserField.setDocument(new JTextFieldLimit(30));
        aPurchaserField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aPurchaserFieldFocusGained(evt);
            }
        });

        aAmountField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        aAmountField.setNextFocusableComponent(aReasonField);
        aAmountField.setPreferredSize(new java.awt.Dimension(166, 20));
        aAmountField.setDocument(new JTextFieldLimit(10));
        aAmountField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aAmountFieldFocusGained(evt);
            }
        });

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        aReasonField.setColumns(20);
        aReasonField.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        aReasonField.setLineWrap(true);
        aReasonField.setRows(5);
        aReasonField.setTabSize(0);
        aReasonField.setWrapStyleWord(true);
        aReasonField.setNextFocusableComponent(aNotesField);
        aReasonField.setPreferredSize(new java.awt.Dimension(166, 76));
        aReasonField.setDocument(new JTextFieldLimit(60));
        aReasonField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aReasonFieldFocusGained(evt);
            }
        });
        aReasonField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                aReasonFieldKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(aReasonField);
        aReasonField.setTabSize(0);

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        aNotesField.setColumns(20);
        aNotesField.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        aNotesField.setLineWrap(true);
        aNotesField.setRows(5);
        aNotesField.setTabSize(0);
        aNotesField.setWrapStyleWord(true);
        aNotesField.setNextFocusableComponent(aStoreField);
        aNotesField.setPreferredSize(new java.awt.Dimension(166, 76));
        aNotesField.setDocument(new JTextFieldLimit(60));
        aNotesField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aNotesFieldFocusGained(evt);
            }
        });
        aNotesField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                aNotesFieldKeyPressed(evt);
            }
        });
        jScrollPane6.setViewportView(aNotesField);
        aNotesField.setTabSize(0);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(L12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(L10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(L8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(L9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(L11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(L7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addPanelLayout.createSequentialGroup()
                                .addComponent(aMonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aDateBox, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aYearBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(aStoreField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aPurchaserField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aAmountField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton)))
                .addContainerGap())
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aStoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aMonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aDateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aYearBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aPurchaserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L10))
                .addGap(8, 8, 8)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L11)))
                    .addComponent(L12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        transTabs.addTab("Add", addPanel);

        list.setModel(fillList());
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(list);

        javax.swing.GroupLayout transactionPanelLayout = new javax.swing.GroupLayout(transactionPanel);
        transactionPanel.setLayout(transactionPanelLayout);
        transactionPanelLayout.setHorizontalGroup(
            transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transTabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );
        transactionPanelLayout.setVerticalGroup(
            transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionPanelLayout.createSequentialGroup()
                .addGroup(transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(transactionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(transTabs))
                    .addGroup(transactionPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane7)))
                .addContainerGap())
        );

        transTabs.getAccessibleContext().setAccessibleName("Add");

        tabs.addTab("Transactions", transactionPanel);

        accountsTabs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                accountsTabsStateChanged(evt);
            }
        });

        jLabel15.setText("Account with the Bank of Edwardsville:");

        jLabel16.setText("Balance:");

        bankField.setEditable(false);
        bankField.setBackground(new java.awt.Color(255, 255, 255));

        bankSubmitButton.setText("Submit");
        bankSubmitButton.setEnabled(false);
        bankSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankSubmitButtonActionPerformed(evt);
            }
        });

        bankEditButton.setText("Edit");
        bankEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankEditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bankPanelLayout = new javax.swing.GroupLayout(bankPanel);
        bankPanel.setLayout(bankPanelLayout);
        bankPanelLayout.setHorizontalGroup(
            bankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bankPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bankPanelLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bankField)))
                .addContainerGap(270, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bankPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bankEditButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bankSubmitButton)
                .addContainerGap())
        );
        bankPanelLayout.setVerticalGroup(
            bankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bankPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(bankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(bankField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bankSubmitButton)
                    .addComponent(bankEditButton))
                .addContainerGap())
        );

        accountsTabs.addTab("Bank Account", bankPanel);

        jLabel18.setText("Balance:");

        cashField.setEditable(false);
        cashField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setText("Cash (in cash box):");

        cashEditButton.setText("Edit");
        cashEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashEditButtonActionPerformed(evt);
            }
        });

        cashSubmitButton.setText("Submit");
        cashSubmitButton.setEnabled(false);
        cashSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashSubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cashPanelLayout = new javax.swing.GroupLayout(cashPanel);
        cashPanel.setLayout(cashPanelLayout);
        cashPanelLayout.setHorizontalGroup(
            cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cashPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(cashPanelLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cashField))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(270, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cashPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cashEditButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cashSubmitButton)
                .addContainerGap())
        );
        cashPanelLayout.setVerticalGroup(
            cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cashPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addGroup(cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cashField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cashSubmitButton)
                    .addComponent(cashEditButton))
                .addContainerGap())
        );

        accountsTabs.addTab("Cash", cashPanel);

        jLabel17.setText("8-Account with SIUE:");

        jLabel19.setText("Balance:");

        ateField.setEditable(false);
        ateField.setBackground(new java.awt.Color(255, 255, 255));

        ateEditButton.setText("Edit");
        ateEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ateEditButtonActionPerformed(evt);
            }
        });

        ateSubmitButton.setText("Submit");
        ateSubmitButton.setEnabled(false);
        ateSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ateSubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout atePanelLayout = new javax.swing.GroupLayout(atePanel);
        atePanel.setLayout(atePanelLayout);
        atePanelLayout.setHorizontalGroup(
            atePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(atePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addGroup(atePanelLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ateField)))
                .addContainerGap(270, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, atePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ateEditButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ateSubmitButton)
                .addContainerGap())
        );
        atePanelLayout.setVerticalGroup(
            atePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(atePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(ateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(atePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ateSubmitButton)
                    .addComponent(ateEditButton))
                .addContainerGap())
        );

        accountsTabs.addTab("8-Account", atePanel);

        jLabel21.setText("Total funds:");

        totalField.setEditable(false);
        totalField.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout accountsPanelLayout = new javax.swing.GroupLayout(accountsPanel);
        accountsPanel.setLayout(accountsPanelLayout);
        accountsPanelLayout.setHorizontalGroup(
            accountsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accountsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accountsTabs)
                    .addGroup(accountsPanelLayout.createSequentialGroup()
                        .addGroup(accountsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        accountsPanelLayout.setVerticalGroup(
            accountsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accountsTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        tabs.addTab("Accounts", accountsPanel);

        moneycounterPanel.setName("Funds Calc"); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Amount");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Pennies:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Nickels:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Dimes:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Quarters:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Half Dollars:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Dollar Coins:");

        pennyL.setText("$0.00");

        nickelL.setText("$0.00");

        dimeL.setText("$0.00");

        quarterL.setText("$0.00");

        halfdollarL.setText("$0.00");

        dollarcoinL.setText("$0.00");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Total:");

        totalL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalL.setText("$0.00");

        pennySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        pennySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pennySpinnerStateChanged(evt);
            }
        });

        nickelSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        nickelSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nickelSpinnerStateChanged(evt);
            }
        });

        dimeSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        dimeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dimeSpinnerStateChanged(evt);
            }
        });

        quarterSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        quarterSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                quarterSpinnerStateChanged(evt);
            }
        });

        halfdollarSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        halfdollarSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                halfdollarSpinnerStateChanged(evt);
            }
        });

        dollarcoinSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        dollarcoinSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dollarcoinSpinnerStateChanged(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Dollars:");

        dollarSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        dollarSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dollarSpinnerStateChanged(evt);
            }
        });

        dollarL.setText("$0.00");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Fives:");

        fiveSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        fiveSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fiveSpinnerStateChanged(evt);
            }
        });

        fiveL.setText("$0.00");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Tens:");

        tenSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        tenSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tenSpinnerStateChanged(evt);
            }
        });

        tenL.setText("$0.00");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Twenties:");

        twentySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        twentySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                twentySpinnerStateChanged(evt);
            }
        });

        twentyL.setText("$0.00");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Fifties:");

        fiftySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        fiftySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fiftySpinnerStateChanged(evt);
            }
        });

        fiftyL.setText("$0.00");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Hundreds:");

        hundredSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        hundredSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hundredSpinnerStateChanged(evt);
            }
        });

        hundredL.setText("$0.00");

        javax.swing.GroupLayout moneycounterPanelLayout = new javax.swing.GroupLayout(moneycounterPanel);
        moneycounterPanel.setLayout(moneycounterPanelLayout);
        moneycounterPanelLayout.setHorizontalGroup(
            moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moneycounterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(moneycounterPanelLayout.createSequentialGroup()
                        .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(moneycounterPanelLayout.createSequentialGroup()
                                .addComponent(pennySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 101, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalL, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(100, Short.MAX_VALUE))
                    .addGroup(moneycounterPanelLayout.createSequentialGroup()
                        .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pennyL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, moneycounterPanelLayout.createSequentialGroup()
                                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nickelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quarterSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(halfdollarSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dollarcoinSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dollarSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fiveSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tenSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(twentySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fiftySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hundredSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dimeL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(quarterL, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(halfdollarL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dollarcoinL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dollarL, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(fiveL, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(tenL, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(twentyL, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(fiftyL, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(hundredL, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(nickelL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        moneycounterPanelLayout.setVerticalGroup(
            moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moneycounterPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalL)
                        .addComponent(jLabel14))
                    .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(pennyL)
                        .addComponent(pennySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nickelL)
                    .addComponent(nickelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dimeL)
                    .addComponent(dimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(quarterL)
                    .addComponent(quarterSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(halfdollarL)
                    .addComponent(halfdollarSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dollarcoinL)
                    .addComponent(dollarcoinSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dollarSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dollarL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fiveSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tenSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(twentySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twentyL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fiftyL, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(fiftySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moneycounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(hundredSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hundredL))
                .addGap(0, 106, Short.MAX_VALUE))
        );

        tabs.addTab("Funds Calculator", moneycounterPanel);

        errLabel.setText(" ");

        adminLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gear.png"))); // NOI18N
        adminLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminLabelMouseExited(evt);
            }
        });

        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        loginLabel.setText(" ");

        calcButton.setText("Open Local Calculator");
        calcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcButtonActionPerformed(evt);
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

        links.setText("Links");

        webradioItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imageicon.png"))); // NOI18N
        webradioItem.setText("Web Radio");
        webradioItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webradioItemActionPerformed(evt);
            }
        });
        links.add(webradioItem);

        SIUeMenu.setText("SIUe");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/e.PNG"))); // NOI18N
        jMenuItem1.setText("Homepage");
        SIUeMenu.add(jMenuItem1);

        links.add(SIUeMenu);

        profilesMenu.setText("Profiles");

        collegiatelinkItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/collegiatelink.png"))); // NOI18N
        collegiatelinkItem.setText("CollegiateLink");
        collegiatelinkItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collegiatelinkItemActionPerformed(evt);
            }
        });
        profilesMenu.add(collegiatelinkItem);

        facebookItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/facebook.png"))); // NOI18N
        facebookItem.setText("Facebook (Show Hosts)");
        facebookItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facebookItemActionPerformed(evt);
            }
        });
        profilesMenu.add(facebookItem);

        links.add(profilesMenu);

        financesMenu.setText("Finances");

        paypalItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/paypal.png"))); // NOI18N
        paypalItem.setText("PayPal");
        paypalItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paypalItemActionPerformed(evt);
            }
        });
        financesMenu.add(paypalItem);

        links.add(financesMenu);

        menubar.add(links);

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
                    .addComponent(tabs)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(errLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(calcButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(calcButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Literally all event related methods Includes:
     *
     * Add, Submit, and Edit : calls outside methods for Transactions FormWindow
     * events : closing, opening ListClicked : searches for element that was
     * clicked MenuBar things : things in the menu bar (exit, close, logout,
     * help, bug, etc) GainFocus : selects all text in the field when field
     * gains focus EnterKeyPressed : clicks a button when enter is pressed
     */
    // <editor-fold defaultstate="collapsed" desc="Literally all event-related methods"> 
    /**
     * Handles when user closes the window
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Main.CloseFinanceGUI();
    }//GEN-LAST:event_formWindowClosed

    /**
     * Handles when user chooses close option in menu bar
     */
    private void closeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeItemActionPerformed
        Main.CloseFinanceGUI();
    }//GEN-LAST:event_closeItemActionPerformed

    /**
     * Handles when user chooses logout option in menu bar
     */
    private void logoutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutItemActionPerformed
        Main.Logout();
        Main.CloseFinanceGUI();
        Main.CloseMainGUI();
    }//GEN-LAST:event_logoutItemActionPerformed

    /**
     * Handles when user chooses exit option in menu bar
     */
    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        int res = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to exit WRAP?",
                "",
                JOptionPane.YES_NO_OPTION);

        // do a thing based on response
        switch (res) {
            case 0:
                System.exit(0);
                break;
            default:
            // do nothing
        }
    }//GEN-LAST:event_exitItemActionPerformed

    /**
     * Handles when user chooses Help option in menu bar
     */
    private void helpItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpItemActionPerformed
        Main.LaunchHelpGUI();
    }//GEN-LAST:event_helpItemActionPerformed

    /**
     * Handles when user chooses "Report a Bug" option in menu bar
     */
    private void bugItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bugItemActionPerformed
        Main.LaunchBugReportGUI();
    }//GEN-LAST:event_bugItemActionPerformed

    /**
     * Handles when user chooses "Make a Suggestion" option in menu bar
     */
    private void suggestionItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suggestionItemActionPerformed
        Main.LaunchSuggestionReportGUI();
    }//GEN-LAST:event_suggestionItemActionPerformed

    /**
     * Handles when the specified spinner value is changed Updates the label
     * associated with it as well as the total label
     */
    private void pennySpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pennySpinnerStateChanged
        pennies = Integer.valueOf(pennySpinner.getValue().toString());
        double d = pennies / 100;
        pennyL.setText("$" + money.format(d));
        updateTotal();
    }//GEN-LAST:event_pennySpinnerStateChanged

    /**
     * Handles when the specified spinner value is changed Updates the label
     * associated with it as well as the total label
     */
    private void nickelSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nickelSpinnerStateChanged
        nickels = Integer.valueOf(nickelSpinner.getValue().toString());
        double d = nickels / 20;
        nickelL.setText("$" + money.format(d));
        updateTotal();
    }//GEN-LAST:event_nickelSpinnerStateChanged

    /**
     * Handles when the specified spinner value is changed Updates the label
     * associated with it as well as the total label
     */
    private void dimeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dimeSpinnerStateChanged
        dimes = Integer.valueOf(dimeSpinner.getValue().toString());
        double d = dimes / 10;
        dimeL.setText("$" + money.format(d));
        updateTotal();
    }//GEN-LAST:event_dimeSpinnerStateChanged

    /**
     * Handles when the specified spinner value is changed Updates the label
     * associated with it as well as the total label
     */
    private void quarterSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_quarterSpinnerStateChanged
        quarters = Integer.valueOf(quarterSpinner.getValue().toString());
        double d = quarters / 4;
        quarterL.setText("$" + money.format(d));
        updateTotal();
    }//GEN-LAST:event_quarterSpinnerStateChanged

    /**
     * Handles when the specified spinner value is changed Updates the label
     * associated with it as well as the total label
     */
    private void halfdollarSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_halfdollarSpinnerStateChanged
        halfdollars = Integer.valueOf(halfdollarSpinner.getValue().toString());
        double d = halfdollars / 2;
        halfdollarL.setText("$" + money.format(d));
        updateTotal();
    }//GEN-LAST:event_halfdollarSpinnerStateChanged

    /**
     * Handles when the specified spinner value is changed Updates the label
     * associated with it as well as the total label
     */
    private void dollarcoinSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dollarcoinSpinnerStateChanged
        dollarcoins = Integer.valueOf(dollarcoinSpinner.getValue().toString());
        double d = dollarcoins;
        dollarcoinL.setText("$" + money.format(d));
        updateTotal();
    }//GEN-LAST:event_dollarcoinSpinnerStateChanged

    /**
     * Handles when the specified spinner value is changed Updates the label
     * associated with it as well as the total label
     */
    private void dollarSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dollarSpinnerStateChanged
        dollars = Integer.valueOf(dollarSpinner.getValue().toString());
        double d = dollars;
        dollarL.setText("$" + money.format(d));
        updateTotal();
    }//GEN-LAST:event_dollarSpinnerStateChanged

    /**
     * Handles when the specified spinner value is changed Updates the label
     * associated with it as well as the total label
     */
    private void fiveSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fiveSpinnerStateChanged
        fives = Integer.valueOf(fiveSpinner.getValue().toString());
        double d = fives * 5;
        fiveL.setText("$" + money.format(d));
        updateTotal();
    }//GEN-LAST:event_fiveSpinnerStateChanged

    /**
     * Handles when the specified spinner value is changed Updates the label
     * associated with it as well as the total label
     */
    private void tenSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tenSpinnerStateChanged
        tens = Integer.valueOf(tenSpinner.getValue().toString());
        double d = tens * 10;
        tenL.setText("$" + money.format(d));
        updateTotal();
    }//GEN-LAST:event_tenSpinnerStateChanged

    /**
     * Handles when the specified spinner value is changed Updates the label
     * associated with it as well as the total label
     */
    private void twentySpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_twentySpinnerStateChanged
        twenties = Integer.valueOf(twentySpinner.getValue().toString());
        double d = twenties * 20;
        twentyL.setText("$" + money.format(d));
        updateTotal();
    }//GEN-LAST:event_twentySpinnerStateChanged

    /**
     * Handles when the specified spinner value is changed Updates the label
     * associated with it as well as the total label
     */
    private void fiftySpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fiftySpinnerStateChanged
        fifties = Integer.valueOf(fiftySpinner.getValue().toString());
        double d = fifties * 50;
        fiftyL.setText("$" + money.format(d));
        updateTotal();
    }//GEN-LAST:event_fiftySpinnerStateChanged

    /**
     * Handles when the specified spinner value is changed Updates the label
     * associated with it as well as the total label
     */
    private void hundredSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hundredSpinnerStateChanged
        hundreds = Integer.valueOf(hundredSpinner.getValue().toString());
        double d = hundreds * 100;
        hundredL.setText("$" + money.format(d));
        updateTotal();
    }//GEN-LAST:event_hundredSpinnerStateChanged

    /**
     * Handles when the gear icon is clicked on
     */
    private void adminLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLabelMouseClicked
        // admin();
    }//GEN-LAST:event_adminLabelMouseClicked

    /**
     * Handles when the mouse enters the gear icon
     */
    private void adminLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLabelMouseEntered
        //loginLabel.setText("Advanced options");
    }//GEN-LAST:event_adminLabelMouseEntered

    /**
     * Handles when the mouse leaves the gear icon
     */
    private void adminLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLabelMouseExited
        //loginLabel.setText("Logged in as " + Main.p.getUsername());
    }//GEN-LAST:event_adminLabelMouseExited

    /**
     * Handles when "Launch Local Calculator" button is clicked Opens the local
     * calculator
     */
    private void calcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonActionPerformed
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException ex) {
            Util.error(ex.toString(), ex.getMessage());

        }
    }//GEN-LAST:event_calcButtonActionPerformed

    /**
     * Handles when add button is pressed on Transactions panel
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (aCheck()) {
            add();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * Handles when the list is clicked on on Transactions panel
     */
    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        if (!transactions.isEmpty()) {

            // graphics update
            submitButton.setEnabled(false);
            editButton.setEnabled(true);
            deleteButton.setEnabled(true);
            setSearchFieldsEditable(false);

            // search for the profile
            search(transactions.elementAt(list.getSelectedIndex()).id);

            // if search tab is not in focus, put it in focus
            transTabs.setSelectedIndex(0);
        } else {
            // do nothing
            // it'll crash otherwise
        }
    }//GEN-LAST:event_listMouseClicked

    /**
     * Handles when edit button is pressed on Transactions panel
     */
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        edit();
    }//GEN-LAST:event_editButtonActionPerformed

    /**
     * Handles when submit button is pressed on Transactions panel
     */
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if (sCheck()) {
            submit();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    /**
     * Handles when delete button is pressed on Transactions panel
     */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // confirmation on delete
        int res = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to delete the transaction from\n"
                + sStoreField.getText() + " for "
                + sAmountField.getText() + "?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);

        // if they select yes
        switch (res) {
            case 0:
                delete();
                break;
            default:
                // do nothing
                break;
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * Handles when the form is shown Updates loginLabel Updates account totals
     * on the accounts tab
     */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        loginLabel.setText("Logged in as " + Main.p.getUsername());

        double[] d = FinanceController.getAccountTotals();
        bankField.setText("$" + money.format(d[0]));
        cashField.setText("$" + money.format(d[1]));
        ateField.setText("$" + money.format(d[2]));

        double total = d[0] + d[1] + d[2];
        totalField.setText("$" + money.format(total));

    }//GEN-LAST:event_formComponentShown

    /**
     * Handles when submit is pressed on bank tab in Accounts tab
     */
    private void bankEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankEditButtonActionPerformed
        bankField.setEditable(true);
        bankSubmitButton.setEnabled(true);
        bankEditButton.setEnabled(false);
        bankField.requestFocus();
        bankField.selectAll();
    }//GEN-LAST:event_bankEditButtonActionPerformed

    /**
     * Handles when edit is pressed on cash tab in Accounts tab
     */
    private void cashEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashEditButtonActionPerformed
        cashField.setEditable(true);
        cashSubmitButton.setEnabled(true);
        cashEditButton.setEnabled(false);
        cashField.requestFocus();
        cashField.selectAll();
    }//GEN-LAST:event_cashEditButtonActionPerformed

    /**
     * Handles when edit is pressed on 8-Account tab in Accounts tab
     */
    private void ateEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ateEditButtonActionPerformed
        ateField.setEditable(true);
        ateSubmitButton.setEnabled(true);
        ateEditButton.setEnabled(false);
        ateField.requestFocus();
        ateField.selectAll();
    }//GEN-LAST:event_ateEditButtonActionPerformed

    /**
     * Handles when submit is pressed on bank tab in Accounts tab
     */
    private void bankSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankSubmitButtonActionPerformed
        if (bankField.getText().equals("")) {
            errLabel.setForeground(Color.red);
            errLabel.setText("Amount field required");
        } else {
            updateAccountTotals();
            bankField.setEditable(false);
            bankSubmitButton.setEnabled(false);
            bankEditButton.setEnabled(true);
        }
    }//GEN-LAST:event_bankSubmitButtonActionPerformed

    /**
     * Handles when submit is pressed on cash tab in Accounts tab
     */
    private void cashSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashSubmitButtonActionPerformed
        if (cashField.getText().equals("")) {
            errLabel.setForeground(Color.red);
            errLabel.setText("Amount field required");
        } else {
            updateAccountTotals();
            cashField.setEditable(false);
            cashSubmitButton.setEnabled(false);
            cashEditButton.setEnabled(true);
        }
    }//GEN-LAST:event_cashSubmitButtonActionPerformed

    /**
     * Handles when submit is pressed on 8-Account tab in Accounts tab
     */
    private void ateSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ateSubmitButtonActionPerformed
        if (ateField.getText().equals("")) {
            errLabel.setForeground(Color.red);
            errLabel.setText("Amount field required");
        } else {
            updateAccountTotals();
            ateField.setEditable(false);
            ateSubmitButton.setEnabled(false);
            ateEditButton.setEnabled(true);
        }
    }//GEN-LAST:event_ateSubmitButtonActionPerformed

    /**
     * Handles when the tab changes on the Accounts tab
     */
    private void accountsTabsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_accountsTabsStateChanged
        bankField.setEditable(false);
        bankSubmitButton.setEnabled(false);
        bankEditButton.setEnabled(true);
        cashField.setEditable(false);
        cashSubmitButton.setEnabled(false);
        cashEditButton.setEnabled(true);
        ateField.setEditable(false);
        ateSubmitButton.setEnabled(false);
        ateEditButton.setEnabled(true);
    }//GEN-LAST:event_accountsTabsStateChanged

    /**
     * Handles if tab is pressed while field is in focus, presses submit
     */
    private void sReasonFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sReasonFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            String s = aReasonField.getText();
            sNotesField.requestFocus();
            sReasonField.setText(s);
        }
    }//GEN-LAST:event_sReasonFieldKeyPressed

    /**
     * Handles if tab is pressed while field is in focus, tabs to the next
     */
    private void sNotesFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sNotesFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            String s = sNotesField.getText();
            sStoreField.requestFocus();
            sNotesField.setText(s);
        }
    }//GEN-LAST:event_sNotesFieldKeyPressed

    /**
     * Handles if tab is pressed while field is in focus, tabs to the next
     */
    private void aReasonFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aReasonFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            String s = aReasonField.getText();
            aNotesField.requestFocus();
            aReasonField.setText(s);
        }
    }//GEN-LAST:event_aReasonFieldKeyPressed

    /**
     * Handles if tab is pressed while field is in focus, tabs to the next
     */
    private void aNotesFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aNotesFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            String s = aNotesField.getText();
            aStoreField.requestFocus();
            aNotesField.setText(s);
        }
    }//GEN-LAST:event_aNotesFieldKeyPressed

    /**
     * Handles when field gains focus, selects all text in the field
     */
    private void sStoreFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sStoreFieldFocusGained
        sStoreField.selectAll();
    }//GEN-LAST:event_sStoreFieldFocusGained

    /**
     * Handles when field gains focus, selects all text in the field
     */
    private void sPurchaserFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sPurchaserFieldFocusGained
        sPurchaserField.selectAll();
    }//GEN-LAST:event_sPurchaserFieldFocusGained

    /**
     * Handles when field gains focus, selects all text in the field
     */
    private void sAmountFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sAmountFieldFocusGained
        sAmountField.selectAll();
    }//GEN-LAST:event_sAmountFieldFocusGained

    /**
     * Handles when field gains focus, selects all text in the field
     */
    private void sReasonFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sReasonFieldFocusGained
        sReasonField.selectAll();
    }//GEN-LAST:event_sReasonFieldFocusGained

    /**
     * Handles when field gains focus, selects all text in the field
     */
    private void sNotesFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sNotesFieldFocusGained
        sNotesField.selectAll();
    }//GEN-LAST:event_sNotesFieldFocusGained

    /**
     * Handles when field gains focus, selects all text in the field
     */
    private void aStoreFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aStoreFieldFocusGained
        aStoreField.selectAll();
    }//GEN-LAST:event_aStoreFieldFocusGained

    /**
     * Handles when field gains focus, selects all text in the field
     */
    private void aPurchaserFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aPurchaserFieldFocusGained
        aPurchaserField.selectAll();
    }//GEN-LAST:event_aPurchaserFieldFocusGained

    /**
     * Handles when field gains focus, selects all text in the field
     */
    private void aAmountFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aAmountFieldFocusGained
        aAmountField.selectAll();
    }//GEN-LAST:event_aAmountFieldFocusGained

    /**
     * Handles when field gains focus, selects all text in the field
     */
    private void aReasonFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aReasonFieldFocusGained
        aReasonField.selectAll();
    }//GEN-LAST:event_aReasonFieldFocusGained

    /**
     * Handles when field gains focus, selects all text in the field
     */
    private void aNotesFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aNotesFieldFocusGained
        aNotesField.selectAll();
    }//GEN-LAST:event_aNotesFieldFocusGained

    private void webradioItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webradioItemActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://www.siue.edu/webradio"));
        } catch (IOException | URISyntaxException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
    }//GEN-LAST:event_webradioItemActionPerformed

    private void collegiatelinkItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collegiatelinkItemActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://siue.collegiatelink.net/organization/webradio"));
        } catch (IOException | URISyntaxException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
    }//GEN-LAST:event_collegiatelinkItemActionPerformed

    private void facebookItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facebookItemActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://www.facebook.com/groups/156451584405369/"));
        } catch (IOException | URISyntaxException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
    }//GEN-LAST:event_facebookItemActionPerformed

    private void paypalItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paypalItemActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://www.paypal.com/businessexp/summary"));
        } catch (IOException | URISyntaxException ex) {
            Util.error(ex.toString(), ex.getMessage());
        }
    }//GEN-LAST:event_paypalItemActionPerformed

    private void sMonthBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMonthBoxActionPerformed
        int index = sDateBox.getSelectedIndex();
        sDateBox.setModel(sUpdateDayBoxModel(sMonthBox.getSelectedIndex()));
        if (sMonthBox.getSelectedIndex() != 0) {
            sDateBox.setSelectedIndex(index);
        }
    }//GEN-LAST:event_sMonthBoxActionPerformed

    private void aMonthBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aMonthBoxActionPerformed
        int index = aDateBox.getSelectedIndex();
        aDateBox.setModel(aUpdateDayBoxModel(aMonthBox.getSelectedIndex()));
        if (aMonthBox.getSelectedIndex() != 0) {
            aDateBox.setSelectedIndex(index);
        }
    }//GEN-LAST:event_aMonthBoxActionPerformed

    private void aYearBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aYearBoxActionPerformed
        int index = aDateBox.getSelectedIndex();
        aDateBox.setModel(aUpdateDayBoxModel(aMonthBox.getSelectedIndex()));
        if (aMonthBox.getSelectedIndex() != 0) {
            aDateBox.setSelectedIndex(index);
        }
    }//GEN-LAST:event_aYearBoxActionPerformed

    private void sYearBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sYearBoxActionPerformed
        int index = sDateBox.getSelectedIndex();
        sDateBox.setModel(sUpdateDayBoxModel(sMonthBox.getSelectedIndex()));
        if (sMonthBox.getSelectedIndex() != 0) {
            sDateBox.setSelectedIndex(index);
        }
    }//GEN-LAST:event_sYearBoxActionPerformed

    // </editor-fold>
    /**
     * updateTotal()
     *
     * Updates the total on the money counter when user changes something
     */
    public void updateTotal() {

        double total = 0;
        total += pennies / 100;
        total += nickels / 20;
        total += dimes / 10;
        total += quarters / 4;
        total += halfdollars / 2;
        total += dollarcoins;
        total += dollars;
        total += fives * 5;
        total += tens * 10;
        total += twenties * 20;
        total += fifties * 50;
        total += hundreds * 100;

        totalL.setText("$" + money.format(total));
    }

    /**
     * updateAccountTotals()
     *
     * Takes the values of the three accounts and sends them to IOController\ to
     * update that file
     */
    public void updateAccountTotals() {

        // create a new double array
        double[] d = new double[]{
            Double.valueOf(bankField.getText().replace("$", "")),
            Double.valueOf(cashField.getText().replace("$", "")),
            Double.valueOf(ateField.getText().replace("$", ""))
        };

        // update them in the file
        FinanceController.updateAccountTotals(d);

        // update them in the gui
        bankField.setText("$" + money.format(d[0]));
        cashField.setText("$" + money.format(d[1]));
        ateField.setText("$" + money.format(d[2]));

        // total
        double total = d[0] + d[1] + d[2];
        totalField.setText("$" + money.format(total));

        // log
        EventLog.add("edited account totals");
    }

    /**
     * fillList()
     *
     * Gets all of the Transactions from IOController and shoves them into an
     * array Then it populates the DefaultListModel of ListElements from that
     * array
     *
     * @return the DefaultListModel to populate the JList
     */
    public DefaultListModel fillList() {

        int total = IOController.getTotalTransactions();
        Transaction[] trans = FinanceController.getAllTransactions();

        for (int i = 0; i < total; i++) {
            transactions.add(i, new ListElement(
                    String.valueOf(trans[i].getAmount()),
                    trans[i].getStore(),
                    String.valueOf(trans[i].getID())
            ));
        }
        return transactions;
    }

    /**
     * updateList()
     *
     * Works with the global list of Transactions, which updates the JList
     * graphics
     *
     * @param action, the type of action (either add or remove)
     * @param element, the element to add or remove
     */
    public void updateList(int action, ListElement element) {
        switch (action) {
            case ADD:         // add
                transactions.add(transactions.getSize(), element);
                break;
            case REMOVE:      // remove
                transactions.remove(list.getSelectedIndex());
                break;
        }
    }

    /**
     * add()
     *
     * If the fields are all valid, this method is called Takes fields and
     * creates Transaction and ListElement objects Then it calls the
     * FinanceController to add the Transaction If the addition succeeds, update
     * the list, and update graphics
     */
    public void add() {
        String store = aStoreField.getText();
        String purchaser = aPurchaserField.getText();
        double amount = Double.valueOf(aAmountField.getText().replace(",", ""));
        String reason = aReasonField.getText().trim();

        String notes;
        if (aNotesField.getText().trim().equals("")) {
            notes = "N/A";
        } else {
            notes = aNotesField.getText().trim();
        }

        int id = Util.generateID();

        Date date = new Date();
        date.setMonth(aMonthBox.getSelectedIndex() - 1);
        date.setDate(aDateBox.getSelectedIndex());
        date.setYear(aYearBox.getSelectedIndex() + 109);

        Transaction t = new Transaction(id, store, date, purchaser, amount, reason, notes);
        ListElement e = new ListElement(String.valueOf(amount), store, String.valueOf(id));

        if (FinanceController.addTransaction(t)) {
            // update graphics
            errLabel.setForeground(Color.blue);
            errLabel.setText("Transaction added successfully");

            updateList(ADD, e);

            setAddValuesToNull();
            aStoreField.requestFocus();

            // log
            EventLog.add("added transaction " + t.getID()
                    + " (" + t.getAmount() + " - " + t.getStore() + ")");

            // else if addition fails
        } else {
            errLabel.setForeground(Color.red);
            errLabel.setText("Transaction addition failed");
        }
    }

    /**
     * search()
     *
     * Calls the searchTransaction() method from FinanceController, which
     * returns a valid Transaction Update the graphics with the Transaction info
     *
     * @param id, the id to search
     */
    public void search(String id) {
        // get the transaction
        Transaction t = FinanceController.searchTransaction(id);

        // update graphics
        errLabel.setText(" ");
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
        setSearchFieldsToValid();

        // update fields with transaction info
        sStoreField.setText(t.getStore());
        sMonthBox.setSelectedIndex(t.getDate().getMonth() + 1);
        sDateBox.setSelectedIndex(t.getDate().getDate());
        sYearBox.setSelectedIndex(t.getDate().getYear() - 109);
        sPurchaserField.setText(t.getName());
        sAmountField.setText(money.format(t.getAmount()));
        sReasonField.setText(t.getReason());
        sNotesField.setText(t.getNotes());

    }

    /**
     * edit()
     *
     * Basically just sets the fields to editable Stores a temporary global
     * Transaction, used in the editing process in submit()
     */
    public void edit() {

        String store = sStoreField.getText();
        String purchaser = sPurchaserField.getText();
        double amount = Double.valueOf(sAmountField.getText());
        String reason = sReasonField.getText();
        String notes = sNotesField.getText();

        Date date = new Date();
        date.setMonth(sMonthBox.getSelectedIndex() - 1);
        date.setDate(sDateBox.getSelectedIndex());
        date.setYear(sYearBox.getSelectedIndex() + 109);

        int id = Integer.valueOf(transactions.get(list.getSelectedIndex()).id);

        // create the temp Transaction
        temp = new Transaction(id, store, date, purchaser, amount, reason, notes);

        // update graphics
        setSearchFieldsEditable(true);
        submitButton.setEnabled(true);
        deleteButton.setEnabled(false);
        editButton.setEnabled(false);
    }

    /**
     * delete()
     *
     * Creates a Transaction with the fields given Then call deleteTransaction()
     * from FinanceController If success, confirm on errLabel
     */
    public void delete() {
        String id = transactions.get(list.getSelectedIndex()).id;
        String store = sStoreField.getText();
        String amount = sAmountField.getText();

        if (FinanceController.deleteTransaction(id)) {

            // create ListElement
            ListElement e = new ListElement(amount, store, id);

            // update graphics
            updateList(REMOVE, e);
            errLabel.setForeground(Color.blue);
            errLabel.setText("Transaction deleted successfully");
            setSearchValuesToNull();
            setSearchFieldsEditable(false);
            editButton.setEnabled(false);
            deleteButton.setEnabled(false);
            submitButton.setEnabled(false);

            // log
            EventLog.add("deleted transaction " + id
                    + " (" + amount + " - " + store + ")");
        }
    }

    /**
     * submit()
     *
     * Takes the new input as parameters for a new Transaction object Then it
     * deletes the old transaction, then adds the new one (in that order) If
     * success, update the graphics If failure, return and update graphics
     */
    public void submit() {
        // update graphics
        errLabel.setForeground(Color.blue);
        errLabel.setText("Transaction edited successfully");

        // get things from searchPanel
        String store = sStoreField.getText();
        String purchaser = sPurchaserField.getText();
        double amount = Double.valueOf(sAmountField.getText());
        String reason = sReasonField.getText().trim();

        String notes;
        if (sNotesField.getText().trim().equals("")) {
            notes = "N/A";
        } else {
            notes = sNotesField.getText().trim();
        }

        Date date = new Date();
        date.setMonth(sMonthBox.getSelectedIndex() - 1);
        date.setDate(sDateBox.getSelectedIndex());
        date.setYear(sYearBox.getSelectedIndex() + 109);

        int id = Integer.valueOf(transactions.get(list.getSelectedIndex()).id);

        // create new transaction
        Transaction t = new Transaction(id, store, date, purchaser, amount, reason, notes);

        // update graphics
        setSearchFieldsEditable(false);

        // delete then add
        FinanceController.deleteTransaction(String.valueOf(temp.id));
        FinanceController.addTransaction(t);

        // create ListElements
        ListElement p = new ListElement(String.valueOf(temp.getAmount()),
                temp.getStore(),
                String.valueOf(temp.getID()));
        ListElement q = new ListElement(String.valueOf(t.getAmount()),
                t.getStore(),
                String.valueOf(t.getID()));

        // update graphics
        updateList(REMOVE, p);
        updateList(ADD, q);
        submitButton.setEnabled(false);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);

        // reset the form, selecting the new Profile just edited
        list.setSelectedIndex(transactions.getSize() - 1);
        search(transactions.getElementAt(transactions.getSize() - 1).id);

        // log
        EventLog.add("edited transaction " + t.getID()
                + " (" + t.getAmount() + " - " + t.getStore() + ")");

    }

    /**
     * admin()
     *
     * Does admin things, like clear out things for a semester and such
     */
    public void admin() {
        // not implemented yet
    }

    /**
     * aCheck()
     *
     * Checks the add panel and makes sure all the fields are kosher See
     * comments in function for details on each element First, it "resets" by
     * making all fields foregrounds black Then it checks each individual field,
     * and sets the foreground red if the field has an error If it returns a
     * true flag, there is no error It calls the setAddErrLabel to find the
     * individual errors and updates errLabel
     *
     * @return flag, the conditional to show if the fields are valid
     */
    public boolean aCheck() {
        boolean flag = true;

        // preconditions
        errLabel.setForeground(Color.red);
        aSetAllForeground(Color.black);

        // Store
        if (aStoreField.getText().equals("") || aStoreField.getText().equals("--")) {
            flag = false;
            aStoreField.setForeground(Color.red);
            aStoreField.setText("--");
        } else if (!Util.sepCheck(aStoreField.getText())) {
            flag = false;
            aStoreField.setForeground(Color.red);
        }

        // Month, Day, and Year
        if (aMonthBox.getSelectedIndex() == 0) {
            flag = false;
            aMonthBox.setForeground(Color.red);
        }
        if (aDateBox.getSelectedIndex() == 0) {
            flag = false;
            aDateBox.setForeground(Color.red);
        }
        if (aYearBox.getSelectedIndex() == 0) {
            flag = false;
            aYearBox.setForeground(Color.red);
        }

        // Purchaser
        if (aPurchaserField.getText().equals("") || aPurchaserField.getText().equals("--")) {
            flag = false;
            aPurchaserField.setForeground(Color.red);
            aPurchaserField.setText("--");
        } else if (!Util.sepCheck(aPurchaserField.getText())) {
            flag = false;
            aPurchaserField.setForeground(Color.red);
        }

        // Amount
        if (aAmountField.getText().equals("") || aAmountField.getText().equals("--")) {
            flag = false;
            aAmountField.setForeground(Color.red);
            aAmountField.setText("--");
        }

        // Reason
        if (aReasonField.getText().trim().equals("") || aReasonField.getText().trim().equals("--")) {
            flag = false;
            aReasonField.setForeground(Color.red);
            aReasonField.setText("--");
        } else if (!Util.sepCheck(aReasonField.getText())) {
            flag = false;
            aReasonField.setForeground(Color.red);
        }

        setAddErrLabel();
        return flag;
    }

    /**
     * setAddErrLabel()
     *
     * Checks each field to see if the text color is red If it is, add to count
     * Starts with end so it can print out "Error with ##### field and #
     * other(s)
     */
    public void setAddErrLabel() {
        int errCount = 0;
        String err = "";

        // notes
        if (aNotesField.getForeground() == Color.red) {
            errCount++;
            err = "Error with notes field";
        }
        // reason
        if (aReasonField.getForeground() == Color.red) {
            errCount++;
            err = "Error with reason field";
        }
        // amount
        if (aAmountField.getForeground() == Color.red) {
            errCount++;
            err = "Error with amount field";
        }
        // purchaser
        if (aPurchaserField.getForeground() == Color.red) {
            errCount++;
            err = "Error with purchaser field";
        }
        // year
        if (aMonthBox.getForeground() == Color.red) {
            errCount++;
            err = "Error with month field";
        }
        // day
        if (aDateBox.getForeground() == Color.red) {
            errCount++;
            err = "Error with day field";
        }
        // month
        if (aMonthBox.getForeground() == Color.red) {
            errCount++;
            err = "Error with month field";
        }
        // store
        if (aStoreField.getForeground() == Color.red) {
            errCount++;
            err = "Error with store field";
        }

        // if there is more than one error
        if (errCount > 1) {
            errLabel.setForeground(Color.red);
            errLabel.setText(err + " and " + (errCount - 1) + " other(s)");
            // if there's only one
        } else if (errCount == 1) {
            errLabel.setForeground(Color.red);
            errLabel.setText(err);
        }

    }

    /**
     * sCheck()
     *
     * Checks the search panel and makes sure all the fields are kosher See
     * comments in function for details on each element First, it "resets" by
     * making all fields foregrounds black Then it checks each individual field,
     * and sets the foreground red if the field has an error If it returns a
     * true flag, there is no error It calls the setSearchErrLabel to find the
     * individual errors and updates errLabel
     *
     * @return flag, the conditional to show if the fields are valid
     */
    public boolean sCheck() {
        boolean flag = true;

        // preconditions
        errLabel.setForeground(Color.red);
        sSetAllForeground(Color.black);

        // Store
        if (sStoreField.getText().equals("") || sStoreField.getText().equals("--")) {
            flag = false;
            sStoreField.setForeground(Color.red);
            sStoreField.setText("--");
        } else if (!Util.sepCheck(sStoreField.getText())) {
            flag = false;
            sStoreField.setForeground(Color.red);
        }

        // Month, Day, and Year
        if (sMonthBox.getSelectedIndex() == 0) {
            flag = false;
            aMonthBox.setForeground(Color.red);
        }
        if (sDateBox.getSelectedIndex() == 0) {
            flag = false;
            sDateBox.setForeground(Color.red);
        }
        if (sYearBox.getSelectedIndex() == 0) {
            flag = false;
            sYearBox.setForeground(Color.red);
        }

        // Purchaser
        if (sPurchaserField.getText().equals("") || sPurchaserField.getText().equals("--")) {
            flag = false;
            sPurchaserField.setForeground(Color.red);
            sPurchaserField.setText("--");
        } else if (!Util.sepCheck(sPurchaserField.getText())) {
            flag = false;
            sPurchaserField.setForeground(Color.red);
        }

        // Amount
        if (sAmountField.getText().equals("") || sAmountField.getText().equals("--")) {
            flag = false;
            sAmountField.setForeground(Color.red);
            sAmountField.setText("--");
        }

        // Reason
        if (sReasonField.getText().trim().equals("") || sReasonField.getText().trim().equals("--")) {
            flag = false;
            sReasonField.setForeground(Color.red);
            sReasonField.setText("--");
        } else if (!Util.sepCheck(sReasonField.getText())) {
            flag = false;
            sReasonField.setForeground(Color.red);
        }

        setSearchErrLabel();
        return flag;
    }

    /**
     * setSearchErrLabel()
     *
     * Checks each field to see if the text color is red If it is, add to count
     * Starts with end so it can print out "Error with ##### field and #
     * other(s)
     */
    public void setSearchErrLabel() {
        int errCount = 0;
        String err = "";

        // notes
        if (sNotesField.getForeground() == Color.red) {
            errCount++;
            err = "Error with notes field";
        }
        // reason
        if (sReasonField.getForeground() == Color.red) {
            errCount++;
            err = "Error with reason field";
        }
        // amount
        if (sAmountField.getForeground() == Color.red) {
            errCount++;
            err = "Error with amount field";
        }
        // purchaser
        if (sPurchaserField.getForeground() == Color.red) {
            errCount++;
            err = "Error with purchaser field";
        }
        // year
        if (sMonthBox.getForeground() == Color.red) {
            errCount++;
            err = "Error with month field";
        }
        // day
        if (sDateBox.getForeground() == Color.red) {
            errCount++;
            err = "Error with day field";
        }
        // month
        if (sMonthBox.getForeground() == Color.red) {
            errCount++;
            err = "Error with month field";
        }
        // store
        if (sStoreField.getForeground() == Color.red) {
            errCount++;
            err = "Error with store field";
        }

        // if there is more than one error
        if (errCount > 1) {
            errLabel.setForeground(Color.red);
            errLabel.setText(err + " and " + (errCount - 1) + " other(s)");
            // if there's only one
        } else if (errCount == 1) {
            errLabel.setForeground(Color.red);
            errLabel.setText(err);
        }
    }

    /**
     * aUpdateDayBoxModel()
     *
     * Updates the Date box so it shows the correct number of days per month
     *
     * @param n
     * @return the model to set
     */
    public DefaultComboBoxModel aUpdateDayBoxModel(int n) {
        int index = aDateBox.getSelectedIndex();
        switch (n) {
            case 1:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            case 2:
                // check if it's a leap year
                if (aYearBox.getSelectedIndex() != 0) {
                    if (Integer.valueOf(aYearBox.getItemAt(aYearBox.getSelectedIndex())) % 4 == 0) {
                        return new DefaultComboBoxModel(new String[]{
                            "--",
                            "1", "2", "3", "4", "5",
                            "6", "7", "8", "9", "10",
                            "11", "12", "13", "14", "15",
                            "16", "17", "18", "19", "20",
                            "21", "22", "23", "24", "25",
                            "26", "27", "28", "29"
                        });
                    } else {
                        return new DefaultComboBoxModel(new String[]{
                            "--",
                            "1", "2", "3", "4", "5",
                            "6", "7", "8", "9", "10",
                            "11", "12", "13", "14", "15",
                            "16", "17", "18", "19", "20",
                            "21", "22", "23", "24", "25",
                            "26", "27", "28"
                        });
                    }
                }
            case 3:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            case 4:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",});
            case 5:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            case 6:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",});
            case 7:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            case 8:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            case 9:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",});
            case 10:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            case 11:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",});
            case 12:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            default:
                return new DefaultComboBoxModel(new String[]{"--"});

        }

    }

    /**
     * sUpdateDayBoxModel()
     *
     * Updates the Date box so it shows the correct number of days per month
     *
     * @param n
     * @return the model to set
     */
    public DefaultComboBoxModel sUpdateDayBoxModel(int n) {
        switch (n) {
            case 1:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            case 2:
                // check if it's a leap year
                if (sYearBox.getSelectedIndex() != 0) {
                    if (Integer.valueOf(sYearBox.getItemAt(sYearBox.getSelectedIndex())) % 4 == 0) {
                        return new DefaultComboBoxModel(new String[]{
                            "--",
                            "1", "2", "3", "4", "5",
                            "6", "7", "8", "9", "10",
                            "11", "12", "13", "14", "15",
                            "16", "17", "18", "19", "20",
                            "21", "22", "23", "24", "25",
                            "26", "27", "28", "29"
                        });
                    }
                } else {
                    return new DefaultComboBoxModel(new String[]{
                        "--",
                        "1", "2", "3", "4", "5",
                        "6", "7", "8", "9", "10",
                        "11", "12", "13", "14", "15",
                        "16", "17", "18", "19", "20",
                        "21", "22", "23", "24", "25",
                        "26", "27", "28"
                    });
                }
            case 3:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            case 4:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",});
            case 5:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            case 6:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",});
            case 7:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            case 8:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            case 9:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",});
            case 10:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            case 11:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",});
            case 12:
                return new DefaultComboBoxModel(new String[]{
                    "--",
                    "1", "2", "3", "4", "5",
                    "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15",
                    "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25",
                    "26", "27", "28", "29", "30",
                    "31"
                });
            default:
                return new DefaultComboBoxModel(new String[]{"--"});

        }
    }

    /**
     * aSetAllForeground() Graphics update
     *
     * @param c
     */
    public void aSetAllForeground(Color c) {
        aStoreField.setForeground(c);
        aMonthBox.setForeground(c);
        aDateBox.setForeground(c);
        aYearBox.setForeground(c);
        aAmountField.setForeground(c);
        aPurchaserField.setForeground(c);
        aReasonField.setForeground(c);
        aNotesField.setForeground(c);
    }

    /**
     * sSetAllForeground() Graphics update
     *
     * @param c
     */
    public void sSetAllForeground(Color c) {
        sStoreField.setForeground(c);
        sMonthBox.setForeground(c);
        sDateBox.setForeground(c);
        sYearBox.setForeground(c);
        sAmountField.setForeground(c);
        sPurchaserField.setForeground(c);
        sReasonField.setForeground(c);
        sNotesField.setForeground(c);
    }

    /**
     * setAddValuesToNull()
     *
     * Graphics update Resets the add panel with null values
     */
    public void setAddValuesToNull() {
        aStoreField.setText("");
        aMonthBox.setSelectedIndex(0);
        aDateBox.setSelectedIndex(0);
        aYearBox.setSelectedIndex(0);
        aAmountField.setText("");
        aPurchaserField.setText("");
        aReasonField.setText("");
        aNotesField.setText("");
    }

    /**
     * setSearchValuesToNull()
     *
     * Graphics update
     *
     * Resets the serach panel with null values
     */
    public void setSearchValuesToNull() {
        sStoreField.setText("");
        sMonthBox.setSelectedIndex(0);
        sDateBox.setSelectedIndex(0);
        sYearBox.setSelectedIndex(0);
        sAmountField.setText("");
        sPurchaserField.setText("");
        sReasonField.setText("");
        sNotesField.setText("");
    }

    /**
     * setSearchFieldsToValid()
     *
     * Graphics update Sets the search panel to accept valid values
     */
    public void setSearchFieldsToValid() {
        sStoreField.setBackground(Color.white);
        sMonthBox.setSelectedIndex(0);
        sDateBox.setSelectedIndex(0);
        sYearBox.setSelectedIndex(0);
        sAmountField.setBackground(Color.white);
        sPurchaserField.setBackground(Color.white);
        sReasonField.setBackground(Color.white);
        sNotesField.setBackground(Color.white);
    }

    /**
     * setSearchFieldsEditable()
     *
     * Graphics update Sets the search fields editable based on boolean
     * parameter
     *
     * @param b, the conditional to change the editability of the fields
     */
    public void setSearchFieldsEditable(boolean b) {
        sStoreField.setEditable(b);
        sAmountField.setEditable(b);
        sPurchaserField.setEditable(b);
        sReasonField.setEditable(b);
        sNotesField.setEditable(b);
        if (!b) {
            sMonthBox.setSelectedIndex(0);
            sDateBox.setSelectedIndex(0);
            sYearBox.setSelectedIndex(0);
        } else {
            sMonthBox.setEnabled(b);
            sDateBox.setEnabled(b);
            sYearBox.setEnabled(b);
        }

        if (!b) {
            sStoreField.setBackground(new Color(240, 240, 240));
            sAmountField.setBackground(new Color(240, 240, 240));
            sPurchaserField.setBackground(new Color(240, 240, 240));
            sReasonField.setBackground(new Color(240, 240, 240));
            sNotesField.setBackground(new Color(240, 240, 240));
        } else {
            sStoreField.setBackground(Color.white);
            sAmountField.setBackground(Color.white);
            sPurchaserField.setBackground(Color.white);
            sReasonField.setBackground(Color.white);
            sNotesField.setBackground(Color.white);
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
            Util.error(ex.toString(), ex.getMessage());
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FinanceGUI().setVisible(true);
        });
    }

    // <editor-fold defaultstate="collapsed" desc="I'll modify what I want">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L1;
    private javax.swing.JLabel L10;
    private javax.swing.JLabel L11;
    private javax.swing.JLabel L12;
    private javax.swing.JLabel L2;
    private javax.swing.JLabel L3;
    private javax.swing.JLabel L4;
    private javax.swing.JLabel L5;
    private javax.swing.JLabel L6;
    private javax.swing.JLabel L7;
    private javax.swing.JLabel L8;
    private javax.swing.JLabel L9;
    private javax.swing.JMenu SIUeMenu;
    private javax.swing.JFormattedTextField aAmountField;
    private javax.swing.JComboBox<String> aDateBox;
    private javax.swing.JComboBox<String> aMonthBox;
    private javax.swing.JTextArea aNotesField;
    private javax.swing.JTextField aPurchaserField;
    private javax.swing.JTextArea aReasonField;
    private javax.swing.JTextField aStoreField;
    private javax.swing.JComboBox<String> aYearBox;
    private javax.swing.JPanel accountsPanel;
    private javax.swing.JTabbedPane accountsTabs;
    private javax.swing.JButton addButton;
    private javax.swing.JPanel addPanel;
    private javax.swing.JLabel adminLabel;
    private javax.swing.JButton ateEditButton;
    private javax.swing.JTextField ateField;
    private javax.swing.JPanel atePanel;
    private javax.swing.JButton ateSubmitButton;
    private javax.swing.JButton bankEditButton;
    private javax.swing.JTextField bankField;
    private javax.swing.JPanel bankPanel;
    private javax.swing.JButton bankSubmitButton;
    private javax.swing.JMenuItem bugItem;
    private javax.swing.JButton calcButton;
    private javax.swing.JButton cashEditButton;
    private javax.swing.JTextField cashField;
    private javax.swing.JPanel cashPanel;
    private javax.swing.JButton cashSubmitButton;
    private javax.swing.JMenuItem closeItem;
    private javax.swing.JMenuItem collegiatelinkItem;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel dimeL;
    private javax.swing.JSpinner dimeSpinner;
    private javax.swing.JLabel dollarL;
    private javax.swing.JSpinner dollarSpinner;
    private javax.swing.JLabel dollarcoinL;
    private javax.swing.JSpinner dollarcoinSpinner;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel errLabel;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenuItem facebookItem;
    private javax.swing.JLabel fiftyL;
    private javax.swing.JSpinner fiftySpinner;
    private javax.swing.JMenu file;
    private javax.swing.JMenu financesMenu;
    private javax.swing.JLabel fiveL;
    private javax.swing.JSpinner fiveSpinner;
    private javax.swing.JLabel halfdollarL;
    private javax.swing.JSpinner halfdollarSpinner;
    private javax.swing.JMenu help;
    private javax.swing.JMenuItem helpItem;
    private javax.swing.JLabel hundredL;
    private javax.swing.JSpinner hundredSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JMenu links;
    private javax.swing.JList<String> list;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JMenuItem logoutItem;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JPanel moneycounterPanel;
    private javax.swing.JLabel nickelL;
    private javax.swing.JSpinner nickelSpinner;
    private javax.swing.JMenuItem paypalItem;
    private javax.swing.JLabel pennyL;
    private javax.swing.JSpinner pennySpinner;
    private javax.swing.JMenu profilesMenu;
    private javax.swing.JLabel quarterL;
    private javax.swing.JSpinner quarterSpinner;
    private javax.swing.JFormattedTextField sAmountField;
    private javax.swing.JComboBox<String> sDateBox;
    private javax.swing.JComboBox<String> sMonthBox;
    private javax.swing.JTextArea sNotesField;
    private javax.swing.JTextField sPurchaserField;
    private javax.swing.JTextArea sReasonField;
    private javax.swing.JTextField sStoreField;
    private javax.swing.JComboBox<String> sYearBox;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JButton submitButton;
    private javax.swing.JMenuItem suggestionItem;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JLabel tenL;
    private javax.swing.JSpinner tenSpinner;
    private javax.swing.JTextField totalField;
    private javax.swing.JLabel totalL;
    private javax.swing.JTabbedPane transTabs;
    private javax.swing.JPanel transactionPanel;
    private javax.swing.JLabel twentyL;
    private javax.swing.JSpinner twentySpinner;
    private javax.swing.JMenuItem webradioItem;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
