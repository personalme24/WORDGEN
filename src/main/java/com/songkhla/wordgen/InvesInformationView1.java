/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import static com.songkhla.wordgen.ListSuspect.jTableSuspect;
import static com.songkhla.wordgen.ListSuspect.txtCaseNO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.json.simple.JSONObject;
import java.awt.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author Petpilin
 */
public class InvesInformationView1 extends javax.swing.JDialog{

    /**
     * Creates new form InvesInformationView
     */
 
        Connection con=null;
    public InvesInformationView1(JFrame parrent) {
        super(parrent,true);
        initComponents();
        ImageIcon img = new ImageIcon("D://Master//WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES)");
        RefreshData();
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInvest = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        txtCaseNO = new javax.swing.JTextField();
        jButtonFind = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ข้อมูลพนักงานสอบสวนในหน่วยงาน");

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

        jTableInvest.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jTableInvest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ลำดับ", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableInvest.getTableHeader().setFont(new Font("TH SarabunPSK", Font.BOLD, 20));
        jTableInvest.getTableHeader().setOpaque(false);
        jScrollPane1.setViewportView(jTableInvest);

        jButtonAdd.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAdd.setText("เพิ่ม");
        jButtonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddMouseClicked(evt);
            }
        });
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonEdit.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonEdit.setText("แก้ไข");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonDelete.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonDelete.setText("ลบ");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        txtCaseNO.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jButtonFind.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonFind.setText("ค้นหา");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCaseNO, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFind)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCaseNO, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFind)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddMouseClicked
              InvesInformationFrom ii=new InvesInformationFrom(null,null);
        ii.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddMouseClicked

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
         JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fwit = (JFrame)(dialog.getParent());
        fwit.removeAll();
       InvesInformationFrom ii=new InvesInformationFrom(fwit,null);
       ii.pack();
       ii.setLocationRelativeTo(null);
        ii.setVisible(true);
                RefreshData();

    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
          JFrame frame = new JFrame();
                      JDialog dialog = new JDialog(frame);//frame is owner
                    JFrame fwit = (JFrame)(dialog.getParent());
                                 fwit.removeAll();

        if(jTableInvest.getSelectedRow()>=0){
            try{
                String investId = jTableInvest.getModel().getValueAt(jTableInvest.getSelectedRow(), 0)+"";

                String sql="select InvestId,InvestCardID,InvestRank,InvestName,InvestPosition,"
                        + "InvestBirthDay,InvestAge,InvestTel from InvestInformation where InvestId="+investId;
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("ExSql : "+sql);
                if(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("InvestId", rs.getString("InvestId"));
                    data.put("InvestCardID", rs.getString("InvestCardID"));
                     data.put("InvestRank", rs.getString("InvestRank"));           
                    data.put("InvestName", rs.getString("InvestName"));
                    data.put("InvestPosition", rs.getString("InvestPosition"));
                    data.put("InvestBirthDay", rs.getString("InvestBirthDay"));
                    data.put("InvestAge", rs.getString("InvestAge"));
                    data.put("InvestTel", rs.getString("InvestTel"));
                 
                    InvesInformationFrom iif =new InvesInformationFrom(fwit,data);
                    iif.pack();
                    iif.setLocationRelativeTo(null);
                    iif.setVisible(true);
                }

                rs.close();
                stmt.close();
                RefreshData();
            }catch(Exception ex){
                ex.printStackTrace();

            }
        }else{

        }       
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        if(jTableInvest.getSelectedRow()>=0){
            try{
                
                String InvestId = jTableInvest.getModel().getValueAt(jTableInvest.getSelectedRow(), 0)+"";

                String sql = "DELETE FROM InvestInformation WHERE InvestId='"+InvestId+"';";
                Connection con = ConnectDatabase.connect();
//                System.out.println("Delete:"+sql);
                Statement  stmt = con.createStatement();
                
                int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการลบข้อมูลพนักงานสอบสวน", null,
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    stmt.executeUpdate(sql);
                    stmt.close();
                }
                RefreshData();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed
  public void RefreshData(){
     try{
              
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
       
        String sql = "select InvestId,InvestCardID,InvestRank,InvestName,InvestPosition,InvestBirthDay,InvestAge,InvestTel from InvestInformation" ;
        ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);
        Vector<Vector> tabledata = new Vector<Vector>();
        while(rs.next()){
            Vector<String> row = new Vector<String>();
            row.add(rs.getString("InvestId"));
            row.add(rs.getString("InvestRank")+" "+rs.getString("InvestName"));
            row.add(rs.getString("InvestPosition"));
            row.add(rs.getString("InvestBirthDay"));
            row.add(rs.getString("InvestAge"));
            row.add(rs.getString("InvestTel"));
            tabledata.add(row);
        }
        rs.close();
        stmt.close();
        Vector ColumnName = new Vector();
       ColumnName.add("ลำดับ");
        ColumnName.add("ยศนาม");
        ColumnName.add("ตำแหน่ง");
        ColumnName.add("วันเดือนปีเกิด");
        ColumnName.add("อายุ");     
        ColumnName.add("เบอร์โทรศัพท์");
         System.out.println("SQL : "+sql);
     
        jTableInvest.setModel(new javax.swing.table.DefaultTableModel(
            tabledata,
            ColumnName
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
                             System.out.println("SQL : "+sql);

        }catch(Exception ex){
            ex.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(InvesInformationView1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvesInformationView1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvesInformationView1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvesInformationView1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new InvesInformationView().setVisible(true);
            }
        });
    }
   
//       private String getFilterCondition(){
//        HashMap<String,String> filter = new HashMap<String,String>();
//        if(txtSearchCase.getText().trim().length()>0){
//            filter.put("crimecaseno", txtSearchCase.getText().trim());
////            filter.put("AccureandOther", txtSearchCase.getText().trim());
//        }
//        
//        String[] key = filter.keySet().toArray(new String[0]);
//        String result="";
//        for(int i=0;i<key.length;i++){
//            if(i==0){
//                result=" or ";
//            }
//            if(i==key.length-1){
//                result+= " "+key[i]+" LIKE '%"+filter.get(key[i])+"%'";
//            }else{
//                result+= " "+key[i]+" LIKE "+filter.get(key[i])+" or ";
//            }
//            System.out.println(result);
//        }
//        
//        return result;
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInvest;
    private javax.swing.JTextField txtCaseNO;
    // End of variables declaration//GEN-END:variables
}
