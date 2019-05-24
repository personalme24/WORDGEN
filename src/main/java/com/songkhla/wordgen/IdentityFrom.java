/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;



import static com.songkhla.wordgen.CrimesCaseEdit.ActionCrimes;
import static com.songkhla.wordgen.CrimesCaseEdit.ChargeNameCase;
import static com.songkhla.wordgen.CrimesCaseEdit.IdCase;
import static com.songkhla.wordgen.CrimesCaseEdit.ListAsset;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseid;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseno;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelActionCode;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelChargeCode;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextAccused;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextSuspect;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextWitness;
import static com.songkhla.wordgen.TrafficEdit.crimecaseid;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import javax.swing.JSpinner;

/**
 *
 * @author Petpilin
 */
public class IdentityFrom extends javax.swing.JDialog {
    Connection con=null;
    PreparedStatement pst=null;;
    boolean isInsert;
    String caseid;

    
    /**
     * Creates new form IdentifyFrom
     */
    public IdentityFrom(JFrame parrent,JSONObject datain) {
         super(parrent,true);
        initComponents();
    jCheckDuringInvest.setSelected(true);
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
            jTextPoliceName.setText(datain.get("PoliceNameCase")+"");
            jTextSuspect.setText(datain.get("SuspectandOther")+"");
            jTextWitness.setText(datain.get("WitnessandOther")+"");
            CaseRequestTimee.setValue(timeReq);
            CaseAcceptDateTime.setText(datain.get("CaseAcceptDate")+"");
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        crimecaseid = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        crimecaseno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        crimecaseyear = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CourtType = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        ChargeName = new javax.swing.JTextField();
        jButtonCharge = new javax.swing.JButton();
        jButtonAction = new javax.swing.JButton();
        ActionCrimes = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckSuicide = new javax.swing.JRadioButton();
        jCheckAnimal = new javax.swing.JRadioButton();
        jCheckKill = new javax.swing.JRadioButton();
        jCheckAccident = new javax.swing.JRadioButton();
        jCheckUnknow = new javax.swing.JRadioButton();
        jCheckExtraordinary = new javax.swing.JRadioButton();
        jCheckControl = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        CaseRequestDateTime = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CaseAcceptDateTime = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        DailyNumber = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CircumstancesOfDeath = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        OccuredDate = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        CrimeLocation = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        CrimeLocationDistrict = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        CrimeLocationAmphur = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        CrimeLocationProvince = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jTextAccused = new javax.swing.JTextField();
        jButtonAccured = new javax.swing.JButton();
        jButtonSuspect = new javax.swing.JButton();
        jTextSuspect = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextWitness = new javax.swing.JTextField();
        jButtonWitness = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        EvidenceRecordNumber = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        ListAsset = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jCheckDuringInvest = new javax.swing.JCheckBox();
        jCheckSue = new javax.swing.JCheckBox();
        jCheckNotSue = new javax.swing.JCheckBox();
        jCheckNoInvest = new javax.swing.JCheckBox();
        jCheckOtherInvest = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        jTextInvestSendtoDepartment = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextInvestigatorResult = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextCourtResult = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextPoliceName = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonSaveCase = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButtonAddInvest = new javax.swing.JButton();
        Date date=new Date();

        SpinnerDateModel sm=new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        CaseRequestTimee = new javax.swing.JSpinner(sm);
        Date date2=new Date();

        SpinnerDateModel sm2=new SpinnerDateModel(date2,null,null,Calendar.HOUR_OF_DAY);
        CaseAcceptTimee = new javax.swing.JSpinner(sm2);
        Date date3=new Date();

        SpinnerDateModel sm3=new SpinnerDateModel(date3,null,null,Calendar.HOUR_OF_DAY);
        OccuredDateTime = new javax.swing.JSpinner(sm3);
        jLabelChargeCode = new javax.swing.JLabel();
        jLabelActionCode = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(77, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("คดีชันสูตร");

        crimecaseid.setText("jLabel2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crimecaseid)
                .addGap(0, 1181, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(crimecaseid))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel5.setText("เลขคดี");

        crimecaseno.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel4.setText("/");

        crimecaseyear.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel3.setText("อำนาจศาล");

        CourtType.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        CourtType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ศาลอาญา", "ศาลแขวง", "ศาลเยาวชน", "ศาลทหาร" }));

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel6.setText("ข้อหา");

        ChargeName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jButtonCharge.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonCharge.setText("ข้อหา");
        jButtonCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChargeActionPerformed(evt);
            }
        });

        jButtonAction.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAction.setText("พฤติการณ์คดี");
        jButtonAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionActionPerformed(evt);
            }
        });

        ActionCrimes.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel7.setText("พฤติการณ์คดี");

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel8.setText("เหตุที่ตาย");

        jCheckSuicide.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckSuicide.setText("ฆ่าตัวตาย");

        jCheckAnimal.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckAnimal.setText("สัตว์ทำร้ายตาย");
        jCheckAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckAnimalActionPerformed(evt);
            }
        });

        jCheckKill.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckKill.setText("ผู้อื่นทำให้ตาย");
        jCheckKill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckKillActionPerformed(evt);
            }
        });

        jCheckAccident.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckAccident.setText("อุบัติเหตุ");
        jCheckAccident.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckAccidentActionPerformed(evt);
            }
        });

        jCheckUnknow.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckUnknow.setText("มิปรากฎเหตุ");
        jCheckUnknow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckUnknowActionPerformed(evt);
            }
        });

        jCheckExtraordinary.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckExtraordinary.setText("ถูกเจ้าพนักงานทำให้ตาย(วิสามัญ)");
        jCheckExtraordinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckExtraordinaryActionPerformed(evt);
            }
        });

        jCheckControl.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckControl.setText("ระหว่างควบคุม");
        jCheckControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckControlActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel9.setText("วันที่รับแจ้ง");

        CaseRequestDateTime.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel10.setText("เวลารับแจ้ง");

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel11.setText("วันที่รับคำร้องทุกข์");

        CaseAcceptDateTime.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel12.setText("เวลารับคำร้องทุกข์");

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel13.setText("ปจว.ข้อ");

        DailyNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel14.setText("ตายโดย");

        CircumstancesOfDeath.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel15.setText("วันที่เกิดเหตุ");

        OccuredDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel16.setText("เวลาที่เกิดเหตุ");

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel17.setText("สถานที่เกิดเหตุ");

        CrimeLocation.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel18.setText("ตำบล");

        CrimeLocationDistrict.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel19.setText("อำเภอ");

        CrimeLocationAmphur.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel20.setText("จังหวัด");

        CrimeLocationProvince.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButton1.setText("ต/อ/จ");

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel21.setText("ผู้กล่าวหา");

        jTextAccused.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jButtonAccured.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAccured.setText("เพิ่ม");
        jButtonAccured.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccuredActionPerformed(evt);
            }
        });

        jButtonSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonSuspect.setText("เพิ่ม");
        jButtonSuspect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuspectActionPerformed(evt);
            }
        });

        jTextSuspect.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jTextSuspect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSuspectActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel26.setText("ผู้ต้องหา");

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel27.setText("พยานและบุคคลอื่น");

        jTextWitness.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jButtonWitness.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonWitness.setText("เพิ่ม");
        jButtonWitness.setActionCommand("พยาน");
        jButtonWitness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWitnessActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel30.setText("เลขบัญชีของกลาง");

        EvidenceRecordNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel31.setText("รายการทรัพย์");

        ListAsset.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jButton8.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButton8.setText("เพิ่ม");
        jButton8.setActionCommand("พยาน");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel34.setText("ผลคดีชั้นพนักงานสอบสวน");

        jCheckDuringInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckDuringInvest.setText("อยู่ระหว่างสอบสวน");

        jCheckSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckSue.setText("สั่งฟ้อง");
        jCheckSue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckSueActionPerformed(evt);
            }
        });

        jCheckNotSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckNotSue.setText("สั่งไม่ฟ้อง");
        jCheckNotSue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckNotSueActionPerformed(evt);
            }
        });

        jCheckNoInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckNoInvest.setText("งดการสอบสวน");
        jCheckNoInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckNoInvestActionPerformed(evt);
            }
        });

        jCheckOtherInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckOtherInvest.setText("อื่นๆ");
        jCheckOtherInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckOtherInvestActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel32.setText("ส่งสำนวนไปยัง");

        jTextInvestSendtoDepartment.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel33.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel33.setText("เลขที่ส่ง");

        jTextField25.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel35.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel35.setText("วันเดือนปีที่ส่ง");

        jTextField26.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel36.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel36.setText("ผลคดีชั้นอัยการ");

        jTextInvestigatorResult.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jTextCourtResult.setColumns(20);
        jTextCourtResult.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jTextCourtResult.setRows(5);
        jScrollPane1.setViewportView(jTextCourtResult);

        jLabel37.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel37.setText("ผลคดีชั้นศาล");

        jTextField28.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel38.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel38.setText("หมายเหตุ");

        jTextPoliceName.setEditable(false);
        jTextPoliceName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel40.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel40.setText("ชื่อพนักงานสอบสวน");

        jLabel41.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel41.setText("บันทึกพนักงานสอบสวน");

        jTextField1.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jButtonSaveCase.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonSaveCase.setText("บันทึก");
        jButtonSaveCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveCaseActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton3.setText("ยกเลิก");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButtonAddInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAddInvest.setText("เพิ่ม");
        jButtonAddInvest.setActionCommand("พยาน");
        jButtonAddInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddInvestActionPerformed(evt);
            }
        });

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(CaseRequestTimee, "HH:mm");
        CaseRequestTimee.setEditor(timeEditor);
        //jSpinner1.setValue(new Date());

        JSpinner.DateEditor te = new JSpinner.DateEditor(CaseAcceptTimee, "HH:mm");
        CaseAcceptTimee.setEditor(te);
        //jSpinner1.setValue(new Date());
        CaseAcceptTimee.setPreferredSize(new java.awt.Dimension(29, 25));

        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(OccuredDateTime, "HH:mm");
        OccuredDateTime.setEditor(timeEditor3);
        //jSpinner1.setValue(new Date());

        jLabelChargeCode.setText("jLabel2");

        jLabelActionCode.setText("jLabel22");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EvidenceRecordNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ListAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(402, 402, 402))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextPoliceName, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddInvest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(157, 157, 157))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextAccused)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(CrimeLocationDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(CrimeLocationAmphur, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(CaseRequestDateTime)
                                                .addComponent(OccuredDate, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(OccuredDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(CaseRequestTimee))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CrimeLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(CaseAcceptDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CaseAcceptTimee, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DailyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)
                                        .addComponent(CrimeLocationProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonWitness, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonAccured, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabelChargeCode)
                                        .addGap(69, 69, 69)
                                        .addComponent(jLabelActionCode))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(311, 311, 311)
                                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextInvestigatorResult, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel34)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jCheckDuringInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckSue, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckNotSue, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckNoInvest)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckOtherInvest)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextInvestSendtoDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCheckSuicide)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCheckAnimal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCheckKill)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCheckAccident)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCheckUnknow)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCheckExtraordinary)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCheckControl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CircumstancesOfDeath))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ActionCrimes, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(crimecaseno, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(crimecaseyear, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(CourtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ChargeName, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonAction)
                                        .addComponent(jButtonCharge))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextWitness, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(577, 577, 577)
                        .addComponent(jButtonSaveCase, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(crimecaseno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(crimecaseyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CourtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChargeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCharge)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ActionCrimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAction))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckSuicide, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckKill, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckAccident, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckUnknow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckExtraordinary, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckControl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CircumstancesOfDeath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CaseRequestDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DailyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CaseAcceptDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CaseRequestTimee, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CaseAcceptTimee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OccuredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CrimeLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OccuredDateTime, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CrimeLocationDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CrimeLocationAmphur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CrimeLocationProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextAccused, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAccured))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChargeCode)
                            .addComponent(jLabelActionCode))
                        .addGap(2, 2, 2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSuspect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonWitness)
                    .addComponent(jTextWitness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListAsset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EvidenceRecordNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckDuringInvest)
                    .addComponent(jCheckSue)
                    .addComponent(jCheckNotSue)
                    .addComponent(jCheckNoInvest)
                    .addComponent(jCheckOtherInvest)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextInvestSendtoDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextInvestigatorResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextPoliceName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAddInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveCase)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1313, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChargeActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fr = (JFrame)(dialog.getParent());
        fr.removeAll();
        ChargePage cp=new ChargePage(fr,null);
        cp.setVisible(true);
    }//GEN-LAST:event_jButtonChargeActionPerformed

    private void jButtonActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionActionPerformed
        // TODO add your handling code here:
          JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fa = (JFrame)(dialog.getParent());
        fa.removeAll();
        ActionPage ap =new ActionPage(fa,null);
        ap.setVisible(true);

    }//GEN-LAST:event_jButtonActionActionPerformed

    private void jCheckAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckAnimalActionPerformed

    private void jCheckKillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckKillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckKillActionPerformed

    private void jCheckAccidentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckAccidentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckAccidentActionPerformed

    private void jCheckUnknowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckUnknowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckUnknowActionPerformed

    private void jCheckExtraordinaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckExtraordinaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckExtraordinaryActionPerformed

    private void jCheckControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckControlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckControlActionPerformed

    private void jButtonAccuredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccuredActionPerformed
        // TODO add your handling code here:
        String aa=crimecaseid.getText();
        String type="ชันสูตร";
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

    private void jButtonSuspectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuspectActionPerformed
        // TODO add your handling code here:
         String idSus=crimecaseid.getText();
         String typeS="ชันสูตร";
        JSONObject s = new JSONObject();
       s.put("CaseIdSus",idSus );
        s.put("TypeCaseS",typeS );
       JFrame frame = new JFrame();
             JDialog dialog = new JDialog(frame);//frame is owner
             JFrame facc = (JFrame)(dialog.getParent());               
             facc.removeAll();
        ListSuspect ls=new ListSuspect(facc,s);
          ls.setModal(true);
        ls.setVisible(true);
    }//GEN-LAST:event_jButtonSuspectActionPerformed

    private void jButtonWitnessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWitnessActionPerformed
        // TODO add your handling code here:
         String idWit=crimecaseid.getText();
        String typeW="ชันสูตร";
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

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jCheckSueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckSueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckSueActionPerformed

    private void jCheckNotSueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckNotSueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckNotSueActionPerformed

    private void jCheckNoInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckNoInvestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckNoInvestActionPerformed

    private void jCheckOtherInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckOtherInvestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckOtherInvestActionPerformed

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonSaveCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCaseActionPerformed
        // TODO add your handling code here:
        con=ConnectDatabase.connect();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String requestTime = format.format(CaseRequestTimee.getValue());
        String acceptTime = format.format(CaseAcceptTimee.getValue());
        String orcuredTime=format.format(OccuredDateTime.getValue());
         if(isInsert){
      String sql="INSERT INTO CrimeCase (crimecaseno,crimecaseyears,ChargeCodeCase,ActionCodeCase,CaseRequestDate,CaseRequestTime,"+
                   "CaseAcceptDate,CaseAccepTime,DailyNumber,OccuredDate,OccuredTime,CrimeLocation,CrimeLocationDistrict,CrimeLocationAmphur,"+
                   "CrimeLocationProvince,TypeCourt,AccureandOther,SuspectandOther,WitnessandOther,Investigator_Result,CourtResult,Invest_SendtoDepartment,"+
                     "PoliceNameCase,AssetList,AssetCode,CircumstancesOfDeath,CauseDead,crimecasenoyear,CaseType)"+
                   "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          System.out.println(sql);
         try {
  
            pst=con.prepareStatement(sql);
            pst.setString(1,crimecaseno.getText());
            pst.setString(2,crimecaseyear.getText());
            pst.setString(3,jLabelChargeCode.getText());
            pst.setString(4,jLabelActionCode.getText());
            pst.setString(5,CaseRequestDateTime.getText());
            pst.setString(6,requestTime);
            pst.setString(7,CaseAcceptDateTime.getText());
            pst.setString(8,acceptTime);
            pst.setString(9,DailyNumber.getText());
            pst.setString(10,OccuredDate.getText());
            pst.setString(11,orcuredTime);
            pst.setString(12,CrimeLocation.getText());
            pst.setString(13,CrimeLocationDistrict.getText());
            pst.setString(14,CrimeLocationAmphur.getText());
            pst.setString(15,CrimeLocationProvince.getText());
            pst.setString(16,CourtType.getSelectedItem().toString());
            pst.setString(17,jTextAccused.getText());
            pst.setString(18,jTextSuspect.getText());
            pst.setString(19,jTextWitness.getText());
            if(jCheckDuringInvest.isSelected()){
               pst.setString(20,"อยู่ระหว่างสอบสวน");  
            }
          else  if(jCheckSue.isSelected()){
               pst.setString(20,"สั่งฟ้อง");  
            } 
          else  if(jCheckNotSue.isSelected()){
               pst.setString(20,"สั่งไม่ฟ้อง");  
            }
          else  if(jCheckNoInvest.isSelected()){
               pst.setString(20,"งดการสอบสวน");  
            }
         else   if(jCheckOtherInvest.isSelected()){
               pst.setString(20,"อื่นๆ");  
            }
            pst.setString(21,jTextCourtResult.getText());
            pst.setString(22,jTextInvestSendtoDepartment.getText());
            pst.setString(23,jTextPoliceName.getText());
              pst.setString(24,ListAsset.getText());
                pst.setString(25,EvidenceRecordNumber.getText());

//            //เกี่ยวกับการตาย
            pst.setString(26,CircumstancesOfDeath.getText());
             if(jCheckSuicide.isSelected()){
                    pst.setString(27,"ฆ่าตัวตาย");
                }
             else   if(jCheckAnimal.isSelected()){
                    pst.setString(27,"สัตว์ทำร้ายตาย");
                }
              else  if(jCheckKill.isSelected()){
                    pst.setString(27,"ผู้อื่นทำให้ตาย");
                }
              else  if(jCheckAccident.isSelected()){
                    pst.setString(27,"อุบัติเหตุ");
                }
              else  if(jCheckUnknow.isSelected()){
                    pst.setString(27,"มิปรากฏเหตุ");
                }
              else   if(jCheckExtraordinary.isSelected()){
                    pst.setString(27,"วิสามัญ");
                }
              else    if(jCheckControl.isSelected()){
                    pst.setString(27,"ระหว่างควบคุม");
                }
                 pst.setString(28,crimecaseno.getText()+"/"+crimecaseyear.getText());
                 pst.setString(29,"ชันสูตร");
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
                         +"AccureandOther = ?,"
                         +"SuspectandOther = ?,"
                         +"WitnessandOther = ?,"
                         +"Investigator_Result = ?,"
                         +"CourtResult = ?"
                         +"Invest_SendtoDepartment =?" 
                         +"PoliceNameCase = ?,"
                         +"AssetList = ?,"
                         +"AssetCode = ?"
                         +"CircumstancesOfDeath =?" 
                         +"CauseDead = ?"
                         +"crimecasenoyear =?" 
                
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
            pst.setString(7,CaseAcceptDateTime.getText());
            pst.setString(8,acceptTime);
            pst.setString(9,DailyNumber.getText());
            pst.setString(10,OccuredDate.getText());
            pst.setString(11,orcuredTime);
            pst.setString(12,CrimeLocation.getText());
            pst.setString(13,CrimeLocationDistrict.getText());
            pst.setString(14,CrimeLocationAmphur.getText());
            pst.setString(15,CrimeLocationProvince.getText());
            pst.setString(16,CourtType.getSelectedItem().toString());
            pst.setString(17,jTextAccused.getText());
            pst.setString(18,jTextSuspect.getText());
            pst.setString(19,jTextWitness.getText());
            if(jCheckDuringInvest.isSelected()){
               pst.setString(20,"อยู่ระหว่างสอบสวน");  
            }
          else  if(jCheckSue.isSelected()){
               pst.setString(20,"สั่งฟ้อง");  
            } 
          else  if(jCheckNotSue.isSelected()){
               pst.setString(20,"สั่งไม่ฟ้อง");  
            }
          else  if(jCheckNoInvest.isSelected()){
               pst.setString(20,"งดการสอบสวน");  
            }
         else   if(jCheckOtherInvest.isSelected()){
               pst.setString(20,"อื่นๆ");  
            }
            pst.setString(21,jTextCourtResult.getText());
            pst.setString(22,jTextInvestSendtoDepartment.getText());
            pst.setString(23,jTextPoliceName.getText());
              pst.setString(24,ListAsset.getText());
                pst.setString(25,EvidenceRecordNumber.getText());

//            //เกี่ยวกับการตาย
            pst.setString(26,CircumstancesOfDeath.getText());
             if(jCheckSuicide.isSelected()){
                    pst.setString(27,"ฆ่าตัวตาย");
                }
             else   if(jCheckAnimal.isSelected()){
                    pst.setString(27,"สัตว์ทำร้ายตาย");
                }
              else  if(jCheckKill.isSelected()){
                    pst.setString(27,"ผู้อื่นทำให้ตาย");
                }
              else  if(jCheckAccident.isSelected()){
                    pst.setString(27,"อุบัติเหตุ");
                }
              else  if(jCheckUnknow.isSelected()){
                    pst.setString(27,"มิปรากฏเหตุ");
                }
              else   if(jCheckExtraordinary.isSelected()){
                    pst.setString(27,"วิสามัญ");
                }
              else    if(jCheckControl.isSelected()){
                    pst.setString(27,"ระหว่างควบคุม");
                }
                 pst.setString(28,crimecaseno.getText()+"/"+crimecaseyear.getText());
                 pst.setString(29,caseid);
            
             pst.executeUpdate();
//                    JOptionPane.showMessageDialog(null, "บันทึกข้อมูล");
                       System.out.println("SQL : "+sqlUpdate);
            pst.close();
             System.out.println("SQL : "+sqlUpdate);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e); 
             System.out.println("SQL : "+pst);
        }
      }
    }//GEN-LAST:event_jButtonSaveCaseActionPerformed

    private void jButtonAddInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddInvestActionPerformed
//      
//         RecordInvestigatorForm ri =new RecordInvestigatorForm();
//        ri.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddInvestActionPerformed

    private void jTextSuspectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSuspectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSuspectActionPerformed
    
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
            java.util.logging.Logger.getLogger(IdentityFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IdentityFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IdentityFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IdentityFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new IdentityFrom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ActionCrimes;
    private javax.swing.JTextField CaseAcceptDateTime;
    private javax.swing.JSpinner CaseAcceptTimee;
    private javax.swing.JTextField CaseRequestDateTime;
    private javax.swing.JSpinner CaseRequestTimee;
    private javax.swing.JTextField ChargeName;
    private javax.swing.JTextField CircumstancesOfDeath;
    private javax.swing.JComboBox<String> CourtType;
    private javax.swing.JTextField CrimeLocation;
    private javax.swing.JTextField CrimeLocationAmphur;
    private javax.swing.JTextField CrimeLocationDistrict;
    private javax.swing.JTextField CrimeLocationProvince;
    private javax.swing.JTextField DailyNumber;
    private javax.swing.JTextField EvidenceRecordNumber;
    private javax.swing.JTextField ListAsset;
    private javax.swing.JTextField OccuredDate;
    private javax.swing.JSpinner OccuredDateTime;
    private javax.swing.JLabel crimecaseid;
    private javax.swing.JTextField crimecaseno;
    private javax.swing.JTextField crimecaseyear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonAccured;
    private javax.swing.JButton jButtonAction;
    private javax.swing.JButton jButtonAddInvest;
    private javax.swing.JButton jButtonCharge;
    private javax.swing.JButton jButtonSaveCase;
    private javax.swing.JButton jButtonSuspect;
    private javax.swing.JButton jButtonWitness;
    private javax.swing.JRadioButton jCheckAccident;
    private javax.swing.JRadioButton jCheckAnimal;
    private javax.swing.JRadioButton jCheckControl;
    private javax.swing.JCheckBox jCheckDuringInvest;
    private javax.swing.JRadioButton jCheckExtraordinary;
    private javax.swing.JRadioButton jCheckKill;
    private javax.swing.JCheckBox jCheckNoInvest;
    private javax.swing.JCheckBox jCheckNotSue;
    private javax.swing.JCheckBox jCheckOtherInvest;
    private javax.swing.JCheckBox jCheckSue;
    private javax.swing.JRadioButton jCheckSuicide;
    private javax.swing.JRadioButton jCheckUnknow;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelActionCode;
    private javax.swing.JLabel jLabelChargeCode;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField jTextAccused;
    private javax.swing.JTextArea jTextCourtResult;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextInvestSendtoDepartment;
    private javax.swing.JTextField jTextInvestigatorResult;
    private javax.swing.JTextField jTextPoliceName;
    public static javax.swing.JTextField jTextSuspect;
    public static javax.swing.JTextField jTextWitness;
    // End of variables declaration//GEN-END:variables
}
