/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import com.songkhla.wordgen.*;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseid;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelNumberAcc;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextAccused;
import static com.songkhla.wordgen.ListAccused.jTableAccure;
import static com.songkhla.wordgen.ListSuspect.jTableSuspect;
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
/**
 *
 * @author Computer
 */
public class ListAccused extends javax.swing.JDialog {

    /**
     * Creates new form ListAccused
     */
Connection con=null;
String typeC;
    public ListAccused(JFrame parrent,JSONObject datain) {
        super(parrent,true);

        initComponents();  
        ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES)");
        txtCaseNO.setVisible(false);
        txtCaseNO.setText(datain.get("CaseIdAcc")+"");
         typeC=datain.get("TypeCase")+"";
         System.out.println("saaaaaaaaa: "+typeC);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAccure = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonDeleteAccured = new javax.swing.JButton();
        jButtonEditAccured = new javax.swing.JButton();
        txtCaseNO = new javax.swing.JLabel();
        jButtonAddAccused = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTableAccure.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jTableAccure.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "เลขคดี", "เลขบัตรประชน", "ชื่อ-นามสกุล"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAccure.setGridColor(new java.awt.Color(255, 255, 255));
        jTableAccure.setRowHeight(25);
        jTableAccure.setRowMargin(2);
        jTableAccure.getTableHeader().setFont(new Font("TH SarabunPSK", Font.BOLD, 20));
        jTableAccure.getTableHeader().setOpaque(false);
        jScrollPane1.setViewportView(jTableAccure);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(4, 93, 179));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ข้อมูลผู้กล่าวหา");

        jButtonDeleteAccured.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonDeleteAccured.setText("ลบ");
        jButtonDeleteAccured.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAccuredActionPerformed(evt);
            }
        });

        jButtonEditAccured.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonEditAccured.setText("แก้ไข");
        jButtonEditAccured.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditAccuredActionPerformed(evt);
            }
        });

        txtCaseNO.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        txtCaseNO.setText("No");

        jButtonAddAccused.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonAddAccused.setText("เพิ่ม");
        jButtonAddAccused.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAccusedActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("./Master/home.png"));
        jButton3.setText("เมนูหลัก");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonAddAccused, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditAccured, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteAccured, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCaseNO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(38, 38, 38))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddAccused)
                    .addComponent(jButtonEditAccured)
                    .addComponent(jButtonDeleteAccured)
                    .addComponent(txtCaseNO)
                    .addComponent(jButton3))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddAccusedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAccusedActionPerformed
        // TODO add your handling code here:
          JFrame frame = new JFrame();
             JDialog dialog = new JDialog(frame);//frame is owner
             JFrame facc = (JFrame)(dialog.getParent());               
             facc.removeAll();
//       if(typeC.equals("ชันสูตร")){
//       Identity_AccusedForm ida=new Identity_AccusedForm(facc,null);
//                  ida.pack();
//        ida.setLocationRelativeTo(null);      
//       ida.setVisible(true);
//       }  
//       else{  
        AccusedForm accusedF=new AccusedForm(facc,null);
                accusedF.pack();
        accusedF.setLocationRelativeTo(null); 
        accusedF.setVisible(true);
        
        
//       }
        RefreshData();
       
    }//GEN-LAST:event_jButtonAddAccusedActionPerformed

    private void jButtonEditAccuredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditAccuredActionPerformed
          JFrame frame = new JFrame();
             JDialog dialog = new JDialog(frame);//frame is owner
             JFrame f = (JFrame)(dialog.getParent());               
             f.removeAll();
          String crimecaseno = txtCaseNO.getText();
        if(jTableAccure.getSelectedRow()>=0){
           
            try{
                String Noperson = jTableAccure.getModel().getValueAt(jTableAccure.getSelectedRow(), 7)+"";            
                String sql = "select NoPerson,Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
                        "Height,Weight,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
                        "PhonePerson,Province,Race,OrderPerson,Religion,Tambon,TypePerson,ZipCode,caseIdPerson from person where Noperson='"+Noperson+ "' and caseIdPerson='"+crimecaseno+"' and TypePerson='ผู้กล่าวหา'";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
//                System.out.println("dddddddddddddd:"+sql);
                if(rs.next()){
                    JSONObject data = new JSONObject();
                      data.put("NoPerson", rs.getString("NoPerson"));
                    data.put("PeopleRegistrationID", rs.getString("PeopleRegistrationID"));
                    data.put("crimecaseno", rs.getString("caseIdPerson"));
                    data.put("Age", rs.getString("Age"));
                    data.put("Amphur", rs.getString("Amphur"));
                    data.put("BirthDay", rs.getString("BirthDay"));
                    data.put("BloodGroup", rs.getString("BloodGroup"));
                    data.put("ExpiredDate", rs.getString("ExpiredDate"));
                    data.put("FatherFullName", rs.getString("FatherFullName"));
                    data.put("FullNamePerson", rs.getString("FullNamePerson"));
                    data.put("FullNamePersonEn", rs.getString("FullNamePersonEn"));
                    data.put("Gender", rs.getString("Gender"));
                    data.put("Height", rs.getString("Height"));
                    data.put("Weight", rs.getString("Weight"));
                    data.put("HouseNumber", rs.getString("HouseNumber"));
                    data.put("IssueDate", rs.getString("IssueDate"));
                    data.put("Moo", rs.getString("Moo"));
                    data.put("MotherFullName", rs.getString("MotherFullName"));
                    data.put("Nationality", rs.getString("Nationality"));
                    data.put("Occupation", rs.getString("Occupation"));
                    data.put("PassportNumber", rs.getString("PassportNumber"));
                    data.put("PhonePerson", rs.getString("PhonePerson"));
                    data.put("Province", rs.getString("Province"));
                    data.put("Race", rs.getString("Race"));
                    data.put("Religion", rs.getString("Religion"));
                    data.put("Tambon", rs.getString("Tambon"));
                     data.put("ZipCode", rs.getString("ZipCode"));
                     data.put("OrderPerson", rs.getString("OrderPerson"));
                      data.put("OtherName", rs.getString("OtherName"));

                            AccusedForm accusedF=new AccusedForm(f,data);
                             accusedF.pack();
                             accusedF.setLocationRelativeTo(null);
                            accusedF.setVisible(true);    		
                }
                
                rs.close();
                stmt.close();
                RefreshData();
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        
       
        }else{

        }
                                              
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditAccuredActionPerformed

    private void jButtonDeleteAccuredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAccuredActionPerformed
              if(jTableAccure.getSelectedRow()>=0){
                  
            try{
                String Noperson = jTableAccure.getModel().getValueAt(jTableAccure.getSelectedRow(), 7)+"";
                String PeopleRegistrationID = jTableAccure.getModel().getValueAt(jTableAccure.getSelectedRow(), 2)+"";
                String sql = "Delete from person WHERE Noperson='"+Noperson+ "' and  caseIdPerson='"+txtCaseNO.getText()+"'";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                

                System.out.println("SQL : "+sql);
                stmt.close();
                RefreshData();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteAccuredActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        MainMenuWord.closeAllDialogs();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ListAccused.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListAccused.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListAccused.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListAccused.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ListAccused().setVisible(true);

  
            }
        });
    }
     public void RefreshData(){
        try{
              
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
        String a=txtCaseNO.getText();
        String sql = "select Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
                     "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
                     "PhonePerson,NoPerson,Province,Race,Religion,OrderPerson,Tambon,TypePerson,Weight,ZipCode,caseIdPerson from person where TypePerson='ผู้กล่าวหา' and"
                + " caseIdPerson='"+a+"'"+getFilterCondition()+" order by OrderPerson ASC";
      
        ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);
        Vector<Vector> tabledata = new Vector<Vector>();
        while(rs.next()){
            Vector<String> row = new Vector<String>();
            row.add(rs.getString("OrderPerson"));
            row.add(rs.getString("PeopleRegistrationID"));
            row.add(rs.getString("FullNamePerson"));
            row.add(rs.getString("Age"));
            row.add(rs.getString("Race"));
            row.add(rs.getString("Nationality"));
            row.add(rs.getString("Religion"));
            row.add(rs.getString("NoPerson"));
            tabledata.add(row);
        }
        rs.close();
        stmt.close();
        Vector ColumnName = new Vector();
         ColumnName.add("ลำดับผู้กล่าวหา");
         ColumnName.add("เลขบัตรประชาชน");
        ColumnName.add("ชื่อ-นามสุกล");
        ColumnName.add("อายุ");
        ColumnName.add("เชื้อชาติ");
        ColumnName.add("สัญชาติ");
        ColumnName.add("ศาสนา");
        ColumnName.add("เลขคน");
         System.out.println("SQL : "+sql);
     
        jTableAccure.setModel(new javax.swing.table.DefaultTableModel(
            tabledata,
            ColumnName
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
         jTableAccure.getColumnModel().getColumn(7).setWidth(0);
jTableAccure.getColumnModel().getColumn(7).setMinWidth(0);
jTableAccure.getColumnModel().getColumn(7).setMaxWidth(0); 
         if(jTableAccure.getRowCount()<=0){
//             int rows = jTableAccure.getRowCount();
            if(typeC.equals("อาญา")){
            CrimesCaseEdit.jTextAccused.setText(""); 
            }
            if(typeC.equals("จราจร")){
            TrafficEdit.jTextAccused.setText(""); 
            }
              if(typeC.equals("ชันสูตร")){
            IdentityEdit.jTextAccused.setText(""); 
            }
            }
         if(jTableAccure.getRowCount()==1){
//             int rows = jTableAccure.getRowCount();
            if(typeC.equals("อาญา")){
                
            CrimesCaseEdit.jTextAccused.setText(jTableAccure.getValueAt(0, 2).toString()); 
            }
            if(typeC.equals("จราจร")){
            TrafficEdit.jTextAccused.setText(jTableAccure.getValueAt(0, 2).toString()); 
            }
              if(typeC.equals("ชันสูตร")){
            IdentityEdit.jTextAccused.setText(jTableAccure.getValueAt(0, 2).toString()); 
            }
            }
            if(jTableAccure.getRowCount()>1){
            
            if(typeC.equals("อาญา")){
            CrimesCaseEdit.jTextAccused.setText(jTableAccure.getValueAt(0, 2).toString()+"และคนอื่นๆ"); 
            }
            if(typeC.equals("จราจร")){
            TrafficEdit.jTextAccused.setText(jTableAccure.getValueAt(0, 2).toString()+"และคนอื่นๆ"); 
            }
              if(typeC.equals("ชันสูตร")){
            IdentityEdit.jTextAccused.setText(jTableAccure.getValueAt(0, 2).toString()+"และคนอื่นๆ"); 
            }
            }
            
               if(typeC.equals("อาญา")){
             int rows = jTableAccure.getRowCount();
                       CrimesCaseEdit.jLabelNumberAcc.setText(rows+"");  
            }
            if(typeC.equals("จราจร")){
             int rows = jTableAccure.getRowCount();
                       TrafficEdit.jLabelNumberAcc.setText(rows+"");   
            }
              if(typeC.equals("ชันสูตร")){
            int rows = jTableAccure.getRowCount();
                       IdentityEdit.jLabelNumberAcc.setText(rows+"");   
            }
          
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
      private String getFilterCondition(){
        HashMap<String,String> filter = new HashMap<String,String>();
        if(txtCaseNO.getText().trim().length()>0){
            filter.put("caseIdPerson", txtCaseNO.getText().trim());
        }
        
        String[] key = filter.keySet().toArray(new String[0]);
        String result="";
        for(int i=0;i<key.length;i++){
            if(i==0){
                result=" and ";
            }
            if(i==key.length-1){
                result+= " "+key[i]+" LIKE '%"+filter.get(key[i])+"%'";
            }else{
                result+= " "+key[i]+" LIKE "+filter.get(key[i])+" and TypePerson='ผู้กล่าวหา' ";
            }
            System.out.println(result);
        }
        
        return result;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAddAccused;
    private javax.swing.JButton jButtonDeleteAccured;
    private javax.swing.JButton jButtonEditAccured;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableAccure;
    public static javax.swing.JLabel txtCaseNO;
    // End of variables declaration//GEN-END:variables
}
