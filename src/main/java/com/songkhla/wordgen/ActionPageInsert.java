/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import static com.songkhla.wordgen.AccusedForm.Checknull;
import static com.songkhla.wordgen.ActionPage.ActionCode;

import static com.songkhla.wordgen.ChargePage.ChargeCode;
import static com.songkhla.wordgen.ChargePage.ChargeName;
import static com.songkhla.wordgen.ChargePage.Law;
import static com.songkhla.wordgen.ChargePage.Note;
import static com.songkhla.wordgen.ChargePage.RateOfPenalty;
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
public class ActionPageInsert extends javax.swing.JDialog {
    Connection con=null;
    PreparedStatement pst=null;
        boolean isInsert;

    
    /**
     * Creates new form ChangPage
     */
//    String chargeNo; 
    public ActionPageInsert(JFrame parrent,JSONObject datain) {
        super(parrent,true);
        initComponents();       
         ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES) BETA");
        con=ConnectDatabase.connect();
        jScrollPane5.setVisible(false);
                jScrollPane6.setVisible(false);
jLabel21.setVisible(false);
jLabel20.setVisible(false);
        if(datain!=null){
//            caseid= "" + datain.get("CaseId"); 
//            chargeNo=datain.get("ActionCode")+"";
            ActionCode.setText(Checknull(datain.get("ActionCode"))+"");
            ActionCrimes.setText(Checknull(datain.get("ActionCrimes"))+"");
             ActionDetail.setText(Checknull(datain.get("ActionDetail"))+"");
              ActionNote.setText(Checknull(datain.get("ActionNote"))+"");
               AnswerAccuser.setText(Checknull(datain.get("AnswerAccuser"))+"");
              AnswerSuspect.setText(Checknull(datain.get("AnswerSuspect"))+"");
             }
          else{
        isInsert=true;
        ActionCode.setText(IdAction());
        }
        
         JTextPopupMenu.addTo(ActionCrimes);
         JTextPopupMenu.addTo(ActionDetail);
         JTextPopupMenu.addTo(AnswerAccuser);
         JTextPopupMenu.addTo(AnswerSuspect);
         JTextPopupMenu.addTo(ActionNote);

    }

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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ActionDetail = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        ActionCrimes = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ButtonAddAction = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ActionNote = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        AnswerAccuser = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        AnswerSuspect = new javax.swing.JTextArea();
        ActionCode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ข้อมูลข้อหา");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("TH SarabunPSK", 0, 16)); // NOI18N
        setForeground(java.awt.Color.white);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(4, 93, 179));
        jPanel1.setPreferredSize(new java.awt.Dimension(744, 720));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("พฤติการณ์คดี");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setText("หมายเหตุ");

        ActionDetail.setColumns(10);
        ActionDetail.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        ActionDetail.setLineWrap(true);
        ActionDetail.setRows(5);
        jScrollPane4.setViewportView(ActionDetail);

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("รายละเอียดพฤติการณ์คดี");

        ActionCrimes.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel4.setText("พฤติการณ์คดี");

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("รหัสพฤติการณ์");

        ButtonAddAction.setBackground(java.awt.SystemColor.windowText);
        ButtonAddAction.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        ButtonAddAction.setForeground(new java.awt.Color(255, 255, 255));
        ButtonAddAction.setText("บันทึกข้อมูล");
        ButtonAddAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionActionPerformed(evt);
            }
        });

        ActionNote.setColumns(20);
        ActionNote.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        ActionNote.setLineWrap(true);
        ActionNote.setRows(3);
        jScrollPane2.setViewportView(ActionNote);

        AnswerAccuser.setColumns(20);
        AnswerAccuser.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        AnswerAccuser.setLineWrap(true);
        AnswerAccuser.setRows(5);
        AnswerAccuser.setAutoscrolls(false);
        jScrollPane5.setViewportView(AnswerAccuser);

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel21.setText("คำให้การผู้กล่าวหา/พยาน");

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel20.setText("คำให้การผู้ต้องหา");

        AnswerSuspect.setColumns(20);
        AnswerSuspect.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        AnswerSuspect.setLineWrap(true);
        AnswerSuspect.setRows(5);
        jScrollPane6.setViewportView(AnswerSuspect);

        ActionCode.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        ActionCode.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(ButtonAddAction)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ActionCode)))
                        .addGap(486, 486, 486))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jScrollPane6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(ActionCrimes)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ActionCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(ActionCrimes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonAddAction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(344, 344, 344))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAddActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionActionPerformed
        // TODO add your handling code here: 
        String intAc="INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,ActionNote,AnswerAccuser,AnswerSuspect) values(?,?,?,?,?,?) ";
//          String intCr="insert into CrimesCase(AnswerSuspect,AnswerAccuse) values(?,?) ";
       if(isInsert){
            try {
           
           pst=con.prepareStatement(intAc);
           pst.setString(1, ActionCode.getText());
           pst.setString(2, ActionCrimes.getText());
           pst.setString(3, ActionDetail.getText());
           pst.setString(4, ActionNote.getText());
           pst.setString(5, AnswerAccuser.getText());
           pst.setString(6, AnswerSuspect.getText()); 
          
            int response = JOptionPane.showConfirmDialog(jPanel2, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                     pst.execute();
                     System.out.println("SQLLLLL : "+intAc);
                     pst.close();


              } 
        } catch (Exception e) {
          JOptionPane.showMessageDialog(jPanel1,e,null, JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
          else{
//          String intCr="insert into CrimesCase(AnswerSuspect,AnswerAccuse) values(?,?) ";
        try {
            String sqlUpdate="UPDATE ActionsCase set "
                + "ActionCrimes=?,"
                + "ActionDetail=?,"
                + "ActionNote=?,"
                + "AnswerAccuser=?,"
                + "AnswerSuspect=?"
                 + "Where ActionCode=?";
      
           pst=con.prepareStatement(sqlUpdate);
           pst.setString(1, ActionCrimes.getText());
           pst.setString(2, ActionDetail.getText());
           pst.setString(3, ActionNote.getText());
           pst.setString(4, AnswerAccuser.getText());
           pst.setString(5, AnswerSuspect.getText()); 
             pst.setString(6, ActionCode.getText());
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
    }//GEN-LAST:event_ButtonAddActionActionPerformed

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
            java.util.logging.Logger.getLogger(ActionPageInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActionPageInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActionPageInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActionPageInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                          new ActionPage().setVisible(true);
            }
        });
    }
   public static String IdAction(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(ActionCode) ActionCode from ActionsCase";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("ActionCode"); 
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
   public static String Checknull(Object input){
					if(input==null||input==""||input=="null") { return ""; }
					return input+"";
					}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ActionCode;
    public static javax.swing.JTextField ActionCrimes;
    public static javax.swing.JTextArea ActionDetail;
    public static javax.swing.JTextArea ActionNote;
    private javax.swing.JTextArea AnswerAccuser;
    private javax.swing.JTextArea AnswerSuspect;
    private javax.swing.JButton ButtonAddAction;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
