/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import structure.ListPass;
import structure.Maxpass;
import structure.ModifPressPap;

/**
 *
 * @author Maxime
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * ListPass, which contains all data.
     */
    public static ListPass lp;

    /**
     * Allow to access clipboard.
     */
    public static ModifPressPap mpp = new ModifPressPap();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        // Initialize data
        initData();
        // Initialize table
        initTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password manager");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    /**
     * Initialize data.
     */
    private void initData() {
        System.out.println("Try to init ListPass object from " + ListPass.filename + " ... ");
        lp = ListPass.readFromFile();
        if (lp == null) {
            System.out.print("Initialize new empty map instead ... ");
            lp = new ListPass();
            System.out.println("Done.");
        } else {
            System.out.println("OK");
        }
    }

    /**
     * Initialize table with data.
     */
    private void initTable() {
        // Create object with data
        Object[][] obj = new Object[lp.size()][5];
        Set set = lp.keySet();
        Iterator it = set.iterator();
        int iterator = 0;
        while (it.hasNext()) {
            // Gey key
            String key = (String) it.next();
            obj[iterator][0] = key;
            // Get value
            Maxpass mp = lp.get(key);
            // Login
            obj[iterator][1] = mp.getLogin();
            obj[iterator][2] = "Copy";
            // Password
            obj[iterator][3] = mp.getPassword();
            obj[iterator][4] = "Copy";
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                obj,
                new String[]{
                    "Key", "Login", "Copy", "Password", "CopyP"
                }
        ));

        // Size of columns
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
        // Size of rows
        jTable1.setRowHeight(25);
        // For buttons
        jTable1.getColumn("Copy").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("CopyP").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("Copy").setCellEditor(new ButtonEditor(new JCheckBox()));
        jTable1.getColumn("CopyP").setCellEditor(new ButtonEditor(new JCheckBox()));

    }
}
