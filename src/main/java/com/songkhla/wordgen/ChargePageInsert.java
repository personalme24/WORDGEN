/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import static com.songkhla.wordgen.ActionPage.ActionCode;
import static com.songkhla.wordgen.ActionPage.ActionCrimes;
import static com.songkhla.wordgen.ActionPage.ActionDetail;
import static com.songkhla.wordgen.ActionPage.ActionNote;
import static com.songkhla.wordgen.ChargePage.ChargeCode;
import static com.songkhla.wordgen.ChargePage.ChargeName;
import static com.songkhla.wordgen.ChargePage.Law;
import static com.songkhla.wordgen.ChargePage.Note;
import static com.songkhla.wordgen.ChargePage.RateOfPenalty;
import static com.songkhla.wordgen.CrimesCaseEdit.ChargeNameCase;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelChargeCode;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

/**
 *
 * @author Matazz
 */
public class ChargePageInsert extends javax.swing.JDialog {
 
    Connection con=null;
    PreparedStatement pst=null;
    boolean isInsert;
    
    /**
     * Creates new form ChangPage
     */
    String chargeNo; 
    public ChargePageInsert(JFrame parrent,JSONObject datain) {
        super(parrent,true);
        initComponents();
         ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES) BETA");
         ChargeCode.setText(IdCharge());
         con=ConnectDatabase.connect();
            if(datain!=null){
                
//            caseid= "" + datain.get("CaseId"); 
            chargeNo=datain.get("ChargeCode")+"";
            ChargeCode.setText(datain.get("ChargeCode")+"");
            ChargeName.setText(datain.get("ChargeName")+"");
             Law.setText(datain.get("Law")+"");
              RateOfPenalty.setText(datain.get("RateOfPenalty")+"");
             Note.setText(datain.get("Note")+"");
                 
           
           
        }
   
            else{
            isInsert=true;
        }
     JTextPopupMenu.addTo(ChargeName);
     JTextPopupMenu.addTo(Law);
     JTextPopupMenu.addTo(RateOfPenalty);
     JTextPopupMenu.addTo(Note);

    }

//    ChargePage(CrimesCaseEdit aThis, Object object) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Note = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        RateOfPenalty = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Law = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        ChargeName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonSaveCharge = new javax.swing.JButton();
        ChargeCode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ข้อมูลข้อหา");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("TH SarabunPSK", 0, 16)); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(4, 93, 179));

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ข้อหา");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Note.setColumns(20);
        Note.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        Note.setLineWrap(true);
        Note.setRows(5);
        Note.setTabSize(1);
        jScrollPane1.setViewportView(Note);

        RateOfPenalty.setColumns(20);
        RateOfPenalty.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        RateOfPenalty.setLineWrap(true);
        RateOfPenalty.setRows(5);
        RateOfPenalty.setTabSize(1);
        jScrollPane5.setViewportView(RateOfPenalty);

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel1.setText("อัตราโทษ");

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel3.setText("หมายเหตุ");

        Law.setColumns(20);
        Law.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        Law.setLineWrap(true);
        Law.setRows(5);
        Law.setTabSize(1);
        jScrollPane4.setViewportView(Law);

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel2.setText("กฎหมายที่อ้าง");

        ChargeName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel4.setText("ข้อหา");

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel5.setText("รหัสข้อหา");

        jButtonSaveCharge.setBackground(java.awt.SystemColor.windowText);
        jButtonSaveCharge.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonSaveCharge.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSaveCharge.setText("บันทึกข้อมูล");
        jButtonSaveCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveChargeActionPerformed(evt);
            }
        });

        ChargeCode.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        ChargeCode.setText("ChargeCode");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(ChargeCode))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChargeName)
                                .addGap(27, 27, 27))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jButtonSaveCharge)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jScrollPane1)))))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChargeCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(ChargeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSaveCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveChargeActionPerformed
        // TODO add your handling code here:
         if(isInsert){
    String intCh="INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(?,?,?,?,?) ";
//          String intCr="insert into CrimesCase(AnswerSuspect,AnswerAccuse) values(?,?) ";
        try {
           
           pst=con.prepareStatement(intCh);
               pst.setString(1,ChargeCode.getText());
            pst.setString(2,ChargeName.getText());
            pst.setString(3,Law.getText());
            pst.setString(4,RateOfPenalty.getText());
             pst.setString(5,Note.getText());
            
           
             int response = JOptionPane.showConfirmDialog(jPanel2, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
               pst.execute();
           System.out.println("SQLLLLL : "+intCh);
           pst.close();
          } 

        } catch (Exception e) {
         JOptionPane.showMessageDialog(jPanel2,"Cannot Save", null , JOptionPane.INFORMATION_MESSAGE);    
        }
         }
         else{
             try{
         String sqlUpdate="UPDATE Charge SET "
                + "ChargeName=?,"
                + "Law=?,"
                + "RateOfPenalty=?,"
                + "Note=?"
                 + "Where ChargeCode=?";
            pst=con.prepareStatement(sqlUpdate);       
            pst.setString(1,ChargeName.getText());
            pst.setString(2,Law.getText());
            pst.setString(3,RateOfPenalty.getText());
             pst.setString(4,Note.getText());
             pst.setString(5,ChargeCode.getText());
          
            int response = JOptionPane.showConfirmDialog(jPanel2, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                     pst.execute();
                     System.out.println("SQLLLLL : "+sqlUpdate);
                     pst.close();


              } 
        } catch (Exception e) {
          JOptionPane.showMessageDialog(jPanel1,e,null, JOptionPane.INFORMATION_MESSAGE);
            
        }
         
         }

           setVisible(false);
        
        
    }//GEN-LAST:event_jButtonSaveChargeActionPerformed

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
            java.util.logging.Logger.getLogger(ChargePageInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChargePageInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChargePageInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChargePageInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
//              new ChargePage().setVisible(true);

                 
            }
        });
    }
    
   public static String IdCharge(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(ChargeCode) ChargeCode from Charge";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("ChargeCode"); 
            }
            
            if(id==0){
                id=1;
            }
            else{
                id=id+1;
            }
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChargeCode;
    public static javax.swing.JTextField ChargeName;
    public static javax.swing.JTextArea Law;
    public static javax.swing.JTextArea Note;
    public static javax.swing.JTextArea RateOfPenalty;
    private javax.swing.JButton jButtonSaveCharge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
