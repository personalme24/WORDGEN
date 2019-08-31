/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;
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
 * @author Petpilin
 */
public class BailAssetAdd extends javax.swing.JDialog {
    Connection con=null;
    PreparedStatement pst=null;
    DataCase dc =new DataCase();
    boolean isInsert;
    String caseId,personId;
    /**
     * Creates new form BailAssetAdd
     */
    public BailAssetAdd(JFrame parrent,JSONObject datain,JSONObject dataId) {
                super(parrent,true);        
                initComponents();
                ImageIcon img = new ImageIcon("./Master/WD.png");
                setIconImage(img.getImage());
                setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES)");
                jLabel2.setVisible(false);
                jLabel3.setVisible(false);
                caseId=dataId.get("BailCaseId")+"";
                personId=dataId.get("BailPersonId")+"";
                jLabel2.setText(caseId);
                jLabel3.setText(personId);
                if(datain!=null){
                    BailAssetOrder.setText(datain.get("BailAssetOrder")+"");
                     BailAssetDetail.setText(datain.get("BailAssetDetail")+"");
                    BailAssetBath.setText(datain.get("BailAssetBath")+"");
                    BailAmount.setText(datain.get("BailAmount")+"");
                    BailAssetTotal.setText(datain.get("BailAssetTotal")+"");
                    BailAssetRemark.setText(datain.get("BailAssetRemark")+"");
//                    jLabel2.setText(datain.get("BailCaseId")+"");
//                     jLabel3.setText(datain.get("BailPersonId")+"");
//                  
         
                
                }
                else{
                    BailAssetOrder.setText(IdBailAsset());
                isInsert=true;}
                  JTextPopupMenu.addTo(BailAssetDetail);
           JTextPopupMenu.addTo(BailAssetBath);
          JTextPopupMenu.addTo(BailAmount);
          JTextPopupMenu.addTo(BailAssetTotal);
          JTextPopupMenu.addTo(BailAssetRemark);

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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        BailAssetDetail = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        BailAmount = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        BailAssetBath = new javax.swing.JTextField();
        BailAssetTotal = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        BailAssetRemark = new javax.swing.JTextArea();
        jButtonSave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BailAssetOrder = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("เพิ่ม/แก้ไข บัญชีทรัพย์สินของผู้ประกันตัว ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel16.setText("ลำดับ");

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel17.setText("ทรัพย์สิน");

        BailAssetDetail.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel18.setText("จำนวน");

        BailAmount.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel19.setText("มูลค่า(บาท)");

        BailAssetBath.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        BailAssetTotal.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel21.setText("รวมมูลค่า(บาท)");

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel23.setText("หมายเหตุ");

        BailAssetRemark.setColumns(20);
        BailAssetRemark.setRows(5);
        jScrollPane4.setViewportView(BailAssetRemark);

        jButtonSave.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonSave.setText("บันทึก");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        BailAssetOrder.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        BailAssetOrder.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BailAssetDetail)
                                    .addComponent(BailAmount)
                                    .addComponent(jScrollPane4)
                                    .addComponent(BailAssetBath)
                                    .addComponent(BailAssetTotal))
                                .addGap(58, 58, 58))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BailAssetOrder)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BailAssetOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BailAssetDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BailAssetBath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BailAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BailAssetTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButtonSave)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:

        con=ConnectDatabase.connect();
        if(isInsert){

        try {

                String sql="INSERT INTO BailAsset (BailAssetOrder,BailAssetDetail,BailAssetBath,BailAmount,BailAssetTotal,BailAssetRemark,BailCaseId,BailPersonId)\n"
                + "VALUES (?,?,?,?,?,?,?,?)";
                pst=con.prepareStatement(sql);
               
                pst.setString(1,BailAssetOrder.getText());
                pst.setString(2,BailAssetDetail.getText());
                pst.setString(3,BailAssetBath.getText());
                pst.setString(4,BailAmount.getText());           
                pst.setString(5,BailAssetTotal.getText());
                pst.setString(6,BailAssetRemark.getText());
                pst.setString(7,caseId);
                pst.setString(8,personId);
          
                
                 int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
             pst.executeUpdate();
                      pst.close();
          } 
        }
                 catch (Exception e) {
 JOptionPane.showMessageDialog(jPanel1, "test info", "Cannot Save", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("SQL : "+pst);
        }
        }  
            else{
            try{
                String sqlUpdate= "UPDATE BailAsset Set\n "
                + "BailAssetDetail=?,"
                + "BailAssetBath=?,"
                + "BailAmount=?,"
                + "BailAssetTotal=?,"
                + "BailAssetRemark=?"
                
                + "Where BailCaseId=? and BailPersonId=? and BailAssetOrder=?";
                
                pst=con.prepareStatement(sqlUpdate);
                pst.setString(1,BailAssetDetail.getText());
                pst.setString(2,BailAssetBath.getText());
                pst.setString(3,BailAmount.getText());           
                pst.setString(4,BailAssetTotal.getText());
                pst.setString(5,BailAssetRemark.getText());
                pst.setString(6,caseId);
                pst.setString(7,personId);
                pst.setString(8,BailAssetOrder.getText());
                
                int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการแก้ไขข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
             pst.executeUpdate();
                      pst.close();
          } 
            }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("SQL : "+pst);
           }
        }
        setVisible(false);

    }//GEN-LAST:event_jButtonSaveActionPerformed

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
            java.util.logging.Logger.getLogger(BailAssetAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BailAssetAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BailAssetAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BailAssetAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new BailAssetAdd().setVisible(true);
            }
        });
    }
   public  String IdBailAsset(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(BailAssetOrder) BailAssetOrder from BailAsset where BailCaseId='"+caseId+"' and BailPersonId='"+personId+"'";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("BailAssetOrder"); 
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
    private javax.swing.JTextField BailAmount;
    private javax.swing.JTextField BailAssetBath;
    private javax.swing.JTextField BailAssetDetail;
    private javax.swing.JLabel BailAssetOrder;
    private javax.swing.JTextArea BailAssetRemark;
    private javax.swing.JTextField BailAssetTotal;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
