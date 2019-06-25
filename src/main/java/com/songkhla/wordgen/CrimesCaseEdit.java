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

           initComponents();     
           eventJRadioKnowSuspect();
        comboInvest();
//        jTextPoliceName.setText(Data.getPolicName());
        jLabelActionCode.setVisible(false);
        jLabelChargeCode.setVisible(false);
        crimecaseid.setVisible(true);
       
       
        if(datain!=null){
            try {
                String knowSus=datain.get("StatusKnowSuspect")+"";
                String rt=datain.get("CaseRequestTime")+"";
                String at=datain.get("CaseAcceptTime")+"";
                String ot=datain.get("CaseAcceptTime")+"";
                String qd=datain.get("CaseRequestDate")+"";
                String ad=datain.get("CaseAcceptDate")+"";
                String od=datain.get("OccuredDate")+"";
               
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
                 Date dateReq=dateFormat.parse(qd);
                 Date dateAcc=dateFormat.parse(ad);
                 Date dateOcc=dateFormat.parse(od);
                 
                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
                Date timeReq = timeFormat.parse(rt);
                Date timeAcc = timeFormat.parse(at);
                Date timeOccu = timeFormat.parse(ot);
                isInsert=false;
                caseid= "" + datain.get("CaseId");
                crimecaseid.setText(datain.get("CaseId")+"");
//          ID.setText(datain.get("CaseId")+"");
            crimecaseno.setText(datain.get("crimecaseno")+"");
            crimecaseyear.setText(datain.get("crimecaseyears")+"");
            jLabelChargeCode.setText(datain.get("ChargeCode")+"");
            String cn=datain.get("ChargeName")+"";
            if(cn.equals("null")){
            ChargeNameCase.setText("");
            }
            else{
            ChargeNameCase.setText(datain.get("ChargeName")+"");}
//            CaseRequestDateTime.setText(datain.get("CaseRequestDate")+"");
            jTextAccused.setText(datain.get("AccureandOther")+"");
            CourtType.setSelectedItem(datain.get("TypeCourt"));
            CrimeLocation.setText(datain.get("CrimeLocation")+"");
            CrimeLocationDistrict.setText(datain.get("CrimeLocationDistrict")+"");
            CrimeLocationAmphur.setText(datain.get("CrimeLocationAmphur")+"");
            CrimeLocationProvince.setText(datain.get("CrimeLocationProvince")+"");
            CrimeLocationMoo.setText(datain.get("CrimeLocationMoo")+"");
            CrimeLocationRoad.setText(datain.get("CrimeLocationRoad")+"");
            CrimeLocationSoi.setText(datain.get("CrimeLocationSoi")+"");            
            jComboPoliceName.setSelectedItem(datain.get("PoliceNameCase"));
            jTextSuspect.setText(datain.get("SuspectandOther")+"");
            jTextWitness.setText(datain.get("WitnessandOther")+"");
            CaseRequestDateTime.setDate(dateReq);
            CaseRequestTimee.setValue(timeReq);
            CaseAcceptDate.setDate(dateAcc);
            CaseAcceptTimee.setValue(timeAcc);
            DailyNumber.setText(datain.get("DailyNumber")+"");
            String investSta=datain.get("Investigator_Result")+"";
            OccuredDate.setDate(dateOcc);
            OccuredDateTime.setValue(timeOccu);
            jLabelActionCode.setText(datain.get("ActionCode")+"");
            Prosecutor_Result.setText(datain.get("Prosecutor_Result")+"");
            jTextInvestSendtoDepartment.setText(datain.get("InvestSendtoDepartment")+"");
            Investigator_Number.setText(datain.get("Investigator_Number")+"");
            Invest_SendCaseDate.setText(datain.get("Invest_SendCaseDate")+"");
            CapitalCrimeCaseNumber.setText(datain.get("CapitalCrimeCaseNumber")+"");
            AnswerAccuser.setText(datain.get("AnswerAccuser")+"");
            if(investSta.equals("อยู่ระหว่างสอบสวน")){
                jCheckDuringInvest.setSelected(true);
            }
           else if(investSta.equals("สั่งฟ้อง")){
                jCheckSue.setSelected(true);
            }
          else  if(investSta.equals("สั่งไม่ฟ้อง")){
                jCheckNotSue.setSelected(true);
            }
          else  if(investSta.equals("งดการสอบสวน")){
                jCheckNoInvest.setSelected(true);
            }
          else  if(investSta.equals("อื่นๆ")){
                jCheckOtherInvest.setSelected(true);
            }
             if(knowSus.equals("รู้ตัว")){
                jRadioKnowSuspect.setSelected(true);
            }
         else   if(knowSus.equals("ไม่รู้ตัว")){
                jRadioUnknowSuspect.setSelected(true);
            }
            ListAsset.setText(datain.get("AssetList")+"");
             EvidenceRecordCase.setText(datain.get("AssetCode")+"");
           
            String ac=datain.get("ActionCrimes")+"";
            if(ac.equals("null")){
            ActionCrimes.setText("");
            }
            else{
            ActionCrimes.setText(datain.get("ActionCrimes")+"");}
            

            } catch (ParseException ex) {
                Logger.getLogger(CrimesCaseEdit.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else{
//            Date date2=new Date();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
//            Date date = dateFormat.parse(date2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	Date date = new Date();
        dateFormat.format(date);
//	System.out.println(dateFormat.format(date));
           crimecaseid.setText(IdCase());       
           CaseAcceptDate.setDate(date);
           CaseRequestDateTime.setDate(date);
           OccuredDate.setDate(date);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CaseType = new javax.swing.JLabel();
        crimecaseid = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonCharge = new javax.swing.JButton();
        crimecaseno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Date date3=new Date();

        SpinnerDateModel sm3=new SpinnerDateModel(date3,null,null,Calendar.HOUR_OF_DAY);
        OccuredDateTime = new javax.swing.JSpinner(sm3);
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ChargeNameCase = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Date date2=new Date();

        SpinnerDateModel sm2=new SpinnerDateModel(date2,null,null,Calendar.HOUR_OF_DAY);
        CaseAcceptTimee = new javax.swing.JSpinner(sm2);
        DailyNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ActionCrimes = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Date date=new Date();

        SpinnerDateModel sm=new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        CaseRequestTimee = new javax.swing.JSpinner(sm);
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CrimeLocation = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        crimecaseyear = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonAction = new javax.swing.JButton();
        CourtType = new javax.swing.JComboBox<>();
        ListAsset = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jButtonAddAsset = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        EvidenceRecordCase = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        CrimeLocationAmphur = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        CrimeLocationProvince = new javax.swing.JTextField();
        CrimeLocationDistrict = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jButtonAddInvest = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        RecordInvestCase = new javax.swing.JTextField();
        jComboPoliceName = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        CrimeLocationRoad = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        CrimeLocationMoo = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        CrimeLocationSoi = new javax.swing.JTextField();
        CaseRequestDateTime = new com.toedter.calendar.JDateChooser();
        CaseAcceptDate = new com.toedter.calendar.JDateChooser();
        OccuredDate = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jTextAccused = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButtonAccured = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jTextSuspect = new javax.swing.JTextField();
        jButtonSuspect = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jButtonWitness = new javax.swing.JButton();
        jTextWitness = new javax.swing.JTextField();
        jRadioKnowSuspect = new javax.swing.JRadioButton();
        jRadioUnknowSuspect = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        AnswerSuspect = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        AnswerAccuser = new javax.swing.JTextArea();
        Invest_SendCaseDate = new javax.swing.JTextField();
        jCheckOtherInvest = new javax.swing.JCheckBox();
        Investigator_Number = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        CapitalCrimeCaseNumber = new javax.swing.JTextField();
        Prosecutor_Result = new javax.swing.JTextField();
        jCheckSue = new javax.swing.JCheckBox();
        jCheckNotSue = new javax.swing.JCheckBox();
        jCheckNoInvest = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        CourtResult = new javax.swing.JTextArea();
        jCheckDuringInvest = new javax.swing.JCheckBox();
        jLabel41 = new javax.swing.JLabel();
        jTextInvestSendtoDepartment = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabelChargeCode = new javax.swing.JLabel();
        jLabelActionCode = new javax.swing.JLabel();
        jButtonSaveCase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crimecaseid)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CaseType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jTabbedPane2.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonCharge.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonCharge.setText("ข้อหา");
        jButtonCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChargeActionPerformed(evt);
            }
        });

        crimecaseno.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        crimecaseno.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel10.setText("ปจว.ข้อ");

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel4.setText("/");

        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(OccuredDateTime, "HH:mm");
        OccuredDateTime.setEditor(timeEditor3);
        //jSpinner1.setValue(new Date());

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel15.setText("สถานที่เกิดเหตุ");

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel14.setText("เวลาที่เกิดเหตุ");

        ChargeNameCase.setEditable(false);
        ChargeNameCase.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel8.setText("วันที่รับแจ้ง");

        JSpinner.DateEditor te = new JSpinner.DateEditor(CaseAcceptTimee, "HH:mm");
        CaseAcceptTimee.setEditor(te);
        //jSpinner1.setValue(new Date());
        CaseAcceptTimee.setPreferredSize(new java.awt.Dimension(29, 25));

        DailyNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel6.setText("ข้อหา");

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel12.setText("เวลารับคำร้องทุกข์");

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel13.setText("วันที่เกิดเหตุ");

        ActionCrimes.setEditable(false);
        ActionCrimes.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel9.setText("เวลารับแจ้ง");

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(CaseRequestTimee, "HH:mm");
        CaseRequestTimee.setEditor(timeEditor);
        //jSpinner1.setValue(new Date());

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel7.setText("พฤติการณ์คดี");

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel11.setText("วันที่รับคำร้องทุกข์");

        CrimeLocation.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel3.setText("อำนาจศาล");

        crimecaseyear.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel5.setText("เลขคดี");

        jButtonAction.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAction.setText("พฤติการณ์คดี");
        jButtonAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionActionPerformed(evt);
            }
        });

        CourtType.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        CourtType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ศาลอาญา", "ศาลแขวง", "ศาลเยาวชน", "ศาลทหาร" }));
        CourtType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourtTypeActionPerformed(evt);
            }
        });

        ListAsset.setEditable(false);
        ListAsset.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        ListAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListAssetActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel29.setText("เลขบัญชีของกลาง");

        jButtonAddAsset.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAddAsset.setText("เพิ่ม");
        jButtonAddAsset.setActionCommand("พยาน");
        jButtonAddAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAssetActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel28.setText("รายการทรัพย์");

        EvidenceRecordCase.setEditable(false);
        EvidenceRecordCase.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButton1.setText("ต/อ/จ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel16.setText("ตำบล");

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel17.setText("อำเภอ");

        CrimeLocationAmphur.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel18.setText("จังหวัด");

        CrimeLocationProvince.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        CrimeLocationDistrict.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel45.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel45.setText("พนักงานสอบสวน");

        jButtonAddInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAddInvest.setText("เพิ่ม");
        jButtonAddInvest.setActionCommand("พยาน");
        jButtonAddInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddInvestActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel46.setText("บันทึกพนักงานสอบสวน");

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel2.setText("ถนน");

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel23.setText("หมู่ที่");

        CrimeLocationMoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrimeLocationMooActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel24.setText("ตรอก/ซอย");

        CaseRequestDateTime.setDateFormatString("dd/mm/yyyy");

        CaseAcceptDate.setDateFormatString("dd/mm/yyyy");

        OccuredDate.setDateFormatString("dd/mm/yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(OccuredDate, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel14)
                            .addGap(7, 7, 7)
                            .addComponent(OccuredDateTime))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CaseAcceptDate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CaseRequestDateTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(4, 4, 4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CaseAcceptTimee, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CaseRequestTimee, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ChargeNameCase)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ActionCrimes, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jButtonAction))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(jLabel10)
                            .addGap(10, 10, 10)
                            .addComponent(CrimeLocation)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(crimecaseno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(crimecaseyear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CourtType, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DailyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(CrimeLocationMoo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel24)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(CrimeLocationSoi, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(CrimeLocationRoad)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CrimeLocationDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CrimeLocationAmphur, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CrimeLocationProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(EvidenceRecordCase, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ListAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAddAsset))
                                    .addComponent(jComboPoliceName, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RecordInvestCase, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DailyNumber)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(crimecaseno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crimecaseyear)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CourtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CrimeLocationSoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel24)
                            .addComponent(CrimeLocationRoad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ActionCrimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonAction)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonCharge)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ChargeNameCase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(CrimeLocationMoo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(CrimeLocationDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CrimeLocationAmphur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CrimeLocationProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CaseRequestTimee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EvidenceRecordCase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ListAsset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAddAsset)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CaseRequestDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CaseAcceptTimee, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboPoliceName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CaseAcceptDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OccuredDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)
                            .addComponent(RecordInvestCase, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OccuredDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CrimeLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("ข้อมูลคดี", jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTextAccused.setEditable(false);
        jTextAccused.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel19.setText("ผู้กล่าวหา");

        jButtonAccured.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAccured.setText("เพิ่ม");
        jButtonAccured.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccuredActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel22.setText("ผู้ต้องหา");

        jTextSuspect.setEditable(false);
        jTextSuspect.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jButtonSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonSuspect.setText("เพิ่ม");
        jButtonSuspect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuspectActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel25.setText("พยานและบุคคลอื่น");

        jButtonWitness.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonWitness.setText("เพิ่ม");
        jButtonWitness.setActionCommand("พยาน");
        jButtonWitness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWitnessActionPerformed(evt);
            }
        });

        jTextWitness.setEditable(false);
        jTextWitness.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jRadioKnowSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jRadioKnowSuspect.setText("รู้ตัว");
        jRadioKnowSuspect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioKnowSuspectActionPerformed(evt);
            }
        });

        jRadioUnknowSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jRadioUnknowSuspect.setText("ไม่รู้ตัว");

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel20.setText("คำให้การผู้ต้องหา");

        AnswerSuspect.setColumns(20);
        AnswerSuspect.setRows(5);
        jScrollPane4.setViewportView(AnswerSuspect);

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel21.setText("คำให้การผู้กล่าวหา/พยาน");

        AnswerAccuser.setColumns(20);
        AnswerAccuser.setRows(5);
        jScrollPane5.setViewportView(AnswerAccuser);

        Invest_SendCaseDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jCheckOtherInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckOtherInvest.setText("อื่นๆ");
        jCheckOtherInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckOtherInvestActionPerformed(evt);
            }
        });

        Investigator_Number.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel38.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel38.setText("ผลคดีชั้นพนักงานสอบสวน");

        jLabel39.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel39.setText("ผลคดีชั้นศาล");

        jLabel40.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel40.setText("หมายเหตุ-เลขคดีอุกฉกรรจ์");

        CapitalCrimeCaseNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        Prosecutor_Result.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

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

        CourtResult.setColumns(20);
        CourtResult.setRows(5);
        jScrollPane2.setViewportView(CourtResult);

        jCheckDuringInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckDuringInvest.setText("อยู่ระหว่างสอบสวน");

        jLabel41.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel41.setText("วันเดือนปีที่ส่ง");

        jTextInvestSendtoDepartment.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel42.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel42.setText("ผลคดีชั้นอัยการ");

        jLabel43.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel43.setText("ส่งสำนวนไปยัง");

        jLabel44.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel44.setText("เลขที่ส่ง");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckDuringInvest)
                        .addGap(2, 2, 2)
                        .addComponent(jCheckSue)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckNotSue)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckNoInvest)
                        .addGap(2, 2, 2)
                        .addComponent(jCheckOtherInvest))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextAccused, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jButtonAccured, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(26, 26, 26)
                                        .addComponent(jRadioKnowSuspect)
                                        .addGap(1, 1, 1)
                                        .addComponent(jRadioUnknowSuspect)
                                        .addGap(2, 2, 2)
                                        .addComponent(jTextSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jButtonSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jTextWitness, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonWitness, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Prosecutor_Result, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(CapitalCrimeCaseNumber, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel43))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(Investigator_Number, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Invest_SendCaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextInvestSendtoDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAccured)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextAccused, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSuspect)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioKnowSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioUnknowSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonWitness)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextWitness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(Prosecutor_Result, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextInvestSendtoDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Investigator_Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Invest_SendCaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CapitalCrimeCaseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel42)
                            .addGap(364, 364, 364))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckDuringInvest)
                    .addComponent(jCheckSue)
                    .addComponent(jCheckNotSue)
                    .addComponent(jCheckNoInvest)
                    .addComponent(jCheckOtherInvest))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("ข้อมูลบุคคล", jPanel5);

        jLabelChargeCode.setText("CodeCharge");

        jLabelActionCode.setText("jLabel2");

        jButtonSaveCase.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonSaveCase.setText("บันทึก");
        jButtonSaveCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveCaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSaveCase, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelChargeCode)
                        .addGap(45, 45, 45)
                        .addComponent(jLabelActionCode)
                        .addGap(563, 563, 563))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(42, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChargeCode)
                            .addComponent(jLabelActionCode))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonSaveCase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCaseActionPerformed
        // TODO add your handling code here:

        con=ConnectDatabase.connect();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String requestTime = format.format(CaseRequestTimee.getValue());
        String acceptTime = format.format(CaseAcceptTimee.getValue());
        String orcuredTime=format.format(OccuredDateTime.getValue());
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/mm/yyyy");
        String requestDate=formatDate.format(CaseRequestDateTime.getDate());
        String acceptDate=formatDate.format(CaseAcceptDate.getDate());
        String occureDate=formatDate.format(OccuredDate.getDate());

        if(isInsert){
            String sql="INSERT INTO CrimeCase (CaseType,crimecaseno,crimecaseyears,ChargeCodeCase,ActionCodeCase,CaseRequestDate,CaseRequestTime,"+
            "CaseAcceptDate,CaseAccepTime,DailyNumber,OccuredDate,OccuredTime,CrimeLocation,CrimeLocationMoo,CrimeLocationSoi,CrimeLocationRoad,CrimeLocationDistrict,CrimeLocationAmphur,"+
            "CrimeLocationProvince,TypeCourt,AccureandOther,SuspectandOther,WitnessandOther,Investigator_Result,CourtResult,Invest_SendtoDepartment,"+
            "PoliceNameCase,AssetList,AssetCode,AnswerSuspect,crimecasenoyear,StatusKnowSuspect,RecordInvestCase,Investigator_Number,Invest_SendCaseDate,Prosecutor_Result,CapitalCrimeCaseNumber)"+
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            System.out.println(sql);
            try {

                pst=con.prepareStatement(sql);

                pst.setString(1,"คดีอาญา");
                pst.setString(2,crimecaseno.getText());
                pst.setString(3,crimecaseyear.getText());
                pst.setString(4,jLabelChargeCode.getText());
                pst.setString(5,jLabelActionCode.getText());
                pst.setString(6,requestDate);
                pst.setString(7,requestTime);
                pst.setString(8,acceptDate);
                pst.setString(9,acceptTime);
                pst.setString(10,DailyNumber.getText());
                pst.setString(11,occureDate);
                pst.setString(12,orcuredTime);
                pst.setString(13,CrimeLocation.getText());
                pst.setString(14,CrimeLocationMoo.getText());
                pst.setString(15,CrimeLocationSoi.getText());
                pst.setString(16,CrimeLocationRoad.getText());
                pst.setString(17,CrimeLocationDistrict.getText());
                pst.setString(18,CrimeLocationAmphur.getText());
                pst.setString(19,CrimeLocationProvince.getText());
                
                pst.setString(20,CourtType.getSelectedItem().toString());
                pst.setString(21,jTextAccused.getText());
                pst.setString(22,jTextSuspect.getText());
                pst.setString(23,jTextWitness.getText());
                if(jCheckDuringInvest.isSelected()){
                    pst.setString(24,"อยู่ระหว่างสอบสวน");
                }
                if(jCheckSue.isSelected()){
                    pst.setString(24,"สั่งฟ้อง");
                }
                if(jCheckNotSue.isSelected()){
                    pst.setString(24,"สั่งไม่ฟ้อง");
                }
                if(jCheckNoInvest.isSelected()){
                    pst.setString(24,"งดการสอบสวน");
                }
                if(jCheckOtherInvest.isSelected()){
                    pst.setString(24,"อื่นๆ");
                }

                pst.setString(25,CourtResult.getText());
                pst.setString(26,jTextInvestSendtoDepartment.getText());
                pst.setString(27,jComboPoliceName.getSelectedItem().toString());
                pst.setString(28,ListAsset.getText());
                pst.setString(29,EvidenceRecordCase.getText());
                pst.setString(30,AnswerSuspect.getText());
                pst.setString(31,crimecaseno.getText()+"/"+crimecaseyear.getText());
                if(jRadioKnowSuspect.isSelected()){
                    pst.setString(32,"รู้ตัว");
                }
                else if(jRadioUnknowSuspect.isSelected()){
                    pst.setString(32,"ไม่รู้ตัว");
                }
                pst.setString(33,RecordInvestCase.getText());
                pst.setString(34,Investigator_Number.getText());
                pst.setString(35,Invest_SendCaseDate.getText());
                pst.setString(36,Prosecutor_Result.getText());
                pst.setString(37,CapitalCrimeCaseNumber.getText());
                

       
         
               
//       JOptionPane.showMessageDialog(jPanel1,null, "Data Save", JOptionPane.INFORMATION_MESSAGE);

                
      int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.NO_OPTION) {
      System.out.println("No button clicked");
    } else if (response == JOptionPane.YES_OPTION) {
         pst.executeUpdate(); 
         pst.close();
         System.out.println("SQL : "+sql);
           JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fr = (JFrame)(dialog.getParent());
        fr.removeAll();
        ReportforCrimesCase n=new ReportforCrimesCase(fr);
        n.pack();
        n.setLocationRelativeTo(null);
        n.setVisible(true);

    } else if (response == JOptionPane.CLOSED_OPTION) {
      System.out.println("JOptionPane closed");
    }
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
            +"AssetCode = ?,"
            +"StatusKnowSuspect=?,"
            +"Investigator_Result=?,"
            +"crimecasenoyear=?," 
            +"CourtResult=?,"
            +"Invest_SendtoDepartment=?,"
            +"PoliceNameCase=?,"
            +"AnswerSuspect=?,"
            +"CrimeLocationMoo=?,"
            +"CrimeLocationSoi=?,"
            +"CrimeLocationRoad=?," 
            +"RecordInvestCase=?,"
            +"Investigator_Number=?,"
            +"Invest_SendCaseDate=?,"
            +"Prosecutor_Result=?," 
            +"CapitalCrimeCaseNumber=?"                    
            +" WHERE  CaseId = ?";
            System.out.println("SQL : "+sqlUpdate);
            try {

                pst=con.prepareStatement(sqlUpdate);
                pst.setString(1,crimecaseno.getText());
                pst.setString(2,crimecaseyear.getText());
                pst.setString(3,jLabelChargeCode.getText());
                pst.setString(4,jLabelActionCode.getText());
                pst.setString(5,requestDate);
                pst.setString(6,requestTime);
                pst.setString(7,acceptDate);
                pst.setString(8,acceptTime);
                pst.setString(9,DailyNumber.getText());
                pst.setString(10,occureDate);
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
                 if(jRadioKnowSuspect.isSelected()){
                    pst.setString(22,"รู้ตัว");
                }
                else if(jRadioUnknowSuspect.isSelected()){
                    pst.setString(22,"ไม่รู้ตัว");
                }
                   if(jCheckDuringInvest.isSelected()){
                    pst.setString(23,"อยู่ระหว่างสอบสวน");
                }
                if(jCheckSue.isSelected()){
                    pst.setString(23,"สั่งฟ้อง");
                }
                if(jCheckNotSue.isSelected()){
                    pst.setString(23,"สั่งไม่ฟ้อง");
                }
                if(jCheckNoInvest.isSelected()){
                    pst.setString(23,"งดการสอบสวน");
                }
                if(jCheckOtherInvest.isSelected()){
                    pst.setString(23,"อื่นๆ");
                }
                 pst.setString(24,crimecaseno.getText()+"/"+crimecaseyear.getText());
                pst.setString(25,CourtResult.getText());
                pst.setString(26,jTextInvestSendtoDepartment.getText());
                pst.setString(27,jComboPoliceName.getSelectedItem().toString());
                pst.setString(28,AnswerSuspect.getText());
                pst.setString(29,CrimeLocationMoo.getText());
                pst.setString(30,CrimeLocationSoi.getText());
                pst.setString(31,CrimeLocationRoad.getText());
                pst.setString(32,RecordInvestCase.getText());
                pst.setString(33,Investigator_Number.getText());
                pst.setString(34,Invest_SendCaseDate.getText());
                pst.setString(35,Prosecutor_Result.getText());
                pst.setString(36,CapitalCrimeCaseNumber.getText());
                pst.setString(37,caseid);
               int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.NO_OPTION) {
      System.out.println("No button clicked");
    } else if (response == JOptionPane.YES_OPTION) {
         pst.executeUpdate(); 
         pst.close();
         System.out.println("SQL : "+sqlUpdate);
           JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fr = (JFrame)(dialog.getParent());
        fr.removeAll();
        ReportforCrimesCase n=new ReportforCrimesCase(fr);
        n.pack();
        n.setLocationRelativeTo(null);
        n.setVisible(true);

    } else if (response == JOptionPane.CLOSED_OPTION) {
      System.out.println("JOptionPane closed");
    }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println("SQL : "+pst);
            }
        }

        //        setVisible(false);
      
    }//GEN-LAST:event_jButtonSaveCaseActionPerformed

    private void CourtTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourtTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CourtTypeActionPerformed

    private void jButtonActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fr = (JFrame)(dialog.getParent());
        fr.removeAll();

        if(ActionCrimes.getText().length()==0 || ActionCrimes.getText()==null|| ActionCrimes.getText().isEmpty()){
            ActionPage d = new ActionPage(fr,null);
            d.pack();
            d.setLocationRelativeTo(null);
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
                    d.pack();
                    d.setLocationRelativeTo(null);
                    d.setVisible(true);

                }

                rs.close();
                stmt.close();

            }catch(Exception ex){
                ex.printStackTrace();

            }

        }
    }//GEN-LAST:event_jButtonActionActionPerformed

    private void jButtonChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChargeActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame f = (JFrame)(dialog.getParent());
        f.removeAll();
        if(ChargeNameCase.getText().length()==0 || ChargeNameCase.getText()==null|| ChargeNameCase.getText().isEmpty()){
            ChargePage d = new ChargePage(f,null);
            d.pack();
            d.setLocationRelativeTo(null);
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
                    d.pack();
                    d.setLocationRelativeTo(null);
                    d.setVisible(true);

                }

                rs.close();
                stmt.close();

            }catch(Exception ex){
                ex.printStackTrace();

            }

        }
    }//GEN-LAST:event_jButtonChargeActionPerformed

    private void ListAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListAssetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListAssetActionPerformed

    private void jButtonAddAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAssetActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame asv = (JFrame)(dialog.getParent());
        asv.removeAll();
        AssetOverView as =new AssetOverView(asv);
        as.pack();
        as.setLocationRelativeTo(null);
        as.setVisible(true);
    }//GEN-LAST:event_jButtonAddAssetActionPerformed

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
        la.pack();
        la.setLocationRelativeTo(null);
        la.setVisible(true);
    }//GEN-LAST:event_jButtonAccuredActionPerformed

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
        ls.pack();
        ls.setLocationRelativeTo(null);
        ls.setVisible(true);
    }//GEN-LAST:event_jButtonSuspectActionPerformed

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
        lw.pack();
        lw.setLocationRelativeTo(null);
        lw.setVisible(true);
    }//GEN-LAST:event_jButtonWitnessActionPerformed

    private void jRadioKnowSuspectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioKnowSuspectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioKnowSuspectActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckOtherInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckOtherInvestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckOtherInvestActionPerformed

    private void jCheckSueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckSueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckSueActionPerformed

    private void jCheckNotSueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckNotSueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckNotSueActionPerformed

    private void jCheckNoInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckNoInvestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckNoInvestActionPerformed

    private void jButtonAddInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddInvestActionPerformed
        String ci=crimecaseid.getText();

        JSONObject data = new JSONObject();
        data.put("CaseIdRec",ci );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame a = (JFrame)(dialog.getParent());
        a.removeAll();
        RecordInvestigatorView ri =new RecordInvestigatorView(a,data);
        ri.pack();
        ri.setLocationRelativeTo(null);
        ri.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddInvestActionPerformed

    private void CrimeLocationMooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrimeLocationMooActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CrimeLocationMooActionPerformed
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
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                   jScrollPane2.getVerticalScrollBar().setUI(new MyScrollBarUI());
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
    private javax.swing.JTextArea AnswerAccuser;
    private javax.swing.JTextArea AnswerSuspect;
    private javax.swing.JTextField CapitalCrimeCaseNumber;
    private com.toedter.calendar.JDateChooser CaseAcceptDate;
    private javax.swing.JSpinner CaseAcceptTimee;
    private com.toedter.calendar.JDateChooser CaseRequestDateTime;
    private javax.swing.JSpinner CaseRequestTimee;
    private javax.swing.JLabel CaseType;
    public static javax.swing.JTextField ChargeNameCase;
    private javax.swing.JTextArea CourtResult;
    private javax.swing.JComboBox<String> CourtType;
    private javax.swing.JTextField CrimeLocation;
    private javax.swing.JTextField CrimeLocationAmphur;
    private javax.swing.JTextField CrimeLocationDistrict;
    private javax.swing.JTextField CrimeLocationMoo;
    private javax.swing.JTextField CrimeLocationProvince;
    private javax.swing.JTextField CrimeLocationRoad;
    private javax.swing.JTextField CrimeLocationSoi;
    private javax.swing.JTextField DailyNumber;
    public static javax.swing.JTextField EvidenceRecordCase;
    private javax.swing.JTextField Invest_SendCaseDate;
    private javax.swing.JTextField Investigator_Number;
    public static javax.swing.JTextField ListAsset;
    private com.toedter.calendar.JDateChooser OccuredDate;
    private javax.swing.JSpinner OccuredDateTime;
    private javax.swing.JTextField Prosecutor_Result;
    private javax.swing.JTextField RecordInvestCase;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLabelActionCode;
    public static javax.swing.JLabel jLabelChargeCode;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioKnowSuspect;
    private javax.swing.JRadioButton jRadioUnknowSuspect;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    public static javax.swing.JTextField jTextAccused;
    private javax.swing.JTextField jTextInvestSendtoDepartment;
    public static javax.swing.JTextField jTextSuspect;
    public static javax.swing.JTextField jTextWitness;
    private lu.tudor.santec.jtimechooser.demo.JTimeChooserDemo jTimeChooserDemo1;
    private lu.tudor.santec.jtimechooser.demo.JTimeChooserDemo jTimeChooserDemo2;
    // End of variables declaration//GEN-END:variables
}
