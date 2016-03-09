/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webradio;

import java.text.DecimalFormat;
import javax.swing.ImageIcon;

public class FinanceGUI extends javax.swing.JFrame {

    DecimalFormat money = new DecimalFormat("0.00");

    /**
     * Creates new form FinanceGUI
     */
    public FinanceGUI() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pennyF = new javax.swing.JTextField();
        nickelF = new javax.swing.JTextField();
        dimeF = new javax.swing.JTextField();
        quarterF = new javax.swing.JTextField();
        halfdollarF = new javax.swing.JTextField();
        dollarcoinF = new javax.swing.JTextField();
        pennyL = new javax.swing.JLabel();
        nickelL = new javax.swing.JLabel();
        dimeL = new javax.swing.JLabel();
        quarterL = new javax.swing.JLabel();
        halfdollarL = new javax.swing.JLabel();
        dollarcoinL = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dollarF = new javax.swing.JTextField();
        fiveF = new javax.swing.JTextField();
        tenF = new javax.swing.JTextField();
        twentyF = new javax.swing.JTextField();
        fiftyF = new javax.swing.JTextField();
        hundredF = new javax.swing.JTextField();
        dollarL = new javax.swing.JLabel();
        fiveL = new javax.swing.JLabel();
        tenL = new javax.swing.JLabel();
        twentyL = new javax.swing.JLabel();
        fiftyL = new javax.swing.JLabel();
        hundredL = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        totalL = new javax.swing.JLabel();
        errLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon("src\\images\\imageicon.png").getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel2.setName("Funds Calc"); // NOI18N

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

        pennyF.setNextFocusableComponent(nickelF);
        pennyF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pennyFFocusLost(evt);
            }
        });

        nickelF.setNextFocusableComponent(dimeF);
        nickelF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nickelFFocusLost(evt);
            }
        });

        dimeF.setNextFocusableComponent(quarterF);
        dimeF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dimeFFocusLost(evt);
            }
        });

        quarterF.setNextFocusableComponent(halfdollarF);
        quarterF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quarterFFocusLost(evt);
            }
        });

        halfdollarF.setNextFocusableComponent(dollarcoinF);
        halfdollarF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                halfdollarFFocusLost(evt);
            }
        });

        dollarcoinF.setNextFocusableComponent(dollarF);
        dollarcoinF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dollarcoinFFocusLost(evt);
            }
        });

        pennyL.setText("$0.00");

        nickelL.setText("$0.00");

        dimeL.setText("$0.00");

        quarterL.setText("$0.00");

        halfdollarL.setText("$0.00");

        dollarcoinL.setText("$0.00");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Dollars:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Fives:");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Tens:");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Twenties:");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Fifties:");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Hundreds:");

        dollarF.setNextFocusableComponent(fiveF);
        dollarF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dollarFFocusLost(evt);
            }
        });

        fiveF.setNextFocusableComponent(tenF);
        fiveF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fiveFFocusLost(evt);
            }
        });

        tenF.setNextFocusableComponent(twentyF);
        tenF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tenFFocusLost(evt);
            }
        });

        twentyF.setNextFocusableComponent(fiftyF);
        twentyF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                twentyFFocusLost(evt);
            }
        });

        fiftyF.setNextFocusableComponent(hundredF);
        fiftyF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fiftyFFocusLost(evt);
            }
        });

        hundredF.setNextFocusableComponent(pennyF);
        hundredF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hundredFFocusLost(evt);
            }
        });

        dollarL.setText("$0.00");

        fiveL.setText("$0.00");

        tenL.setText("$0.00");

        twentyL.setText("$0.00");

        fiftyL.setText("$0.00");

        hundredL.setText("$0.00");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Total:");

        totalL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalL.setText("$0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(pennyF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pennyL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(nickelF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nickelL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dimeF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dimeL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(quarterF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quarterL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(halfdollarF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(halfdollarL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dollarcoinF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dollarcoinL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dollarF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dollarL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(fiveF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fiveL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tenF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tenL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(twentyF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(twentyL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(fiftyF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fiftyL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(hundredF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hundredL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pennyF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pennyL)
                    .addComponent(jLabel8)
                    .addComponent(dollarF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dollarL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nickelF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nickelL)
                    .addComponent(jLabel9)
                    .addComponent(fiveF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dimeF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dimeL)
                    .addComponent(jLabel10)
                    .addComponent(tenF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(quarterF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quarterL)
                    .addComponent(jLabel11)
                    .addComponent(twentyF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twentyL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(halfdollarF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(halfdollarL)
                    .addComponent(jLabel12)
                    .addComponent(fiftyF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiftyL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dollarcoinF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dollarcoinL)
                    .addComponent(jLabel13)
                    .addComponent(hundredF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hundredL))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalL)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Funds Calculator", jPanel2);

        errLabel.setText(" ");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(errLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Main.CloseFinanceGUI();
    }//GEN-LAST:event_formWindowClosed

    private void pennyFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pennyFFocusLost
        try {
            int num = Integer.valueOf(pennyF.getText());    // convert text to int
            double result = num * 0.01;                     // get monetary amount
            pennyL.setText("$" + money.format(result));                   // set the label
        } catch (NumberFormatException e) {
            // do nothing
        }
        updateTotal();                                      // update the total
    }//GEN-LAST:event_pennyFFocusLost

    private void nickelFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nickelFFocusLost
        try {
            int num = Integer.valueOf(nickelF.getText());   // convert text to int
            double result = num * 0.05;                     // get monetary amount
            nickelL.setText("$" + money.format(result));                  // set the label
        } catch (NumberFormatException e) {
            // do nothing
        }
        updateTotal();
    }//GEN-LAST:event_nickelFFocusLost

    private void dimeFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dimeFFocusLost
        try {
            int num = Integer.valueOf(dimeF.getText());     // convert text to int
            double result = num * 0.10;                     // get monetary amount
            dimeL.setText("$" + money.format(result));                    // set the label
        } catch (NumberFormatException e) {
            // do nothing
        }
        updateTotal();
    }//GEN-LAST:event_dimeFFocusLost

    private void quarterFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quarterFFocusLost
        try {
            int num = Integer.valueOf(quarterF.getText());  // convert text to int
            double result = num * 0.05;                     // get monetary amount
            quarterL.setText("$" + money.format(result));                 // set the label
        } catch (NumberFormatException e) {
            // do nothing
        }
        updateTotal();
    }//GEN-LAST:event_quarterFFocusLost

    private void halfdollarFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_halfdollarFFocusLost
        try {
            int num = Integer.valueOf(halfdollarF.getText());   // convert text to int
            double result = num * 0.50;                         // get monetary amount
            halfdollarL.setText("$" + money.format(result));                  // set the label
        } catch (NumberFormatException e) {
            // do nothing
        }
        updateTotal();
    }//GEN-LAST:event_halfdollarFFocusLost

    private void dollarcoinFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dollarcoinFFocusLost
        try {
            int num = Integer.valueOf(dollarcoinF.getText());   // convert text to int
            double result = num * 1.00;                         // get monetary amount
            dollarcoinL.setText("$" + money.format(result));                  // set the label
        } catch (NumberFormatException e) {
            // do nothing
        }
        updateTotal();
    }//GEN-LAST:event_dollarcoinFFocusLost

    private void dollarFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dollarFFocusLost
        try {
            int num = Integer.valueOf(dollarF.getText());   // convert text to int
            double result = num * 1.00;                         // get monetary amount
            dollarL.setText("$" + money.format(result));                  // set the label
        } catch (NumberFormatException e) {
            // do nothing
        }
        updateTotal();
    }//GEN-LAST:event_dollarFFocusLost

    private void fiveFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fiveFFocusLost
        try {
            int num = Integer.valueOf(fiveF.getText());   // convert text to int
            double result = num * 5.00;                   // get monetary amount
            fiveL.setText("$" + money.format(result));                  // set the label
        } catch (NumberFormatException e) {
            // do nothing
        }
        updateTotal();
    }//GEN-LAST:event_fiveFFocusLost

    private void tenFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tenFFocusLost
        try {
            int num = Integer.valueOf(tenF.getText());    // convert text to int
            double result = num * 10.00;                  // get monetary amount
            tenL.setText("$" + money.format(result));                   // set the label
        } catch (NumberFormatException e) {
            // do nothing
        }
        updateTotal();
    }//GEN-LAST:event_tenFFocusLost

    private void twentyFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_twentyFFocusLost
        try {
            int num = Integer.valueOf(twentyF.getText());   // convert text to int
            double result = num * 20.00;                    // get monetary amount
            twentyL.setText("$" + money.format(result));                  // set the label
        } catch (NumberFormatException e) {
            // do nothing
        }
        updateTotal();
    }//GEN-LAST:event_twentyFFocusLost

    private void fiftyFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fiftyFFocusLost
        try {
            int num = Integer.valueOf(fiftyF.getText());    // convert text to int
            double result = num * 50.00;                    // get monetary amount
            fiftyL.setText("$" + money.format(result));                   // set the label
        } catch (NumberFormatException e) {
            // do nothing
        }
        updateTotal();
    }//GEN-LAST:event_fiftyFFocusLost

    private void hundredFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hundredFFocusLost
        try {
            int num = Integer.valueOf(hundredF.getText());  // convert text to int
            double result = num * 100.00;                    // get monetary amount
            hundredL.setText("$" + money.format(result));                 // set the label
        } catch (NumberFormatException e) {
            // do nothing
        }
        updateTotal();
    }//GEN-LAST:event_hundredFFocusLost

    public void updateTotal() {

        double total;

        String str[] = new String[12];

        str[0] = pennyL.getText();
        str[1] = nickelL.getText();
        str[2] = dimeL.getText();
        str[3] = quarterL.getText();
        str[4] = halfdollarL.getText();
        str[5] = dollarcoinL.getText();
        str[6] = dollarL.getText();
        str[7] = fiveL.getText();
        str[8] = tenL.getText();
        str[9] = twentyL.getText();
        str[10] = fiftyL.getText();
        str[11] = hundredL.getText();

        double pennies = Double.parseDouble(str[0]);
        double nickels = Double.parseDouble(str[1]);
        double dimes = Double.parseDouble(str[2]);
        double quarters = Double.parseDouble(str[3]);
        double halfdollars = Double.parseDouble(str[4]);
        double dollarcoins = Double.parseDouble(str[5]);
        double dollars = Double.parseDouble(str[6]);
        double fives = Double.parseDouble(str[7]);
        double tens = Double.parseDouble(str[8]);
        double twenties = Double.parseDouble(str[9]);
        double fifties = Double.parseDouble(str[10]);
        double hundreds = Double.parseDouble(str[11]);

        total = pennies
                + nickels
                + dimes
                + quarters
                + halfdollars
                + dollarcoins
                + dollars
                + fives
                + tens
                + twenties
                + fifties
                + hundreds;
        totalL.setText("$" + money.format(total));

    }

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
            java.util.logging.Logger.getLogger(FinanceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinanceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinanceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinanceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FinanceGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dimeF;
    private javax.swing.JLabel dimeL;
    private javax.swing.JTextField dollarF;
    private javax.swing.JLabel dollarL;
    private javax.swing.JTextField dollarcoinF;
    private javax.swing.JLabel dollarcoinL;
    private javax.swing.JLabel errLabel;
    private javax.swing.JTextField fiftyF;
    private javax.swing.JLabel fiftyL;
    private javax.swing.JTextField fiveF;
    private javax.swing.JLabel fiveL;
    private javax.swing.JTextField halfdollarF;
    private javax.swing.JLabel halfdollarL;
    private javax.swing.JTextField hundredF;
    private javax.swing.JLabel hundredL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nickelF;
    private javax.swing.JLabel nickelL;
    private javax.swing.JTextField pennyF;
    private javax.swing.JLabel pennyL;
    private javax.swing.JTextField quarterF;
    private javax.swing.JLabel quarterL;
    private javax.swing.JTextField tenF;
    private javax.swing.JLabel tenL;
    private javax.swing.JLabel totalL;
    private javax.swing.JTextField twentyF;
    private javax.swing.JLabel twentyL;
    // End of variables declaration//GEN-END:variables
}
