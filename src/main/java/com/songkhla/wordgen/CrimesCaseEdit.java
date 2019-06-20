/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;


import static com.songkhla.wordgen.ListAccused.jTableAccure;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.json.simple.JSONObject;

/**
 *
 * @author Petpilin
 */
public class CrimesCaseEdit extends javax.swing.JDialog {
    Connection con=null;
    PreparedStatement pst=null;;
    boolean isInsert;
    String caseid;

    /**
     * Creates new form CrimesCaseEdit
     */
    public CrimesCaseEdit(JFrame parrent,JSONObject datain){
        super(parrent,true);
     
//      try  {
//        for (UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()){
//        
//                 if("Windows".equals(info.getName()))
//                 {
//                 UIManager.setLookAndFeel(info.getClassName());
//                 }
//        }
//      }catch(Exception ex){
//          ex.getMessage();
//      }
           initComponents();
           eventJRadioKnowSuspect();
        
        
        comboInvest();
//        jTextPoliceName.setText(Data.getPolicName());
        jLabelActionCode.setVisible(false);
        jLabelChargeCode.setVisible(false);
        crimecaseid.setVisible(true);
         
        if(datain!=null){
            try {
                String rt=datain.get("CaseRequestTime")+"";
                String at=datain.get("CaseAcceptTime")+"";
                String ot=datain.get("CaseAcceptTime")+"";
                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
                Date timeReq = dateFormat.parse(rt);
                Date timeAcc = dateFormat.parse(at);
                Date timeOccu = dateFormat.parse(ot);
                isInsert=false;
                caseid= "" + datain.get("CaseId");
                crimecaseid.setText(datain.get("CaseId")+"");
//          ID.setText(datain.get("CaseId")+"");
            crimecaseno.setText(datain.get("crimecaseno")+"");
            crimecaseyear.setText(datain.get("crimecaseyears")+"");
            jLabelChargeCode.setText(datain.get("ChargeCode")+"");
            ChargeNameCase.setText(datain.get("ChargeName")+"");
            CaseRequestDateTime.setText(datain.get("CaseRequestDate")+"");
            jTextAccused.setText(datain.get("AccureandOther")+"");
            CourtType.setSelectedItem(datain.get("TypeCourt"));
            CrimeLocation.setText(datain.get("CrimeLocation")+"");
            CrimeLocationDistrict.setText(datain.get("CrimeLocationDistrict")+"");
            CrimeLocationAmphur.setText(datain.get("CrimeLocationAmphur")+"");
            CrimeLocationProvince.setText(datain.get("CrimeLocationProvince")+"");
            jComboPoliceName.setSelectedItem(datain.get("PoliceNameCase"));
            jTextSuspect.setText(datain.get("SuspectandOther")+"");
            jTextWitness.setText(datain.get("WitnessandOther")+"");
            CaseRequestTimee.setValue(timeReq);
            CaseAcceptDate.setText(datain.get("CaseAcceptDate")+"");
            CaseAcceptTimee.setValue(timeAcc);
            DailyNumber.setText(datain.get("DailyNumber")+"");
            String investSta=datain.get("Investigator_Result")+"";
            OccuredDate.setText(datain.get("OccuredDate")+"");
            OccuredDateTime.setValue(timeOccu);
            if(investSta.equals("อยู่ระหว่างสอบสวน")){
                jCheckDuringInvest.setSelected(true);
            }
            if(investSta.equals("สั่งฟ้อง")){
                jCheckSue.setSelected(true);
            }
            if(investSta.equals("สั่งไม่ฟ้อง")){
                jCheckNotSue.setSelected(true);
            }
            if(investSta.equals("งดการสอบสวน")){
                jCheckNoInvest.setSelected(true);
            }
            if(investSta.equals("อื่นๆ")){
                jCheckOtherInvest.setSelected(true);
            }
            ListAsset.setText(datain.get("AssetList")+"");
            ActionCrimes.setText(datain.get("ActionCrimes")+"");
            jLabelActionCode.setText(datain.get("ActionCode")+"");
            } catch (ParseException ex) {
                Logger.getLogger(CrimesCaseEdit.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else{
           crimecaseid.setText(IdCase());
            isInsert=true;
          
        }
            
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTimeChooserDemo1 = new lu.tudor.santec.jtimechooser.demo.JTimeChooserDemo();
        jTimeChooserDemo2 = new lu.tudor.santec.jtimechooser.demo.JTimeChooserDemo();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        crimecaseno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        crimecaseyear = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CourtType = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        ChargeNameCase = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ActionCrimes = new javax.swing.JTextField();
        jButtonAction = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        DailyNumber = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        OccuredDate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        CrimeLocation = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextAccused = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        CrimeLocationAmphur = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        CrimeLocationProvince = new javax.swing.JTextField();
        jButtonCharge = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        CrimeLocationDistrict = new javax.swing.JTextField();
        jButtonAccured = new javax.swing.JButton();
        jButtonSaveCase = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jTextSuspect = new javax.swing.JTextField();
        jButtonSuspect = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        ListAsset = new javax.swing.JTextField();
        jButtonWitness = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jTextWitness = new javax.swing.JTextField();
        jButtonAddAsset = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        EvidenceRecordCase = new javax.swing.JTextField();
        jCheckSue = new javax.swing.JCheckBox();
        jCheckDuringInvest = new javax.swing.JCheckBox();
        jCheckNotSue = new javax.swing.JCheckBox();
        jCheckOtherInvest = new javax.swing.JCheckBox();
        jCheckNoInvest = new javax.swing.JCheckBox();
        jLabel31 = new javax.swing.JLabel();
        jTextInvestSendtoDepartment = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextInvestigatorResult = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextCourtResult = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        jLabelChargeCode = new javax.swing.JLabel();
        CaseRequestDateTime = new javax.swing.JTextField();
        CaseAcceptDate = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        AnswerSuspect = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        AnswerVictim = new javax.swing.JTextArea();
        jLabelActionCode = new javax.swing.JLabel();
        Date date=new Date();

        SpinnerDateModel sm=new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        CaseRequestTimee = new javax.swing.JSpinner(sm);
        Date date2=new Date();

        SpinnerDateModel sm2=new SpinnerDateModel(date2,null,null,Calendar.HOUR_OF_DAY);
        CaseAcceptTimee = new javax.swing.JSpinner(sm2);
        Date date3=new Date();

        SpinnerDateModel sm3=new SpinnerDateModel(date3,null,null,Calendar.HOUR_OF_DAY);
        OccuredDateTime = new javax.swing.JSpinner(sm3);
        jButtonAddInvest = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextRecordInvest = new javax.swing.JTextField();
        jComboPoliceName = new javax.swing.JComboBox<>();
        jRadioKnowSuspect = new javax.swing.JRadioButton();
        jRadioUnknowSuspect = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CaseType = new javax.swing.JLabel();
        crimecaseid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel3.setText("อำนาจศาล");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 45, -1, 30));

        crimecaseno.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        crimecaseno.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(crimecaseno, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 46, 80, -1));

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel4.setText("/");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 45, -1, 30));

        crimecaseyear.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(crimecaseyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 45, 80, -1));

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel5.setText("เลขคดี");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 45, -1, 30));

        CourtType.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        CourtType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ศาลอาญา", "ศาลแขวง", "ศาลเยาวชน", "ศาลทหาร" }));
        CourtType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourtTypeActionPerformed(evt);
            }
        });
        jPanel1.add(CourtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 45, 254, -1));

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel6.setText("ข้อหา");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 117, -1, 30));

        ChargeNameCase.setEditable(false);
        ChargeNameCase.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(ChargeNameCase, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 117, 384, -1));

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButton1.setText("ต/อ/จ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 444, -1, -1));

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel7.setText("พฤติการณ์คดี");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 78, 77, 30));

        ActionCrimes.setEditable(false);
        ActionCrimes.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(ActionCrimes, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 78, 383, -1));

        jButtonAction.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAction.setText("พฤติการณ์คดี");
        jButtonAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 77, -1, -1));

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel8.setText("วันที่รับแจ้ง");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 155, -1, 30));

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel9.setText("เวลารับแจ้ง");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 156, -1, 30));

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel10.setText("ปจว.ข้อ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 290, -1, 30));

        DailyNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(DailyNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 328, 496, 69));

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel11.setText("วันที่รับคำร้องทุกข์");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 201, -1, 30));

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel12.setText("เวลารับคำร้องทุกข์");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 201, -1, 30));

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel13.setText("วันที่เกิดเหตุ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 240, -1, 30));

        OccuredDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(OccuredDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 240, 184, -1));

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel14.setText("เวลาที่เกิดเหตุ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 240, -1, 30));

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel15.setText("สถานที่เกิดเหตุ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 326, 85, 30));

        CrimeLocation.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(CrimeLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 290, 490, -1));

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel16.setText("ตำบล");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 408, -1, 30));

        jTextAccused.setEditable(false);
        jTextAccused.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(jTextAccused, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 45, 432, -1));

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel17.setText("อำเภอ");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 408, -1, 30));

        CrimeLocationAmphur.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(CrimeLocationAmphur, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 408, 262, -1));

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel18.setText("จังหวัด");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 445, -1, 30));

        CrimeLocationProvince.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(CrimeLocationProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 445, 435, -1));

        jButtonCharge.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonCharge.setText("ข้อหา");
        jButtonCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChargeActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCharge, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 116, 107, -1));

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel19.setText("ผู้กล่าวหา");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 45, -1, 30));

        CrimeLocationDistrict.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(CrimeLocationDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 408, 194, -1));

        jButtonAccured.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAccured.setText("เพิ่ม");
        jButtonAccured.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccuredActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAccured, new org.netbeans.lib.awtextra.AbsoluteConstraints(1139, 44, 73, -1));

        jButtonSaveCase.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonSaveCase.setText("บันทึก");
        jButtonSaveCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveCaseActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSaveCase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 760, 102, -1));

        jLabel22.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel22.setText("ผู้ต้องหา");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 80, -1, 30));

        jTextSuspect.setEditable(false);
        jTextSuspect.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(jTextSuspect, new org.netbeans.lib.awtextra.AbsoluteConstraints(813, 80, 320, -1));

        jButtonSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonSuspect.setText("เพิ่ม");
        jButtonSuspect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuspectActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSuspect, new org.netbeans.lib.awtextra.AbsoluteConstraints(1139, 79, 73, -1));

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel25.setText("พยานและบุคคลอื่น");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 119, 106, 30));

        ListAsset.setEditable(false);
        ListAsset.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        ListAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListAssetActionPerformed(evt);
            }
        });
        jPanel1.add(ListAsset, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 158, 211, -1));

        jButtonWitness.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonWitness.setText("เพิ่ม");
        jButtonWitness.setActionCommand("พยาน");
        jButtonWitness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWitnessActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonWitness, new org.netbeans.lib.awtextra.AbsoluteConstraints(1144, 118, 68, -1));

        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel28.setText("รายการทรัพย์");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(813, 158, 85, 30));

        jTextWitness.setEditable(false);
        jTextWitness.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(jTextWitness, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 119, 391, -1));

        jButtonAddAsset.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAddAsset.setText("เพิ่ม");
        jButtonAddAsset.setActionCommand("พยาน");
        jButtonAddAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAssetActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAddAsset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1134, 157, 76, -1));

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel29.setText("เลขบัญชีของกลาง");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 158, -1, 30));

        EvidenceRecordCase.setEditable(false);
        EvidenceRecordCase.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(EvidenceRecordCase, new org.netbeans.lib.awtextra.AbsoluteConstraints(728, 158, 81, -1));

        jCheckSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckSue.setText("สั่งฟ้อง");
        jCheckSue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckSueActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckSue, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 201, -1, -1));

        jCheckDuringInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckDuringInvest.setText("อยู่ระหว่างสอบสวน");
        jPanel1.add(jCheckDuringInvest, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 201, -1, -1));

        jCheckNotSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckNotSue.setText("สั่งไม่ฟ้อง");
        jCheckNotSue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckNotSueActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckNotSue, new org.netbeans.lib.awtextra.AbsoluteConstraints(968, 201, -1, -1));

        jCheckOtherInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckOtherInvest.setText("อื่นๆ");
        jCheckOtherInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckOtherInvestActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckOtherInvest, new org.netbeans.lib.awtextra.AbsoluteConstraints(1156, 201, -1, -1));

        jCheckNoInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckNoInvest.setText("งดการสอบสวน");
        jCheckNoInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckNoInvestActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckNoInvest, new org.netbeans.lib.awtextra.AbsoluteConstraints(1043, 201, -1, -1));

        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel31.setText("ส่งสำนวนไปยัง");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 323, -1, 30));

        jTextInvestSendtoDepartment.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(jTextInvestSendtoDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 323, 142, -1));

        jLabel32.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel32.setText("เลขที่ส่ง");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(861, 323, -1, 30));

        jTextField25.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(908, 323, 127, -1));

        jLabel33.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel33.setText("วันเดือนปีที่ส่ง");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1045, 323, 77, 30));

        jTextField26.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1126, 323, 81, -1));

        jLabel34.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel34.setText("ผลคดีชั้นพนักงานสอบสวน");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 202, -1, 30));

        jLabel35.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel35.setText("ผลคดีชั้นอัยการ");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 243, -1, -1));

        jTextInvestigatorResult.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(jTextInvestigatorResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 238, 472, 66));

        jLabel36.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel36.setText("ผลคดีชั้นศาล");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, -1, 30));

        jTextCourtResult.setColumns(20);
        jTextCourtResult.setRows(5);
        jScrollPane1.setViewportView(jTextCourtResult);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 510, 582, -1));

        jLabel37.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel37.setText("หมายเหตุ-เลขคดีอุกฉกรรจ์");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 359, 156, 30));

        jLabelChargeCode.setText("CodeCharge");
        jPanel1.add(jLabelChargeCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(1073, 19, -1, -1));
        jPanel1.add(CaseRequestDateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 156, 202, 32));

        CaseAcceptDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseAcceptDateActionPerformed(evt);
            }
        });
        jPanel1.add(CaseAcceptDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 203, 170, 30));

        jLabel38.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel38.setText("พนักงานสอบสวน");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 650, -1, 30));

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel20.setText("คำให้การผู้ต้องหา");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 615, -1, -1));

        AnswerSuspect.setColumns(20);
        AnswerSuspect.setRows(5);
        jScrollPane4.setViewportView(AnswerSuspect);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 644, 553, -1));

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel21.setText("คำให้การผู้กล่าวหา/พยาน");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 483, -1, -1));

        AnswerVictim.setColumns(20);
        AnswerVictim.setRows(5);
        jScrollPane5.setViewportView(AnswerVictim);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 513, 553, -1));

        jLabelActionCode.setText("jLabel2");
        jPanel1.add(jLabelActionCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(1178, 19, -1, -1));

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(CaseRequestTimee, "HH:mm");
        CaseRequestTimee.setEditor(timeEditor);
        //jSpinner1.setValue(new Date());
        jPanel1.add(CaseRequestTimee, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 158, 215, 30));

        JSpinner.DateEditor te = new JSpinner.DateEditor(CaseAcceptTimee, "HH:mm");
        CaseAcceptTimee.setEditor(te);
        //jSpinner1.setValue(new Date());
        CaseAcceptTimee.setPreferredSize(new java.awt.Dimension(29, 25));
        jPanel1.add(CaseAcceptTimee, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 202, 201, 32));

        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(OccuredDateTime, "HH:mm");
        OccuredDateTime.setEditor(timeEditor3);
        //jSpinner1.setValue(new Date());
        jPanel1.add(OccuredDateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 242, 211, 30));

        jButtonAddInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAddInvest.setText("เพิ่ม");
        jButtonAddInvest.setActionCommand("พยาน");
        jButtonAddInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddInvestActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAddInvest, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 690, 61, -1));

        jTextField1.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 582, 80));

        jLabel41.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel41.setText("บันทึกพนักงานสอบสวน");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 700, 139, -1));
        jPanel1.add(jTextRecordInvest, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 690, 360, 32));

        jPanel1.add(jComboPoliceName, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 650, 360, 30));

        jRadioKnowSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jRadioKnowSuspect.setText("รู้ตัว");
        jRadioKnowSuspect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioKnowSuspectActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioKnowSuspect, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, -1, 30));

        jRadioUnknowSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jRadioUnknowSuspect.setText("ไม่รู้ตัว");
        jPanel1.add(jRadioUnknowSuspect, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, 30));

        jScrollPane2.setViewportView(jPanel1);

        jPanel3.setBackground(new java.awt.Color(77, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("บันทึก/แก้ไข ข้อมูล");

        CaseType.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        CaseType.setForeground(new java.awt.Color(255, 255, 255));
        CaseType.setText("คดีอาญา");

        crimecaseid.setText("NoCaseId");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CaseType)
                .addGap(18, 18, 18)
                .addComponent(crimecaseid)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(CaseType, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addComponent(crimecaseid)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckNoInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckNoInvestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckNoInvestActionPerformed

    private void jCheckOtherInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckOtherInvestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckOtherInvestActionPerformed

    private void jCheckNotSueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckNotSueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckNotSueActionPerformed

    private void jCheckSueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckSueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckSueActionPerformed

    private void jButtonAddAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAssetActionPerformed
        // TODO add your handling code here:
        AssetOverView as =new AssetOverView();
        as.setModal(true);
        as.setVisible(true);

    }//GEN-LAST:event_jButtonAddAssetActionPerformed

    private void jButtonWitnessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWitnessActionPerformed
        // TODO add your handling code here:
        String idWit=crimecaseid.getText();
        String typeW="อาญา";
        JSONObject s = new JSONObject();
        s.put("CaseIdWit",idWit );
        s.put("TypeCaseW",typeW );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fwit = (JFrame)(dialog.getParent());
        fwit.removeAll();
        ListWitness lw=new ListWitness(fwit,s);
        lw.setModal(true);
        lw.setVisible(true);
    }//GEN-LAST:event_jButtonWitnessActionPerformed

    private void jButtonSuspectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuspectActionPerformed
        // TODO add your handling code here:
        String idSus=crimecaseid.getText();
        String caseNumber=crimecaseno.getText()+crimecaseyear.getText();
        String typeS="อาญา";
        JSONObject s = new JSONObject();
        s.put("CaseIdSus",idSus );
        s.put("TypeCaseS",typeS );
        s.put("CaseNumber",caseNumber );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame facc = (JFrame)(dialog.getParent());
        facc.removeAll();
        ListSuspect ls=new ListSuspect(facc,s);
        ls.setModal(true);
        ls.setVisible(true);
    }//GEN-LAST:event_jButtonSuspectActionPerformed

    private void jButtonSaveCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCaseActionPerformed
        // TODO add your handling code here:

        con=ConnectDatabase.connect();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String requestTime = format.format(CaseRequestTimee.getValue());
        String acceptTime = format.format(CaseAcceptTimee.getValue());
        String orcuredTime=format.format(OccuredDateTime.getValue());
        if(isInsert){
            String sql="INSERT INTO CrimeCase (CaseType,crimecaseno,crimecaseyears,ChargeCodeCase,ActionCodeCase,CaseRequestDate,CaseRequestTime,"+
            "CaseAcceptDate,CaseAccepTime,DailyNumber,OccuredDate,OccuredTime,CrimeLocation,CrimeLocationDistrict,CrimeLocationAmphur,"+
            "CrimeLocationProvince,TypeCourt,AccureandOther,SuspectandOther,WitnessandOther,Investigator_Result,CourtResult,Invest_SendtoDepartment,"+
            "PoliceNameCase,AssetList,AssetCode,AnswerSuspect,crimecasenoyear)"+
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            System.out.println(sql);
            try {

                pst=con.prepareStatement(sql);

                pst.setString(1,"คดีอาญา");
                pst.setString(2,crimecaseno.getText());
                pst.setString(3,crimecaseyear.getText());
                pst.setString(4,jLabelChargeCode.getText());
                pst.setString(5,jLabelActionCode.getText());
                pst.setString(6,CaseRequestDateTime.getText());
                pst.setString(7,requestTime);
                pst.setString(8,CaseAcceptDate.getText());
                pst.setString(9,acceptTime);
                pst.setString(10,DailyNumber.getText());
                pst.setString(11,OccuredDate.getText());
                pst.setString(12,orcuredTime);
                pst.setString(13,CrimeLocation.getText());
                pst.setString(14,CrimeLocationDistrict.getText());
                pst.setString(15,CrimeLocationAmphur.getText());
                pst.setString(16,CrimeLocationProvince.getText());
                pst.setString(17,CourtType.getSelectedItem().toString());
                pst.setString(18,jTextAccused.getText());
                pst.setString(19,jTextSuspect.getText());
                pst.setString(20,jTextWitness.getText());
                if(jCheckDuringInvest.isSelected()){
                    pst.setString(21,"อยู่ระหว่างสอบสวน");
                }
                if(jCheckSue.isSelected()){
                    pst.setString(21,"สั่งฟ้อง");
                }
                if(jCheckNotSue.isSelected()){
                    pst.setString(21,"สั่งไม่ฟ้อง");
                }
                if(jCheckNoInvest.isSelected()){
                    pst.setString(21,"งดการสอบสวน");
                }
                if(jCheckOtherInvest.isSelected()){
                    pst.setString(21,"อื่นๆ");
                }
             
                pst.setString(22,jTextCourtResult.getText());
                pst.setString(23,jTextInvestSendtoDepartment.getText());
                pst.setString(24,jComboPoliceName.getSelectedItem().toString());
                pst.setString(25,ListAsset.getText());
                pst.setString(26,EvidenceRecordCase.getText());
                 pst.setString(27,AnswerSuspect.getText());
                  pst.setString(28,crimecaseno.getText()+"/"+crimecaseyear.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Saved successfully");
                System.out.println("SQL : "+sql);
                
                pst.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println("SQL : "+pst);
            }
        }
        else{
            String sqlUpdate="UPDATE CrimeCase SET crimecaseno = ?,"
            +"crimecaseyears = ?,"
            +"ChargeCodeCase = ?,"
            +"ActionCodeCase = ?,"
            +"CaseRequestDate = ?,"
            +"CaseRequestTime = ?,"
            +"CaseAcceptDate = ?,"
            +"CaseAccepTime = ?,"
            +"DailyNumber = ?,"
            +"OccuredDate = ?,"
            +"OccuredTime = ?,"
            +"CrimeLocation = ?,"
            +"CrimeLocationDistrict = ?,"
            +"CrimeLocationAmphur = ?,"
            +"CrimeLocationProvince = ?,"
            +"AccureandOther = ?,"
            +"SuspectandOther = ?,"
            +"WitnessandOther = ?,"
            +"TypeCourt = ?,"
            +"AssetList = ?,"
            +"AssetCode = ?"
            +" WHERE  CaseId = ?";
            System.out.println("SQL : "+sqlUpdate);
            try {

                pst=con.prepareStatement(sqlUpdate);
                pst.setString(1,crimecaseno.getText());
                pst.setString(2,crimecaseyear.getText());
                pst.setString(3,jLabelChargeCode.getText());
                pst.setString(4,jLabelActionCode.getText());
                pst.setString(5,CaseRequestDateTime.getText());
                pst.setString(6,requestTime);
                pst.setString(7,CaseAcceptDate.getText());
                pst.setString(8,acceptTime);
                pst.setString(9,DailyNumber.getText());
                pst.setString(10,OccuredDate.getText());
                pst.setString(11,orcuredTime);
                pst.setString(12,CrimeLocation.getText());
                pst.setString(13,CrimeLocationDistrict.getText());
                pst.setString(14,CrimeLocationAmphur.getText());
                pst.setString(15,CrimeLocationProvince.getText());
                pst.setString(16,jTextAccused.getText());
                pst.setString(17,jTextSuspect.getText());
                pst.setString(18,jTextWitness.getText());
                pst.setString(19,CourtType.getSelectedItem().toString());
                pst.setString(20,ListAsset.getText());
                pst.setString(21,EvidenceRecordCase.getText());
                pst.setString(22,caseid);

                pst.executeUpdate();
                //                    JOptionPane.showMessageDialog(null, "บันทึกข้อมูล");

                pst.close();
                System.out.println("SQL : "+sqlUpdate);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println("SQL : "+pst);
            }
        }

        //        setVisible(false);
        ReportAllForm n=new ReportAllForm();
        n.setModal(true);
        n.setVisible(true);

    }//GEN-LAST:event_jButtonSaveCaseActionPerformed

    private void jButtonAccuredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccuredActionPerformed
        // TODO add your handling code here:
        String aa=crimecaseid.getText();
        String type="อาญา";
        JSONObject data = new JSONObject();
        data.put("CaseIdAcc",aa );
        data.put("TypeCase",type );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame facc = (JFrame)(dialog.getParent());
        facc.removeAll();
        ListAccused la =new ListAccused(facc,data);
        la.setModal(true);
        la.setVisible(true);

    }//GEN-LAST:event_jButtonAccuredActionPerformed

    private void jButtonChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChargeActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame f = (JFrame)(dialog.getParent());
        f.removeAll();
        if(ChargeNameCase.getText().length()==0 || ChargeNameCase.getText()==null|| ChargeNameCase.getText().isEmpty()){
            ChargePage d = new ChargePage(f,null);
            d.setModal(true);
            d.setVisible(true);
        }
        else {

            try{
                //                String crimecaseno = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0)+"";
                String chargeCode=jLabelChargeCode.getText();
                String sql="select * From Charge where Charge.ChargeCode ='"+chargeCode+"'";
                System.out.println("ExSql : "+sql);
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                if(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("ChargeCode", rs.getString("ChargeCode"));
                    data.put("ChargeName", rs.getString("ChargeName"));
                    data.put("Law", rs.getString("Law"));
                    data.put("RateOfPenalty", rs.getString("RateOfPenalty"));
                    data.put("Note", rs.getString("Note"));

                    ChargePage d = new ChargePage(f,data);
                    d.setVisible(true);

                }

                rs.close();
                stmt.close();

            }catch(Exception ex){
                ex.printStackTrace();

            }

        }

    }//GEN-LAST:event_jButtonChargeActionPerformed

    private void jButtonActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fr = (JFrame)(dialog.getParent());
        fr.removeAll();

        if(ActionCrimes.getText().length()==0 || ActionCrimes.getText()==null|| ActionCrimes.getText().isEmpty()){
            ActionPage d = new ActionPage(fr,null);
            d.setModal(true);
            d.setVisible(true);
        }
        else {

            try{
                //                String crimecaseno = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0)+"";
                String actionCode=jLabelActionCode.getText();
                String sql="select * From ActionsCase where ActionsCase.ActionCode ='"+actionCode+"'";
                //                System.out.println("ExSql : "+sql);
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                if(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("ActionCode", rs.getString("ActionCode"));
                    data.put("ActionCrimes", rs.getString("ActionCrimes"));
                    data.put("ActionDetail", rs.getString("ActionDetail"));
                    data.put("ActionNote", rs.getString("ActionNote"));

                    ActionPage d = new ActionPage(fr,data);
                    d.setVisible(true);

                }

                rs.close();
                stmt.close();

            }catch(Exception ex){
                ex.printStackTrace();

            }

        }

    }//GEN-LAST:event_jButtonActionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAddInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddInvestActionPerformed
        String ci=crimecaseid.getText();

        JSONObject data = new JSONObject();
        data.put("CaseIdRec",ci );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame a = (JFrame)(dialog.getParent());
        a.removeAll();
        RecordInvestigatorView ri =new RecordInvestigatorView(a,data);
        ri.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddInvestActionPerformed

    private void ListAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListAssetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListAssetActionPerformed

    private void CourtTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourtTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CourtTypeActionPerformed

    private void CaseAcceptDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseAcceptDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CaseAcceptDateActionPerformed

    private void jRadioKnowSuspectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioKnowSuspectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioKnowSuspectActionPerformed
    public void eventJRadioKnowSuspect(){
    ButtonGroup g=new ButtonGroup();
        g.add(jRadioKnowSuspect);
        g.add(jRadioUnknowSuspect);
        jRadioKnowSuspect.setSelected(true);
       jRadioKnowSuspect.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            if(jRadioKnowSuspect.isSelected()){
            jButtonSuspect.setEnabled(true);
            
            }
            else jButtonSuspect.setEnabled(false);
            }
        }
        );
      
               }
    
    public static String IdCase(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(CaseId) caseid from CrimeCase";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("caseid"); 
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
    public void comboInvest(){
    
     try {

         Connection con2 = ConnectDatabase.connect();
	Statement st = con2.createStatement();
        	String c = "Select InvestName from InvestInformation";
        	ResultSet res = st.executeQuery(c);
	//Vector<Object> v=new Vector<Object>();
	
	while(res.next())
	{
	jComboPoliceName.addItem(res.getString("InvestName"));

	
	}
	
}
catch (Exception d) {  //System.out.println(d);  
}
    }
    public static JComponent makeExamplePane() {
     JPanel text = new JPanel();
    JScrollPane scroll = new JScrollPane(text);
    return scroll;
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrimesCaseEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrimesCaseEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrimesCaseEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrimesCaseEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
//                  JComponent before = makeExamplePane();
//                   UIManager.put("ScrollBarUI", "MyMetalScrollBarUI");
// 
//                    JComponent after = makeExamplePane();
// 
     
                
//        aa.setMinimumSize ( new Dimension ( 1264, 728 ) );
//         Container c = aa.getContentPane();
//            c.add(before);
//            c.add(after);   
 
//        aa.setMaximizedBounds ( new Rectangle ( 1264, 728 ) );
            }
        });
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField ActionCrimes;
    private javax.swing.JTextArea AnswerSuspect;
    private javax.swing.JTextArea AnswerVictim;
    private javax.swing.JTextField CaseAcceptDate;
    private javax.swing.JSpinner CaseAcceptTimee;
    private javax.swing.JTextField CaseRequestDateTime;
    private javax.swing.JSpinner CaseRequestTimee;
    private javax.swing.JLabel CaseType;
    public static javax.swing.JTextField ChargeNameCase;
    private javax.swing.JComboBox<String> CourtType;
    private javax.swing.JTextField CrimeLocation;
    private javax.swing.JTextField CrimeLocationAmphur;
    private javax.swing.JTextField CrimeLocationDistrict;
    private javax.swing.JTextField CrimeLocationProvince;
    private javax.swing.JTextField DailyNumber;
    public static javax.swing.JTextField EvidenceRecordCase;
    public static javax.swing.JTextField ListAsset;
    private javax.swing.JTextField OccuredDate;
    private javax.swing.JSpinner OccuredDateTime;
    public static javax.swing.JLabel crimecaseid;
    public static javax.swing.JTextField crimecaseno;
    private javax.swing.JTextField crimecaseyear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAccured;
    private javax.swing.JButton jButtonAction;
    private javax.swing.JButton jButtonAddAsset;
    private javax.swing.JButton jButtonAddInvest;
    private javax.swing.JButton jButtonCharge;
    private javax.swing.JButton jButtonSaveCase;
    private javax.swing.JButton jButtonSuspect;
    private javax.swing.JButton jButtonWitness;
    private javax.swing.JCheckBox jCheckDuringInvest;
    private javax.swing.JCheckBox jCheckNoInvest;
    private javax.swing.JCheckBox jCheckNotSue;
    private javax.swing.JCheckBox jCheckOtherInvest;
    private javax.swing.JCheckBox jCheckSue;
    private javax.swing.JComboBox<String> jComboPoliceName;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLabelActionCode;
    public static javax.swing.JLabel jLabelChargeCode;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioKnowSuspect;
    private javax.swing.JRadioButton jRadioUnknowSuspect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    public static javax.swing.JTextField jTextAccused;
    private javax.swing.JTextArea jTextCourtResult;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextInvestSendtoDepartment;
    private javax.swing.JTextField jTextInvestigatorResult;
    private javax.swing.JTextField jTextRecordInvest;
    public static javax.swing.JTextField jTextSuspect;
    public static javax.swing.JTextField jTextWitness;
    private lu.tudor.santec.jtimechooser.demo.JTimeChooserDemo jTimeChooserDemo1;
    private lu.tudor.santec.jtimechooser.demo.JTimeChooserDemo jTimeChooserDemo2;
    // End of variables declaration//GEN-END:variables
}
