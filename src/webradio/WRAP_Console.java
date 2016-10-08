/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webradio;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.TextField;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;
import java.util.Scanner;
import java.io.Console;

public class WRAP_Console extends javax.swing.JFrame {

    // <editor-fold desc="FancyCaret class" defaultstate="collapsed">
    public class FancyCaret extends DefaultCaret {

        public FancyCaret() {
            setBlinkRate(500);
        }

        protected synchronized void damage(Rectangle r) {
            if (r == null) {
                return;
            }

            // give values to x,y,width,height (inherited from java.awt.Rectangle)
            x = r.x;
            y = r.y;
            height = r.height;
            // A value for width was probably set by paint(), which we leave alone.
            // But the first call to damage() precedes the first call to paint(), so
            // in this case we must be prepared to set a valid width, or else
            // paint()
            // will receive a bogus clip area and caret will not get drawn properly.
            if (width <= 0) {
                width = getComponent().getWidth();
            }

            repaint(); // calls getComponent().repaint(x, y, width, height)
        }

        @Override
        public void paint(Graphics g) {
            JTextComponent comp = getComponent();
            if (comp == null) {
                return;
            }

            int dot = getDot();
            Rectangle r = null;
            char dotChar;
            try {
                r = comp.modelToView(dot);
                if (r == null) {
                    return;
                }
                dotChar = comp.getText(dot, 1).charAt(0);
            } catch (BadLocationException e) {
                return;
            }

            if ((x != r.x) || (y != r.y)) {
                // paint() has been called directly, without a previous call to
                // damage(), so do some cleanup. (This happens, for example, when
                // the
                // text component is resized.)
                repaint(); // erase previous location of caret
                x = r.x; // Update dimensions (width gets set later in this method)
                y = r.y;
                height = r.height;
            }

            //g.setColor(comp.getCaretColor());
            g.setColor(new Color(51, 255, 0));
            g.setXORMode(comp.getBackground()); // do this to draw in XOR mode

            if (dotChar == '\n') {
                int diam = r.height;
                if (isVisible()) {
                    //g.fillArc(r.x - diam / 2, r.y, diam, diam, 270, 180); // half
                    g.fillRect(r.x, r.y, width, r.height);
                }                                    // circle
                width = diam / 2 + 2;
                return;
            }

            if (dotChar == '\t') {
                try {
                    Rectangle nextr = comp.modelToView(dot + 1);
                    if ((r.y == nextr.y) && (r.x < nextr.x)) {
                        width = nextr.x - r.x;
                        if (isVisible()) {
                            g.fillRect(r.x, r.y, width, r.height);
                        }
                        return;
                    } else {
                        dotChar = ' ';
                    }
                } catch (BadLocationException e) {
                    dotChar = ' ';
                }
            }

            width = g.getFontMetrics().charWidth(dotChar);
            if (isVisible()) {
                g.fillRect(r.x, r.y, width, r.height);
            }
        }
    }
    // </editor-fold>

    // <editor-fold desc="CustomOutputStream" defaultstate="collapsed">
    /**
     * This class extends from OutputStream to redirect output to a JTextArrea
     *
     * @author www.codejava.net
     *
     */
    public class CustomOutputStream extends OutputStream {

        private final JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {
            // redirects data to the text area
            textArea.append(String.valueOf((char) b));
            // scrolls the text area to the end of data
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }
    // </editor-fold>

    private PrintStream standardOut;
    Scanner in = new Scanner(System.in);
    
    /**
     * Creates new form Frame
     */
    public WRAP_Console() {
        
        System.out.println("made it here");
        // makes new printstream reference and pushes it to main console stream
        PrintStream printStream = new PrintStream(new CustomOutputStream(console));
        
        System.out.println("made it here too");
        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);
        
        System.out.println("how about here");
        
        // inits the components
        initComponents();

        System.out.println("and here");
        
        // sets the cursor to the rectangle
        console.setCaret(new FancyCaret());

        // get the ball rolling with login
        System.out.print("username: ");
        String username = in.next();
        
        System.out.print("password: ");
        TextField passwordField = new TextField(8);
        passwordField.setEchoChar('*');
        String password = in.next();
        
        System.out.println("USERNAME: " + username.toUpperCase());
        System.out.println("PASSWORD: " + password.toUpperCase());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollpane = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        console.setBackground(new java.awt.Color(0, 0, 0));
        console.setColumns(20);
        console.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        console.setForeground(new java.awt.Color(51, 255, 0));
        console.setLineWrap(true);
        console.setRows(5);
        console.setWrapStyleWord(true);
        scrollpane.setViewportView(console);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("View");

        jMenuItem1.setText("Increase font size...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Decrease font size...");
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Font font = console.getFont();
        float size = font.getSize() + 2.0f;
        console.setFont(font.deriveFont(size));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(WRAP_Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WRAP_Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WRAP_Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WRAP_Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new WRAP_Console().setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea console;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane scrollpane;
    // End of variables declaration//GEN-END:variables
}
